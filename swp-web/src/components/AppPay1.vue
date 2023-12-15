

<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="circle">&ndash;&gt;-->
<!--&lt;!&ndash;    <ul class="circle-ul">&ndash;&gt;-->
<!--&lt;!&ndash;      <li v-for="(item) of classList" :key="item.id" class="circle-li">&ndash;&gt;-->
<!--&lt;!&ndash;        <div v-on:click="changeList(item.id)" v-bind:class="{changeBorder:item.id==a}" value="change!">&ndash;&gt;-->
<!--&lt;!&ndash;          <img :src="item.coverImg" style="width: 100px;height: 100px;padding-top: 5px;" alt />&ndash;&gt;-->
<!--&lt;!&ndash;          <div class="topic-shade">&ndash;&gt;-->
<!--&lt;!&ndash;            <div class="shade"><img src="@/assets/gou.jpg" style="width: 14px;height: 14px;" alt /></div>&ndash;&gt;-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->
<!--&lt;!&ndash;        </div>&ndash;&gt;-->
<!--&lt;!&ndash;      </li>&ndash;&gt;-->
<!--&lt;!&ndash;    </ul>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--<template>-->
<!--  <div class="circle">-->
<!--    <ul class="circle-ul">-->
<!--      <li v-for="(item) of classList" :key="item.id" class="circle-li">-->
<!--        <div v-on:click="changeList(item.id)" v-bind:class="{changeBorder:item.id==a}" value="change!">-->
<!--          <img :src="item.coverImg" style="width: 100px;height: 100px;padding-top: 5px;" alt />-->
<!--          <div class="topic-shade" v-if="item.id === a">-->
<!--            <div class="shade"><img src="@/assets/gou.jpg" style="width: 14px;height: 14px;" alt /></div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </li>-->
<!--    </ul>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      a:true,-->
<!--      classList: [-->
<!--        {-->
<!--          id: "001",-->
<!--          coverImg:require('@/assets/QQ.png')-->
<!--        },-->
<!--        {-->
<!--          id: "002",-->
<!--          coverImg:require('@/assets/wechat.png')-->
<!--        },-->
<!--        {-->
<!--          id: "003",-->
<!--          coverImg:require('@/assets/Alipay.png')-->
<!--        },-->
<!--        {-->
<!--          id: "004",-->
<!--          coverImg:require('@/assets/QQ.png')-->
<!--        }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    changeList(id) {-->
<!--      if (this.a == id) {-->
<!--        this.a = !this.a;-->
<!--      } else {-->
<!--        this.a = id;-->
<!--      }-->
<!--    },-->
<!--    payway(){-->
<!--      console.log(this.a)-->
<!--    }-->
<!--  },-->
<!--  computed: {}-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--.circle{-->
<!--  position: relative;-->
<!--  width: 632px;-->
<!--  left: 15px;-->
<!--}-->
<!--.circle-ul {-->
<!--  display: flex;-->
<!--  justify-content: flex-start;-->
<!--  flex-wrap: wrap;-->
<!--  width: 532px;-->
<!--  padding: 0;-->
<!--  margin: 14px 0 0 50px;-->
<!--}-->
<!--.circle-li {-->
<!--  margin-right: 20px;-->
<!--  list-style: none;-->
<!--  margin-bottom: 20px;-->

<!--}-->
<!--.topic-shade-->
<!--{display: none;}-->
<!--.changeBorder-->
<!--{width: 114px;-->
<!--height: 114px;-->
<!--position: relative;-->
<!--cursor: pointer;-->
<!--border: 1px dashed #969696;-->
<!--margin: -1px -8px 0 -8px;}-->
<!--.topic-shade{-->
<!--display: flex;-->
<!--flex-direction: column;-->
<!--justify-content: flex-end;-->
<!--position: absolute;-->
<!--top: 123.5px;-->
<!--right: 0;-->
<!--bottom: 0;-->
<!--left: 86px;}-->
<!--.shade-->
<!--{margin-bottom: 4px;}-->
<!--</style>-->



