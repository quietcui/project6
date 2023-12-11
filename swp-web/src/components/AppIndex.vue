

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
                    <div>{{ this.$globalVar.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="search">
            <input type="text" placeholder="搜索壁纸...">
            <button>搜索</button>
        </div>
        <br>
        <div class="label">
            最新 动漫 科技 风景
        </div>
        <div class="gallery">
            <img src="https://picsum.photos/300/200?random=1" @click="topicture('https://picsum.photos/300/200?random=1')">
            <img src="https://picsum.photos/300/200?random=2">
            <img src="https://picsum.photos/300/200?random=3">
            <img src="https://picsum.photos/300/200?random=4">
            <img src="https://picsum.photos/300/200?random=5">
            <img src="https://picsum.photos/300/200?random=6">
            <img src="https://picsum.photos/300/200?random=7">
            <img src="https://picsum.photos/300/200?random=8">
            <img src="https://picsum.photos/300/200?random=9">
            <img src="https://picsum.photos/300/200?random=10">
            <img src="https://picsum.photos/300/200?random=11">
            <img src="https://picsum.photos/300/200?random=12">
            <img src="https://picsum.photos/300/200?random=13">
            <img src="https://picsum.photos/300/200?random=14">
            <img src="https://picsum.photos/300/200?random=15">
            <img src="https://picsum.photos/300/200?random=16">
        </div>
        <div class="footer">
            <p>© 2023 壁纸引擎. All rights reserved.</p>
        </div>

        <div class="image-viewer">
            <el-image v-if="imageName" :src="`http://localhost:8090/user/download?name=${imageName}`"
                fit="contain"></el-image>

        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {

    name: "AppIndex",
    data() {
        return {
            isCollapse: false,
            aside_width: '200px',
            icon: 'el-icon-s-fold',
            picturesrc: '',
            imageName: "", //用于保存图片的文件名
        }
    },
    // mounted:{
    //       async getImageName() {
    //       try {
    //         //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
    //         let response = await axios.get("http://localhost:8090/user/get-image-name");
    //         //如果请求成功，将文件名保存到imageName属性中
    //         if (response.status === 200) {
    //           this.imageName = response.data;
    //         }
    //       } catch (error) {
    //         //如果请求失败，打印错误信息
    //         console.error(error);
    //       }
    //     },
    //   },
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
        touser() {
            let self = this;
            self.$router.push("/user");
        },
        show() {
            console.log(this.$globalVar);
        },
        refresh() {
            location.reload();
        },
        topicture(picture) {
            console.log(picture);
            this.picturesrc = picture;
            this.$router.push({ path: '/picture', query: { name: this.picturesrc } });
        },
        toupload() {
            this.$router.push("/upload");
        }
    },

    computed: {
    }
}
</script>

<style>
body {
    background-color: #f0f0f0;
    font-family: Arial, sans-serif;
}

.image-viewer {
    width: 600px;
    height: 400px;
    margin: 20px auto;
    border: 1px solid #ccc;
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