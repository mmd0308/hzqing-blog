import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import App from './App'
import router from './router'
import store from './store'
import '@/icons' // icon
import '@/permission' // 权限
import locale from 'element-ui/lib/locale/lang/zh-CN'

import 'mavon-editor/dist/css/index.css'
import  mavonEditor from 'mavon-editor'
Vue.use(mavonEditor)

Vue.use(ElementUI, { locale })

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
