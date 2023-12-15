<template>
  <div class="image-viewer">
    <el-button type="primary" @click="postImageName">获取图片</el-button>

    <el-image v-if="imageName" :src="`http://localhost:8090/vwallpaper/ShowPicture?filepath=${imageName}`" fit="contain"></el-image>
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
  methods: {
    //定义一个方法，用于从后端获取图片的文件名
    async postImageName() {
      let vwallpaper = {

        vwpId:'' ,
        name:'',
        createId:'',
        price:'',
        type:'美女',
        path:''

      };
      try {
        //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
        let response = await axios.post("http://localhost:8090/vwallpaper/getImagesByTypeAndName",vwallpaper);
        //如果请求成功，将文件名保存到imageName属性中
        if (response.status === 200) {
          this.imageName = response.data.data[0].path;
          console.log(response.data);
          console.log(this.imageName);
        }
      } catch (error) {
        //如果请求失败，打印错误信息
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.image-viewer {
  width: 600px;
  height: 400px;
  margin: 20px auto;
  border: 1px solid #ccc;
}
</style>
