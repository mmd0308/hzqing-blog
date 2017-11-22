<template>
    <div id="blog">
        <div class="title-div">
            <el-row>
                <el-col :span="21">
                    <el-input placeholder="请输入文章标题" v-model="title" class="title-input">
                    </el-input>
                </el-col>
                <el-col :span="3">
                    <el-button type="danger" @click="saveBlog">发表博客</el-button>
                </el-col>
            </el-row>
        </div>
        <mavon-editor 
            style="height: 100%"
            ref="mavonEditor"
            placeholder="请开始你的表演..."
            @save="$save"
            @change="$change"
            @imgAdd="$imgAdd"
            @imgDel="$imgDel"
            :value="mavonDate"
        ></mavon-editor>
    </div>
</template>
<script>
import {  addObj, getObj } from '@/api/admin/blog/article'
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
            mavonDate: ''
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
                arDesc: ''
            }
        },
        saveBlog(){
            alert('发表博客')
        },
        $save(value,render){
            this.form.arContent = value;
            this.form.arContentHtml = render;
            this.form.arTitle = this.title;
            addObj(this.form).then(response => {
                debugger
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
            console.log("1..."+value)
            console.log("2..."+render)
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
            getObj(this.blodId).then(response => {
                this.mavonDate = response.data.arContent
                this.form = response.data
                this.title = response.data.arTitle
                console.log(response.data)
            })
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

</style>
