<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎--上传</div>
            <div class="nav">
                <button @click="toindex">首页</button>
                <button @click="refresh">刷新</button>
                <button @click="refresh">上传</button>
                <div class="userimgbox">
                    <img src="../assets/bg.jpg" alt="" width="25" @click="touser">
                    <div style=" color: #28e1f8;">{{ this.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="form">
          <div class="uploadbox">
          <el-upload class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="false"
                     :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :on-change="handleFileChange"
                     :data="Vwallpaper" :auto-upload="false" ref="upload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
          </div>
            <input type="text" placeholder="输入图片名称..." v-model="tname">
            <input type="text" placeholder="输入图片价格￥(输入0即为免费分享)..." v-model="tprice">
            <div class="chosebox">请选择图片类型...</div>
            <el-radio-group v-model="ttype">
              <el-radio-button label="风景"></el-radio-button>
              <el-radio-button label="动物"></el-radio-button>
              <el-radio-button label="美女"></el-radio-button>
              <el-radio-button label="动漫"></el-radio-button>
              <el-radio-button label="游戏"></el-radio-button>
              <el-radio-button label="电影"></el-radio-button>
              <el-radio-button label="明星"></el-radio-button>
              <el-radio-button label="科幻"></el-radio-button>
              <el-radio-button label="其他"></el-radio-button>
            </el-radio-group>
            <el-button @click="Upload">上传</el-button>
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
          Vwallpaper: {
            // 额外的参数
            vwpId: '',
            name: null,
            createId: '',
            price: '',
            type: '',
            path: ''
            // ...
          },
            NAME:'',
            BALANCE:'',
            USERID:'',
            PASSWORD:'',
            imageUrl: '',
            tname: null,
            tprice: '',
            ttype: '风景',
        };
    },
    mounted() {
      // 在组件加载时自动执行的函数
      this.NAME=sessionStorage.getItem('NAME')
      this.USERID=sessionStorage.getItem('USERID')
      this.BALANCE=sessionStorage.getItem('BALANCE')
      this.PASSWORD=sessionStorage.getItem('PASSWORD')
      sessionStorage.setItem('USERCHOSE', 'myup')
      sessionStorage.setItem('LASTURL', '/upload')
      console.log(this.NAME)
      console.log(this.USERID)
      console.log(this.PASSWORD)
      console.log(this.BALANCE)
      sessionStorage.setItem('SEARCHTYPE', '')
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
        Upload() {
          this.Vwallpaper.name=this.tname;
          this.Vwallpaper.createId=this.USERID;
          this.Vwallpaper.price=this.tprice;
          this.Vwallpaper.type= this.ttype;
          if(this.tname==null)
          {
            alert("上传失败！图片名不能为空，请输入图片名")
            location.reload();
            return;
          }
          if(this.tprice==null)
          {
            alert("上传失败！价格不能为空，请输入价格，免费分享请输入0");
            location.reload();
          }
          console.log(this.Vwallpaper);
          this.$refs.upload.submit();
        },
        handleFileChange(file) {
          this.imageUrl = URL.createObjectURL(file.raw);
        },
        handleAvatarSuccess(response) {
          // this.imageUrl = URL.createObjectURL(file.raw);
          console.log(response);
          console.log(response.data);
          let result=response;
          if(result.code === 200)
          {
            alert("上传成功！")
            location.reload();
          }
          if(result.code === 400) {
            alert("上传失败！价格不能为空，请输入价格，免费分享请输入0")
            location.reload();
          }
        },
        beforeAvatarUpload(file) {
          const isJPG = file.type === 'image/jpeg';
          const isPNG = file.type === 'image/png';
          const isLt2M = file.size / 1024 / 1024 <10;

          if (!isJPG&&!isPNG) {
            this.$message.error('上传图片只能是 JPG 或 PNG 格式!');
          }
          if (!isLt2M) {
            this.$message.error('上传图片大小不能超过 10MB!');
          }
          return isJPG && isLt2M
        }
    }
}
</script>

<style scoped>
.uploadbox{
  border: 1px solid #ccc;
  background-color: rgba(169, 190, 188, 0.49);
}
.chosebox {
  width: 350px;
  height: 50px;
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
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
    color: #28e1f8;
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
  color: #28e1f8;
  font-size: 20px;
  font-weight: 600;
    border: none;
    background-color: rgba(255, 255, 255, 0);
}

.nav button:hover {
    color: #ff0062;
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
}
.userimgbox img{
  width: 35px;
  height: 35px;
  border-radius: 50%;
  object-fit: cover;
}
</style>