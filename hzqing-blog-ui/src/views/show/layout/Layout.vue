<template>
  <div id="app" class="app-wrapper">
    <el-row>
      <el-col :span="24">
          <navbar ref="index_navbar"></navbar>
      </el-col>
    </el-row>
    <el-row class="index_left_right">
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
    margin: 0px 15px;
}
.index_left_right{
    margin: 17px 18% 0px 18%;
}
.app-wrapper{
    font: 14px/24px 'microsoft yahei';
}
</style>
