<!--<template>-->
<!--    <div class="container">-->
<!--        <div class="header">-->
<!--            <div class="logo">壁纸引擎</div>-->
<!--            <div class="nav">-->
<!--                <button @click="refresh">首页</button>-->
<!--                <button>分类</button>-->
<!--                <button @click="toupload">上传</button>-->
<!--                <div class="userimgbox">-->
<!--                    <img src="../assets/tou1.jpg" alt="" width="25" @click="touser">-->
<!--                    <div>{{ this.NAME }}</div>-->
<!--                </div>-->
<!--            </div>-->
<!--        </div>-->
<!--        <div class="search">-->
<!--            <input type="text" placeholder="搜索壁纸...">-->
<!--            <button>搜索</button>-->
<!--        </div>-->
<!--        <br>-->
<!--        <div class="label">-->
<!--            最新 风景 动物 美女 动漫 游戏 电影 明星 科幻 其他-->
<!--        </div>-->
<!--        <div class="gallery">-->
<!--            <img src="https://picsum.photos/300/200?random=1" @click="topicture('https://picsum.photos/300/200?random=1')">-->
<!--            <img src="https://picsum.photos/300/200?random=2">-->
<!--            <img src="https://picsum.photos/300/200?random=3">-->
<!--            <img src="https://picsum.photos/300/200?random=4">-->
<!--            <img src="https://picsum.photos/300/200?random=5">-->
<!--            <img src="https://picsum.photos/300/200?random=6">-->
<!--            <img src="https://picsum.photos/300/200?random=7">-->
<!--            <img src="https://picsum.photos/300/200?random=8">-->
<!--            <img src="https://picsum.photos/300/200?random=9">-->
<!--            <img src="https://picsum.photos/300/200?random=10">-->
<!--            <img src="https://picsum.photos/300/200?random=11">-->
<!--            <img src="https://picsum.photos/300/200?random=12">-->
<!--            <img src="https://picsum.photos/300/200?random=13">-->
<!--            <img src="https://picsum.photos/300/200?random=14">-->
<!--            <img src="https://picsum.photos/300/200?random=15">-->
<!--            <img src="https://picsum.photos/300/200?random=16">-->
<!--        </div>-->
<!--        <div class="footer">-->
<!--            <p>© 2023 壁纸引擎. All rights reserved.</p>-->
<!--        </div>-->
<!--    </div>-->
<!--</template>-->

<!--<script>-->
<!--import axios from "axios";-->

