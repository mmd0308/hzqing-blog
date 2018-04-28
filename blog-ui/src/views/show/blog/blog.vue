<template>
    <div class="show-article">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>学无止境</span>
            </div>
            <div class="show-blog-list"  v-for="(item,index) in list" :key="item">
                <el-row>
                    <el-col class="hidden-md-and-down"  :lg="5" :xl="5">
                        <img class="show-index-blog-topic-pic" width="100%" src="https://baijunyao.com/uploads/article/20180106/5a50792eeef57.jpg" alt="">
                    </el-col>
                    <el-col :lg="19" :xl="19">
                        <div class="appMain-card-header"  @click="toDetail(item.id)">
                            <h3>{{ item.arTitle }}</h3>
                        </div>
                        <div class="show-index-blog-abstract">
                            {{ item.arDesc }}
                        </div>
                        <div style="height:20px;">
                            <div class="see_time_text see-font">
                                <span>
                                    <svg-icon icon-class="show-blog-user"></svg-icon> {{ item.fullName }}
                                </span>
                                <span>
                                    <svg-icon icon-class="show-blog-time"/> {{ item.arCtime | formatDate}}
                                </span>
                                <span v-if="item.countNum !== null">
                                    <svg-icon icon-class="show-blog-see"/> {{ item.countNum}}
                                </span>
                                <span v-else>
                                    <svg-icon icon-class="show-blog-see"/>  0
                                </span>
                                <!-- <span>
                                    评论： 0
                                </span> -->
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </div>
        </el-card>
        <div class="block" style="text-align: center;">
            <el-pagination
                background
                layout="prev, pager, next"
                :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
import { showPage } from '@/api/admin/blog/article/index'
import { parseTime } from '@/utils/index'
export default {
  filters: {
    formatDate(time) {
      return parseTime(time, '{y}-{m}-{d} {h}:{i}')
    }
  },
  data() {
    return {
      list: null,
      total: null,
      listQuery: {
        page: 1,
        pageSize: 5,
        arTitle: '',
        arUp: ''
      },
      isItem: '0'
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      showPage(this.listQuery).then(response => {
        this.list = response.data.list
        this.total = response.data.total
      })
    },
    toDetail(id) {
      this.$router.push({
        path: '/detail',
        query: {
          blodId: id 
        }
      })
    },
    blurHeader(item) {
      this.isItem = item;
      if (item === '0') {
          this.listQuery.arUp = ''
          this.getList()
      }
      if ( item === '1') {
          this.listQuery.arUp = '1'
          this.getList()
      }

    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.show-article{
    .el-card__body{
        padding: 0px;
    }
    .show-blog-list{
        padding: 20px;
        border-bottom: 1px solid #ebeef5;
    }
    .box-card{
        margin-bottom: 10px;
        border-radius: 10px;
    }
}
</style>
