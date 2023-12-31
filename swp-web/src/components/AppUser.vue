<!--<template>-->
<!--    <div class="container">-->
<!--        <div class="header">-->
<!--            <div class="logo">壁纸引擎&#45;&#45;用户</div>-->
<!--            <div class="nav">-->
<!--                <button @click="toindex">首页</button>-->
<!--                <button>分类</button>-->
<!--                <button @click="toupload">上传</button>-->
<!--                <div class="userimgbox">-->
<!--                    <img src="../assets/tou1.jpg" alt="" width="25" @click="refresh">-->
<!--                    <div>{{ this.NAME }}</div>-->
<!--                </div>-->
<!--            </div>-->
<!--        </div>-->

<!--        <div class="paybox">-->
<!--          <pay v-if="showRecharge" />-->
<!--        </div>-->
<!--        <div class="profile">-->
<!--            <img src="https://picsum.photos/100/100?random=1">-->
<!--            <div class="profile-info">-->
<!--                <p>用户名: <span>{{ this.NAME }}</span></p>-->
<!--                <p>账号: <span>{{ this.USERID }}</span></p>-->
<!--                <p>余额: <span>￥{{ this.BALANCE }}</span></p>-->
<!--            </div>-->
<!--        </div>-->
<!--        <div class="tabs">-->
<!--            <button class="active">我上传的壁纸</button>-->
<!--            <button class="active">我下载的壁纸</button>-->
<!--            <button class="active" @click="toupload">上传壁纸</button>-->
<!--            <button class="active" @click="showRechargeBox">充值</button>-->
<!--            <button class="active" @click="tologin">退出登录</button>-->
<!--        </div>-->
<!--        <div class="content">-->
<!--            <img src="https://picsum.photos/300/200?random=2">-->
<!--            <img src="https://picsum.photos/300/200?random=3">-->
<!--            <img src="https://picsum.photos/300/200?random=4">-->
<!--            <img src="https://picsum.photos/300/200?random=5">-->
<!--            <img src="https://picsum.photos/300/200?random=6">-->
<!--            <img src="https://picsum.photos/300/200?random=7">-->
<!--            <img src="https://picsum.photos/300/200?random=8">-->
<!--            <img src="https://picsum.photos/300/200?random=9">-->
<!--        </div>-->

<!--        <div class="footer">-->
<!--            <p>© 2023 壁纸引擎. All rights reserved.</p>-->
<!--        </div>-->
<!--    </div>-->
<!--</template>-->
<!--  -->
<!--<script>-->


<!--import pay from "@/components/AppPay.vue";-->

<!--export default {-->
<!--    name: "AppUser",-->
<!--    components: {pay,},-->
<!--    data() {-->
<!--        return {-->
<!--            showRecharge: false,-->
<!--            name: '',-->
<!--            NAME:'',-->
<!--            BALANCE:'',-->
<!--            USERID:'',-->
<!--            PASSWORD:'',-->
<!--        }-->
<!--    },-->
<!--    mounted() {-->
<!--        // 在组件加载时自动执行的函数-->
<!--        this.yourFunction();-->
<!--        this.NAME=sessionStorage.getItem('NAME')-->
<!--        this.USERID=sessionStorage.getItem('USERID')-->
<!--        this.BALANCE=sessionStorage.getItem('BALANCE')-->
<!--        this.PASSWORD=sessionStorage.getItem('PASSWORD')-->
<!--        sessionStorage.setItem('SEARCHTYPE', '')-->
<!--        console.log(this.NAME)-->
<!--        console.log(this.USERID)-->
<!--        console.log(this.PASSWORD)-->
<!--        console.log(this.BALANCE)-->
<!--    },-->
<!--    methods: {-->
<!--        showRechargeBox() {    //显示充值-->
<!--          this.showRecharge = true;-->
<!--        },-->
<!--        tologin(){-->
<!--          sessionStorage.setItem('NAME', '')-->
<!--          sessionStorage.setItem('USERID', '')-->
<!--          sessionStorage.setItem('BALANCE', '')-->
<!--          sessionStorage.setItem('PASSWORD', '')-->
<!--          this.$router.push("/");-->
<!--        },-->
<!--        yourFunction() {-->
<!--            console.log("hhhhh");-->
<!--        },-->
<!--        toindex() {-->
<!--            this.$router.push("/index");-->
<!--        },-->
<!--        refresh() {-->
<!--            location.reload();-->
<!--        },-->
<!--        toupload() {-->
<!--            this.$router.push("/upload");-->
<!--        },-->
<!--        topay(){-->
<!--          this.$router.push("/pay");-->
<!--        }-->
<!--    }-->
<!--}-->

