import router from "./router";
import "element-ui/src/locale/lang/el";

router.beforeEach((to,from,next)=>{
  if (to.matched.some(record=>record.meta.requireAuth)){
    const token = localStorage.getItem("token")
    console.log("------"+token)

    if (token){
      if (!(to.path === '/login')){
        next()
      }
    }else {
      next({
        path:'/login'
      })
    }
  }else {
    next()
  }
})