<template>
    <div id="diary">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>{{navHeader}}</span>
            </div>
          <div class="dirary-body" style="background:#fff">
              <hzqing-vue-timeline timelineColor="#fff" timeContentColor="#f1f1f1" :dataList="timeItemList"></hzqing-vue-timeline>
          </div>
        </el-card>
    </div>
</template>
<script>
import { showAll } from '@/api/admin/blogger/diary/index'
export default {
  data() {
    return {
      navHeader: '',
      timeItemList: [],
      listQuery: {
        title: ''
      }
    }
  },
  created() {
    this.getAll()
    this.navHeader = this.$route.query.navHeader
  },
  methods: {
    getAll() {
      showAll(this.listQuery).then(response => {
        this.timeItemList = response.data
      })
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
#diary{
  .dirary-body{
      border-radius: 10px;
      #hzqing{
       border-radius: 10px;
      }
  }
}
</style>
