<template>
    <div class="container">
        <div class="header">
            <div class="logo">壁纸引擎--壁纸</div>
            <div class="nav">
                <button @click="toindex">首页</button>
                <button @click="refresh">刷新</button>
                <button @click="toupload">上传</button>
                <div class="userimgbox">
                    <img src="../assets/bg.jpg" alt="" width="25" @click="touser">
                    <div style=" color: #28e1f8;">{{ this.NAME }}</div>
                </div>
            </div>
        </div>
        <div class="nav">
            <button @click="tolastpage"> 《--返回上一页</button>
        </div>
        <div class="info">
            <div>壁纸名称: {{this.picturename}}</div>
            <div>壁纸价格: {{this.pictureprice}}￥</div>
            <div>壁纸创作者: {{this.picturecreatid}}</div>
          <img
              v-bind:src="isbuyHover ? require('@/assets/buyhover.png') : require('@/assets/buy.png')"
              v-on:mouseover="togglebuyHover(true)"
              v-on:mouseout="togglebuyHover(false)"
              width="30" @click="buypicture" title="购买"
          />
          <img
              v-bind:src="isloadHover ? require('@/assets/downloadhover.png') : require('@/assets/download.png')"
              v-on:mouseover="toggleloadHover(true)"
              v-on:mouseout="toggleloadHover(false)"
              width="30" @click="loadpicture" title="下载"
          />
          <img
              v-bind:src="islikeHover ? require('@/assets/likehover.png') : require('@/assets/like.png')"
              v-if="!likeflag"
              v-on:mouseover="togglelikeHover(true)"
              v-on:mouseout="togglelikeHover(false)"
              width="30" @click="likepicture" title="点赞"
          />
          <img
              v-bind:src="islikeHover ? require('@/assets/likehover.png') : require('@/assets/like1.png')"
              v-if="likeflag"
              v-on:mouseover="togglelikeHover(true)"
              v-on:mouseout="togglelikeHover(false)"
              width="30" @click="likepicture" title="点赞"
          />
          <img
              v-bind:src="iscollectHover ? require('@/assets/collecthover.png') : require('@/assets/collect.png')"
              v-if="!collectflag"
              v-on:mouseover="togglecollectHover(true)"
              v-on:mouseout="togglecollectHover(false)"
              width="30" @click="collectpicture" title="收藏"
          />
          <img
              v-bind:src="iscollectHover ? require('@/assets/collecthover.png') : require('@/assets/collect2.png')"
              v-if="collectflag"
              v-on:mouseover="togglecollectHover(true)"
              v-on:mouseout="togglecollectHover(false)"
              width="30" @click="collectpicture" title="收藏"
          />
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

