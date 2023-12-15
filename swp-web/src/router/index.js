import VueRouter from "vue-router"
import login from '../components/AppLogin.vue'
import index from '../components/AppIndex.vue'
import user from '../components/AppUser.vue'
import register from '../components/AppRegister.vue'
import picture from '../components/AppPicture.vue'
import upload from '../components/AppUpload.vue'
import pictureload from '../components/PictureLoad.vue'
import pictureload2 from '../components/PictureLoad2.vue'
import showpicture from '../components/AppShowpicture.vue'
import pay from '../components/AppPay.vue'
import test from '../components/AppTest.vue'
import search from '../components/AppSearch.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/index',
    name: 'index',
    component: index
  },
  {
    path:"/user",
    name:'user',
    component: user
  },
  {
    path:"/register",
    name:"register",
    component: register
  },
  {
    path:"/picture",
    name:"picture",
    component: picture
  },
  {
    path:"/upload",
    name:"upload",
    component: upload
  },
  {
    path:"/pictureload",
    name:"pictureload",
    component: pictureload
  },
  {
    path:"/pictureload2",
    name:"pictureload2",
    component: pictureload2
  },
  {
    path:"/showpicture",
    name:"showpicture",
    component:showpicture
  },
  {
    path:"/pay",
    name:"pay",
    component:pay
  },
  {
    path:"/test",
    name:"test",
    component:test,
  },
  {
    path:"/search",
    name:"search",
    component:search,
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
