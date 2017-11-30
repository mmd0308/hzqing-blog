<template>
  <div id="appMain">
    <el-row>
      <el-col :span="18">
        <div class="index-left">
          <index ref="blog_index"></index>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="index-right">
            <sidebar ref="index_sidebar"></sidebar>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import index from '@/views/show/index/Index'
  import sidebar from '@/views/show/layout/Sidebar'
  export default {
    components: {
      index,
      sidebar
    }
  }
</script>

