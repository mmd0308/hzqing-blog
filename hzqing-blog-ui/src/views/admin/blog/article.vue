<template>
    <div id="category">
            <el-card>
                <div id="query">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="query" style="width:96%" placeholder="请输入分类名称"></el-input>
                        </el-col>
                        <el-col :span="16">
                            <el-button-group>
                                <el-button type="primary">查询</el-button>
                                <el-button type="primary" @click="toCreate">新增</el-button>
                            </el-button-group>
                        </el-col>
                    </el-row>
                </div>
                <el-table
                :data="list"
                style="width: 100%" >
                    <el-table-column
                    label="标题"
                    sortable >
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.arTitle }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="创建时间"
                    width="180px"
                    :formatter="formatter">
                        <template scope="scope">
                            <span style="margin-left: 10px">{{ scope.row.arCtime | formatDate }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="状态"
                    width="100px"
                    :formatter="formatter">
                        <template scope="scope">
                            <span style="margin-left: 10px" v-if="scope.row.arState == 'FB'">
                                <el-tag type="success">发布</el-tag>
                            </span>
                            <span style="margin-left: 10px" v-if="scope.row.arState == 'CG'">
                                <el-tag type="danger">草稿</el-tag>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column
                    label="置顶"
                    width="100px"
                    :formatter="formatter">
                        <template scope="scope">
                            <span style="margin-left: 10px" v-if="scope.row.arUp == 'Y'">
                                <el-tag type="warning" >置顶</el-tag>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="200px">
                        <template scope="scope">
                            <el-button
                                size="mini"
                                type="success"
                                @click="toUpdate(scope.row.id)">编辑</el-button>
                            <el-button
                                size="mini"
                                type="info"
                                @click="toFb(scope.row.id)">发布</el-button>
                            <el-button
                                v-if="scope.row.show == 'show'"
                                size="mini"
                                type="info"
                                @click="handleEdit(scope.$index, scope.row)">置顶</el-button>
                            <el-button
                                v-if="scope.row.show == 'hide'"
                                size="mini"
                                type="warning"
                                @click="handleEdit(scope.$index, scope.row)">取消置顶</el-button>
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
import {  page, getObj, delObj } from '@/api/admin/blog/article'
import { formatDate} from '@/utils/date'
export default {
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm');
      }
    },
    data() {
        return {
            form: this.initObj(),
            listQuery:{
                page: 1,
                pageSize: 10
            },
            list: null,
            total: null,
            query: ''
        }
    },
    created() {
        this.getList();
    },
    methods: {
       initObj() {
            return {
                id: '',
                arTitle: '',
                arContent: '',
                arContentHtml: '',
                arDesc: ''
            }
        },
        formatter(row, column) {
            return row.address;
        },  
        handleEdit(index, row) {
            console.log(index, row);
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
                    this.getList();
                })
            })
        },
        getList() {
            page(this.listQuery).then(response => {
                this.list = response.data.list
                this.total = response.data.total
            })
        },
        handleSizeChange(val) {
            this.listQuery.pageSize = val
            this.getList();
        },
        handleCurrentChange(val) {
            this.listQuery.page = val
            this.getList();
        },
        toCreate() {
            this.$router.push('/blog/write')
        },
        toUpdate(id) {
            this.$router.push({
                path: '/blog/write',
                query: {
                    blodId: id 
                    }
                })
        }
    }
}
</script>
<style>
#query{
    margin: 0px 0px 10px 0px;
}
</style>

