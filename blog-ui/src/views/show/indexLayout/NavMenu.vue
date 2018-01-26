<template>
    <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#333"
    text-color="#fff"
    active-text-color="#1C86EE">
        <el-row>
            <el-col :xs="15" :sm="6" :md="6" :lg="6" :xl="4">
                <div class="show-navbar-title">
                    <span>
                         <router-link to="/" >衡钊清的博客</router-link>
                    </span>
                </div>
            </el-col>
            <el-col :xs="0" :sm="18" :md="18" :lg="18" :xl="20">
                <el-menu-item index="1">待开发1...</el-menu-item>
                <el-menu-item index="2">待开发2...</el-menu-item>
                <el-menu-item index="3">待开发3...</el-menu-item>
                <el-menu-item index="4" style="float:right; margin-right:10%;">登录</el-menu-item>
            </el-col>
            <el-col :xs="9" :sm="0" :md="0" :lg="0" :xl="0">
                <div style="float:right">
                    <el-submenu index="5">
                        <template slot="title">
                            <span class="svg-container">
                                <svg-icon icon-class="phoneMenu" class="phoneNavMenu"></svg-icon>
                            </span>
                        </template>
                        <el-menu-item index="2-1">待开发1...</el-menu-item>
                        <el-menu-item index="2-2">待开发2...</el-menu-item>
                        <el-menu-item index="2-3">待开发3...</el-menu-item>
                        <el-menu-item index="2-3">登录</el-menu-item>
                    </el-submenu>
                </div>
            </el-col>
        </el-row>    
    </el-menu>
</template>

<script>
export default {
  data() {
    return {
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
<style>
.show-navbar-title{
    margin-left: 10%;
    margin-top: 11px;
    margin-bottom: 8px;
    text-align: center;
    font-size: 28px;
    color: #fff;
}
.phoneNavMenu{
    width: 1.5rem !important;
    height: 1.5rem !important;
}
</style>
