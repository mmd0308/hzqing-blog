<template>
    <div class="showWebIndex">
        <div class="blog-header">
            <div :class="{item: isItem === '0'}" class="items" @mouseover="blurHeader('0')" > 最新发布</div>
            <div :class="{item: isItem === '1'}" class="items" @mouseover="blurHeader('1')" > 博文推荐</div>
            <!-- <div :class="{item: isItem === '2'}" class="items" @mouseover="blurHeader('2')" > 最新发布</div>
            <div :class="{item: isItem === '3'}" class="items" @mouseover="blurHeader('3')" > 最新发布</div> -->
        </div>
        <div v-loading="listLoading" 
            element-loading-text="拼命加载中..."
            element-loading-spinner="el-icon-loading"
            >
            <el-card class="box-card"   v-for="(item,index) in list" :key="index" >
                <div class="show-blog-list">
                    <el-row>
                        <el-col class="hidden-sm-and-down" :md="5"  :lg="5" :xl="5" v-if="item.arImg != null && item.arImg != ''">
                            <img class="show-index-blog-topic-pic" :src="item.arImg" alt="">
                        </el-col>
                        <el-col :md="19" :lg="19" :xl="19" v-if="item.arImg != null && item.arImg != ''">
                            <div class="appMain-card-header"  @click="toDetail(item.id)">
                                <h3>{{ item.arTitle }}</h3>
                            </div>
                            <div class="show-index-blog-abstract  show-blog-list-desc">
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
                        <el-col :md="24" :lg="24" :xl="24" v-else>
                            <div class="appMain-card-header"  @click="toDetail(item.id)">
                                <h3>{{ item.arTitle }}</h3>
                            </div>
                            <div class="show-index-blog-abstract  show-blog-list-desc">
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
      isItem: '0',
      listLoading: false
    }
  },
  created() {
    this.getList()
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
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.showWebIndex{
    .blog-header{
        height: 40px;
        font-size: 16px;
        line-height: 40px;
        margin: 30px auto;
        width: 200px;
        .item{
             background: #ff7d44;
        }
        .items{
            float: left;
            width: 100px;
            text-align: center;
            border-radius: 20px;
        }
    }
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
