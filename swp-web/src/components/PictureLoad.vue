
<!--<template>-->
<!--  <el-upload class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="true"-->
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


<!--<template>-->
<!--  <div>-->
<!--    <el-upload ref="upload" class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="false"-->
<!--               :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :on-change="getFile"> &lt;!&ndash; 添加了ref和on-change属性 &ndash;&gt;-->
<!--      <img v-if="imageUrl" :src="imageUrl" class="avatar">-->
<!--      <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
<!--    </el-upload>-->
<!--    <el-button type="primary" @click="uploadFile">上传</el-button>-->
<!--  </div>-->
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
<!--      imageUrl: '',-->
<!--      selectedFile: null-->
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
<!--    },-->
<!--    getFile (event) {-->
<!--      const files = event.target.files-->
<!--      let filename = files [0].name //只有一个文件-->
<!--      if ( filename.lastIndexOf ('.') <= 0 ) {-->
<!--        return alert ("Please add a valid image!") //判断图片是否有效-->
<!--      }-->
<!--      const fileReader = new FileReader () //内置方法new FileReader () 读取文件-->
<!--      fileReader.addEventListener ('load', () => {-->
<!--        this.imageUrl = fileReader.result-->
<!--      })-->
<!--      fileReader.readAsDataURL (files [0])-->
<!--      this.selectedFile = files [0] //给this.selectedFile赋值-->
<!--    },-->
<!--    uploadFile () {-->
<!--      this.$refs.upload.submit(this.selectedFile)-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->




<!--<template>-->
<!--  <div>-->
<!--  <el-upload ref="upload" class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload" :show-file-list="true"-->
<!--     :before-upload="beforeAvatarUpload" :on-change="handleFileChange">-->
<!--    <img v-if="imageUrl" :src="imageUrl" class="avatar">-->
<!--    <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
<!--  </el-upload>-->
<!--    <el-button @click="uploadFile">上传</el-button>-->
<!--  </div>-->
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
<!--      imageUrl: '',-->
<!--      selectedFile: null,-->
<!--      selectedFile1: null,-->
<!--      flag:"false",-->
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
<!--      this.selectedFile = file; // 存储选中的文件-->
<!--      this.selectedFile1 = file;-->

<!--      console.log(this.flag);-->

<!--      return false;-->
<!--    },-->
<!--    handleFileChange(file) {-->
<!--      this.imageUrl = URL.createObjectURL(file.raw);-->
<!--      this.selectedFile = file.raw;-->
<!--    },-->
<!--    uploadFile() {-->
<!--      this.flag="true";-->
<!--      console.log(this.flag);-->
<!--      if (!this.selectedFile) {-->
<!--        return this.$message.error('请先选择一个文件！');-->
<!--      }-->
<!--      this.$refs.upload.submit(this.selectedFile); // 手动触发上传-->
<!--      this.$axios.post('http://localhost:8090/vwallpaper/upload',this.selectedFile1)-->
<!--    },-->
<!--  }-->
<!--}-->
<!--</script>-->



<!--<template>-->
<!--  <div>-->
<!--  <el-upload class="avatar-uploader" action="http://localhost:8090/vwallpaper/upload"-->
<!--             :show-file-list="true" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :auto-upload="false" ref="upload">-->
<!--    <img v-if="imageUrl" :src="imageUrl" class="avatar">-->
<!--    <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
<!--  </el-upload>-->
<!--  <el-button type="primary" @click="submitUpload">上传图片</el-button>-->
<!--  </div>-->
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
<!--    submitUpload() {-->
<!--      this.$refs.upload.submit(); // 调用 el-upload 的 submit 方法-->
<!--    },-->
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
  <div>
    <el-radio-group v-model="radio1">
      <el-radio-button label="上海"></el-radio-button>
      <el-radio-button label="北京"></el-radio-button>
      <el-radio-button label="广州"></el-radio-button>
      <el-radio-button label="深圳"></el-radio-button>
    </el-radio-group>
  </div>
  <div style="margin-top: 20px">
    <el-radio-group v-model="radio2" size="medium">
      <el-radio-button label="上海" ></el-radio-button>
      <el-radio-button label="北京"></el-radio-button>
      <el-radio-button label="广州"></el-radio-button>
      <el-radio-button label="深圳"></el-radio-button>
    </el-radio-group>
  </div>
  <div style="margin-top: 20px">
    <el-radio-group v-model="radio3" size="small">
      <el-radio-button label="上海"></el-radio-button>
      <el-radio-button label="北京" disabled ></el-radio-button>
      <el-radio-button label="广州"></el-radio-button>
      <el-radio-button label="深圳"></el-radio-button>
    </el-radio-group>
  </div>
  <div style="margin-top: 20px">
    <el-radio-group v-model="radio4" disabled size="mini">
      <el-radio-button label="上海"></el-radio-button>
      <el-radio-button label="北京"></el-radio-button>
      <el-radio-button label="广州"></el-radio-button>
      <el-radio-button label="深圳"></el-radio-button>
    </el-radio-group>
  </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      radio1: '上海',
      radio2: '上海',
      radio3: '上海',
      radio4: '上海'
    };
  }
}
</script>







