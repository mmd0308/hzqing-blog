<template>
  <div id="showLayout">
    <el-container>
      <el-header height="45px">
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
  import NavMenu from '@/views/show/layout/NavMenu'
  import Footer from '@/views/show/layout/Footer'
  export default {
    components: {
      NavMenu,
      showFooter: Footer
    }
  }
</script>
