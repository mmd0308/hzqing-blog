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
                        <div>
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
                        <div style="width:52px;height:52px;padding:6px">
                            <vue-avatar class="vue-avatar fl" username='Heng Zhao Qing' :src="avatar" size="40"></vue-avatar>
                        </div>
                        <ul class="sub-menu">
                            <li v-for="(it,ind) in showMenus" :key="ind" @click="handlerNav(it.href)">
                              {{it.menuName}}
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="moblieRight">
                    <span class="svg-container">
                        <svg-icon icon-class="phoneMenu" class="phoneNavMenu"></svg-icon>
                    </span>
                    <ul class="moblie-menu sub-menu">
                        <li v-for="(it,ind) in menuList" :key="ind" @click="handlerNav(it.href)">
                            {{it.menuName}}
                        </li>
                    </ul>
                </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getDefaultMenus } from '@/api/manager/system/menu/index'
import vueAvatar from 'vue-avatar'
export default {
  components: {
    vueAvatar
  },
  computed: {
    ...mapGetters([
      'token',
      'showMenus',
      'avatar'
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
    },
    handlerNav(href) {
      if (href === '/logout') {
        this.logout()
      } else {
        this.$router.push({
          path: href
        })
      }
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
.showNavMenu {
    .show-navbar-title{
        margin: 0px;
        width: var(--hzq-nav-web-headers);
        font-weight: 700;
        line-height: 52px;
        float: left;
    }
    .nav{
        position: relative;
        padding: 0px;
        left: 0;
        float: left;
        margin: 0 10px 0 0;
        font-size: 15px;
        list-style: none;
        height: 52px;
        display: var(--hzq-nav-web-disply);
        li{
            position: relative;
            float: left;
            width: var(--hzq-nav-web-menus);
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
        display: var(--hzq-nav-web-disply);
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
        display: var(--hzq-nav-moblie-disply);
        .moblie-menu{
            width: 100%;
            right: 0px;
            z-index: 50;
        }
    }
    .moblieRight:hover{
        background-color: #404040;
    }
    .moblieRight:hover .sub-menu{
        background-color: #404040;
        display: block;
    }
}
</style>
