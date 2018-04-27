<template>
  <div class="basicSet">
      <el-row class="row">
          <el-col :span="5">
                <div class="pic">
                    <img src="static/img/touxiang.jpeg"/>
                </div>
          </el-col>
          <el-col :span="19">
              <div class="updateAct">
                  更改头像
              </div>
          </el-col>
      </el-row>
      <el-row class="row">
          <el-col :span="5">
              昵称
          </el-col>
          <el-col :span="19">
              fsaf
          </el-col>
      </el-row>
      <el-row class="row">
          <el-col :span="5">
              电子邮箱
          </el-col>
          <el-col :span="19">
              fsaf
          </el-col>
      </el-row>
      <el-row class="row">
          <el-col :span="5">
            手机
          </el-col>
          <el-col :span="19">
              fsaf
          </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
       basicForm: {
          age: ''
        }
    }
  },
  methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.basicSet{
    background: #fff;
    .row{
        border-bottom: 1px solid #f0f0f0;
        line-height: 50px;
        padding: 20px;  
        .updateAct{
            background: #02e7be;
            width: 100px;
            line-height: 30px;
            margin: auto 0px;
            text-align: center;
            border-radius: 20px;
            margin-top: 40px;
        }
        .pic{
            width: 110px;
            height: 110px;
            display: block;
            cursor: pointer;
            margin: auto;
            float: left;
        }
        .pic img{
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }
    }
}
</style>
