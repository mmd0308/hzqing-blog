<template>
    <div id="diary">
        <show-header :message='msg'></show-header>
        <div class="dirary-body" style="background:#fff">
             <hzqing-vue-timeline timelineColor="#fff" timeContentColor="#7FE4E1" :dataList="timeItemList"></hzqing-vue-timeline>
        </div>
    </div>
</template>
<script>
import { showAll } from '@/api/admin/blogger/diary/index'
import ShowHeader from '@/components/ShowHeader/index'
export default {
  components: {
    ShowHeader
  },
  data() {
    return {
      msg: '个人日记',
      timeItemList: [],
      listQuery: {
        title: ''
      }
    }
  },
  created() {
    this.getAll()
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
