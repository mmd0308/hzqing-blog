<template>
  <div id="app" class="app-wrapper">
    <el-row>
      <el-col :span="24">
          <navbar></navbar>
      </el-col>
    </el-row>
    <el-row>
       <router-view></router-view>
    </el-row>
  </div>
</template>
<script>
  import navbar from '@/views/show/layout/Navbar'
  import appmain from '@/views/show/layout/AppMain'
  import sidebar from '@/views/show/layout/Sidebar'
  export default {
    components: {
      navbar,
      appmain,
      sidebar
    }
  }
</script>
<style>
.index-left{
    margin: 17px 10px 0px 260px;
}
.index-right{
    margin: 17px 260px 0px 10px;
}
.app-wrapper{
    font: 14px/24px 'microsoft yahei';
}
</style>
