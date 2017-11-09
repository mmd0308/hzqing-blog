<template>
    <div id="user">
            <el-card>
                <div id="query">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="query" style="width:96%" placeholder="请输入姓名或账户"></el-input>
                        </el-col>
                        <el-col :span="16">
                            <el-button-group>
                                <el-button type="primary">查询</el-button>
                                <el-button type="primary">新增</el-button>
                            </el-button-group>
                        </el-col>
                    </el-row>
                </div>
                <el-table
                :data="list"
                style="width: 100%"
                >
                    <el-table-column align="center" label="序号" type="index" width="90"></el-table-column>
                    <el-table-column
                    label="账户"
                    sortable>
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.username }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="邮箱">
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.email }}</span>
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
                                v-if="scope.row.show == 'show'"
                                size="mini"
                                type="info"
                                @click="handleEdit(scope.$index, scope.row)">显示</el-button>
                            <el-button
                                v-if="scope.row.show == 'hide'"
                                size="mini"
                                type="warning"
                                @click="handleEdit(scope.$index, scope.row)">隐藏</el-button>
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
  import {  page } from '@/api/admin/system/user/index'
  export default {
    data() {
      return {
        list: null,
        query: '',
        total: null,
        listQuery:{
            page: 1,
            pageSize: 10,
            username: '',
            email: ''
        }
      }
    },
    created() {
      this.getList()
    },
    methods: {
      initObj() {
        return {
          id: '',
          username: undefined,
          password: undefined,
          email: undefined,
          note: ''
        }
      },
      getList() {
        page(this.listQuery).then(response => {
            this.list = response.data.list
            this.total = response.data.total
        })
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    }
  }
</script>
<style>
#query{
    margin: 0px 0px 10px 0px;
}
</style>

