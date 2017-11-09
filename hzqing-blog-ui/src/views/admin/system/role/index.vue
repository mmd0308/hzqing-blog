<template>
    <div id="category">
            <el-card>
                <div id="query">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="input" style="width:96%" placeholder="请输入分类名称"></el-input>
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
                :data="tableData"
                style="width: 100%"
                >
                    <el-table-column
                    label="类别"
                    sortable
                    width="180">
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.date }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="文章"
                    :formatter="formatter">
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.address }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="创建时间"
                    :formatter="formatter">
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.address }}</span>
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
            </el-card>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          show:'show'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
          show:'hide'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          show:'hide'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄',
          show:'hide'
        }]
      }
    },
    methods: {
      formatter(row, column) {
        return row.address;
      },  
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
  }
</script>
<style>
#query{
    margin: 0px 0px 10px 0px;
}
</style>

