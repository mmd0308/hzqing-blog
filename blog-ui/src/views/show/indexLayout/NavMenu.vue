<template>
    <div>
        <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#333"
        text-color="#fff"
        :router="true"
        active-text-color="#1C86EE">
            <el-row>
                <el-col :xs="15" :sm="6" :md="6" :lg="6" :xl="4">
                    <div class="show-navbar-title">
                        <span>
                            <router-link to="/" >衡钊清的博客</router-link>
                        </span>
                    </div>
                </el-col>
                <el-col :xs="0" :sm="13" :md="14" :lg="15" :xl="18">
                    <el-menu-item index="1">待开发1...</el-menu-item>
                    <el-menu-item index="2">待开发2...</el-menu-item>
                    <el-menu-item index="3">待开发3...</el-menu-item>
                </el-col>
                 <el-col :xs="0" :sm="5" :md="4" :lg="3" :xl="2">
                    <el-menu-item index="login" v-if="login != ''">登录</el-menu-item>
                    <el-submenu index="5" v-else>
                        <template slot="title">
                            <div class="detail-comment-pic" style="height:40px;width:40px;vertical-align: text-bottom;">
                                <img src="static/img/touxiang.jpeg"/>
                            </div>
                        </template>
                        <el-menu-item index="2-1">写文章</el-menu-item>
                        <el-menu-item index="2-2">待开发2...</el-menu-item>
                        <el-menu-item index="2-3">待开发3...</el-menu-item>
                        <el-menu-item index="2-4">登录</el-menu-item>
                    </el-submenu>
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
    </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: '1',
      login: ''
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
