<template>
  <div id="showLayout">
    <el-container>
      <div class="header">
        <el-header class="hzq_main">
          <nav-menu></nav-menu>
        </el-header>
      </div>
      <el-main class="hzq_main">
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
    .header{
      background-color: var(--hzq-show-header-bg)
    }
    .el-header{
      height: 52px !important;
      color: var(--hzq-show-header-font-color);
    }
  }
</style>
