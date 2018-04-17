<template>
    <el-card class="sidebar-box-card">
        <div slot="header" class="flink-clearfix">
            <span>友情链接</span>
        </div>
        <div class="show-index-blog-abstract show-index-detail-text">
            <span v-for="(item, index) in dataList" :key="item" style="padding:0px 15px 0px 0px;"  >{{item.linkName}}</span>
        </div>
    </el-card>
</template>

<script>
import { showAll } from '@/api/admin/bus/link/index'
export default {
  data() {
    return {
      dataList: []
    }
  },
  created(){
    this.getList()
  },
  methods: {
    getList() {
      showAll().then(response => {
        this.dataList = response.data
      })
    }
  }
}
</script>
 
<style>
    .sidebar-box-card{
        border-radius: 10px;
    }
    .flink-clearfix{
        text-align: center;
    }
</style>
