<template>
    <div id="tag">
        <el-card>
            <div id="query">
                <el-row>
                    <el-col :span="8">
                        <el-input v-model="query" style="width:96%" placeholder="请输入标签名称"></el-input>
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
                <el-table-column align="center" label="序号" type="index" width="90"></el-table-column>
                <el-table-column
                label="类别名称"
                sortable>
                    <template scope="scope">
                        <span style="margin-left: 10px">{{ scope.row.tagName }}</span>
                    </template>
                </el-table-column>
                <el-table-column
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
                label="类型">
                    <template scope="scope">
                        <span style="margin-left: 10px" v-if="scope.row.tagType === 'L'">
                            <el-tag type="success">标签</el-tag>
                        </span>
                        <span style="margin-left: 10px"  v-if="scope.row.tagType === 'C'">
                            <el-tag type="error">分类</el-tag>
                        </span>
                    </template>
                </el-table-column>
                <el-table-column
                label="显示顺序">
                    <template scope="scope">
                        <span style="margin-left: 10px">{{ scope.row.sort }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                label="备注" >
                    <template scope="scope">
                        <span style="margin-left: 10px">{{ scope.row.note }}</span>
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
            <el-dialog  :visible.sync="dialogFormVisible" :before-close="handleClose" width="40%" :title="title">
                <el-form :model="form" :inline="true" :rules="rules" ref="form" label-width="90px">
                    <el-form-item label="标签名称" prop="tagName" >
                        <el-input v-model="form.tagName" placeholder="请输入姓名" class="input-selects-width"></el-input>
                    </el-form-item>
                    <el-form-item label="是否启用" prop="enabled">
                        <el-switch active-value = 1  inactive-value = 0 v-model="form.enabled"></el-switch>
                    </el-form-item>
                    <el-form-item  label="排序" prop="sort">
                        <el-input v-model="form.sort" class="input-selects-width"></el-input>
                    </el-form-item>
                    <el-form-item  label="类别" prop="tagType">
                         <el-select v-model="form.tagType" placeholder="请选择类型">
                            <el-option
                            v-for="item in tagTypes"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="备注" prop="note">
                        <el-input type="textarea" :autosize="{ minRows: 3, maxRows: 5}" class="input-selects-width" placeholder="请输入备注"
                                v-model="form.note"></el-input>
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
  import { page, getObj, putObj, delObj, addObj } from '@/api/admin/blog/tag/index'
  export default {
    data() {
      return {
        list: null,
        query: '',
        total: null,
        listQuery: {
          page: 1,
          pageSize: 10,
          tagName: ''
        },
        textMap: {
          update: '更新',
          create: '创建'
        },
        title: '',
        dialogStatus: '',
        dialogFormVisible: false,
        dialogRoleFormVisible: false,
        form: this.initObj(),
        rules: {
          tagName: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 2, max: 20, message: '长度在3到20个字符', trigger: 'blur' }
          ]
        },
        tagTypes: [
          { value: 'L', label: '标签' },
          { value: 'C', label: '类别' }
        ]
      }
    },
    created() {
      this.getList()
    },
    methods: {
      initObj() {
        return {
          id: '',
          tagName: undefined,
          enabled: undefined,
          sort: undefined,
          note: '',
          tagType: undefined
        }
      },
      resetTemp() {
        this.form = this.initObj()
      },
      queryList() {
        this.listQuery.tagName = this.query
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
          this.title = '修改标签'
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
        this.title = '新增标签'
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
      }
    }
  }
</script>

