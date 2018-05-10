<template>
    <div id="diary">
        <el-card>
            <div id="query">
                <el-row>
                    <el-col :span="8">
                        <el-input v-model="query" style="width:96%" placeholder="请输入日记标题"></el-input>
                    </el-col>
                    <el-col :span="16">
                        <el-button-group>
                            <el-button type="primary" @click="queryList()">查询</el-button>
                            <el-button type="primary" @click="toCreate()">新增</el-button>
                        </el-button-group>
                    </el-col>
                </el-row>
            </div>
            <el-table
            :data="list"
            style="width: 100%"
            :highlight-current-row="true"
            class="system-table"
            >
                <el-table-column align="center" label="序号" type="index" width="100"></el-table-column>
                <el-table-column
                width="150"
                label="图片">
                    <template scope="scope">
                          <img v-if="scope.row.img" :src="scope.row.img" class="avatarlist">
                    </template>
                </el-table-column>
                <el-table-column
                width="100"
                label="是否显示">
                    <template scope="scope">
                        <span style="margin-left: 10px" v-if="scope.row.enabled == 1">
                            <el-tag type="success">显示</el-tag>
                        </span>
                        <span style="margin-left: 10px" v-else>
                            <el-tag type="error">隐藏</el-tag>
                        </span>
                    </template>
                </el-table-column>
                <el-table-column
                label="标题">
                    <template scope="scope">
                        <span style="margin-left: 10px">
                            {{ scope.row.title}}
                        </span>
                    </template>
                </el-table-column>
                <el-table-column
                width="150"
                label="时间">
                    <template scope="scope">
                        <span style="margin-left: 10px">
                            {{ scope.row.time | formatDate}}
                        </span>
                    </template>
                </el-table-column>
                <el-table-column
                label="内容" >
                    <template scope="scope">
                        <span style="margin-left: 10px">{{ scope.row.content }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="200px">
                    <template scope="scope">
                        <el-button
                            size="mini"
                            type="success"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination-container">
                <el-pagination @size-change="handleSizeChange" 
                                @current-change="handleCurrentChange"
                                :current-page.sync="listQuery.page"
                                :page-sizes="[10.,20,30,50]" 
                                :page-size="listQuery.pageSize"
                                layout="total, sizes, prev, pager, next, jumper" 
                                :total="total">
                </el-pagination>
            </div>
                 <!--编辑框-->
            <el-dialog  :visible.sync="dialogFormVisible" :before-close="handleClose" width="740px" :title="title">
                <el-form :model="form" :inline="true" :rules="rules" ref="form" label-width="90px" label-position="right">
                    <el-row>
                        <el-col :span="14">
                             <el-form-item label="主题" prop="title">
                                <el-input v-model="form.title" placeholder="请输入主题"  ></el-input>
                            </el-form-item>
                            <el-form-item label="是否启用" prop="enabled">
                                <el-switch active-value = 1  inactive-value = 0 v-model="form.enabled"></el-switch>
                            </el-form-item>
                            <el-form-item  label="时间" prop="time">
                                <el-date-picker
                                    v-model="form.time"
                                    type="datetime"
                                    placeholder="选择日期时间">
                                </el-date-picker>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="上传图片" prop="img" class="upload">
                                <el-upload
                                    class="avatar-uploader"
                                    :action="uploadUrl"
                                    :headers="uploadHeader"
                                    :show-file-list="false"
                                    :on-success="handleAvatarSuccess">
                                        <img v-if="form.img" :src="form.img" class="avatar">
                                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                    </el-upload>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-form-item label="内容" prop="content" >
                        <el-input style="width:530px" type="textarea" :autosize="{ minRows: 3, maxRows: 5}" placeholder="请输入备注"
                                v-model="form.content"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="cancel('form')">取 消</el-button>
                    <el-button v-if="dialogStatus=='create'" type="primary" @click="create('form')">确 定</el-button>
                    <el-button v-else type="primary" @click="update('form')">确 定</el-button>
                </div>
            </el-dialog>
        </el-card>                
    </div>
</template>

<script>
  import { page, getObj, putObj, delObj, addObj } from '@/api/admin/blogger/diary/index'
  import { parseTime } from '@/utils/index'
  import { getToken } from '@/utils/auth'
  export default {
    filters: {
      formatDate(time) {
        return parseTime(time, '{y}-{m}-{d} {h}:{i}')
      }
    },
    data() {
      return {
        list: null,
        query: '',
        total: null,
        listQuery: {
          page: 1,
          pageSize: 10,
          title: ''
        },
        textMap: {
          update: '更新',
          create: '创建'
        },
        uploadHeader: {
          'ACCESS-TOKEN': getToken()
        },
        title: '',
        dialogStatus: '',
        dialogFormVisible: false,
        dialogRoleFormVisible: false,
        form: this.initObj(),
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' },
            { min: 10, max: 2000, message: '长度在10到20000个字符', trigger: 'blur' }
          ]
        },
        uploadUrl: process.env.BASE_API + '/admin/blogger/diary/uploadImages'
      }
    },
    created() {
      this.getList()
    },
    methods: {
      initObj() {
        return {
          id: '',
          time: new Date(),
          img: undefined,
          title: undefined,
          content: '',
          enabled: undefined
        }
      },
      resetTemp() {
        this.form = this.initObj()
      },
      queryList() {
        this.listQuery.title = this.query
        this.getList()
      },
      getList() {
        page(this.listQuery).then(response => {
          this.list = response.data.list
          this.total = response.data.total
        })
      },
      cancel(formName) {
        this.dialogFormVisible = false
        this.$refs[formName].resetFields()
      },
      handleClose(done) {
        this.cancel('form')
        done()
      },
      handleEdit(index, row) {
        getObj(row.id).then(response => {
          this.form = response.data
          this.dialogFormVisible = true
          this.dialogStatus = 'update'
          this.title = '修改日记'
        })
      },
      update(formName) {
        const set = this.$refs
        set[formName].validate(valid => {
          if (valid) {
            putObj(this.form.id, this.form).then(() => {
              this.cancel(formName)
              this.getList()
              this.$notify({
                title: '成功',
                message: '更新成功',
                type: 'success',
                duration: 2000
              })
            })
          } else {
            return false
          }
        })
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
        this.resetTemp()
        this.dialogFormVisible = true
        this.dialogStatus = 'create'
        this.title = '新增日记'
      },
      create(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            addObj(this.form).then(() => {
              this.$notify({
                title: '成功',
                message: '创建成功',
                type: 'success',
                duration: 2000
              })
              this.cancel(formName)
              this.getList()
            })
          } else {
            return false
          }
        })
      },
      handleSizeChange(val) {
        this.listQuery.pageSize = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.listQuery.page = val
        this.getList()
      },
      handleAvatarSuccess(response, file, fileList) {
        this.form.img = process.env.BASE_API + response.data
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss">
#diary{
    .avatar {
        width: 120px;
        height: 120px;
        display: block;
    }
    .avatarlist {
        width: 80px;
        height: 80px;
        display: block;
    }
    .el-form-item{
        width: 100%;
    }
    .upload{
       .el-form-item__content{
         width: 150px;
        } 
    }
    .el-form-item__content{
        width: 260px;
    }
    .el-date-editor.el-input, .el-date-editor.el-input__inner{
        width: 100%;
    }
}
</style>