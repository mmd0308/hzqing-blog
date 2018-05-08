<template>
    <div id="diary">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>{{navHeader}}</span>
                <div class="fr">
                  <el-button class="el-header-right-button" v-if="resCode.indexOf('BUTTON_GRRJ_SZ') != -1" @click="toAdd" type="text">新增</el-button>
                </div>
            </div>
          <div class="dirary-body" style="background:#fff">
              <hzqing-vue-timeline timelineColor="#fff" timeContentColor="#f1f1f1" :dataList="timeItemList"></hzqing-vue-timeline>
          </div>
        </el-card>
    </div>
</template>
<script>
import { showAll } from '@/api/admin/blogger/diary/index'
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters([
      'resCode'
    ])
  },
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
    },
    toAdd() {
      alert('新增日记')
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
#diary{
  .el-card__body{
    padding: 0px;
  }
  .dirary-body{
      border-radius: 10px;
      #hzqing{
       border-radius: 10px;
      }
  }
}
</style>
