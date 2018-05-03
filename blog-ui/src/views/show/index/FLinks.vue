<template>
    <el-card class="sidebar-box-card">
        <div slot="header" class="flink-clearfix">
            <span>友情链接</span>
        </div>
        <div class="show-index-blog-abstract  ">
          <span v-for="(item, index) in dataList" :key="index" style="padding:0px 15px 0px 0px;"  >
            <a :href="item.linkHref">
              {{item.linkName}}
            </a>
          </span>
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
