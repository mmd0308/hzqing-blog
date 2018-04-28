<template>
    <div id="detail">
        <show-header :message='msg'></show-header>
        <el-card class="detail-card">
             <div slot="header" class="blogTiltle">
                <h1>
                     {{ form.arTitle }}    
                </h1>
                <div class="title-mate">
                    本文作者：南昌seo　最后编辑：2018-03-29 15:07:37　分类：网站运营   标签：hadoop分布式 /分布式
                </div>
            </div>
            <div class="sidebar-text sidebar-item  ">
                <mavon-editor 
                v-model="form.arContent" 
                style="height: 93%"
                ref="mavonEditor"
                :toolbarsFlag="false"
                :subfield="false"
                defaultOpen="preview"
                placeholder="请开始你的表演..."
                code_style="solarized-dark"
                :ishljs = "true"
                @save="$save"
                @imgAdd="$imgAdd"
                @change="$change"
                 >
                </mavon-editor>
            </div>
        </el-card>
        <div class="comments">
          <comments-index :articleId="form.id">
          </comments-index>
        </div>
    </div>
</template>
<script>
  import { getObj } from '@/api/admin/blog/article/index'
  import { parseTime } from '@/utils/index'
  import ShowHeader from '@/components/ShowHeader/index'
  import CommentsIndex from '@/views/show/comment/Index'
export default {
  components: {
    ShowHeader,
    CommentsIndex
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
        arTitle: ''
      },
      form: this.initObj(),
      toolbarsFlag: false,
      subfield: false,
      msg: '博客分类'
    }
  },
  created() {
    this.form.id = this.$route.query.blodId
    this.findById()
  },
  methods: {
    initObj() {
      return {
        id: '',
        userId: undefined,
        arTitle: undefined,
        arDesc: undefined,
        arContent: undefined,
        arContentHtml: undefined,
        arCtime: undefined,
        arEtime: undefined,
        arUp: ''
      }
    },
    findById() {
      getObj(this.form.id).then(response => {
        this.form = response.data
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
#detail{
    .el-card__header{
        border: none;
        padding: 18px 20px 5px 20px;
        background: #fff;
    }
    .detail-card{
        border-radius: 10px;
    }
    .el-card__body{
        padding: 0px;
    }
   .v-note-wrapper .v-note-panel .v-note-show .v-show-content, .v-note-wrapper .v-note-panel .v-note-show .v-show-content-html{
       background: #fff;
   }
   .blogTiltle {
       h1{
            text-align: center;
            font-size: 1.625em;
            color: #2f2f2f;
            font-weight: normal;
            margin-bottom: 10px;
       }
       .title-mate{
            text-align: center;
            color: #969696;
            margin-bottom: 10px;
            border-bottom: 1px solid #ebebeb;
            padding: 10px 0px 15px;
            font-size: 12px;
       }
   }
   .comments{
     margin-top: 20px;
   }

}
</style>

