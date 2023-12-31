<template>
    <div class="form">
      <div class="paytitle">
        <span class="paytitleword">壁纸引擎--充值界面</span>
        <img class="deletestyle" src="../assets/delete.png" @click="refresh">
      </div>
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
      <div>
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
      <button @click="payup">充值</button>
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
    sessionStorage.setItem('USERCHOSE', 'myup')
    sessionStorage.setItem('SEARCHTYPE', '')
    console.log(this.NAME)
    console.log(this.USERID)
    console.log(this.PASSWORD)
    console.log(this.BALANCE)
  },
  methods: {
    refresh()
    {
      location.reload();
    },
    payup() {
      if(this.payprice=='')
      {
        alert("请输入充值金额！");
        location.reload();
      }
      else if(this.payprice<=0)
      {
        alert("充值失败，您必须输入大于0的充值金额");
        location.reload();
      }
      let bal=0;
          bal=parseFloat(this.BALANCE)+parseFloat(this.payprice);
      let user = {
        userId: this.USERID,
        name: '',
        password: '',
        balance: bal,
      };
      console.log(this.NAME);
      console.log(user.payprice);
      let self = this;
      this.$axios.post('http://localhost:8090/user/TopUp', user)     ////////////////////////////////////充值
          .then(function (response) {
            let result = response.data;
            if (result.code === 200) {
              console.log("登录成功！");
              console.log("返回的数据：", result.data);
              console.log("总记录数：", result.total);

              sessionStorage.setItem('BALANCE', result.data.balance)

              alert("充值成功！");
              location.reload();
            } else if (result.code === 400) {
              console.log("登录失败！");
              alert("充值失败");
              location.reload();
            }
          })
          .catch(function (error) {
            console.log("请求错误：", error);
          });

    },
    changeList(id) {
      if (this.a == id) {
        this.a = !this.a;
      } else {
        this.a = id;
      }
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
.paytitle{
  display: flex;
  width: 902px;
  height: 50px;
  background-color: #00edff5e;
  margin-top: -136px;
  margin-left: 0px;
  margin-right: auto;
}
.paytitleword{
  margin: auto auto;
}
.deletestyle{
  width: 30px;
  height: 30px;
  margin: auto 0;
}
.deletestyle:hover{
  width: 35px;
  height: 35px;
  cursor: pointer;
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
  width: 900px;
  height: 500px;
  border-top: 1px solid rgba(255, 255, 255,1);
  /* 在盒子的顶部添加一个1像素宽的边框，颜色为白色，透明度为50%。 */
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(20px);
  /* 对盒子应用一个模糊半透明的效果，模糊半径为10像素。这样可以创建玻璃模糊的效果，模糊盒子后面的内容。 */
  background: rgba(191, 206, 248, 0.5);
  /* 设置盒子的背景颜色为半透明的深灰色（RGB值为50, 50, 50），透明度为20%。 */
  /* 设置盒子使用Flexbox布局。 */
  /* 将Flex容器的主轴方向设置为垂直，使得项目在列方向上排列。 */
  justify-content: center;
  /*  在盒子的垂直方向上居中内容。 */
  /* 在盒子的水平方向上居中内容。 */
  border-radius: 10px;
  /* 应用一个10像素的圆角，使得盒子的角变得圆滑。 */
  margin-top: 10px;
  margin-left: 100px;
  margin-right: auto;
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

