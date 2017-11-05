<template>
    <div id="blog">
        <div>
            <h1>标题 发布博客</h1>
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
            img_file: {}
        }
    },
    components: {
        mavonEditor
    },
    methods: {
        $save(value,render){
            alert(value)
            alert(render)
        },
        $change(value,render){ // 编辑区发生变化的回调事件
            console.log("1..."+value)
            console.log("2..."+render)
        },
        $imgAdd(pos, $file){
            this.img_file[pos] = $file;
            alert(pos)
            alert($file)
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
</style>
