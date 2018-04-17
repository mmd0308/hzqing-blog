<template>
  <div id="showLayout">
    <el-container>
      <el-header>
        <nav-menu></nav-menu>
      </el-header>
      <el-main>
        <router-view ref="show_index_router_view"></router-view>
      </el-main>
      <el-footer>
        <show-footer></show-footer>
      </el-footer>
    </el-container>
  </div>
</template>
<script>
  import NavMenu from '@/views/show/indexLayout/NavMenu'
  import Footer from '@/views/show/indexLayout/Footer'
  export default {
    components: {
      NavMenu,
      showFooter: Footer
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
  #showLayout{
    .el-header{
      background-color: #222;
      height: 52px !important;
      color: #fff;
      padding: 0% 18%;
    }
    .el-main{
      margin: 0% 18%;
    }
    @media screen and (max-width:1400px){
      .el-header{
        padding: 0% 11%;
      }
      .el-main{
        margin: 0% 11%;
      }
    }
    @media screen and (max-width:1280px){
      .el-header{
        padding: 0% 7%;
      }
      .el-main{
        margin: 0% 7%;
      }
    }
    @media screen and (max-width:1024px){
      .el-header{
        padding: 0% 5%;
      }
      .el-main{
        margin: 0% 5%;
      }
    }
    @media screen and (max-width:768px){
      .el-header{
        padding: 0% 3%;
      }
      .el-main{
        margin:0%  3%;
      }
    }
  }
</style>
