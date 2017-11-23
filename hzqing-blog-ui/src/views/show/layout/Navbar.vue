<template>
  <div id="navbar" class="navbar-div">
        <el-row>
            <el-col :span="4">
                <div class="show-navbar-title">
                    <router-link to="/">
                         衡钊清的博客
                    </router-link>
                </div>
            </el-col>
            <el-col :span="17">
                <el-menu :default-active="activeIndex" class="el-menu-demo show-navbar-menu" mode="horizontal" @select="handleSelect">
                    <el-menu-item index="1">
                        <router-link to="/">
                            首页
                        </router-link>
                    </el-menu-item>
                    <el-menu-item index="2">
                        <router-link to="/">
                            待开发
                        </router-link>
                    </el-menu-item>
                    <el-menu-item index="3">
                        <router-link to="/">
                            简介
                        </router-link>
                    </el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span="3">
                <div class="show-navbar-login" hidden>
                    <router-link to="/login">
                    登陆
                    </router-link>
                </div>
            </el-col>
        </el-row>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        activeIndex: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
<style>
.show-navbar-menu{
    background: white;
}
.show-navbar-title{
    text-align: right;
    font-size: 28px;
    margin: 14px 30px 10px 10px;
}
.navbar-div{
    border: 1px solid #f0f0f0;
}
.show-navbar-login{
    font-size: 15px;
    margin: 21px 10px 10px 18px;
}
</style>
