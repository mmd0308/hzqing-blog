<template>
  <div class="comment">
        <div class="detail-comment-topic" >
            <div  class="detail-comment ">
                <div class="detail-comment-pic">
                    <img src="static/img/touxiang.jpeg"/>
                </div>
                <div class="detail-comment-textarea" @click="toCreate">
                    <el-input
                        type="textarea"
                        :autosize="{ minRows: 3, maxRows: 5}"
                        placeholder="写下你的评论..."
                        v-model="commentContent">
                        </el-input>
                    <div class="detail-comment-submit" v-if="btn_show_bl">
                        <el-button type="success" style="float:right;padding:9px 23px;" round  @click="create" >发送</el-button>
                        <el-button type="info" style="float:right;padding:9px 23px; margin-right:10px;" round>取消</el-button>
                    </div> 
                </div>
            </div>
            <div>
                <span>最新评论</span>
                <span v-if="articleId === null" style="float: right; padding: 3px 0;font-size:13px;">总共{{ total }}条留言</span>
                <span v-else style="float: right; padding: 3px 0;font-size:13px;">总共{{ total }}条评论</span>
            </div>
        </div>
        <div class="detail-comment-body" v-for="(item,index) in list" :key="index">
            <div style="margin-bottom: 15px;">
                <div class="detail-comment-pic">
                    <img src="static/img/touxiang.jpeg"/>
                </div>
                <div class="comment-msg">
                    <div class="comment-head">
                        <span class="author">
                            {{ item.userFullName}}
                        </span>
                        <span class="fr see-font">
                            {{ item.coCtime | formatDate}}
                        </span>
                    </div>
                    <div class="detail-comment-reply">
                        {{ item.coContent }}
                    </div>
                    <div class="see-font comment-bar">
                        <span class="svg-container svg-comment">
                            <svg-icon icon-class="comment-star"></svg-icon>
                            1人赞
                        </span>
                        <span class="svg-container svg-comment" v-if="resCode.indexOf('BUTTON_LY_HH') != -1"  @click="toReply(item.id, null, null)">
                            <svg-icon icon-class="user-reply"></svg-icon>
                              回复
                        </span>
                    </div>
                     <div class="comment-reply-other">
                        <div class="other-reply bb-dash"  v-for="(it,ind) in item.lists" :key="ind">
                            <div style="margin:10px 0px;">
                                <span class="author">
                                    {{ it.userFullName}}
                                </span>
                                ：
                                <span class="author">
                                    @{{ item.userFullName }}
                                </span> 
                                <span>
                                    {{ it.coContent}}
                                </span>
                            </div>
                            <div class="see-font" style="margin-bottom:10px;">
                                <span>
                                    {{ it.coCtime | formatDate}}
                                </span>
                                <span class="svg-container svg-comment" v-if="resCode.indexOf('BUTTON_LY_HH') != -1" @click="toReply(item.id, it.userFullName, it.id)">
                                    <svg-icon icon-class="user-reply"></svg-icon>
                                    回复
                                </span>
                            </div>
                        </div>
                        <div class="other-reply detail-comment-reply" v-if="show_reply === item.id">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 3, maxRows: 5}"
                                placeholder="写下你的评论..."
                                v-model="form.coContent">
                                </el-input>
                            <div class="detail-comment-submit">
                                <el-button type="success" style="float:right;padding:9px 23px;" round  @click="create" >发送</el-button>
                                <el-button type="info" style="float:right;padding:9px 23px; margin-right:10px;" round>取消</el-button>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block" style="text-align: center;" v-if="articleId === null">
            <el-pagination
                background
                layout="prev, pager, next"
                :total="total">
            </el-pagination>
        </div>
  </div>
</template>

<script>
import { showPage, getObj, putObj, delObj, addObj } from '@/api/admin/blogger/comments/index'
import { parseTime } from '@/utils/index'
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters([
      'resCode'
    ])
  },
  props: {
    articleId: {
      type: String,
      default: null
    }
  },
  filters: {
    formatDate(time) {
      return parseTime(time, '{y}-{m}-{d} {h}:{i}')
    }
  },
  data() {
    return {
      total: null,
      list: null,
      commentContent: null,
      listQuery: {
        page: 1,
        pageSize: 5,
        articleId: null,
        coType: 'L'
      },
      form: this.initObj(),
      btn_show_bl:false,
      show_reply: null
    }
  },
  created() {
    if (this.articleId != null) {
      this.listQuery.coType = 'P'
      this.listQuery.articleId = this.articleId
    }
    this.getList()
  },
  methods: {
    initObj() {
      return {
        id: '',
        coCtime: new Date(),
        coContent: null,
        articleId: null,
        coId: '-1',
        userId: null,
        superId: null,
        coType: 'L'
      }
    },
    getList() {
      showPage(this.listQuery).then(response => {
        this.list = response.data.list
        this.total = response.data.total
      })
    },
    resetTemp() {
      this.form = this.initObj() 
    },
    handleDelete(index, row) {
      this.$confirm('是否刪除该记录？', '记录', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        delObj(row.id).then(() => {
        this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: 2000
        })
        this.getList()
        })
      })
    },
    toCreate() {
      this.btn_show_bl = true
    },
    create() {
      if (this.commentContent != null) {
        this.form.coContent = this.commentContent
      }
      if (this.articleId != null) {
        this.form.coType = 'P'
        this.form.articleId = this.articleId
      }
      addObj(this.form).then(() => {
        this.$notify({
          title: '成功',
          message: '创建成功',
          type: 'success',
          duration: 2000
        })
        this.show_reply = null
        this.getList()
      })
    },
    toReply(id, name, itId) {
      this.show_reply = id
      this.form.coId = id
      this.form.superId = id
      if (null != name) {
        this.form.coContent = "@"+name
      }
      if (null != itId) {
          this.form.coId = itId
      }
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.comment{
    background: #fff;
    padding: 35px;
    border-radius: 10px;
    .detail-comment-submit{
        margin: 10px 0px;
    }
    .detail-comment{
        margin-bottom: 20px;
    }
    .detail-comment-topic{
        padding-bottom: 10px;
    }
    .detail-comment-textarea{
        position: relative;
        display: inline-block;
        margin-left: 10px;
        width: 94%;
    }
    .detail-comment-reply{
        position: relative;
        display: inline-block;
        width: 100%;
        margin: 20px 0px 10px;
    }
    .detail-card .el-card__body{
        padding: 0px;
    }
    .detail-comment-body{
        border-top: 1px solid #ebeef5;
        padding: 20px 0px;
        .comment-msg{
            margin: 0px 0px 0px 62px;
        }
        .comment-bar{
            text-align: right;
        }
    }
    .comment-reply-other{
        border-left: 2px solid #d9d9d9;
    }
    .comment-reply-other .other-reply{
        margin-left: 18px;
        font-size: 14px;
        
    }

    .svg-comment:nth-child(2){
        margin-left: 10px;
    }
}

</style>
