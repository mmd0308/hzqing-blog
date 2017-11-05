<template>
    <div id="category">
            <el-card>
                <div id="query">
                    <el-row>
                        <el-col :span="8">
                            <el-input v-model="input" style="width:96%" placeholder="请输入标题名称"></el-input>
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
                    :data="tableData5"
                    style="width: 100%">
                    <el-table-column type="expand">
                    <template scope="props">
                        <div  class="text item">
                            内容：JournalNode不用单独拎出来吗？他不是保证两个namenode数据同步的吗 
                        </div>
                        <div v-for="o in 1" :key="o" class="text item title">
                            {{'张三回复Kdpshd: ' + o }}
                        </div>
                        <div  class="text item">
                            内容：JournalNode不用单独拎出来吗？他不是保证两个namenode数据同步的吗 
                        </div>
                    </template>
                    </el-table-column>
                    <el-table-column
                    label="标题"
                    width="500px"
                    prop="id">
                    </el-table-column>
                    <el-table-column
                    label="作者"
                    prop="name">
                    </el-table-column>
                    <el-table-column
                    label="时间"
                    prop="desc">
                    </el-table-column>
                    <el-table-column label="操作" width="100px">
                        <template scope="scope">
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
        tableData5: [{
          id: 'Hadoop-2.8.0之分布式集群（HA架构）搭建',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '2013-4-8',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987125',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987126',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }]
      }
    }
  }
</script>
<style>
#query{
    margin: 0px 0px 10px 0px;
}
.demo-table-expand {
    font-size: 0;
}
.demo-table-expand label {
    width: 300px;
    color: #99a9bf;
}
.demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
}
.text {
    font-size: 14px;
}

.item {
    padding: 15px 0;
}
.title{
    background: #eef1f6;
    padding: 10px 0;
}
</style>
