<template>
  <div>
    <img src="../assets/IMG_7114.png" />
    <div class="table">
      <div>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="账号" prop="user">
            <el-input  v-model="ruleForm.user" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "register",
    data() {
      var checkEmail = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('邮箱不能为空'));
        }
        setTimeout(() => {
          const regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
          if (!regEmail.test(value)) {
            callback(new Error('请输入合法邮箱'));
          } else {
              callback();
          }
        }, 1000);
      };
      var validateUser = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入账号'));

        } else {

          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        }
        callback();
      };
      return {
        ruleForm: {
          user: '',
          pass: '',
          email: ''
        },
        rules: {
          user: [
            { validator: validateUser, trigger: 'blur' }
          ],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          email: [
            { validator: checkEmail, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
  img{
    width: 100%;
    height: 90%;
    position: relative;
    top: 50px;
  }
  .table{
    background: #FFFF;
    position: absolute;
    top: 120px;
    right: 100px;
    width:450px;
    height:400px;
    border:1px solid #D5D5D5
  }
  .table > div{
    margin-top: 80px;
    padding-right: 30px;
  }
</style>