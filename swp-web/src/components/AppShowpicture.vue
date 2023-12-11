<template>
  <div class="image-viewer">
    <el-image v-if="imageName" :src="`http://localhost:8090/user/download?name=${imageName}`" fit="contain"></el-image>
  </div>
</template>
  
<script>
import axios from "axios";
export default {
  name: "ImageViewer",
  data() {
    return {
      imageName: "", //用于保存图片的文件名
    };
  },
  mounted: {
    async getImageName() {
      try {
        //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
        let response = await axios.get("http://localhost:8090/user/get-image-name");
        //如果请求成功，将文件名保存到imageName属性中
        if (response.status === 200) {
          this.imageName = response.data;
        }
      } catch (error) {
        //如果请求失败，打印错误信息
        console.error(error);
      }
    },
  },
  methods: {

  },
};
</script>
  
<style scoped>
.image-viewer {
  width: 600px;
  height: 400px;
  margin: 20px auto;
}
</style>
  