<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎--壁纸</div>
            <div class="nav">
                <button @click="toindex">首页</button>
                <button>分类</button>
                <button @click="toupload">上传</button>
                <div class="userimgbox">
                    <img src="../assets/tou1.jpg" alt="" width="25" @click="touser">
                    <div>{{ this.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="nav">
            <button @click="toindex"> 《--返回上一页</button>
        </div>
        <div class="info">
            <div>壁纸名称: {{this.picturename}}</div>
            <div>壁纸价格: {{this.pictureprice}}￥</div>
            <div>壁纸创作者: {{this.picturecreatid}}</div>
            <button @click="loadpicture">下载</button>
        </div>
        <div class="image">
            <img v-if="this.$route.query.name" :src="this.$route.query.name">
        </div>
        <div class="footer">
            <p>© 2023 壁纸引擎. All rights reserved.</p>
        </div>
    </div>
</template>
    
<script>

import axios from "axios";

export default {
    name: 'AppPicture',
    data() {
        return {
            name: '',
            password: '',
            picture: '',
            NAME:'',
            BALANCE:'',
            USERID:'',
            PASSWORD:'',
            pictureid:'',
            picturename:'',
            pictureprice:'',
            picturecreatid:'',
        }
    },
    mounted() {
      // 在组件加载时自动执行的函数
      this.NAME=sessionStorage.getItem('NAME')
      this.USERID=sessionStorage.getItem('USERID')
      this.BALANCE=sessionStorage.getItem('BALANCE')
      this.PASSWORD=sessionStorage.getItem('PASSWORD')
      this.pictureid=this.$route.query.wpid;
      sessionStorage.setItem('SEARCHTYPE', '')
      console.log(this.NAME)
      console.log(this.USERID)
      console.log(this.PASSWORD)
      console.log(this.BALANCE)
      console.log(this.$route.query.name)
      console.log(this.$route.query.vwid)
      this.postImagePrice();
    },
    methods: {
        touser() {
            let self = this;
            self.$router.push("/user");
        },
        toindex() {
            let self = this;
            self.$router.push("/index");
        },
        toupload() {
            this.$router.push("/upload");
        },
        async postImagePrice() {
        let vwallpaper = {

          vwpId:this.pictureid ,
          name:'',
          createId:'',
          price:'',
          type:'',
          path:''

        };
        try {
          //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
          let response = await axios.post("http://localhost:8090/vwallpaper/getImagesByVwpid",vwallpaper);
          //如果请求成功，将文件名保存到imageName属性中
          if (response.status === 200) {
            console.log(response.data);
            console.log(this.imageName);
            this.picturename=response.data.data[0].name;
            this.picturecreatid=response.data.data[0].createId;
            this.pictureprice=response.data.data[0].price;

          }
        } catch (error) {
          //如果请求失败，打印错误信息
          console.error(error);
        }
      },
    }
}

</script>
    
<style scoped>
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

.back {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 20px;
}

.back a {
    text-decoration: none;
    color: #333333;
    font-size: 16px;
}

.back a:hover {
    color: #0099ff;
}

.image {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 20px;
}

.image img {
    width: 80%;
    height: auto;
}

.info {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 20px;
    margin-left: 90px;

  gap: 20px;
  width: 1000px;
  height: 100px;
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
  /* 将Flex容器的主轴方向设置为垂直，使得项目在列方向上排列。 */
  justify-content: center;
  /*  在盒子的垂直方向上居中内容。 */
  align-items: center;
  /* 在盒子的水平方向上居中内容。 */
  border-radius: 10px;
  /* 应用一个10像素的圆角，使得盒子的角变得圆滑。 */
}

.info p {
    font-size: 16px;
    color: #333333;
}

.info button {
    width: 100px;
    height: 40px;
    border: none;
    border-radius: 20px;
    background-color: #0099ff;
    color: white;
    font-size: 16px;
}
.info button:hover {
    background-color: #0066cc;
    cursor: pointer;
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
    
    