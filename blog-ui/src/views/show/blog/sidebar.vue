<template>
    <div id="showIndexSidebar">
        <el-card class="sidebar-box-card">
            <div class="">
                <el-input placeholder="请输入内容" v-model="queryAll"  size="mini"  @keyup.enter.native="toQuery">
                    <el-button @click="toQuery" slot="append" icon="el-icon-search"></el-button>
                </el-input>
            </div>
        </el-card>
        <el-card class="sidebar-box-card" body-style="">
            <div slot="header" class="clearfix">
                <span>本栏推荐</span>
            </div>
            <ul             
            v-loading="listLoading" 
            element-loading-text="拼命加载中..."
            element-loading-spinner="el-icon-loading">
                <li v-for="(item, index) in list" :key="index" class="right-commend" @click="toDetail(item.id)">
                    <div class="right-img fl" v-if="item.arImg != null && item.arImg != ''">
                        <img width="100%" height="100%" :src="item.arImg" alt="">
                    </div>
                    <h4 class="title">
                        {{ item.arTitle }}
                    </h4>
                    <p class="see-font time-eye">
                        <span class="time">
                            {{ item.arCtime | formatDate}}
                        </span>
                        <span class="eye">
                            阅读: ( {{ item.countNum}} )
                        </span>
                    </p>
                </li>
            </ul>
        </el-card>     
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>标签列表</span>
            </div>
            <div class="">
                <el-button class="tag-button check-tagColor" round size="mini" v-for="(item, index) in tagList" :key="index" @click="getArticleByLablesId(item.id, item.tagName)" >{{ item.tagName }}</el-button>
            </div>
        </el-card>
    </div>
</template>

<script>
import { showPage } from '@/api/admin/blog/article/index'
import { showAll } from '@/api/admin/blog/tag/index'
import { parseTime } from '@/utils/index'
export default {
  filters: {
    formatDate(time) {
      return parseTime(time, '{y}-{m}-{d}')
    }
  },
  data() {
    return {
      queryAll: '',
      listQuery: {
        page: 1,
        pageSize: 5,
        arTitle: '',
        arUp: '',
        tagId: ''
      },
      tagQuery: {
        tagType: 'L'
      },
      list: null,
      listLoading: false,
      toUp: false,
      tagList: null
    }
  },
  created() {
    this.listQuery.tagId = this.$route.query.tagId
    this.toUp = true
    this.getList()
    // 获取所有的标签
    this.getTagList()
  },
  methods: {
    toQuery() {
      this.$emit('getArticleByTitle', this.queryAll)
    },
    getArticleByLablesId(id, name) {
      this.$emit('getArticleByLablesId', [id, name])
    },
    getList() {
      this.listLoading = true
      this.listQuery.arUp = '1'
      showPage(this.listQuery).then(response => {
        this.list = response.data.list
        this.listLoading = false
        if (this.toUp) {
          this.toUp = false
          // 先找相同分类下面的推荐博客，找不到。找推荐博客
          if (response.data.list.length === 0) {
            this.listQuery.tagId = ''
            this.getList()
          }
        }
      })
    },
    getTagList() {
      showAll(this.tagQuery).then(response => {
        this.tagList = response.data
      })
    },
    toDetail(id) {
      this.$router.push({
        path: '/detail',
        query: {
          blodId: id
        }
      })
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
#showIndexSidebar{
    margin-left: 15px;
    .right-img{
        width: 90px;
        height: 60px;
        margin-right: 10px;
    }
    .sidebar-box-card{
        margin-bottom: 18px;
    }
    .sidebar-item {
        margin-bottom: 18px;
    }
    .sidebar-item-tag{
        color: #fff;
        margin: 3px 4px;
        border-radius: 15px;
    }
    .title{
        white-space: normal;
        overflow: hidden;
        font-weight: normal;
        margin: 0px 0px 5px 0px;
        height: 3em;

    }
    .right-commend{
        margin-bottom: 20px;
    }
    .right-commend:last-child{
        margin-bottom: 0px;
    }
    .time-eye{
      margin: 0px;
      .time {
          margin-right: 10px;
      }
    }
    .tag-button{
        margin: 3px 2px !important;
        color: #fff;
    }
    .check-tagColor:nth-child(5n+1){
        background: #ff7d44;
    }
    .check-tagColor:nth-child(5n+2){
        background:#695fa9
    }
    .check-tagColor:nth-child(5n+3){
        background:#cd4b6c
    }
    .check-tagColor:nth-child(5n+4){
        background:#8bb841
    }
    .check-tagColor:nth-child(5n+5){
        background:#f45086
    }
}

</style>
