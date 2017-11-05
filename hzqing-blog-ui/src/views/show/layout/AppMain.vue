<template>
  <div id="appMain">
    <el-row>
      <el-col :span="17">
        <div class="index-left">
          <index></index>
        </div>
      </el-col>
      <el-col :span="7">
        <div class="index-right">
            <sidebar></sidebar>
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

