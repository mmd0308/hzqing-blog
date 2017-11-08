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
            placeholder="请开始你的表演..."
            @save="$save"
            @change="$change"
            @imgAdd="$imgAdd"
            @imgDel="$imgDel"
        ></mavon-editor>
    </div>
</template>
<script>
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
export default {
    data(){
        return {
            img_file: {},
            title: ''
        }
    },
    components: {
        mavonEditor
    },
    methods: {
        saveBlog(){
            alert('发表博客')
        },
        $save(value,render){
            alert(value)
            alert(render)
            debugger
        },
        $change(value,render){ // 编辑区发生变化的回调事件
            console.log("1..."+value)
            console.log("2..."+render)
        },
        $imgAdd(pos, $file){
            this.img_file[pos] = $file;
           this.$refs.mavonEditor.$imgUpdateByUrl( $file,"http://localhost:8080/jfjf");
        },
        $imgDel(pos){
            delete this.img_file[pos];
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
