<template>
  <div class="tagIndex">
        <div class="classification">
            <div class="backIndex">
                <router-link to="/" ><span>回首页</span></router-link>
            </div>
            <div class="addClass" @click="tagToAdd">
                <div>
                    <svg-icon icon-class="blog-write-tag-add"></svg-icon> 
                    <span> 新建分类</span>
                </div>
            </div>
            <div class="tagForm" v-if="tagFormBL" >
                <el-input v-model="formTag.tagName" placeholder="请输入分类名称..."></el-input>
                <div class="tagButton">
                    <el-button type="primary" round size="mini" @click="tagSave">确定</el-button>
                    <el-button type="info" round size="mini" @click="tagCancel" >取消</el-button>
                </div>
            </div>
            <div class="listClass" v-loading="tagLoading">
                <div  v-for="(item,key) in tagList" :key="key" :class="[{checkTagItem: checkTag === key}, {item}]" @click="tagClick(key, item)">
                    <el-row>
                        <el-col :span="22">
                            <div style=" overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                                {{ item.tagName }}
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <span v-if="checkTag === key" style="float:right;" 	>
                                <el-dropdown trigger="click" placement="bottom" @command="handleCommand">
                                    <svg-icon icon-class="admin-system"></svg-icon>
                                    <el-dropdown-menu slot="dropdown">
                                        <el-dropdown-item command='edit'>修改分类</el-dropdown-item>
                                        <el-dropdown-item command='deleted'>删除分类</el-dropdown-item>
                                    </el-dropdown-menu>
                                </el-dropdown>
                            </span>
                        </el-col>
                    </el-row>
                </div> 
            </div>
            <!-- <div class="button">
                <i class="el-icon-delete"></i>
                <span>设置</span>
            </div> -->
        </div>
        <!-- 修改分类 -->
        <el-dialog  :visible.sync="tagEditDialog" width="20%" :title="title">
            <el-input v-model="tagName" placeholder="请输入分类名称"></el-input>
            <div slot="footer" class="dialog-footer">
                <el-button @click="tagEditDialog = false">取 消</el-button>
                <el-button  type="primary" @click="update()">确 定</el-button>
            </div>
        </el-dialog>
  </div>
</template>
<script>
import { getAll, addObj, putObj, delObj } from '@/api/admin/blog/tag/index'
export default {
  data() {
    return {
      tagList: [],
      tagQuery: {
        tagType: ''
      },
      checkTag: '',
      formTag: this.initTag(),
      tagFormBL: false,
      tagLoading: true,
      tagEditDialog: false,
      title: '',
      tagName: ''
    }
  },
  created() {
    this.getTags()
  },
  methods: {
    initTag() {
      return {
        id: '',
        tagName: '',
        enabled: '1',
        sort: 1,
        note: '',
        tagType: 'C' // 分类
      }
    },
    tagToAdd() {
      this.tagFormBL = true
      this.formTag = this.initTag()
    },
    tagCancel() {
      this.tagFormBL = false
    },
    tagSave() {
      addObj(this.formTag).then(response => {
        this.tagCancel()
        this.getTags()
        this.formTag = this.initTag()
      })
    },
    getTags() {
      this.tagLoading = true
      this.tagQuery.tagType = 'C'
      getAll(this.tagQuery).then(response => {
        this.tagList = response.data
        this.tagLoading = false
        this.tagClick(0, this.tagList[0]) // 选中首个类别
      })
    },
    tagClick(key, item) {
      this.tagCancel()
      this.checkTag = key // 替换颜色
      if(item != null) {
        this.formTag = item
        this.bus.$emit('getTagId', item.id)
      }
    },
    handleCommand(command) {
      if (command === 'edit') {
        this.tagEditDialog = true
        this.title = '修改分类'
      } else if (command === 'deleted') {
        this.$confirm('是否刪除该记录？', '删除', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          delObj(this.formTag.id).then(() => {
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            })
            this.getTags()
          })
        })
      } else{
        console.log(command)
      }
    },
    update() { // 更新分类
      this.formTag.tagName = this.tagName
      putObj(this.formTag.id, this.formTag).then(response => {
        this.tagEditDialog = false // 取消对话框
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success',
          duration: 2000
        })
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.tagIndex{
    height: 100%;
    .classification{
        position: relative;
        height: 100%;
        overflow-y: auto;
        background-color: #404040;
        color: #f2f2f2;
        z-index: 100;
        .backIndex{
            padding: 30px 18px 5px;
            text-align: center;
        }
        .backIndex span{
            display: block;
            font-size: 15px;
            padding: 9px 0;
            color: #ec7259;
            border: 1px solid rgba(236,114,89,.8);
            border-radius: 20px;
        }
        .addClass{
            padding: 0 15px;
            margin-top: 20px;
            margin-bottom: 10px;
        }
        .tagForm{
            padding: 15px;
            .el-input__inner{
                background-color: #595959;
                border: none;
                height: 35px;
                color: #f2f2f2;
            }
            .tagButton{
                padding-top: 10px;
            }
        }
        .listClass{
            font-size: 15px;
            .item{
                padding: 10px 25px 10px 15px;
                height: 40px;
            }
            .item:hover{
                background-color: #a2a2a2;
            }
            .checkTagItem{
                background-color: #595959;
            }
        }
        .button{
            position: fixed;
            bottom: 0;
            height: 50px;
            line-height: 50px;
            font-size: 15px;
            padding-left: 15px;
            color: #999;
        }
    }
}
</style>
