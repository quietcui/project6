
<!--<template>-->
<!--  <el-upload class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="false"-->
<!--    :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">-->
<!--    <img v-if="imageUrl" :src="imageUrl" class="avatar">-->
<!--    <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
<!--  </el-upload>-->
<!--</template>-->


<!--<style>-->
<!--.avatar-uploader .el-upload {-->
<!--  border: 1px dashed #d9d9d9;-->
<!--  border-radius: 6px;-->
<!--  cursor: pointer;-->
<!--  position: relative;-->
<!--  overflow: hidden;-->
<!--}-->

<!--.avatar-uploader .el-upload:hover {-->
<!--  border-color: #409EFF;-->
<!--}-->

<!--.avatar-uploader-icon {-->
<!--  font-size: 28px;-->
<!--  color: #8c939d;-->
<!--  width: 178px;-->
<!--  height: 178px;-->
<!--  line-height: 178px;-->
<!--  text-align: center;-->
<!--}-->

<!--.avatar {-->
<!--  width: 178px;-->
<!--  height: 178px;-->
<!--  display: block;-->
<!--}-->
<!--</style>-->


<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      imageUrl: ''-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    handleAvatarSuccess(res, file) {-->
<!--      this.imageUrl = URL.createObjectURL(file.raw);-->
<!--    },-->
<!--    beforeAvatarUpload(file) {-->
<!--      const isJPG = file.type === 'image/jpeg';-->
<!--      const isLt2M = file.size / 1024 / 1024 < 2;-->

<!--      if (!isJPG) {-->
<!--        this.$message.error('上传头像图片只能是 JPG 格式!');-->
<!--      }-->
<!--      if (!isLt2M) {-->
<!--        this.$message.error('上传头像图片大小不能超过 2MB!');-->
<!--      }-->
<!--      return isJPG && isLt2M;-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->


<template>
  <div>
    <v-btn
        color="success"
        class="mr-0"
        @click.stop.prevent="uploadFile($event)"
    @click="update ()"
    >
    Modificar
    </v-btn>
    <el-upload ref="upload" class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="false"
               :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :on-change="getFile"> <!-- 添加了ref和on-change属性 -->
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <el-button type="primary" @click="uploadFile">上传</el-button>
  </div>
</template>


<style scoped>
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
</style>


<script>
export default {
  data() {
    return {
      imageUrl: '',
      selectedFile: null
    };
  },
  methods: {
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
    },
    getFile (event) {
      const files = event.target.files
      let filename = files [0].name //只有一个文件
      if ( filename.lastIndexOf ('.') <= 0 ) {
        return alert ("Please add a valid image!") //判断图片是否有效
      }
      const fileReader = new FileReader () //内置方法new FileReader () 读取文件
      fileReader.addEventListener ('load', () => {
        this.imageUrl = fileReader.result
      })
      fileReader.readAsDataURL (files [0])
      this.selectedFile = files [0] //给this.selectedFile赋值
    },
    uploadFile () {
      this.$refs.upload.submit(this.selectedFile)
    }
  }
}
</script>