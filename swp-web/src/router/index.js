import VueRouter from "vue-router"
import login from '../components/AppLogin.vue'
import index from '../components/AppIndex.vue'
import user from '../components/AppUser.vue'
import register from '../components/AppRegister.vue'
import picture from '../components/AppPicture.vue'
import upload from '../components/AppUpload.vue'
import pictureload from '../components/PictureLoad.vue'
import showpicture from '../components/AppShowpicture.vue'

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
    path:"/showpicture",
    name:"showpicture",
    component:showpicture
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
