<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎</div>
            <div class="nav">
                <button @click="toindex">首页</button>
                <button>分类</button>
                <button @click="toupload">上传</button>
                <div class="userimgbox">
                    <img src="../assets/tou1.jpg" alt="" width="25" @click="refresh">
                    <div>{{ this.$globalVar.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="profile">
            <img src="https://picsum.photos/100/100?random=1">
            <div class="profile-info">
                <p>用户名: <span>{{ this.$globalVar.NAME }}</span></p>
                <p>账号: <span>{{ this.$globalVar.USERID }}</span></p>
                <p>余额: <span>￥{{ this.$globalVar.BALANCE }}</span></p>
            </div>
        </div>
        <div class="tabs">
            <button class="active">我上传的壁纸</button>
            <button class="active">我下载的壁纸</button>
            <button class="active" @click="toupload">上传壁纸</button>
            <button class="active">充值</button>
        </div>
        <div class="content">
            <img src="https://picsum.photos/300/200?random=2">
            <img src="https://picsum.photos/300/200?random=3">
            <img src="https://picsum.photos/300/200?random=4">
            <img src="https://picsum.photos/300/200?random=5">
            <img src="https://picsum.photos/300/200?random=6">
            <img src="https://picsum.photos/300/200?random=7">
            <img src="https://picsum.photos/300/200?random=8">
            <img src="https://picsum.photos/300/200?random=9">
        </div>

        <div class="footer">
            <p>© 2023 壁纸引擎. All rights reserved.</p>
        </div>
    </div>
</template>
  
<script>

export default {
    name: "AppUser",
    components: {},
    data() {
        return {
            name: ''
        }
    },
    mounted() {
        // 在组件加载时自动执行的函数
        this.yourFunction();
    },
    methods: {
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
        }
    }
}

</script>
  
<style>
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

.tabs button.active {
    background-color: #0099ff;
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
</style>
  
  