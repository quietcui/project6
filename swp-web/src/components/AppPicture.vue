<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎</div>
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
            <p>图片名称: 随机图片1</p>
            <button>下载</button>
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
        }
    },
    mounted() {
      // 在组件加载时自动执行的函数
      this.NAME=sessionStorage.getItem('NAME')
      this.USERID=sessionStorage.getItem('USERID')
      this.BALANCE=sessionStorage.getItem('BALANCE')
      this.PASSWORD=sessionStorage.getItem('PASSWORD')
      console.log(this.NAME)
      console.log(this.USERID)
      console.log(this.PASSWoRD)
      console.log(this.BALANCE)
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
        }

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

.nav a {
    text-decoration: none;
    color: #333333;
    font-size: 16px;
}

.nav a:hover {
    color: #0099ff;
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
    
    