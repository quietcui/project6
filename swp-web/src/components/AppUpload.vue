<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎</div>
            <div class="nav">
                <button @click="toindex">首页</button>
                <button>分类</button>
                <button @click="refresh">上传</button>
                <div class="userimgbox">
                    <img src="../assets/tou1.jpg" alt="" width="25" @click="touser">
                    <div>{{ this.$globalVar.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="form">
            <el-upload class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="false"
                     :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <input type="text" placeholder="输入图片名称..." v-model="tname">
            <input type="text" placeholder="输入图片价格￥(输入0即为免费分享)..." v-model="tprice">
            <input type="text" placeholder="输入图片类型..." v-model="ttype">
            <input type="text" placeholder="输入你的昵称..." v-model="tcreateId">
            <button @click="upload">上传</button>
        </div>
        <div class="footer">
            <p>© 2023 壁纸引擎. All rights reserved.</p>
        </div>
    </div>
</template>

<script>


export default {
    name: "AppUpload",
    data() {
        return {
            imageUrl: '',
            tname: '',
            tcreateId: '',
            tprice: '',
            ttype: '',
            tpath: ''
        };
    },
    methods: {
        toindex() {
            this.$router.push("/index");
        },
        touser() {
            this.$router.push("/user");
        },
        refresh() {
            location.reload();
        },
        toupload() {
            this.$router.push("/upload");
        },
        upload() {
            let vwallpaper = {
                vwpId: '001',
                name: this.tname,
                createId: this.tcreateId,
                price: this.tprice,
                type: this.ttype,
                path: ''

            }
            this.$axios.post('http://localhost:8090/vwallpaper/upload', vwallpaper)   /////////////////////////////////////////上传壁纸
        },
        handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        }
    }
}
</script>

<style>
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

.form {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
    margin-top: 20px;
}

.form input {
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
}</style>