<!--export default {-->

<!--    name: "AppIndex",-->
<!--    data() {-->
<!--        return {-->
<!--            NAME:'',-->
<!--            BALANCE:'',-->
<!--            USERID:'',-->
<!--            PASSWORD:'',-->
<!--            isCollapse: false,-->
<!--            aside_width: '200px',-->
<!--            icon: 'el-icon-s-fold',-->
<!--            picturesrc: '',-->
<!--            imageName: "", //用于保存图片的文件名-->
<!--        }-->
<!--    },-->
<!--    mounted() {-->
<!--      // 在组件加载时自动执行的函数-->
<!--      this.NAME=sessionStorage.getItem('NAME')-->
<!--      this.USERID=sessionStorage.getItem('USERID')-->
<!--      this.BALANCE=sessionStorage.getItem('BALANCE')-->
<!--      this.PASSWORD=sessionStorage.getItem('PASSWORD')-->
<!--      console.log(this.NAME)-->
<!--      console.log(this.USERID)-->
<!--      console.log(this.PASSWoRD)-->
<!--      console.log(this.BALANCE)-->
<!--    },-->
<!--    methods: {-->
<!--        doCollapse() {-->
<!--            this.isCollapse = !this.isCollapse-->
<!--            if (!this.isCollapse) {-->
<!--                //展开-->
<!--                this.aside_width = '200px',-->
<!--                    this.icon = 'el-icon-s-fold'-->
<!--            } else {-->
<!--                //收起-->
<!--                this.aside_width = '65px',-->
<!--                    this.icon = 'el-icon-s-unfold'-->
<!--            }-->
<!--        },-->
<!--        touser() {-->
<!--            let self = this;-->
<!--            self.$router.push("/user");-->
<!--        },-->
<!--        show() {-->
<!--            console.log(this.$globalVar);-->
<!--        },-->
<!--        refresh() {-->
<!--            location.reload();-->
<!--        },-->
<!--        topicture(picture) {-->
<!--            console.log(picture);-->
<!--            this.picturesrc = picture;-->
<!--            this.$router.push({ path: '/picture', query: { name: this.picturesrc } });-->
<!--        },-->
<!--        toupload() {-->
<!--            this.$router.push("/upload");-->
<!--        }-->
<!--    },-->

<!--    computed: {-->
<!--    }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--body {-->
<!--    background-color: #f0f0f0;-->
<!--    font-family: Arial, sans-serif;-->
<!--}-->

<!--.image-viewer {-->
<!--    width: 600px;-->
<!--    height: 400px;-->
<!--    margin: 20px auto;-->
<!--    border: 1px solid #ccc;-->
<!--}-->

<!--.container {-->
<!--    width: 80%;-->
<!--    margin: 0 auto;-->
<!--}-->

<!--.header {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    justify-content: space-between;-->
<!--    padding: 20px;-->
<!--}-->

<!--.logo {-->
<!--    font-size: 32px;-->
<!--    font-weight: bold;-->
<!--    color: #333333;-->
<!--}-->

<!--.nav {-->
<!--    display: flex;-->
<!--    gap: 20px;-->
<!--}-->

<!--.nav img:hover {-->
<!--    cursor: pointer;-->
<!--}-->

<!--.nav button {-->
<!--    text-decoration: none;-->
<!--    color: #333333;-->
<!--    font-size: 16px;-->
<!--    border: none;-->
<!--    background-color: rgba(255, 255, 255, 0);-->
<!--}-->

<!--.nav button:hover {-->
<!--    color: #0099ff;-->
<!--    cursor: pointer;-->
<!--}-->

<!--.search {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    gap: 10px;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.search input {-->
<!--    width: 60%;-->
<!--    height: 40px;-->
<!--    border: 1px solid #cccccc;-->
<!--    border-radius: 20px;-->
<!--    padding: 10px;-->
<!--    font-size: 16px;-->
<!--}-->

<!--.search button {-->
<!--    width: 100px;-->
<!--    height: 40px;-->
<!--    border: none;-->
<!--    border-radius: 20px;-->
<!--    background-color: #0099ff;-->
<!--    color: white;-->
<!--    font-size: 16px;-->
<!--}-->

<!--.search button:hover {-->
<!--    background-color: #0066cc;-->
<!--}-->

<!--.label {-->
<!--    margin: 0 auto;-->
<!--    font-weight: 600;-->
<!--    font-size: 20px;-->
<!--}-->

<!--.gallery {-->
<!--    display: grid;-->
<!--    grid-template-columns: repeat(4, 1fr);-->
<!--    grid-gap: 20px;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.gallery img {-->
<!--    width: 100%;-->
<!--    height: 200px;-->
<!--    object-fit: cover;-->
<!--}-->

<!--.gallery img:hover {-->
<!--    opacity: 0.8;-->
<!--}-->

<!--.footer {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    justify-content: center;-->
<!--    padding: 20px;-->
<!--}-->

<!--.footer p {-->
<!--    font-size: 14px;-->
<!--    color: #999999;-->
<!--}-->

<!--.userimgbox {-->
<!--    margin-top: 20px;-->
<!--}-->
<!--</style>-->




<template>
  <div class="container">
    <div class="header">
      <div class="logo">壁纸引擎</div>
      <div class="nav">
        <button @click="refresh">首页</button>
        <button>分类</button>
        <button @click="toupload">上传</button>
        <div class="userimgbox">
          <img src="../assets/tou1.jpg" alt="" width="25" @click="touser">
          <div>{{ this.NAME }}</div>
        </div>
      </div>
    </div>
    <div class="search">
      <input type="text" placeholder="搜索壁纸..." v-model="searchname">
      <button @click="tosearch">搜索</button>
    </div>
    <br>
    <div class="typechose">
      <button @click="tosearchtype('')">最新</button>
      <button @click="tosearchtype('风景')">风景</button>
      <button @click="tosearchtype('动物')">动物</button>
      <button @click="tosearchtype('美女')">美女</button>
      <button @click="tosearchtype('动漫')">动漫</button>
      <button @click="tosearchtype('游戏')">游戏</button>
      <button @click="tosearchtype('电影')">电影</button>
      <button @click="tosearchtype('明星')">明星</button>
      <button @click="tosearchtype('科幻')">科幻</button>
      <button @click="tosearchtype('其他')">其他</button>
    </div>
    <div class="imggallery">
      <div class="image-viewer">
        <el-image class="image-style" v-for="(imageName, index) in imageNames" :key="index" :src="getImageUrl(imageName)" fit="contain" @click="topicture(getImageUrl(imageName))"></el-image>
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
      searchname:'',//搜索框内容
      searchtype:'',
      NAME:'',
      BALANCE:'',
      USERID:'',
      PASSWORD:'',
      isCollapse: false,
      aside_width: '200px',
      icon: 'el-icon-s-fold',
      picturesrc: '',
      pictureid:'',
      imageName: "", //用于保存图片的文件名
      images:[],
      imageNames: [],//用于报存图片路径数组
      imageID:[],
    }
  },
  mounted() {
    // 在组件加载时自动执行的函数
    this.NAME=sessionStorage.getItem('NAME')
    this.USERID=sessionStorage.getItem('USERID')
    this.BALANCE=sessionStorage.getItem('BALANCE')
    this.PASSWORD=sessionStorage.getItem('PASSWORD')
    sessionStorage.setItem('SEARCHNAME', '')
    console.log(this.NAME)
    console.log(this.USERID)
    console.log(this.PASSWORD)
    console.log(this.BALANCE)
    this.searchtype=sessionStorage.getItem('SEARCHTYPE')
    this.postImageName();
  },
  methods: {
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
    show() {
      console.log(this.$globalVar);
    },
    refresh() {
      sessionStorage.setItem('SEARCHTYPE', '')
      location.reload();
    },
    topicture(picture,picid) {
      this.picturesrc = picture;
      this.pictureid=picid
      this.$router.push({ path: '/picture', query: { name: this.picturesrc, wpid: this.pictureid} });
    },
    tosearch(){
      sessionStorage.setItem('SEARCHNAME',this.searchname)
      this.$router.push("/search");
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
        name:'',
        createId:'',
        price:'',
        type:this.searchtype,
        path:''

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
            this.imageNames.push(response.data.data[i].path);
            this.imageID.push(response.data.data[i].vwpId);
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
.typechose{
  margin: 0 auto;
  font-weight: 600;
  font-size: 20px;
  display: flex;
  gap: 20px;
}
.typechose button{
  text-decoration: none;
  margin: 0 auto;
  font-weight: 700;
  font-size: 20px;
  color: #333333;
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
.image-style :hover{
  width: 250px;
  height: 200px;
  cursor: pointer;
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
  color: #333333;
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
  color: #333333;
  font-size: 16px;
  border: none;
  background-color: rgba(255, 255, 255, 0);
}

.nav button:hover {
  color: #0099ff;
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

.label {
  margin: 0 auto;
  font-weight: 600;
  font-size: 20px;
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
</style>