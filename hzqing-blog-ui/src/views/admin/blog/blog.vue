<template>
    <div id="blog">
        <div class="title-div">
            <el-row>
                <el-col :span="21">
                    <el-input placeholder="请输入文章标题" v-model="title"  class="title-input">
                    </el-input>
                </el-col>
                <el-col :span="3">
                    <el-button type="danger" @click="toSaveBlog">发表博客</el-button>
                </el-col>
            </el-row>
        </div>
        <mavon-editor 
            style="height: 100%"
            ref="mavonEditor"
            placeholder="请开始你的表演..."
            :code_style="code_style"
            @save="$save"
            @change="$change"
            @imgAdd="$imgAdd"
            @imgDel="$imgDel"
            :value="mavonDate"
        ></mavon-editor>
        <el-dialog title="发布博客" :visible.sync="dialogFormVisible" width="30%">
            <el-form :model="form"  :rules="rule" ref="form">
                <el-form-item label="文章类型" :label-width="formLabelWidth" prop="arType">
                    <el-select v-model="form.arType"  placeholder="请选择活动区域"  >
                        <el-option label="原创" value="Y"></el-option>
                        <el-option label="转载" value="Z"></el-option>
                    </el-select>
                </el-form-item>
                 <el-form-item label="转载地址" :label-width="formLabelWidth" v-if="form.arType == 'Z'">
                    <el-input v-model="form.arUrl" auto-complete="off" class="dialog-element-width"></el-input>
                </el-form-item>
                <el-form-item label="分类" :label-width="formLabelWidth" prop="cateId">
                    <el-select v-model="form.cateId" multiple placeholder="请选择">
                        <el-option
                        v-for="item in categorys"
                        :key="item.id"
                        :label="item.cateName"
                        :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="标签" :label-width="formLabelWidth" prop="arLabel">
                    <el-input v-model="form.arLabel" auto-complete="off" class="dialog-element-width"></el-input>
                </el-form-item>
                <el-form-item label="描述" :label-width="formLabelWidth" prop="arDesc">
                    <el-input  type="textarea" ref="textAreaSize" :maxlength = "textMaxSize" @change="textArea" v-model="form.arDesc" auto-complete="off" class="dialog-element-width" :autosize="{ minRows: 3, maxRows: 6}" >
                    </el-input>
                    <div style="width:90%;text-align:right;" hidden>
                        字数:{{this.textSize}}
                    </div>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveBlog('form')">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {  addObj, getObj ,getCateByAid } from '@/api/admin/blog/article'
import {  getAll } from '@/api/admin/blog/category'
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import axios from 'axios'
export default {
    data(){
        return {
            img_file: {},
            title: '',
            form: this.initObj(),
            blodId: '',
            mavonDate: '',
            dialogFormVisible: false,
            formLabelWidth: '120px',
            categorys: null,
            rule: {
                arType: {  required: true,  message: '请选择文章类型',  trigger: 'blur'    },
                arLabel: {  required: true,  message: '请输入标签',  trigger: 'blur'    },
                cateId: {  required: true,  message: '请选择类别'  },
                arDesc: {  required: true,  message: '请写摘要',  trigger: 'blur'    }
            },
            textSize: 200,
            textMaxSize: 200,
            code_style: 'solarized-dark'
        }
    },
    components: {
        mavonEditor
    },
    created() {
        this.blodId = this.$route.query.blodId;
        if(this.blodId != undefined){
            this.findById();
        }
        
    },
    methods: {
        initObj() {
            return {
                id: '',
                arTitle: '',
                arContent: '',
                arContentHtml: '',
                arDesc: '',
                arType: '',
                arUrl: '',
                arLabel: '',
                cateId: [],
                arState: 'CG'
            }
        },
        toSaveBlog(){
            if(this.title == ''){
                this.$message({
                    message:'请输入博客标题...',
                    type: 'warning'
                    });
                return false;
            }
            this.dialogFormVisible = true
            //查询所有类别
            getAll().then(response => {
                this.categorys = response.data
            })
            //根据文章id获取类别
            if(this.form.id != ''){
                getCateByAid(this.form.id).then(response =>{
                    this.form.cateId = response.data
                })
            }
            
        },
        saveBlog(formName) {
            this.form.arState = 'FB'
            this.form.arTitle = this.title;
            this.form.arContent = this.$refs.mavonEditor.d_value;
            this.form.arContentHtml = this.$refs.mavonEditor.d_render;
            this.$refs[formName].validate(valid => {
                if (valid) {
                    addObj(this.form).then(response => {
                        this.form.id = response.data.id
                        this.dialogFormVisible = false
                        this.$notify({
                            title: '成功',
                            message: '保存成功',
                            type: 'success',
                            duration: 2000
                        })
                    })
                } else {
                    return false
                }
            })
        },
        $save(value,render){
            if(this.title == ''){
                this.$message({
                    message:'请输入博客标题...',
                    type: 'warning'
                    });
                return false;
            }
            this.form.arContent = value;
            this.form.arContentHtml = render;
            this.form.arTitle = this.title;
            addObj(this.form).then(response => {
                this.form.id = response.data.id
                this.$notify({
                    title: '成功',
                    message: '保存成功',
                    type: 'success',
                    duration: 2000
                })
            })
        },
        $change(value,render){ // 编辑区发生变化的回调事件
/*            this.form.arContent = value;
            this.form.arContentHtml = render;
            this.form.arTitle = this.title;
            addObj(this.form).then(response => {
                this.form.id = response.data.id
            })
            */
        },
        $imgAdd(pos, $file){
            this.img_file[pos] = $file;
            let file = $file
            let param = new FormData()  // 创建form对象
            param.append('file', file)  // 通过append向form对象添加数据
            console.log(param.get('file')) // FormData私有类对象，访问不到，可以通过get判断值是否传进去
            let config = {
                headers: {'Content-Type': 'multipart/form-data'}
            }
            var that = this;
            // 添加请求头
            axios.post('/admin/blog/article/uploadImages', param, config)
                .then(response => {
                    // that.$refs.mavonEditor.$imgUpdateByUrl(pos,process.env.BASE_API+response.data.data)
                    that.$refs.mavonEditor.$img2Url(pos,process.env.BASE_API+response.data.data)
            })
        },
        $imgDel(pos){
            delete this.img_file[pos];
        },
        findById() {
            this.restTemp();
            getObj(this.blodId).then(response => {
                this.mavonDate = response.data.arContent
                this.form = response.data
                this.title = response.data.arTitle
                console.log(response.data)
            })
        },
        restTemp() {
            this.form = this.initObj();
        },
        textArea(){
            var size = this.$refs.textAreaSize.value.length;
            this.textSize = (200 - size ) > 0 ? size: 0;
        }
    }
}
</script>
<style>
#blog {
    margin: auto;
    width: 100%;
    height: 540px;
}
.title-div{
    padding: 15px 0px;
}

.title-input input{
    border: none;
    font-size: 25px;
}
.dialog-element-width{
    width: 90%;
}

</style>
