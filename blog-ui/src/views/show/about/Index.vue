<template>
    <div id="about">
        <show-header :message='msg'></show-header>
        <div style="background:#fff">
            <timeline>
                <timeline-title>title</timeline-title>
                <timeline-item color="#9dd8e0">item1</timeline-item>
                <timeline-item :hollow="false">item2</timeline-item>
                <timeline-item  line-color="#9dd8e0" color="#222">item55</timeline-item>
                <timeline-item hollow="true" color="#222">item2</timeline-item>
                <timeline-item :hollow="false">item2</timeline-item>
                <timeline-item :hollow="false">
                    暂时保留  寻找更好的样式
                    A cute emoticon and emoji keyboard which can generate random emoticon or emoji and no xss.
                    A cute emoticon and emoji keyboard which can generate random emoticon or emoji and no xss. 
                </timeline-item>
            </timeline>
        </div>
    </div>
</template>

<script>
import { Timeline, TimelineItem, TimelineTitle } from 'vue-cute-timeline'
import ShowHeader from '@/components/ShowHeader/index'
export default {
    components: {
        Timeline,
        TimelineItem,
        TimelineTitle,
        ShowHeader 
    },
    data() {
        return {
            msg: '关于我'
        }
    }
}
</script>

<style>
#about{
    
}
</style>
