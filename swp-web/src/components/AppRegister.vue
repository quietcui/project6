<template>
    <div class="background">
        <div class="box">
            <h2>用户注册</h2>
            <div class="input-box">
                <label>账号</label>
                <input type="text" v-model="name">
            </div>
            <div class="input-box">
                <label>用户名</label>
                <input type="text" v-model="pname">
            </div>
            <div class="input-box">
                <label>密码</label>
                <input type="password" v-model="password">
            </div>
            <div class="input-box">
                <label>确认密码</label>
                <input type="password" v-model="ppassword">
            </div>
            <div class="btn-box">
                <div>
                    <button @click="tologin">返回登录</button>
                    <button @click="register">注册</button>
                </div>
            </div>
        </div>
    </div>
</template>
    
<script>

export default {
    name: 'AppRegister',
    data() {
        return {
            name: '',
            password: '',
            pname: '',
            ppassword: ''
        }
    },
    methods: {
        tologin(){
          this.$router.push("/");
        },
        register() {
            if (this.name == "") {
                alert("请输入账号")
                location.reload();
            }
            else if (this.pname == "") {
                alert("请输入用户名")
                location.reload();
            }
            else if (this.password == "") {
                alert("请输入密码")
                location.reload();
            }
            else if (this.password != this.ppassword) {
                alert("两次输入密码不一致")
                location.reload();
            }
            else {
                let user = {
                    userId: this.name,
                    name: this.pname,
                    password: this.password,
                    balance: '0'
                };

                let self = this;
                this.$axios.post('http://localhost:8090/user/register', user)
                    .then(function (response) {
                        let result = response.data;
                        if (result.code === 200) {
                            console.log("登录成功！");
                            console.log("返回的数据：", result.data);
                            console.log("总记录数：", result.total);
                            self.$router.push("/");
                        } else if (result.code === 400) {
                            console.log("登录失败！");
                            alert("该账号已被使用");
                            location.reload();
                        }
                    })
                    .catch(function (error) {
                        console.log("请求错误：", error);
                    });
            }

        }
    }
}


</script>
    
<style scoped>

* {
    margin: 0;
    padding: 0;
}

.background {
    height: 100vh;
    background: url(../assets/login_back.jpg) no-repeat;
    background-size: cover;
    display: flex;
    justify-content: center;
    align-items: center;
}

/*  */
.box {
    width: 350px;
    height: 400px;
    border-top: 1px solid rgba(255, 255, 255, 0.5);
    /* 在盒子的顶部添加一个1像素宽的边框，颜色为白色，透明度为50%。 */
    border-left: 1px solid rgba(255, 255, 255, 0.5);
    border-bottom: 1px solid rgba(255, 255, 255, 0.3);
    border-right: 1px solid rgba(255, 255, 255, 0.3);
    backdrop-filter: blur(10px);
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
    margin-top: 100px;
    margin-left: auto;
    margin-right: auto;
}

.box>h2 {
    color: rgba(255, 255, 255, 0.9);
    margin-bottom: 30px;
}

.box .input-box {
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
    margin-bottom: 10px;
    /*设置所选 <h2> 元素的底部外边距为30像素。这将在 <h2> 元素的下方留出 30 像素的空间。 */
}

.box .input-box label {
    font-size: 13px;
    color: rgba(255, 255, 255, 0.9);
    margin-bottom: 5px;
}

.box .input-box input {
    letter-spacing: 1px;
    font-size: 14px;
    box-sizing: border-box;
    width: 250px;
    height: 35px;
    border-radius: 5px;
    border: 1px solid rgba(255, 255, 255, 0.5);
    background: rgba(255, 255, 255, 0.2);
    outline: none;
    padding: 0 12px;
    color: rgba(255, 255, 255, 0.9);
    transition: 0.2s;
}

.box .input-box input:focus {
    border: 1px solid rgba(255, 255, 255, 0.8);
}

.box .btn-box {
    width: 250px;
    display: flex;
    flex-direction: column;
    align-items: start;
}

.box .btn-box>a {
    outline: none;
    display: block;
    width: 250px;
    text-align: end;
    text-decoration: none;
    font-size: 13px;
    color: rgba(255, 255, 255, 0.9);
}

.box .btn-box>a:hover {
    /* 悬停状态 */
    color: rgba(255, 255, 255, 1);
}

.box .btn-box>div {
    margin-top: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.box .btn-box>div>button {
    cursor: pointer;
    outline: none;
    margin-top: 10px;
    //margin-left: 60px;
    display: block;
    font-size: 14px;
    border-radius: 5px;
    transition: 0.2s;
}

.box .btn-box>div>button:nth-of-type(1) {
    width: 120px;
    height: 35px;
    color: rgba(255, 255, 255, 0.9);
    border: 1px solid rgba(192, 119, 91, 0.7);
    background: rgba(192, 119, 91, 0.5);
}

.box .btn-box>div>button:nth-of-type(2) {
    width: 120px;
    height: 35px;
    margin-left: 10px;
    color: rgba(255, 255, 255, 0.9);
    border: 1px solid rgba(192, 119, 91, 0.7);
    background: rgba(192, 119, 91, 0.5);
}

.box .btn-box>div>button:hover {
    border: 1px solid rgba(251, 128, 71, 0.7);
    background: rgba(251, 128, 71, 0.5);
}</style>
    
    