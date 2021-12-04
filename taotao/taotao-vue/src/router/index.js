import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Index from '../views/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    //redirect: {name: "Index"}
    component: Index
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    // meta: {
    //   requireAuth: true
    // }
  },

  // {
  //   path: '/Index',
  //   name: 'Index',
  //   component: Index,
  //   meta: {
  //     requireAuth: true
  //   }
  // }
  // {
  //   path: '/blog/add',
  //   name: 'Login',
  //   component: Index,
  //   meta: {
  //     requireAuth: true
  //   }
  // },
  // {
  //   path: '/blog/:blogId/edit',
  //   name: 'Login',
  //   component: Login,
  //   meta: {
  //     requireAuth: true
  //   }
  //}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
