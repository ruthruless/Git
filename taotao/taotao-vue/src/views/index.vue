<template>
  <div>
    <el-container>
      <el-header class="home-top">
        <top></top>
      </el-header>
    </el-container>

    <el-container>
      <el-header>
        <div class="search-top" style="margin-top: 15px;">
          <el-input placeholder="搜你喜欢" v-model="select" class="input-with-select">
            <el-button type="primary" slot="append" icon="el-icon-search">搜索</el-button>
          </el-input>
        </div>
      </el-header>
      <el-container>
        <el-aside width="250px">
          <h3 style="color: #FF6200" class="menu-top">主题市场</h3>
          <ul class="menu">
            <li>
              <img class="menu-logo" src="../assets/index/nz.png">
              <el-link class="menu-link">女装</el-link><span>/</span>
              <el-link class="menu-link">内衣</el-link><span>/</span>
              <el-link class="menu-link">家居</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/baby.png">
              <el-link class="menu-link">母婴</el-link><span>/</span>
              <el-link class="menu-link">童装</el-link><span>/</span>
              <el-link class="menu-link">玩具</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/shoe.png">
              <el-link class="menu-link">女鞋</el-link><span>/</span>
              <el-link class="menu-link">男鞋</el-link><span>/</span>
              <el-link class="menu-link">箱包</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/naz.png">
              <el-link class="menu-link">男装</el-link><span>/</span>
              <el-link class="menu-link">运动户外</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/makeups.png">
              <el-link class="menu-link">美妆</el-link><span>/</span>
              <el-link class="menu-link">彩妆</el-link><span>/</span>
              <el-link class="menu-link">个护</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/phone.png">
              <el-link class="menu-link">手机</el-link><span>/</span>
              <el-link class="menu-link">数码</el-link><span>/</span>
              <el-link class="menu-link">企业</el-link>
            </li>
            <li>
              <img class="menu-logo" src="../assets/index/home.png">
              <el-link class="menu-link">家纺</el-link><span>/</span>
              <el-link class="menu-link">家饰</el-link><span>/</span>
              <el-link class="menu-link">鲜花</el-link>
            </li>
          </ul>
        </el-aside>
        <el-main>
          <el-container>
            <el-aside width="600px">
              <el-carousel height="230px">
                <el-carousel-item v-for="item in items" :key="item">
                  <img :src="item"/>
                </el-carousel-item>
              </el-carousel>
            </el-aside>
            <el-main class="user">
              <div class="block">
                <el-avatar :size="50" :src="user.avatar"></el-avatar>
                <div>{{ user.username }}</div>
              </div>

              <div class="maction">

                <span v-show="!hasLogin"><el-link type="primary" href="/login">登录</el-link></span>

                <span v-show="hasLogin" ><el-link type="danger" @click="logout">退出</el-link></span>

                <el-divider direction="vertical"></el-divider>
                <span v-show="!hasLogin"><span><el-link href="/Register">注册</el-link></span></span>

                <el-divider direction="vertical"></el-divider>
                <span><el-link type="success" href="/blog/add">开店</el-link></span>
              </div>

            </el-main>
          </el-container>
        </el-main>
      </el-container>
    </el-container>

    <el-container>
      <el-header>
        <h2 class="theme">猜你喜欢</h2>
      </el-header>
      <el-main>
        <span class="commodity">
          <el-link :underline="false">
            <img src="../assets/index/nz.png">
            <div style="font-size: 15px;margin-top: 10px;">链接</div>
            <div style="font-size: 15px;margin-top: 10px;">￥90</div>
          </el-link>
        </span>
      </el-main>
    </el-container>

  </div>



</template>
<script>
  import top from "../components/top"
  export default {
    name: "index",
    components:{
      top:top,
    },
    data(){
      return{
        items:[
            "https://img.alicdn.com/tfs/TB1FjZ7VWL7gK0jSZFBXXXZZpXa-520-280.png",
            "https://gtms03.alicdn.com/tps/i3/TB1gXd1JXXXXXapXpXXvKyzTVXX-520-280.jpg",
            "https://gtms01.alicdn.com/tps/i1/TB1r4h8JXXXXXXoXXXXvKyzTVXX-520-280.jpg",
            "https://gtms02.alicdn.com/tps/i2/TB10vPXKpXXXXacXXXXvKyzTVXX-520-280.jpg",
            "https://img.alicdn.com/tfs/TB1wOidVWL7gK0jSZFBXXXZZpXa-520-280.jpg"
        ],
        select:"",
        user: {
          username: '请先登录',
          avatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
        },
        hasLogin: false
      }
    },
    methods:{
      logout(){
        const _this= this
        _this.$axios.get("/logout",{
          headers:{
            "Authorization":localStorage.getItem("token")
          }
        }).then(()=>{
          _this.$store.commit("REMOVE_INFO")
          _this.$router.push("/index")
        })
      }
    },
    create() {
      if (this.$store.getters.getUser.username) {
        this.user.username = this.$store.getters.getUser.username
        this.user.avatar = this.$store.getters.getUser.avatar

        this.hasLogin = true
      }
    }
  }
</script>
<style scoped>

  top{
    height: auto;
  }
  .search-top{
    margin-top: 10px;
    width: 50%;
    padding-left: 20%;
  }
  ol,ul{
    list-style: none;
  }
  li{
    margin-top: 10px;
  }
  .menu-logo{
    width: 16px;
    padding-right: 10px;
    vertical-align:middle;
  }
  .menu-link{
    padding-left: 5px;
    padding-right: 5px;
    height: 16px;
  }
  .menu-top{
    text-align: center;
    margin: 0;
    padding: 0;
  }
  .menu{
    text-align: left;
  }
  .user > div,.user > div > div{
    margin-top: 10px;
  }
  .user{
    margin-top: 30px;
  }
  .theme{
    text-align: left;
  }
  .commodity{
    border-radius: 10%;
    border: 1px solid black;
    height: 300px;
    width: 20%;
    list-style: none;
    text-align: left;
    padding-left: 35px;
    float: left;
  }
</style>