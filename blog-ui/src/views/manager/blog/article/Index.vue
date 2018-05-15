<template>
  <div id="user">
    <el-card>
      <div id="query">
        <el-row>
          <el-col :span="8">
            <el-input v-model="query" style="width:96%" placeholder="请输入博客名称"></el-input>
          </el-col>
          <el-col :span="16">
            <el-button type="primary" @click="queryList()">查询</el-button>
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
        label="标题"
        sortable>
            <template scope="scope">
                <span style="margin-left: 10px">{{ scope.row.arTitle }}</span>
            </template>
        </el-table-column>
        <el-table-column
        label="创建时间"  width="200" >
            <template scope="scope">
                <span style="margin-left: 10px">{{ scope.row.arCtime | formatDate }}</span>
            </template>
        </el-table-column>
        <el-table-column
        label="修改时间" width="200" >
            <template scope="scope">
                <span style="margin-left: 10px">{{ scope.row.arEtime | formatDate }}</span>
            </template>
        </el-table-column>
        <el-table-column
        label="状态" width="100" >
            <template scope="scope">
                <span style="margin-left: 10px" v-if="scope.row.arState === 'FB'">
                  <el-tag type="success">发布</el-tag>
                </span>
                <span style="margin-left: 10px" v-if="scope.row.arState === 'CG'">
                  <el-tag type="warning">草稿</el-tag>
                </span>
            </template>
        </el-table-column>
        <el-table-column
        label="是否置顶" width="100" >
            <template scope="scope">
                <span style="margin-left: 10px" v-if="scope.row.arUp === '0'">否</span>
                <span style="margin-left: 10px" v-if="scope.row.arUp === '1'">是</span>
            </template>
        </el-table-column>
        <el-table-column label="操作" width="200px">
          <template scope="scope">
              <el-button
                  size="mini"
                  type="success"
                  v-if="scope.row.arState != 'FB'"
                  @click="handleEdit(scope.$index, scope.row)">发布</el-button>
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
    </el-card>                
  </div>
</template>

<script>
  import { page, delObj, putObj } from '@/api/manager/blog/article/index'
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
        query: '',
        total: null,
        listQuery: {
          page: 1,
          pageSize: 10,
          arTitle: ''
        },
        form: this.initObj()
      }
    },
    created() {
      this.getList()
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
          arState: undefined,
          arUp: undefined
        }
      },
      resetTemp() {
        this.form = this.initObj()
      },
      queryList() {
        this.listQuery.arTitle = this.query
        this.getList()
      },
      getList() {
        page(this.listQuery).then(response => {
          this.list = response.data.list
          this.total = response.data.total
        })
      },
      handleEdit(index, row) {
        this.resetTemp()
        this.form.id = row.id
        this.form.arState = 'FB'
        putObj(row.id, this.form).then(() => {
          this.$notify({
            title: '成功',
            message: '发布成功',
            type: 'success',
            duration: 2000
          })
          this.getList()
        })
      },
      handleDelete(index, row) {
        this.$confirm('是否刪除该博客？', '删除博客', {
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