<template>
  <div class="comment">
        <div class="detail-comment-topic" >
            <div  class="detail-comment ">
                <div class="detail-comment-pic">
                    <img src="static/img/touxiang.jpeg"/>
                </div>
                <div class="detail-comment-textarea">
                    <el-input
                        type="textarea"
                        :autosize="{ minRows: 3, maxRows: 5}"
                        placeholder="写下你的评论..."
                        v-model="textarea3">
                        </el-input>
                </div>
                <div class="detail-comment-submit">
                    <el-button type="success" style="float:right;padding:9px 23px;" round>提交</el-button>
                    <el-button style="float:right;padding:9px 23px; margin-right:10px;" round>取消</el-button>
                </div>
            </div>
            <div>
                <span>最新评论</span>
                <span style="float: right; padding: 3px 0;font-size:13px;">总共4条评论</span>
            </div>
        </div>
        <div class="detail-comment-body" v-for="o in 2" :key="o">
            <div style="margin-bottom: 15px;">
                <div class="detail-comment-pic">
                    <img src="static/img/touxiang.jpeg"/>
                </div>
                <div style="margin-left:5px; display: inline-block;">
                    <div class="user-comment">
                        微微凉
                    </div>
                    <div class="show-index-detail-text user-comment-time">
                        5楼 · 2018.01.23 08:39
                    </div>
                </div>
            </div>
            <div>
                <div class="detail-comment-reply">
                    评论内容 感觉还是不错吧  啊哈哈
                </div>
                <div class="show-index-detail-text ">
                    <span class="svg-container svg-comment">
                        <svg-icon icon-class="comment-star" class="phoneNavMenu"></svg-icon>
                    </span>
                    <span>
                        1人赞
                    </span>
                    <span class="svg-container svg-comment">
                        <svg-icon icon-class="user-reply" class="phoneNavMenu"></svg-icon>
                    </span>
                    <span>
                        回复
                    </span>
                </div>
            </div>
            <div class="comment-reply-other">
                <div class="other-reply"  v-for="o in 4" :key="o">
                    <div style="margin:10px 0px;">
                        <span class="author">
                            微微凉
                        </span>
                        ：
                        <span class="author">
                            @米粒兜兜
                        </span> ☺️很方便呦
                    </div>
                    <div class="show-index-detail-text user-comment-time" style="margin-bottom:10px;">
                        2018.01.23 12:50 
                        <el-button size="mini" style="padding:0px; border:none;">
                            <span class="svg-container svg-comment">
                                <svg-icon icon-class="user-reply" style="width:1.1rem;height:1.1rem;"></svg-icon>
                            </span>
                            回复
                        </el-button>
                    </div>
                </div>
            </div>
        </div>
  </div>
</template>

<script>
import { page, getObj, putObj, delObj, addObj } from '@/api/admin/blogger/comments/index'
export default {
  data() {
    return {
      form: this.initObj()
    }
  },
  methods: {
    initObj() {
      return {
        id: '',
        coCtime: new Date(),
        coContent: null,
        articleId: null,
        coId: null,
        userId: null
      }
    },
    resetTemp() {
      this.form = this.initObj() 
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.comment{
    background: #fff;
    padding: 35px;
    .detail-comment-submit{
        margin: 10px 0px;
    }
    .detail-comment{
        margin-bottom: 20px;
    }
    .detail-comment-topic{
        padding-bottom: 10px;
        border-bottom: 1px solid #ebeef5;
    }
    .detail-comment-textarea{
        position: relative;
        display: inline-block;
        margin-left: 10px;
        width: 94%;
    }

    .detail-card .el-card__body{
        padding: 0px;
    }
    .detail-comment-body{
        border-bottom: 1px solid #ebeef5;
        padding: 20px 0px;
    }
    .user-comment{
        margin-bottom: 5px;
        font-size: 15px;
    }
    .user-comment-time{
        font-size: 12px;
    }
    .detail-comment-reply{
        margin: 20px 0px;
    }
    .svg-comment{
        vertical-align: sub;
        margin: 2px 5px;
    }
    .comment-reply-other{
        border-left: 2px solid #d9d9d9;
    }
    .comment-reply-other .other-reply{
        margin-left: 18px;
        font-size: 14px;
        border-bottom: 1px dashed #f0f0f0;
    }
}

</style>