<!--</script>-->
<!--  -->
<!--<style scoped>-->
<!--body {-->
<!--    background-color: #f0f0f0;-->
<!--    font-family: Arial, sans-serif;-->
<!--}-->
<!--.paybox{-->
<!--  position: fixed;-->
<!--  top: 50%;-->
<!--  left: 50%;-->
<!--  transform: translate(-50%, -50%);-->
<!--  padding: 20px;-->
<!--  z-index: 1000; /* 设置层叠顺序，确保它在其他内容之上 */-->
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

<!--.profile {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    gap: 20px;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.profile img {-->
<!--    width: 100px;-->
<!--    height: 100px;-->
<!--    border-radius: 50%;-->
<!--    object-fit: cover;-->
<!--}-->

<!--.profile-info {-->
<!--    display: flex;-->
<!--    flex-direction: column;-->
<!--    gap: 10px;-->
<!--}-->

<!--.profile-info p {-->
<!--    font-size: 16px;-->
<!--    color: #333333;-->
<!--}-->

<!--.profile-info span {-->
<!--    font-weight: bold;-->
<!--}-->

<!--.tabs {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    gap: 20px;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.tabs button {-->
<!--    cursor: pointer;-->
<!--    display: block;-->
<!--    width: 150px;-->
<!--    height: 40px;-->
<!--    line-height: 40px;-->
<!--    text-align: center;-->
<!--    text-decoration: none;-->
<!--    color: #333333;-->
<!--    font-size: 16px;-->
<!--    border: 1px solid #cccccc;-->
<!--    border-radius: 20px;-->
<!--}-->

<!--.tabs button.active {-->
<!--    background-color: #0099ff;-->
<!--    color: white;-->
<!--}-->

<!--.tabs button:hover {-->
<!--    background-color: #0066cc;-->
<!--}-->

<!--.content {-->
<!--    display: grid;-->
<!--    grid-template-columns: repeat(4, 1fr);-->
<!--    grid-gap: 20px;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.content img {-->
<!--    width: 100%;-->
<!--    height: 200px;-->
<!--    object-fit: cover;-->
<!--}-->

<!--.content img:hover {-->
<!--    opacity: 0.8;-->
<!--}-->

<!--.upload {-->
<!--    display: flex;-->
<!--    align-items: center;-->
<!--    justify-content: center;-->
<!--    margin-top: 20px;-->
<!--}-->

<!--.upload button {-->
<!--    width: 100px;-->
<!--    height: 40px;-->
<!--    border: none;-->
<!--    border-radius: 20px;-->
<!--    background-color: #0099ff;-->
<!--    color: white;-->
<!--    font-size: 16px;-->
<!--}-->

<!--.upload button:hover {-->
<!--    background-color: #0066cc;-->
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

<!--.updata {-->
<!--    align-items: center;-->
<!--    text-align: center;-->
<!--    margin: 0 auto;-->
<!--    width: 100px;-->
<!--    height: 40px;-->
<!--    border: none;-->
<!--    border-radius: 20px;-->
<!--    background-color: #0099ff;-->
<!--    color: white;-->
<!--    font-size: 16px;-->
<!--}-->

<!--.userimgbox {-->
<!--    margin-top: 20px;-->
<!--}-->
<!--</style>-->
<!--  -->
<!-- -->


<template>
  <div class="container">
    <div class="header">
      <div class="logo">壁纸引擎--用户</div>
      <div class="nav">
        <button @click="toindex">首页</button>
        <button>分类</button>
        <button @click="toupload">上传</button>
        <div class="userimgbox">
          <img src="../assets/bg.jpg" alt="" width="25" @click="refresh">
          <div>{{ this.NAME }}</div>
        </div>
      </div>
    </div>

    <div class="paybox">
      <pay v-if="showRecharge" />
    </div>
    <div class="profile">
      <img src="../assets/bg.jpg">
      <div class="profile-info">
        <p>用户名: <span>{{ this.NAME }}</span></p>
        <p>账号: <span>{{ this.USERID }}</span></p>
        <p>余额: <span>￥{{ this.BALANCE }}</span></p>
      </div>
    </div>
    <div class="tabs">
      <button :class="this.usechose.t1" @click="myupchose">我上传的壁纸</button>
      <button :class="this.usechose.t2" @click="mybuychose">我购买的壁纸</button>
      <button :class="this.usechose.t3" @click="myloadchose">我下载的壁纸</button>
      <button :class="this.usechose.t4" @click="mycollectchose">我收藏的壁纸</button>
      <button class="active" @click="toupload">上传壁纸</button>
      <button class="active" @click="showRechargeBox">充值</button>
      <button class="active" @click="tologin">退出登录</button>
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


import pay from "@/components/AppPay.vue";
import axios from "axios";

export default {
  name: "AppUser",
  components: {pay,},
  data() {
    return {
      showRecharge: false,
      name: '',
      NAME:'',
      BALANCE:'',
      USERID:'',
      PASSWORD:'',
      userchoseshow:'',
      images:[],
      srcurl:'',
      usechose: {
        t1:'',
        t2:'',
        t3:'',
        t4:'',
      }
    }
  },
  mounted() {
    // 在组件加载时自动执行的函数
    this.yourFunction();
    this.NAME=sessionStorage.getItem('NAME')
    this.USERID=sessionStorage.getItem('USERID')
    this.BALANCE=sessionStorage.getItem('BALANCE')
    this.PASSWORD=sessionStorage.getItem('PASSWORD')
    this.userchoseshow=sessionStorage.getItem('USERCHOSE')
    sessionStorage.setItem('SEARCHTYPE', '')
    sessionStorage.setItem('LASTURL', '/user')
    console.log(this.NAME)
    console.log(this.USERID)
    console.log(this.PASSWORD)
    console.log(this.BALANCE)
    this.postImageName();
    this.usechose={
      t1:'',
      t2:'',
      t3:'',
      t4:'',
    }
    if(this.userchoseshow=='myup')
    {this.usechose.t1='cho'}
    if(this.userchoseshow=='mybuy')
    {this.usechose.t2='cho'}
    if(this.userchoseshow=='myload')
    {this.usechose.t3='cho'}
    if(this.userchoseshow=='mycollect')
    {this.usechose.t4='cho'}

  },
  methods: {
    myupchose(){
      sessionStorage.setItem('USERCHOSE', 'myup');
      location.reload();
    },
    mybuychose(){
      sessionStorage.setItem('USERCHOSE', 'mybuy');
      location.reload();
    },
    myloadchose(){
      sessionStorage.setItem('USERCHOSE', 'myload');
      location.reload();
    },
    mycollectchose(){
      sessionStorage.setItem('USERCHOSE', 'mycollect');
      location.reload();
    },
    showRechargeBox() {    //显示充值
      this.showRecharge = true;
    },
    topicture(picture,picid) {
      this.picturesrc = picture;
      this.pictureid=picid;
      console.log(this.pictureid)
      this.$router.push({ path: '/picture', query: { name: this.picturesrc, wpid: this.pictureid} });
    },
    tologin(){
      sessionStorage.setItem('NAME', '')
      sessionStorage.setItem('USERID', '')
      sessionStorage.setItem('BALANCE', '')
      sessionStorage.setItem('PASSWORD', '')
      this.$router.push("/");
    },
    yourFunction() {
      console.log("hhhhh");
    },
    toindex() {
      this.$router.push("/index");
    },
    refresh() {
      location.reload();
    },
    toupload() {
      this.$router.push("/upload");
    },
    topay(){
      this.$router.push("/pay");
    },
    async postImageName() {
      let self = this;
      let vwallpaper={};

      if(this.userchoseshow=='myup') {
        vwallpaper = {

          vwpId: '',
          name: '',
          createId: this.USERID,
          price: '',
          type: '',
          path: '',
        }
        console.log("hhhh")
        this.srcurl = "http://localhost:8090/vwallpaper/getImagesByCreateId";
      }
      if(this.userchoseshow=='mybuy') {
        vwallpaper = {

          vwpId: '',
          userId: this.USERID,
        }
        this.srcurl = "http://localhost:8090/vwporder/getPurchasedImages";
      }
        if(this.userchoseshow=='myload') {
          vwallpaper = {

            vwpId: '',
            userId: this.USERID,
          }
          this.srcurl = "http://localhost:8090/vwpdownload/getDownloadedImages";
        }
      if(this.userchoseshow=='mycollect') {
        vwallpaper = {

          vwpId: '',
          userId: this.USERID,
        }
        this.srcurl = "http://localhost:8090/vwporder/getPurchasedImages";
      }
      try {
        //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
        let response = await axios.post(this.srcurl,vwallpaper);
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
    getImageUrl(imageName) {
      return `http://localhost:8090/vwallpaper/ShowPicture?filepath=${imageName}`;
    },
  }
}

</script>

<style scoped>
body {
  background-color: #f0f0f0;
  font-family: Arial, sans-serif;
}
.paybox{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  z-index: 1000; /* 设置层叠顺序，确保它在其他内容之上 */
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
  color: black;
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
  color: black;
  font-size: 20px;
  font-weight: 600;
  border: none;
  background-color: rgba(255, 255, 255, 0);
}

.nav button:hover {
  color: #0099ff;
  cursor: pointer;
}

.profile {
  display: flex;
  align-items: center;
  gap: 20px;
  margin-top: 20px;
}

.profile img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: cover;
}

.profile-info {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.profile-info p {
  font-size: 16px;
  color: #333333;
}

.profile-info span {
  font-weight: bold;
}

.tabs {
  display: flex;
  align-items: center;
  gap: 20px;
  margin-top: 20px;
}

.tabs button {
  cursor: pointer;
  display: block;
  width: 150px;
  height: 40px;
  line-height: 40px;
  text-align: center;
  text-decoration: none;
  color: #333333;
  font-size: 16px;
  border: 1px solid #cccccc;
  border-radius: 20px;
}

.tabs button {
  background-color: #0099ff;
  color: white;
}
.tabs button.cho {
  background-color: #ff00fa;
  color: white;
}

.tabs button:hover {
  background-color: #0066cc;
}

.content {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 20px;
  margin-top: 20px;
}

.content img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.content img:hover {
  opacity: 0.8;
}

.upload {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 20px;
}

.upload button {
  width: 100px;
  height: 40px;
  border: none;
  border-radius: 20px;
  background-color: #0099ff;
  color: white;
  font-size: 16px;
}

.upload button:hover {
  background-color: #0066cc;
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

.updata {
  align-items: center;
  text-align: center;
  margin: 0 auto;
  width: 100px;
  height: 40px;
  border: none;
  border-radius: 20px;
  background-color: #0099ff;
  color: white;
  font-size: 16px;
}

.userimgbox {
  margin-top: 20px;
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
.userimgbox img{
  width: 35px;
  height: 35px;
  border-radius: 50%;
  object-fit: cover;
}
</style>

