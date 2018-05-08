<template>
    <div class="showNavMenu">
                <h1 class="show-navbar-title">
                    <router-link to="/" >衡钊清博客</router-link>
                </h1>
                <ul class="nav"
                    v-loading="listLoading" 
                    element-loading-text="拼命加载中..."
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="#222"
                >
                    <li v-for="(item, index) in menuList" :key="index">
                        <div style="width:110px;">
                            <router-link :to="item.href">
                                {{item.menuName}}
                            </router-link>
                        </div>
                        <ul class="sub-menu">
                            <li v-for="(it,ind) in item.menusvo" :key="ind">
                                <router-link :to="it.href">
                                    {{it.menuName}}
                                </router-link>
                            </li>
                        </ul>
                    </li>
                </ul>
                <div class="navRight">
                    <router-link to="/login" v-if="showMenus === null || showMenus.length === 0">
                        <div class="login">
                            登录
                        </div>
                    </router-link>
                    <div v-else>
                        <div class="detail-comment-pic" style="height:52px;width:52px; padding:8px;">
                            <img src="static/img/touxiang.jpeg"/>
                        </div>
                        <ul class="sub-menu">
                            <li v-for="(it,ind) in showMenus" :key="ind">
                                <router-link :to="it.href">
                                    {{it.menuName}}
                                </router-link>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="moblieRight">
                    <el-dropdown placement="bottom" trigger="click">
                        <span class="svg-container">
                            <svg-icon icon-class="phoneMenu" class="phoneNavMenu"></svg-icon>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>写文章</el-dropdown-item>
                            <el-dropdown-item>狮子头</el-dropdown-item>
                            <el-dropdown-item>螺蛳粉</el-dropdown-item>
                            <el-dropdown-item disabled>双皮奶</el-dropdown-item>
                            <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getDefaultMenus } from '@/api/admin/system/menu/index'
export default {
  computed: {
    ...mapGetters([
      'token',
      'showMenus'
    ])
  },
  data() {
    return {
      activeIndex: '1',
      login: '',
      menuList: null,
      listLoading: true
    }
  },
  created() {
    this.getMenuList()
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    },
    getMenuList() {
      this.listLoading = true
      getDefaultMenus().then(response => {
        this.menuList = response.data
        this.listLoading = false
      })
    },
    logout() {
      this.$store.dispatch('LogOut').then(() => {
        location.reload() // 为了重新实例化vue-router对象 避免bug
      })
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
.showNavMenu {
    .show-navbar-title{
        margin: 0px;
        width: 200px;
        font-weight: 700;
        line-height: 52px;
        float: left;
    }
    .nav{
        position: relative;
        padding: 0px;
        left: 0;
        float: left;
        display: block;
        margin: 0 10px 0 0;
        font-size: 15px;
        list-style: none;
        min-width: 550px;
        height: 52px;
        li{
            position: relative;
            float: left;
            width: 110px;
            text-align: center;
            line-height: 52px;
        }
        li:hover{
            background-color: #404040;
        }
        li:hover .sub-menu{
            background-color: #404040;
            display: block;
        }

    }
    .sub-menu{
        position: absolute;
        top: 52px;
        z-index: 10;
        display: none;
        padding-bottom: 0;
        min-width: 110px;
        text-align: center;
        li{
            line-height: 30px;
            font-size: 12px;
            list-style: none;
        }
        li:hover{
            background: #ff7d44;
        }
    }
    .navRight{
        float: right;
        width: 59px;
        text-align: center;
        .sub-menu{
            
        }
    }
    .navRight:hover{
        background-color: #404040;
    }
    .navRight:hover .sub-menu{
        background-color: #404040;
        display: block;
    }
    .login{
        line-height: 52px;
        font-size: 15px;

    }
    .moblieRight{
        float: right;
        width: 59px;
        text-align: center;
        line-height: 52px;
        display: none;
    }
    .moblieRight:hover{
        background-color: #404040;
    }
    @media screen and (max-width:980px){
      .moblieRight{
        display: block;
      }
      .nav{
          display: none;
      }
      .navRight{
          display: none;
      }
    }
}
</style>
