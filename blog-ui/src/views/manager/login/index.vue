<template>
  <div class="login-container">
    <div class="login-register">
      <h3 class="title">
        <div :class="{'check-item':formStates === 'login','title-item':true}" @click="checkForm('login')">登录</div>
        <b>|</b>
        <div :class="{'check-item':formStates === 'register','title-item':true}" @click="checkForm('register')"> 注册</div>
      </h3>
      <!-- 登录 -->
      <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left" label-width="0px" v-if="formStates === 'login'"
        class="card-box login-form">
        <el-form-item prop="username">
          <span class="svg-container svg-container_login">
            <svg-icon icon-class="user" />
          </span>
          <el-input name="username" type="text" v-model="loginForm.username" autoComplete="on" placeholder="邮箱或手机号" />
        </el-form-item>
        <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password"></svg-icon>
          </span>
          <el-input name="password" :type="pwdType" @keyup.enter.native="handleLogin" v-model="loginForm.password" autoComplete="on"
            placeholder="密码"></el-input>
            <span class="show-pwd" @click="showPwd"><svg-icon icon-class="eye" /></span>
        </el-form-item>
        <div class="tips">
          <span style="margin-right:20px;">用户名: guest</span>
          <span> 密码: guest</span>
        </div>
        <el-button type="primary" style="width:100%; border-radius: 25px;" :loading="loading" @click.native.prevent="handleLogin">
          登 录
        </el-button>
        <div class="more-sign">
          <h6>社交帐号登录</h6>
          <div>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="weibo"></svg-icon> 
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="weixin"></svg-icon> 
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="hzqing-qq"></svg-icon> 
            </el-tooltip>
          </div>
        </div>
      </el-form>
      <!-- 注册 -->
      <el-form autoComplete="on" :model="regForm" :rules="regRules" ref="regForm" label-position="left" label-width="0px" v-if="formStates === 'register'"
        class="card-box login-form">

        <el-form-item prop="nickName">
          <span class="svg-container svg-container_login">
            <svg-icon icon-class="user" />
          </span>
          <el-input  type="text" v-model="regForm.nickName" autoComplete="on" placeholder="昵称" />
        </el-form-item>

        <el-form-item prop="email">
          <span class="svg-container svg-container_login">
            <svg-icon icon-class="reg-email" />
          </span>
          <el-input type="text" v-model="regForm.email" autoComplete="on" placeholder="邮箱" />
        </el-form-item>

        <el-form-item prop="phone">
          <span class="svg-container svg-container_login">
            <svg-icon icon-class="phone" />
          </span>
          <el-input type="text" v-model="regForm.phone" autoComplete="on" placeholder="手机号" />
        </el-form-item>

        <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password"></svg-icon>
          </span>
          <el-input name="password" :type="pwdType" @keyup.enter.native="handleRegister" v-model="regForm.password" autoComplete="on"
            placeholder="密码"></el-input>
            <span class="show-pwd" @click="showPwd"><svg-icon icon-class="eye" /></span>
        </el-form-item>

        <el-button type="primary" style="width:100%; border-radius: 25px;" :loading="loading" @click.native.prevent="handleRegister">
          注 册
        </el-button>
        <div class="more-sign">
          <h6>社交帐号注册</h6>
          <div>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="weibo"></svg-icon> 
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="weixin"></svg-icon> 
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="待开发...." placement="bottom-end">
              <svg-icon class="login-icon" icon-class="hzqing-qq"></svg-icon> 
            </el-tooltip>
          </div>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { register } from '@/api/manager/system/user/login'
export default {
  name: 'login',
  data() {
    const validatePass = (rule, value, callback) => {
      if (value.length < 5) {
        callback(new Error('密码不能小于5位'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        username: '',
        password: ''
      },
      regForm: {
        nickName: '',
        phone: '',
        password: '',
        email: ''
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur', message: '请输入邮箱或者手机号' }],
        password: [{ required: true, trigger: 'blur', validator: validatePass }]
      },
      regRules: {
        nickName: [{ required: true, trigger: 'blur', message: '请输入昵称' }]
      },
      loading: false,
      pwdType: 'password',
      formStates: 'login'
    }
  },
  methods: {
    showPwd() {
      if (this.pwdType === 'password') {
        this.pwdType = ''
      } else {
        this.pwdType = 'password'
      }
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store.dispatch('Login', this.loginForm).then(() => {
            this.loading = false
            // 判断，根据用户不同，返回不同的界面
            this.$router.push({ path: '/index' }) // 登录成功返回的页面
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('登录校验错误')
          return false
        }
      })
    },
    handleRegister() {
      this.$refs.regForm.validate(valid => {
        if (valid) {
          this.loading = true
          register(this.regForm).then(() => {
            this.$notify({
              title: '成功',
              message: '恭喜你！你已注册成功，请登录！',
              type: 'success',
              duration: 2000
            })
            this.loading = false
            this.formStates = 'login'
          })
        } else {
          console.log('注册校验错误')
          return false
        }
      })
    },
    checkForm(item) {
      this.formStates = item
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#969696;

  .login-container {
    position: fixed;
    height: 100%;
    width:100%;
    background-color: #f1f1f1;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
    }
    .tips {
      font-size: 14px;
      color: $light_gray;
      margin: 20px 0px;
      text-align: center;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 18px;
      color: $light_gray;
      margin: auto;
      text-align: center;
      font-weight: 400;
      padding: 30px 0px 0px;
      .title-item {
        padding: 0px 0px  5px;
        margin: 0px 15px;
        display: inline;
      }
      .title-item:hover{
        border-bottom: 2px solid #e05143;
      }
      .check-item{
        color: #e05143;
        border-bottom: 2px solid #e05143;
      }
    }
    .login-register{
      width: 400px;
      margin: 120px auto;
      background: #fff;
    }
    .login-form {
      padding: 40px 35px 35px 35px;
      border-radius: 4px;
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select:none;
    }
    .thirdparty-button{
      position: absolute;
      right: 35px;
      bottom: 28px;
    }
    .more-sign{
      margin-top: 20px;
      text-align: center;
    }
    .more-sign h6{
      position: relative;
      margin: 0 0 20px;
      font-size: 11px;
      color: #b5b5b5;
      font-weight: 500;
    }
    .more-sign h6:before{
      content: "";
      border-top: 1px solid #b5b5b5;
      display: block;
      position: absolute;
      width: 60px;
      top: 5px;
      left: 30px;
    }
    .more-sign h6:after{
      content: "";
      border-top: 1px solid #b5b5b5;
      display: block;
      position: absolute;
      width: 60px;
      top: 5px;
      right: 30px;
    }
    .login-icon{
      width: 32px !important;
      height: 32px !important;
      margin: 0 15px;
    }
  }
</style>