<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="imgList">&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="img-item" v-for="(item, index) in allimgData" :class="{active:item.bOn}" :key="index" @click="checkImg(index)">&ndash;&gt;-->
<!--&lt;!&ndash;      <img :src="item.imgsrc" alt="">&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name:"FileManagement",&ndash;&gt;-->
<!--&lt;!&ndash;  data(){&ndash;&gt;-->
<!--&lt;!&ndash;    return{&ndash;&gt;-->
<!--&lt;!&ndash;      arr:[],&ndash;&gt;-->
<!--&lt;!&ndash;      allimgData:[&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          id:'001',&ndash;&gt;-->
<!--&lt;!&ndash;          imgsrc:"http://browser9.qhimg.com/bdm/480_296_0/t01bbd94b90e850d1d3.jpg"&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          id:'002',&ndash;&gt;-->
<!--&lt;!&ndash;          imgsrc:"http://browser9.qhimg.com/bdm/480_296_0/t01bbd94b90e850d1d3.jpg"&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          id:'003',&ndash;&gt;-->
<!--&lt;!&ndash;          imgsrc:"http://browser9.qhimg.com/bdm/480_296_0/t01bbd94b90e850d1d3.jpg"&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          id:'004',&ndash;&gt;-->
<!--&lt;!&ndash;          imgsrc:"http://browser9.qhimg.com/bdm/480_296_0/t01bbd94b90e850d1d3.jpg"&ndash;&gt;-->
<!--&lt;!&ndash;        }&ndash;&gt;-->
<!--&lt;!&ndash;      ]&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  mounted () {&ndash;&gt;-->
<!--&lt;!&ndash;    this.allimgData.map(function (value) {&ndash;&gt;-->
<!--&lt;!&ndash;      value.bOn = false&ndash;&gt;-->
<!--&lt;!&ndash;    })&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  methods:{&ndash;&gt;-->
<!--&lt;!&ndash;    checkImg(index){&ndash;&gt;-->
<!--&lt;!&ndash;      const temp = this.allimgData[index]&ndash;&gt;-->
<!--&lt;!&ndash;      temp.bOn = !this.allimgData[index].bOn&ndash;&gt;-->
<!--&lt;!&ndash;      this.$set(this.allimgData, index, temp)&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->


<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;.imgList{&ndash;&gt;-->
<!--&lt;!&ndash;  width: 98%;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 20px 0;&ndash;&gt;-->
<!--&lt;!&ndash;  background-color: #FFF;&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-wrap: wrap;&ndash;&gt;-->
<!--&lt;!&ndash;  .active{&ndash;&gt;-->
<!--&lt;!&ndash;    display: block;&ndash;&gt;-->
<!--&lt;!&ndash;    width: 196px;&ndash;&gt;-->
<!--&lt;!&ndash;    height: 196px;&ndash;&gt;-->
<!--&lt;!&ndash;    line-height: 0;&ndash;&gt;-->
<!--&lt;!&ndash;    font-size: 0;&ndash;&gt;-->
<!--&lt;!&ndash;    vertical-align: middle;&ndash;&gt;-->
<!--&lt;!&ndash;    border: 3px solid #2b89fd;&ndash;&gt;-->
<!--&lt;!&ndash;    -webkit-transform: rotate(0deg);&ndash;&gt;-->

<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;  .active::before{&ndash;&gt;-->
<!--&lt;!&ndash;    content: "";&ndash;&gt;-->
<!--&lt;!&ndash;    position: absolute;&ndash;&gt;-->
<!--&lt;!&ndash;    right: 0;&ndash;&gt;-->
<!--&lt;!&ndash;    bottom: 0;&ndash;&gt;-->
<!--&lt;!&ndash;    border: 12px solid #2b89fd;&ndash;&gt;-->
<!--&lt;!&ndash;    border-top-color: transparent;&ndash;&gt;-->
<!--&lt;!&ndash;    border-left-color: transparent;&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;  .active::after{&ndash;&gt;-->
<!--&lt;!&ndash;    content: "";&ndash;&gt;-->
<!--&lt;!&ndash;    display: block;&ndash;&gt;-->
<!--&lt;!&ndash;    width: 5px;&ndash;&gt;-->
<!--&lt;!&ndash;    height: 10px;&ndash;&gt;-->
<!--&lt;!&ndash;    position: absolute;&ndash;&gt;-->
<!--&lt;!&ndash;    right: 4px;&ndash;&gt;-->
<!--&lt;!&ndash;    bottom: 5px;&ndash;&gt;-->
<!--&lt;!&ndash;    border: 1px solid #fff;&ndash;&gt;-->
<!--&lt;!&ndash;    border-top-color: transparent;&ndash;&gt;-->
<!--&lt;!&ndash;    border-left-color: transparent;&ndash;&gt;-->
<!--&lt;!&ndash;    transform: rotate(45deg);&ndash;&gt;-->
<!--&lt;!&ndash;    cursor: pointer;&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;  .img-item{&ndash;&gt;-->
<!--&lt;!&ndash;    width: 196px;&ndash;&gt;-->
<!--&lt;!&ndash;    height: 196px;&ndash;&gt;-->
<!--&lt;!&ndash;    overflow: hidden;&ndash;&gt;-->
<!--&lt;!&ndash;    background-color: #FFFFFF;&ndash;&gt;-->
<!--&lt;!&ndash;    margin: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;    cursor: pointer;&ndash;&gt;-->
<!--&lt;!&ndash;    img{&ndash;&gt;-->
<!--&lt;!&ndash;      height: 196px;&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->

<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->



<template>
  <div class="container">
    <div class="form">
      <div class="userbox">
        <p>账号: <span>{{ this.USERID }}</span></p>
        <p>余额: <span>{{ this.BALANCE }}</span></p>
        <p>选择充值金额:</p>
        <el-radio-group v-model="payprice">
          <el-radio-button label="1"></el-radio-button>
          <el-radio-button label="5"></el-radio-button>
          <el-radio-button label="10"></el-radio-button>
          <el-radio-button label="20"></el-radio-button>
          <el-radio-button label="50"></el-radio-button>
          <el-radio-button label="100"></el-radio-button>
        </el-radio-group>
        <el-input class="payinput" placeholder="自定义价格..." v-model="payprice"> </el-input>
        <div class="paybox">
          <p>选择支付方式: </p>

          <div class="circle">
            <ul class="circle-ul">
              <li v-for="(item) of classList" :key="item.id" class="circle-li">
                <div v-on:click="changeList(item.id)" v-bind:class="{changeBorder:item.id==a}" value="change!">
                  <img :src="item.coverImg" style="width: 50px;height: 50px;padding-top: 5px;" alt />
                  <div class="topic-shade" v-if="item.id === a">
                    <div class="shade"><img src="@/assets/gou.jpg" style="width: 14px;height: 14px;" alt /></div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <button>充值</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name:'AppPay',
  data() {
    return {
      NAME:'',
      BALANCE:'',
      USERID:'',
      PASSWORD:'',
      payprice:'',
      a:true,
      classList: [
        {
          id: "001",
          coverImg:require('@/assets/QQ.png')
        },
        {
          id: "002",
          coverImg:require('@/assets/wechat.png')
        },
        {
          id: "003",
          coverImg:require('@/assets/Alipay.png')
        },
      ]
    };
  },
  mounted() {
    // 在组件加载时自动执行的函数
    this.NAME=sessionStorage.getItem('NAME')
    this.USERID=sessionStorage.getItem('USERID')
    this.BALANCE=sessionStorage.getItem('BALANCE')
    this.PASSWORD=sessionStorage.getItem('PASSWORD')
    console.log(this.NAME)
    console.log(this.USERID)
    console.log(this.PASSWORD)
    console.log(this.BALANCE)
  },
  methods: {
    changeList(id) {
      if (this.a == id) {
        this.a = !this.a;
      } else {
        this.a = id;
      }
    },
    payway(){
      console.log(this.a)
    },
    touser(){
      this.$router.push("/user");
    },
    toindex(){
      this.$router.push("/");
    },
    toupload(){
      this.$router.push("/upload");
    }
  },
  computed: {}
}
</script>

<style scoped>
.userbox {
  width: 900px;
  height: 500px;
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  /* 在盒子的顶部添加一个1像素宽的边框，颜色为白色，透明度为50%。 */
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(20px);
  /* 对盒子应用一个模糊半透明的效果，模糊半径为10像素。这样可以创建玻璃模糊的效果，模糊盒子后面的内容。 */
  background: rgba(50, 50, 50, 0.2);
  /* 设置盒子的背景颜色为半透明的深灰色（RGB值为50, 50, 50），透明度为20%。 */
  display: flex;
  /* 设置盒子使用Flexbox布局。 */
  flex-direction: column;
  /* 将Flex容器的主轴方向设置为垂直，使得项目在列方向上排列。 */
  justify-content: center;
  /*  在盒子的垂直方向上居中内容。 */
  align-items: center;
  /* 在盒子的水平方向上居中内容。 */
  border-radius: 10px;
  /* 应用一个10像素的圆角，使得盒子的角变得圆滑。 */
  margin-top: 10px;
  margin-left: auto;
  margin-right: auto;
}
.payinput{
  display: flex;
  justify-content: center;
  width: 300px;
}
.container {
  display: flex;
  width: 80%;
  margin: 0 auto;
}
.paybox{
  display:flex;
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
.nav a {
  text-decoration: none;
  color: #333333;
  font-size: 16px;
}
.nav a:hover {
  color: #0099ff;
}
.form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
  margin-top: 20px;
}
.form p {
  font-size: 16px;
  color: #333333;
}
.form span {
  font-weight: bold;
}
.form input {
  width: 60%;
  height: 40px;
  border: 1px solid #cccccc;
  border-radius: 20px;
  padding: 10px;
  font-size: 16px;
}
.form select {
  width: 60%;
  height: 40px;
  border: 1px solid #cccccc;
  border-radius: 20px;
  padding: 10px;
  font-size: 16px;
}
.form button {
  width: 100px;
  height: 40px;
  border: none;
  border-radius: 20px;
  background-color: #0099ff;
  color: white;
  font-size: 16px;
}
.form button:hover {
  background-color: #0066cc;
}
.payment {
  display: flex;
  align-items: center;
  gap: 20px;
  margin-top: 20px;
}
.payment img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: cover;
}
.payment p {
  font-size: 16px;
  color: #333333;
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
.circle{
  position: relative;
  width: 632px;
  left: 15px;
}
.circle-ul {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  width: 532px;
  padding: 0;
  margin: 14px 0 0 50px;
}
.circle-li {
  margin-right: 20px;
  list-style: none;
  margin-bottom: 20px;

}
.topic-shade
{display: none;}
.changeBorder
{width: 54px;
  height: 54px;
  position: relative;
  cursor: pointer;
  border: 1px dashed #969696;
  margin: -1px -8px 0 -8px;}
.topic-shade{
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  position: absolute;
  top: 70.5px;
  right: 0;
  bottom: 0;
  left: 46px;}
.shade
{margin-bottom: 4px;}
</style>


