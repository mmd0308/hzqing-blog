<template>
    <div class="mkDown">
        <div class="blogMKDown">
            <div class="blogTopic">
                <el-input placeholder="请输入内容" v-model="formArticle.arTitle">
                </el-input>
                <div style="float:right;">
                  {{ blogEditState }}
                </div>
            </div>
            <mavon-editor 
                v-model="formArticle.arContent" 
                style="height: 93%"
                ref="mavonEditor"
                :subfield="false"
                defaultOpen="edit"
                placeholder="请开始你的表演..."
                code_style="solarized-dark"
                :ishljs = "true"
                :toolbars="toolbars"
                @save="$save"
                @imgAdd="$imgAdd"
                @change="$change"
                 >
            </mavon-editor>
        </div>
  </div>
</template>
<script>
import axios from 'axios'
import { putObj } from '@/api/manager/blog/article/index'
import { getToken } from '@/utils/auth'
export default {
  data() {
    return {
      topic: '2018-03-09',
      toolbars: {
        bold: false, // 粗体
        italic: false, // 斜体
        header: false, // 标题
        underline: false, // 下划线
        strikethrough: false, // 中划线
        mark: false, // 标记
        superscript: false, // 上角标
        subscript: false, // 下角标
        quote: false, // 引用
        ol: false, // 有序列表
        ul: false, // 无序列表
        link: false, // 链接
        imagelink: true, // 图片链接
        code: false, // code
        table: false, // 表格
        fullscreen: true, // 全屏编辑
        readmodel: false, // 沉浸式阅读
        htmlcode: false, // 展示html源码
        help: true, // 帮助
        /* 1.3.5 */
        undo: true, // 上一步
        redo: true, // 下一步
        trash: false, // 清空
        save: true, // 保存（触发events中的save事件）
        /* 1.4.2 */
        navigation: true, // 导航目录
        /* 2.1.8 */
        alignleft: false, // 左对齐
        aligncenter: false, // 居中
        alignright: false, // 右对齐
        /* 2.2.1 */
        subfield: true, // 单双栏模式
        preview: false // 预览
      },
      formArticle: {
        id: '',
        arTitle: undefined,
        arDesc: undefined,
        arContent: undefined,
        arContentHtml: undefined,
        arEtime: undefined,
        arState: undefined
      },
      blogEditState: '已保存',
      changeSave: false
    }
  },
  created() {
    if (this.formArticle.id !== '') {
      this.changeSave = true
    }
  },
  methods: {
    initTag() {
      return {
      }
    },
    $save(value, render) {
      this.blogEditState = '保存中...'
      this.formArticle.arContent = value
      this.formArticle.arContentHtml = render
      this.formArticle.arEtime = new Date()
      this.formArticle.arState = 'CG'
      putObj(this.formArticle.id, this.formArticle).then(response => {
        this.blogEditState = '已保存'
        this.changeSave = true
      })
    },
    $change(value, render) {
      // 编辑区发生变化的回调事件
      this.blogEditState = '未保存'
      // if (this.changeSave) {
      //   this.blogEditState = '保存中...'
      //   this.formArticle.arContent = value
      //   this.formArticle.arContentHtml = render
      //   this.formArticle.arEtime = new Date()
      //   putObj(this.formArticle.id, this.formArticle).then(response => {
      //     this.blogEditState = '已保存'
      //   })
      // }
    },
    $imgAdd(pos, $file) {
      this.changeSave = false
      const param = new FormData() // 创建form对象
      param.append('file', $file) // 通过append向form对象添加数据
      // console.log(param.get('file')) // FormData私有类对象，访问不到，可以通过get判断值是否传进去
      const config = {
        headers: { 'Content-Type': 'multipart/form-data', 'ACCESS-TOKEN': getToken() }
      }
      var that = this
      // 添加请求头
      axios.post('/admin/blog/article/uploadImages', param, config).then(response => {
        // that.$refs.mavonEditor.$imgUpdateByUrl(pos,process.env.BASE_API+response.data.data)
        that.$refs.mavonEditor.$img2Url(pos, process.env.BASE_API + response.data.data)
        this.$refs.mavonEditor.$refs.toolbar_left.$imgDelByFilename(pos)
      })
    }
  },
  mounted: function() {
    const that = this
    that.bus.$on('getWriteArticle', function(item) {
      that.formArticle = item
    })
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.mkDown{
    height: 100%;
    .blogMKDown{
        height: 100%;
        .blogTopic{
            padding: 11px 0px;
            .el-input{
              width: 92%;
            }
            .el-input__inner{
                width: 100%;
                padding: 15px 0px 10px 40px;
                margin-bottom: 0;
                border: none;
                font-size: 30px;
                font-weight: 400;
                line-height: 30px;
                box-shadow: none;
                color: #595959;
                background-color: transparent;
                outline: none;
                border-radius: 0;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
        }
    }
}

</style>
