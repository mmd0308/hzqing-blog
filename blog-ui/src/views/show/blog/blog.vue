<template>
    <div class="show-article">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>{{navHeader}}</span>
            </div>
            <div
                v-loading="listLoading" 
                element-loading-text="拼命加载中..."
                element-loading-spinner="el-icon-loading">
                <div class="show-blog-list"  v-for="(item,index) in list" :key="index" >
                    <el-row>
                        <el-col class="hidden-sm-and-down" :md="5"  :lg="5" :xl="5" v-if="item.arImg != null && item.arImg != ''">
                            <img class="show-index-blog-topic-pic" width="100%" :src="item.arImg" alt="">
                        </el-col>
                        <el-col :md="19" :lg="19" :xl="19" v-if="item.arImg != null && item.arImg != ''">
                            <div class="appMain-card-header mp"  @click="toDetail(item.id)">
                                <h3>{{ item.arTitle }}</h3>
                            </div>
                            <div class="show-index-blog-abstract" style=" overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">
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
                                     <span>
                                        评论： 0
                                    </span> 
                                    <span class="disply-blog-button" v-if="resCode.indexOf('BUTTON_BLOGLIST_UP') != -1">
                                        <span class="el-header-right-button mp " v-if="item.arUp === '0'" @click="updateArUp(item.id, '1')"  type="text">置顶</span>
                                        <span class="el-header-right-button mp " v-if="item.arUp === '1'" @click="updateArUp(item.id, '0')" type="text">取消置顶</span>
                                    </span>
                                </div>
                            </div>
                        </el-col>
                        <el-col :md="24" :lg="24" :xl="24" v-else>
                            <div class="appMain-card-header mp"  @click="toDetail(item.id)">
                                <h3>{{ item.arTitle }}</h3>
                            </div>
                            <div class="show-index-blog-abstract" style=" overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">
                                {{ item.arDesc }}
                            </div>
                            <div style="height:20px; margin-top:5px;">
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
                                    <span>
                                        评论： 0 
                                    </span> 
                                    <span class="disply-blog-button" v-if="resCode.indexOf('BUTTON_BLOGLIST_UP') != -1">
                                        <span class="el-header-right-button mp"   v-if="item.arUp === '0'" @click="updateArUp(item.id, '1')"  type="text">置顶</span>
                                        <span class="el-header-right-button mp" v-if="item.arUp === '1'" @click="updateArUp(item.id, '0')" type="text">取消置顶</span>
                                    </span>
                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </el-card>
        <div class="block" style="text-align: center;">
            <el-pagination
                background
                @size-change="handleSizeChange" 
                @current-change="handleCurrentChange"
                :current-page.sync="listQuery.page"
                :page-size="listQuery.pageSize"
                layout="prev, pager, next"
                :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
import { showPage, putObj } from '@/api/manager/blog/article/index'
import { parseTime } from '@/utils/index'
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters([
      'resCode'
    ])
  },
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
        pageSize: 10,
        arTitle: '',
        arUp: '',
        tagId: ''
      },
      isItem: '0',
      navHeader: '',
      listLoading: false,
      form: {
        id: '',
        arUp: ''
      }
    }
  },
  created() {
    this.getListByRouter()
  },
  watch: {
    '$route': 'getListByRouter' // 监听不同的路由query
  },
  methods: {
    getList() {
      this.listLoading = true
      showPage(this.listQuery).then(response => {
        this.list = response.data.list
        this.total = response.data.total
        this.listLoading = false
      })
    },
    getListByTagId(tag) {
      this.navHeader = tag[1]
      this.listQuery.tagId = tag[0]
      this.getList()
    },
    getListByTitle(title) {
      this.navHeader = title
      this.listQuery.arTitle = title
      this.getList()
    },
    getListByRouter() {
      this.navHeader = this.$route.query.navHeader
      this.listQuery.tagId = this.$route.query.tagId
      this.getList()
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
      this.isItem = item
      if (item === '0') {
        this.listQuery.arUp = ''
        this.getList()
      }
      if (item === '1') {
        this.listQuery.arUp = '1'
        this.getList()
      }
    },
    handleSizeChange(val) {
      this.listQuery.pageSize = val
      this.getList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.getList()
    },
    updateArUp(id, arUp) {
      this.form.id = id
      this.form.arUp = arUp
      putObj(id, this.form).then(() => {
        this.$notify({
          title: '成功',
          message: '发布成功',
          type: 'success',
          duration: 2000
        })
        this.getList()
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.show-article{
    margin-right: 15px;
    .el-card__body{
        padding: 0px;
    }
    .show-blog-list{
        padding: 20px;
        border-bottom: 1px solid #ebeef5;
    }
    .disply-blog-button{
        display: none;
    }
    .show-blog-list:hover{
        .disply-blog-button{
            display: inline;
        }        
    }
    .box-card{
        margin-bottom: 10px;
        border-radius: 10px;
    }
}
</style>
