<template>
  <div class="work">
    <div class="header">
      <h2>作品展示</h2>
      <div class="hzq">Exhibition of works</div>
    </div>
    <div class="work-body">
      <el-row>
          <el-col :span="6" v-for="o in 4" :key="o">
            <div class="item">
              <img src="static/img/timeline.png"/>
            </div>
          </el-col>
      </el-row>
    </div>
  </div>
</template>

<style rel="stylesheet/scss" lang="scss">
  .work{
    .header{
      width: 160px;
      text-align: center;
      margin: auto;
      margin-top: 30px;
      margin-bottom: 30px;
      h2{
        margin: 0px;
        height: 30px;
        line-height: 30px;
        font-size: 16px;
        color: #333;
        border-bottom: solid 1px #cfcfcf;
      }
      .hzq{
        height: 25px;
        line-height: 25px;
        font-size: 14px;
        color: #666;
      }
    }
    .work-body{
      margin: 0px;;
      overflow: hidden;
      margin-bottom: 30px;
      .item{
          margin: 0 10px;
         img{
            margin: auto;
            height: 100%;
            width: 100%;
            border: 0;
            display: block;
            border-radius: 10px;
          }
      }
    }
  }
</style>

<script>
export default {
  data() {
    return {
      currentDate: new Date()
    }
  }
}
</script>