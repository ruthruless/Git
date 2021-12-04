<template>
  <div>
    <top></top>
    <el-container>
      <el-header>

      </el-header>
      <el-main>
        <span class="commodity">
        <el-link :underline="false">
          <img src="../assets/index/nz.png">
          <div style="font-size: 15px;margin-top: 10px;">链接</div>
          <div style="font-size: 15px;margin-top: 10px;">￥90</div>
          <el-button>进入店铺</el-button>
          <el-button type="warning">警告按钮</el-button>
        </el-link>
        </span>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import top from "../components/top"
  export default {
    name: "commoditiesType",
    components:{
      top:top
    }
  }
</script>

<style scoped>
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