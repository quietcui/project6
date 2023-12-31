<template>
  <div class="background">
    <div class="box">
      <h2>用户登录</h2>
      <div class="input-box">
        <label>账号</label>
        <input type="text" v-model="name">
      </div>
      <div class="input-box">
        <label>密码</label>
        <input type="password" v-model="password">
      </div>
      <div class="btn-box">
        <a href="#">忘记密码?</a>
        <div>
          <button @click="login">登录</button>
          <button @click="register">注册</button>
        </div>
      </div>
    </div>
  </div>
</template>
  
<script>

export default {
  name: 'AppLogin',
  data() {
    return {
      name: '',
      password: '',
    }
  },
  methods: {
    register() {
      this.$router.push("/register");
    },
    login() {
      let user = {
        userId: this.name,
        password: this.password
      };
      let self = this;
      this.$axios.post('http://localhost:8090/user/login', user)     ////////////////////////////////////登录信息
        .then(function (response) {
          let result = response.data;
          if (result.code === 200) {
            console.log("登录成功！");
            console.log("返回的数据：", result.data);
            console.log("总记录数：", result.total);

            sessionStorage.setItem('NAME', result.data.name)
            sessionStorage.setItem('USERID', result.data.userId)
            sessionStorage.setItem('BALANCE', result.data.balance)
            sessionStorage.setItem('PASSWORD', result.data.password)
            sessionStorage.setItem('SEARCHNAME', '')
            sessionStorage.setItem('SEARCHTYPE', '')
            sessionStorage.setItem('USERCHOSE', 'myup')
            sessionStorage.setItem('LASTURL', '')

            self.$router.push("/index");
          } else if (result.code === 400) {
            console.log("登录失败！");
            alert("账号或密码错误，请重新输入");
            location.reload();
          }
        })
        .catch(function (error) {
          console.log("请求错误：", error);
        });

    }
  }
}

</script>
  
<style scoped>
@import '../assets/login.css';
</style>
  
  