<template>
    <div id="diary">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>{{navHeader}}</span>
                <div class="fr">
                  <el-button class="el-header-right-button" v-if="resCode.indexOf('BUTTON_GRRJ_XZ') != -1" @click="toAdd" type="text">新增</el-button>
                </div>
            </div>
          <div class="dirary-body" style="background:#fff">
              <hzqing-vue-timeline timelineColor="#fff" timeContentColor="#f1f1f1" :dataList="timeItemList"></hzqing-vue-timeline>
          </div>
        </el-card>
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
                    <el-button type="primary" @click="create('form')">确 定</el-button>
                </div>
            </el-dialog>
    </div>
</template>
<script>
import { showAll, addObj } from '@/api/admin/blogger/diary/index'
import { mapGetters } from 'vuex'
import { getToken } from '@/utils/auth'
export default {
  computed: {
    ...mapGetters([
      'resCode'
    ])
  },
  data() {
    return {
      navHeader: '',
      timeItemList: [],
      listQuery: {
        title: ''
      },
      dialogFormVisible: false,
      title: '',
      form: this.initObj(),
      rules: {
        content: [
          { required: true, message: '请输入内容', trigger: 'blur' },
          { min: 10, max: 2000, message: '长度在10到20000个字符', trigger: 'blur' }
        ]
      },
      uploadHeader: {
        'ACCESS-TOKEN': getToken()
      },
      uploadUrl: process.env.BASE_API + '/admin/blogger/diary/uploadImages'
    }
  },
  created() {
    this.getAll()
    this.navHeader = this.$route.query.navHeader
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
    getAll() {
      showAll(this.listQuery).then(response => {
        this.timeItemList = response.data
      })
    },
    toAdd() {
      this.dialogFormVisible = true
    },
    handleClose(done) {
      this.cancel('form')
      done()
    },
    cancel(formName) {
      this.dialogFormVisible = false
      this.$refs[formName].resetFields()
    },
    handleAvatarSuccess(response, file, fileList) {
      this.form.img = process.env.BASE_API + response.data
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
            this.getAll()
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
#diary{
  .el-card__body{
    padding: 0px;
  }
  .dirary-body{
      border-radius: 10px;
      #hzqing{
       border-radius: 10px;
      }
  }
}
</style>