import axios from "axios";

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
            pictureid:'',
            picturename:'',
            pictureprice:'',
            picturecreatid:'',
            picturesrc:'',
            lastpage:'',
            isbuyHover: false,
            iscollectHover: false,
            isloadHover: false,
            islikeHover: false,
            likeflag: false,
            collectflag:false,
        }
    },
    mounted() {
      // 在组件加载时自动执行的函数
      this.NAME=sessionStorage.getItem('NAME')
      this.USERID=sessionStorage.getItem('USERID')
      this.BALANCE=sessionStorage.getItem('BALANCE')
      this.PASSWORD=sessionStorage.getItem('PASSWORD')
      sessionStorage.setItem('USERCHOSE', 'myup')
      this.pictureid=this.$route.query.wpid;
      this.picturesrc=this.$route.query.name;
      sessionStorage.setItem('SEARCHTYPE', '')
      this.lastpage=sessionStorage.getItem('LASTURL')
      console.log(this.NAME)
      console.log(this.USERID)
      console.log(this.PASSWORD)
      console.log(this.BALANCE)
      console.log(this.$route.query.name)
      console.log(this.$route.query.wpid)
      console.log(this.picturesrc)

      this.postImagePrice();
      this.flaglikepicture();
      this.flagcollectpicture();

    },
    methods: {
      togglebuyHover(value) {
        this.isbuyHover = value;
      },
      togglecollectHover(value) {
        this.iscollectHover = value;
      },
      toggleloadHover(value) {
        this.isloadHover = value;
      },
      togglelikeHover(value) {
        this.islikeHover = value;
      },
      getsrc(){
        return this.picturesrc1;
      },
      flagcollectpicture(){
        let self = this;
        let mycollect = {
          vwpId: this.pictureid,
          userId: this.USERID,
        };
        this.$axios.post('http://localhost:8090/mycollect/queryCollect', mycollect)     ////////////////////////////////////登录信息
            .then(function (response) {
              let result = response.data;
              if (result.code === 200) {
                console.log("登录成功！");
                console.log("返回的数据：", result.data);
                console.log("总记录数：", result.total);
                if(result.data=="已经收藏")
                {
                  self.collectflag=true;
                }
                else if(result.data=="尚未收藏")
                {
                  self.collectflag=false;
                }

              } else if (result.code === 400) {
                alert("error");
                location.reload();
              }
            })
            .catch(function (error) {
              console.log("请求错误：", error);
            });
      },
      flaglikepicture(){
        let self = this;
        let mycollect = {
          vwpId: this.pictureid,
          userId: this.USERID,
        };
        this.$axios.post('http://localhost:8090/myfavourite/queryFavourite', mycollect)     ////////////////////////////////////登录信息
            .then(function (response) {
              let result = response.data;
              if (result.code === 200) {
                console.log("登录成功！");
                console.log("返回的数据：", result.data);
                console.log("总记录数：", result.total);
                if(result.data=="已经点赞")
                {
                  self.likeflag=true;
                }
                else if(result.data=="尚未点赞")
                {
                  self.likeflag=false;
                }

              } else if (result.code === 400) {
                alert("error");
                location.reload();
              }
            })
            .catch(function (error) {
              console.log("请求错误：", error);
            });
      },
      collectpicture(){
        let self = this;
          let mycollect = {
            vwpId: this.pictureid,
            userId: this.USERID,
          };
          this.$axios.post('http://localhost:8090/mycollect/doCollect', mycollect)     ////////////////////////////////////登录信息
              .then(function (response) {
                let result = response.data;
                if (result.code === 200) {
                  console.log("登录成功！");
                  console.log("返回的数据：", result.data);
                  console.log("总记录数：", result.total);
                  if(result.data=="成功收藏")
                  {
                    alert("收藏成功！");
                    location.reload();
                  }
                  else if(result.data=="取消收藏")
                  {
                    alert("您已取消收藏");
                    location.reload();
                  }

                } else if (result.code === 400) {
                    alert("error");
                    location.reload();
                }
              })
              .catch(function (error) {
                console.log("请求错误：", error);
              });
      },
      likepicture(){
        let self = this;
        let mycollect = {
          vwpId: this.pictureid,
          userId: this.USERID,
        };
        this.$axios.post('http://localhost:8090/myfavourite/doFavourite', mycollect)     ////////////////////////////////////登录信息
            .then(function (response) {
              let result = response.data;
              if (result.code === 200) {
                console.log("登录成功！");
                console.log("返回的数据：", result.data);
                console.log("总记录数：", result.total);
                if(result.data=="点赞成功")
                {
                  alert("点赞成功！感谢您对该壁纸的支持");
                  location.reload();
                }
                else if(result.data=="取消点赞")
                {
                  alert("您已取消点赞");
                  location.reload();
                }

              } else if (result.code === 400) {

                  alert("error");
                  location.reload();
              }
            })
            .catch(function (error) {
              console.log("请求错误：", error);
            });
      },
      loadpicture(){
        let self = this;
        if(this.picturecreatid==this.USERID)
        {self.downloadImg()}
        else
        {
          let user = {
            vwpId: this.pictureid,
            userId: this.USERID,
          };
          this.$axios.post('http://localhost:8090/vwpdownload/download', user)     ////////////////////////////////////登录信息
              .then(function (response) {
                let result = response.data;
                if (result.code === 200) {
                  console.log("登录成功！");
                  console.log("返回的数据：", result.data);
                  console.log("总记录数：", result.total);
                  self.downloadImg();

                } else if (result.code === 400) {
                  if (result.msg == "你还没购买过该壁纸") {
                    alert("您还没购买过该壁纸，无法下载");
                    location.reload();
                  }
                }
              })
              .catch(function (error) {
                console.log("请求错误：", error);
              });
        }
      },
      downloadImg() {
        let imgname1 = this.picturename;
        var image = new Image();
        console.log(this.picturename);
        // 解决跨域 Canvas 污染问题
        image.setAttribute("crossOrigin", "anonymous");

        // 保存组件实例
        var vm = this;

        image.onload = function () {
          var canvas = document.createElement("canvas");
          canvas.width = image.width;
          canvas.height = image.height;
          var context = canvas.getContext("2d");
          context.drawImage(image, 0, 0, image.width, image.height);

          // 获取原始二进制数据
          canvas.toBlob(function (blob) {
            var url = window.URL.createObjectURL(blob); // 创建一个 Blob URL
            var a = document.createElement("a"); // 生成一个 <a> 元素
            var event = new MouseEvent("click"); // 创建一个单击事件
            console.log(vm.picturename); // 使用保存的组件实例

            a.download = imgname1 || "photo"; // 设置图片名称
            a.href = url; // 将生成的 Blob URL 设置为 a.href 属性
            a.dispatchEvent(event); // 触发 <a> 的单击事件

            // 释放 Blob URL
            window.URL.revokeObjectURL(url);
          });
        };
        image.src = this.picturesrc;
      },
      buypicture(){
        let user = {
          vwpId: this.pictureid,
          orderId:'',
          buyerId:this.USERID,
        };
        if(this.BALANCE<this.pictureprice)
        {
          alert("抱歉，您无法购买此壁纸，因为您的余额不足");
          location.reload();
        }
        if(this.USERID==this.picturecreatid)
        {
          alert("抱歉，您无法购买此壁纸，因为您是壁纸的上传者");
          location.reload();
        }
        let self = this;
        this.$axios.post('http://localhost:8090/vwporder/purchaseImage', user)     ////////////////////////////////////登录信息
            .then(function (response) {
              let result = response.data;
              if (result.code === 200) {
                console.log("登录成功！");
                console.log("返回的数据：", result.data);
                console.log("总记录数：", result.total);
                sessionStorage.setItem('BALANCE', result.data.balance)
                alert("购买成功！");
                location.reload();

              } else if (result.code === 400) {
                console.log("失败！");
                console.log(result);
                if(result.msg == "不需要购买!") {
                  alert("该壁纸由创作者免费提供，您无需购买，可直接下载");
                  location.reload();
                }
                if(result.msg == "不能购买自己上传的壁纸") {
                  alert("您无法购买此壁纸，因为你是此壁纸的上传者");
                  location.reload();
                }
                if(result.msg == "余额不足") {
                  alert("您无法购买此壁纸，因为您的余额不足");
                  location.reload();
                }
                if(result.msg == "你已购买过该壁纸") {
                  alert("您无法购买此壁纸，因为您已经购买过该壁纸，可直接下载");
                  location.reload();
                }
              }
            })
            .catch(function (error) {
              console.log("请求错误：", error);
            });

      },
        tolastpage(){
          let self = this;
          console.log(this.lastpage);
          self.$router.push(this.lastpage);
        },
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
        },
        refresh() {
          sessionStorage.setItem('SEARCHTYPE', '')
          location.reload();
        },
        async postImagePrice() {
        let vwallpaper = {

          vwpId:this.pictureid ,
          name:'',
          createId:'',
          price:'',
          type:'',
          path:''

        };
        try {
          //使用axios发送一个GET请求，假设后端有一个接口可以返回图片的文件名
          let response = await axios.post("http://localhost:8090/vwallpaper/getImagesByVwpid",vwallpaper);
          //如果请求成功，将文件名保存到imageName属性中
          if (response.status === 200) {
            console.log(response.data);
            console.log(this.imageName);
            this.picturename=response.data.data[0].name;
            this.picturecreatid=response.data.data[0].createId;
            this.pictureprice=response.data.data[0].price;

          }
        } catch (error) {
          //如果请求失败，打印错误信息
          console.error(error);
        }
      },
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
    margin-left: 90px;

  gap: 20px;
  width: 1000px;
  height: 100px;
  margin-right: 10px;
  object-fit: cover;
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  /* 在盒子的顶部添加一个1像素宽的边框，颜色为白色，透明度为50%。 */
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(10px);
  /* 对盒子应用一个模糊半透明的效果，模糊半径为10像素。这样可以创建玻璃模糊的效果，模糊盒子后面的内容。 */
  background: rgba(50, 50, 50, 0.2);
  /* 设置盒子的背景颜色为半透明的深灰色（RGB值为50, 50, 50），透明度为20%。 */

  /* 设置盒子使用Flexbox布局。 */
  /* 将Flex容器的主轴方向设置为垂直，使得项目在列方向上排列。 */
  justify-content: center;
  /*  在盒子的垂直方向上居中内容。 */
  align-items: center;
  /* 在盒子的水平方向上居中内容。 */
  border-radius: 10px;
  /* 应用一个10像素的圆角，使得盒子的角变得圆滑。 */
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
  background-color: #cc8b00;
    cursor: pointer;
}


.info img:hover {
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
    
    