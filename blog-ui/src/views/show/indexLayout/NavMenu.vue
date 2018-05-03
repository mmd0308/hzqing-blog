<template>
    <div class="showNavMenu">
                <h1 class="show-navbar-title">
                    <router-link to="/" >衡钊清的博客</router-link>
                </h1>
                <ul class="nav">
                    <li>
                        <el-dropdown placement="bottom" trigger="hover" @command="handleCommand">
                            <div style="width:110px;">
                                <router-link to="/blog?navHeader=学无止境">
                                学无止境
                                </router-link>
                            </div>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="java">Java</el-dropdown-item>
                                <el-dropdown-item divided command="hadoop">Hadoop</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </li>
                    <li>
                        <el-dropdown placement="bottom" trigger="hover" @command="handleCommand">
                            <div style="width:110px;">
                                <router-link to="/blog">
                                    Elastic Stack
                                </router-link>
                            </div>
                            <!-- <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="java">Logstash</el-dropdown-item>
                                <el-dropdown-item divided command="admin">Elasticsearch</el-dropdown-item>
                                <el-dropdown-item divided command="admin">Kibana</el-dropdown-item>
                            </el-dropdown-menu> -->
                        </el-dropdown>
                    </li>
                    <li>
                        <router-link to="/works" >
                            作品展示
                        </router-link>
                    </li>
                    <li>
                        <router-link to="/diary" >
                            个人日记
                        </router-link>
                    </li>
                    <li>
                        <router-link to="/message" >
                            给我留言
                        </router-link>
                    </li>
                </ul>
                <div class="navRight">
                    <router-link to="/login" v-if="token === undefined">
                        <div class="login">
                            登录
                        </div>
                    </router-link>
                    <div v-else>
                        <el-dropdown placement="bottom" trigger="click" @command="handleCommand">
                            <div class="detail-comment-pic" style="height:40px;width:40px; line-height: 84px;">
                                <img src="static/img/touxiang.jpeg"/>
                            </div>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="write">写文章</el-dropdown-item>
                                <el-dropdown-item command="set">设置</el-dropdown-item>
                                <el-dropdown-item command="admin">平台管理</el-dropdown-item>
                                <el-dropdown-item divided command="loyout">退出</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </div>
                </div>
                <div class="moblieRight">
                    <el-dropdown placement="bottom" trigger="click" @command="mobileHandleCommand">
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
export default {
  computed: {
    ...mapGetters([
      'token'
    ])
  },
  data() {
    return {
      activeIndex: '1',
      login: ''
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    },
    logout() {
      this.$store.dispatch('LogOut').then(() => {
        location.reload() // 为了重新实例化vue-router对象 避免bug
      })
    },
    handleCommand(command) { // web
      if (command === 'write') {
        this.$router.push({ path: '/write' })
      } else if (command === 'admin') {
        this.$router.push({ path: '/admin' })
      } else if (command === 'loyout') {
        this.logout()
      } else if (command === 'set') {
        this.$router.push({ path: '/setting' })
      } else if (command === 'java') {
        this.$router.push(
          { 
            path: '/blog',
            query: {
              navHeader: 'JAVA',
              tagId: '1'
            }
          }
        )
      } else if (command === 'hadoop') {
         this.$router.push(
          { 
            path: '/blog',
            query: {
              navHeader: 'Hadoop',
              tagId: '7f08cc6d356f11e8a5a50242ac110002'
            }
          }
        ) 
      }
    },
    mobileHandleCommand(command) { // mobile

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
        li{
            position: relative;
            float: left;
            margin-right: 1px;
            width: 110px;
            text-align: center;
            line-height: 52px;
        }
        li:hover{
            background-color: #404040;
        }
        .el-dropdown{
            color: inherit;
        }
    }
    .navRight{
        float: right;
        width: 59px;
        text-align: center;
    }
    .navRight:hover{
        background-color: #404040;
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
.el-dropdown-menu__item:focus, .el-dropdown-menu__item:not(.is-disabled):hover{
        background-color: #404040 !important;
    color: #66b1ff !important;
}
}
</style>
