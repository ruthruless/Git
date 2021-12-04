<template>
  <div>
    <el-row>
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <el-link :underline="false" class="top-link">亲，请登录</el-link>
          <el-link :underline="false" class="top-link">免费注册</el-link>
          <el-link :underline="false" class="top-link">手机逛淘宝</el-link>
        </div>
      </el-col>
      <el-col :span="8"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="8">
        <div class="grid-content bg-purple top-link">
          <el-dropdown >
            <span class=" el-dropdown-link ">
              我的淘宝<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown" class="top-right">
              <el-link :underline="false" >已购的宝贝</el-link>
              <el-link :underline="false" >我的足迹</el-link>
            </el-dropdown-menu>
            </el-dropdown>
          <el-link :underline="false" class="top-right">免费注册</el-link>
          <el-link :underline="false" class="top-right">手机逛淘宝</el-link>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "top"
  }
</script>

<style scoped>


  .bg-purple-light {

  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .top-link{
    text-align: center;
    margin-top: 3px;
    padding-left: 5px;
    padding-right: 5px;
  }
  .top-right{
    padding-left: 5px;
    padding-right: 5px;
  }

</style>