<template>
  <div class="container">
    <div class="header">
      <div class="logo">壁纸引擎--搜索</div>
      <div class="nav">
        <button @click="toindex">首页</button>
        <button @clikc="refresh">刷新</button>
        <button @click="toupload">上传</button>
        <div class="userimgbox">
          <img src="../assets/bg.jpg" alt="" width="25" @click="touser">
          <div style=" color: #28e1f8;">{{ this.NAME }}</div>
        </div>
      </div>
    </div>
    <div class="search">
      <input type="text" placeholder="搜索壁纸..." v-model="searchname">
      <button @click="searchnameway">搜索</button>
      <div class="searchnameresole">正在显示搜索结果：{{this.searchshowname}} </div>
    </div>
    <br>
    <div class="typechose">
      <button :class="typechoseshow.t1" @click="tosearchtype('')">最新</button>
      <button :class="typechoseshow.t2" @click="tosearchtype('风景')">风景</button>
      <button :class="typechoseshow.t3" @click="tosearchtype('动物')">动物</button>
      <button :class="typechoseshow.t4" @click="tosearchtype('美女')">美女</button>
      <button :class="typechoseshow.t5" @click="tosearchtype('动漫')">动漫</button>
      <button :class="typechoseshow.t6" @click="tosearchtype('游戏')">游戏</button>
      <button :class="typechoseshow.t7" @click="tosearchtype('电影')">电影</button>
      <button :class="typechoseshow.t8" @click="tosearchtype('明星')">明星</button>
      <button :class="typechoseshow.t9" @click="tosearchtype('科幻')">科幻</button>
      <button :class="typechoseshow.t10" @click="tosearchtype('其他')">其他</button>
    </div>
    <div class="imggallery">
      <div class="image-viewer">
        <el-image class="image-style" v-for="(aimage, index) in images" :key="index" :src="getImageUrl(aimage.imageNames)" fit="contain" @click="topicture(getImageUrl(aimage.imageNames),aimage.imageID)"></el-image>
      </div>
    </div>
    <div class="footer">
      <p>© 2023 壁纸引擎. All rights reserved.</p>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {

  name: "AppIndex",
  data() {
    return {
      searchtype:'',
      name:'',
      searchname:'',//搜索框内容
      NAME:'',
      BALANCE:'',
      USERID:'',
      PASSWORD:'',
      isCollapse: false,
      aside_width: '200px',
      icon: 'el-icon-s-fold',
      picturesrc: '',
      pictureid: '',
      imageName: "", //用于保存图片的文件名
      searchshowname:'',//用于显示当前搜索结果
      images:[],
      typechoseshow:{
        t1:'ty1',
        t2:'',
        t3:'',
        t4:'',
        t5:'',
        t6:'',
        t7:'',
        t8:'',
        t9:'',
        t10:'',
      },
    }
  },
  mounted() {
    // 在组件加载时自动执行的函数
    this.NAME=sessionStorage.getItem('NAME')
    this.USERID=sessionStorage.getItem('USERID')
    this.BALANCE=sessionStorage.getItem('BALANCE')
    this.PASSWORD=sessionStorage.getItem('PASSWORD')
    sessionStorage.setItem('USERCHOSE', 'myup')
    sessionStorage.setItem('LASTURL', '/search')
    console.log(this.NAME)
    console.log(this.USERID)
    console.log(this.PASSWORD)
    console.log(this.BALANCE)
    this.searchname=sessionStorage.getItem('SEARCHNAME')
    this.searchtype=sessionStorage.getItem("SEARCHTYPE")
    this.searchshowname=sessionStorage.getItem('SEARCHNAME')
    this.postImageName();
    this.typechoseshow={
      t1:'',
      t2:'',
      t3:'',
      t4:'',
      t5:'',
      t6:'',
      t7:'',
      t8:'',
      t9:'',
      t10:'',
    };
    if(this.searchtype=='最新')
    {this.typechoseshow.t1='ty1'}
    if(this.searchtype=='风景')
    {this.typechoseshow.t2='ty1'}
    if(this.searchtype=='动物')
    {this.typechoseshow.t3='ty1'}
    if(this.searchtype=='美女')
    {this.typechoseshow.t4='ty1'}
    if(this.searchtype=='动漫')
    {this.typechoseshow.t5='ty1'}
    if(this.searchtype=='游戏')
    {this.typechoseshow.t6='ty1'}
    if(this.searchtype=='电影')
    {this.typechoseshow.t7='ty1'}
    if(this.searchtype=='明星')
    {this.typechoseshow.t8='ty1'}
    if(this.searchtype=='科幻')
    {this.typechoseshow.t9='ty1'}
    if(this.searchtype=='其他')
    {this.typechoseshow.t10='ty1'}
  },
  methods: {
    searchnameway(){
      sessionStorage.setItem('SEARCHNAME', this.searchname);
      location.reload();
    },
    doCollapse() {
      this.isCollapse = !this.isCollapse
      if (!this.isCollapse) {
        //展开
        this.aside_width = '200px',
            this.icon = 'el-icon-s-fold'
      } else {
        //收起
        this.aside_width = '65px',
            this.icon = 'el-icon-s-unfold'
      }
    },
    tosearchtype(Searchtype){  //分类
      sessionStorage.setItem('SEARCHTYPE', Searchtype)
      location.reload();
    },
    touser() {
      let self = this;
      self.$router.push("/user");
    },
    refresh() {
      location.reload();
    },
    topicture(picture,picid) {
      this.picturesrc = picture;
      this.pictureid=picid;
      console.log(this.pictureid)
      this.$router.push({ path: '/picture', query: { name: this.picturesrc, wpid: this.pictureid} });
    },
    toindex(){
      sessionStorage.setItem('SEARCHTYPE', '')
      this.$router.push("/index");
    },
    toupload() {
      this.$router.push("/upload");
    },
    getImageUrl(imageName) {
      return `http://localhost:8090/vwallpaper/ShowPicture?filepath=${imageName}`;
    },
    async postImageName() {
      let vwallpaper = {

        vwpId:'' ,
        name:this.searchname,
        createId:'',
        price:'',
        type:this.searchtype,
        path:'',
        imageID:[],
      };
      try {
        //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
        let response = await axios.post("http://localhost:8090/vwallpaper/getImagesByTypeAndName",vwallpaper);
        //如果请求成功，将文件名保存到imageName属性中
        if (response.status === 200) {
          console.log(response.data);
          console.log(this.imageName);
          let i=0;
          while(response.data.data[i] && response.data.data[i].path!=null){
            this.images.push({imageNames:response.data.data[i].path,imageID:response.data.data[i].vwpId})
            i++;
          }
        }
      } catch (error) {
        //如果请求失败，打印错误信息
        console.error(error);
      }
    },
  },


  computed: {
  }
}
</script>

