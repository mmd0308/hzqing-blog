<template>
  <div id="app" class="app-wrapper">
    <el-row>
      <el-col :span="24">
          <navbar ref="index_navbar"></navbar>
      </el-col>
    </el-row>
    <el-row>
       <router-view ref="index_router_view"></router-view>
    </el-row>
  </div>
</template>
<script>
  import navbar from '@/views/show/layout/Navbar'
  export default {
    components: {
      navbar
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
