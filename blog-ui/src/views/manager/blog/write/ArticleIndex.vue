<template>
  <div class="articleIndex">
        <div class="addBlog">
            <div class="newBlog" @click="toAddArticle">
                <i class="el-icon-plus"></i>
                <span>新建文章</span>
            </div>
            <el-table :data="blogList" style="width: 100%" highlight-current-row :show-header="false" @row-click="getArticleById">
                <el-table-column prop="name" >
                    <template slot-scope="scope">
                        <el-col :span="2">
                            <svg-icon icon-class="blog-write-article-document"></svg-icon>
                        </el-col>
                        <el-col :span="22">
                            <div style=" overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                                {{ scope.row.arTitle }}
                            </div>
                        </el-col>
                    </template>
                </el-table-column>
                <el-table-column  width="50">
                    <template slot-scope="scope"   v-if="articleId == scope.row.id" > 
                         <el-dropdown trigger="click" placement="bottom" @command="handleCommand">
                                    <svg-icon icon-class="blog-write-article-system"></svg-icon>
                                    <el-dropdown-menu slot="dropdown">
                                        <el-dropdown-item command='release'>直接发布</el-dropdown-item>
                                        <el-dropdown-item command='deleted'>删除文章</el-dropdown-item>
                                    </el-dropdown-menu>
                                </el-dropdown>
                    </template>
                </el-table-column>
            </el-table>
        </div>
  </div>
</template>

<script>
import { getAllByTagId, addObjVo, delObj, putObj } from '@/api/manager/blog/article/index'
import { parseTime } from '@/utils/index'
export default {
  data() {
    return {
      blogList: [],
      articleId: '',
      tagId: '',
      form: this.initObj(),
      releaseForm: {
        id: '',
        arState: ''
      }
    }
  },
  created() {
    // this.getAllArticleByTagId()
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
        arCtime: new Date(),
        arEtime: new Date(),
        arState: 'CG',
        arUp: '0',
        tagId: ''
      }
    },
    toAddArticle() {
      // 创建 博客
      this.form = this.initObj()
      this.form.tagId = this.tagId
      this.form.arTitle = parseTime(new Date())
      addObjVo(this.form).then(() => {
        this.$notify({
          title: '成功',
          message: '创建成功',
          type: 'success',
          duration: 2000
        })
        this.getAllArticleByTagId(this.tagId)
      })
    },
    getAllArticleByTagId(tagId) {
      getAllByTagId(tagId, null).then(response => {
        this.blogList = response.data.list
        if (this.blogList.length !== 0) {
          this.articleId = this.blogList[0].id
          this.bus.$emit('getWriteArticle', this.blogList[0])
        }
      })
    },
    getArticleById(row, event, column) {
      this.articleId = row.id
      this.bus.$emit('getWriteArticle', row)
      this.form = row
    },
    handleCommand(command) {
      if (command === 'release') {
        this.releaseForm.id = this.form.id
        this.releaseForm.arState = 'FB'
        putObj(this.form.id, this.releaseForm).then(() => {
          this.$notify({
            title: '成功',
            message: '发布成功',
            type: 'success',
            duration: 2000
          })
        })
      } else if (command === 'deleted') {
        this.$confirm('是否刪除该博客？', '删除博客', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          delObj(this.form.id).then(() => {
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            })
            this.getAllArticleByTagId(this.tagId)
          })
        })
      }
    }
  },
  mounted: function() {
    const that = this
    that.bus.$on('getTagId', function(tagId) {
      that.tagId = tagId
      that.$nextTick(() => {
        that.getAllArticleByTagId(tagId)
      })
    })
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.articleIndex{
    height: 100%;
    .addBlog{
        position: relative;
        overflow-y: scroll;
        height: 100%;
        .newBlog{
            line-height: 20px;
            font-size: 15px;
            font-weight: 400;
            padding: 20px 0 20px 25px;
            cursor: pointer;
            color: #595959;
            border-bottom: 1px solid #ebeef5;
        }
        .el-table{
            font-size: 16px;
        }
        .el-table .cell{
            line-height: 50px;
        }
    }
}

</style>