<style scoped>
.ty1{
  color: #ff0062;
}
.image-style :hover{
  width: 250px;
  height: 200px;
  cursor: pointer;
}
.typechose{
  margin: 0 auto;
  font-weight: 600;
  font-size: 20px;
  display: flex;
  gap: 20px;
  color: #333333;
}
.typechose button{
  text-decoration: none;
  margin: 0 auto;
  font-weight: 700;
  font-size: 20px;
  border: none;
  background-color: rgba(255, 255, 255, 0);
}
.typechose button:hover{
  color: #0099ff;
  cursor: pointer;
}


element {
  object-fit: contain;
  width: 50px;
}
.imggallery {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 20px;
  margin-top: 20px;
}
.image-viewer {
  width: 1300px;
  height: 400px;
  margin: auto auto;
  margin-right: 10px;
}

.image-style{
  width: 300px;
  height: 220px;
  margin-right: 10px;
  object-fit: cover;
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  /* 在盒子的顶部添加一个1像素宽的边框，颜色为白色，透明度为50%。 */
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(10px);
  /* 对盒子应用一个模糊半透明的效果，模糊半径为10像素。这样可以创建玻璃模糊的效果，模糊盒子后面的内容。 */
  background: rgba(50, 50, 50, 0.2);
  /* 设置盒子的背景颜色为半透明的深灰色（RGB值为50, 50, 50），透明度为20%。 */

  /* 设置盒子使用Flexbox布局。 */
  flex-direction: column;
  /* 将Flex容器的主轴方向设置为垂直，使得项目在列方向上排列。 */
  justify-content: center;
  /*  在盒子的垂直方向上居中内容。 */
  align-items: center;
  /* 在盒子的水平方向上居中内容。 */
  border-radius: 10px;
  /* 应用一个10像素的圆角，使得盒子的角变得圆滑。 */
}


body {
  background-color: #f0f0f0;
  font-family: Arial, sans-serif;
}


.container {
  width: 80%;
  margin: 0 auto;
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
}

.logo {
  font-size: 32px;
  font-weight: bold;
  color: #28e1f8;
}

.nav {
  display: flex;
  gap: 20px;
}

.nav img:hover {
  cursor: pointer;
}

.nav button {
  text-decoration: none;
  color: #28e1f8;
  font-size: 20px;
  font-weight: 600;
  border: none;
  background-color: rgba(255, 255, 255, 0);
}

.nav button:hover {
  color: #ff0062;
  cursor: pointer;
}

.search {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-top: 20px;
}

.search input {
  width: 60%;
  height: 40px;
  border: 1px solid #cccccc;
  border-radius: 20px;
  padding: 10px;
  font-size: 16px;
}

.search button {
  width: 100px;
  height: 40px;
  border: none;
  border-radius: 20px;
  background-color: #0099ff;
  color: white;
  font-size: 16px;
}

.search button:hover {
  background-color: #0066cc;
  cursor: pointer;
}

.gallery {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 20px;
  margin-top: 20px;
}

.gallery img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.gallery img:hover {
  opacity: 0.8;
}

.footer {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.footer p {
  font-size: 14px;
  color: #999999;
}

.userimgbox {
  margin-top: 20px;
}
.userimgbox img{
  width: 35px;
  height: 35px;
  border-radius: 50%;
  object-fit: cover;
}
</style>