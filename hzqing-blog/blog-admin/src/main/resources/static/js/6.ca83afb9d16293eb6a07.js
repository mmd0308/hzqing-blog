webpackJsonp([6],{"0zBP":function(e,t,n){(e.exports=n("FZ+f")(!1)).push([e.i,"\n#button .el-input__inner[data-v-65e6703f] {\n  width: 80% !important;\n}\n",""])},CDju:function(e,t,n){"use strict";t.e=function(e){return Object(a.a)({url:"/admin/menu/tree/"+e,method:"get"})},t.c=function(e,t){return Object(a.a)({url:"/admin/menu/getNextLevelCode/"+e+"/"+t,method:"get"})},t.a=function(e){return Object(a.a)({url:"/admin/menu/add",method:"post",data:e})},t.b=function(e){return Object(a.a)({url:"/admin/menu/delete/"+e,method:"delete"})},t.d=function(e,t){return Object(a.a)({url:"/admin/menu/put/"+e,method:"put",data:t})};var a=n("vLgD")},ChOy:function(e,t,n){var a=n("xIYo");"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);n("rjj0")("0fcf284a",a,!0)},R8ai:function(e,t,n){"use strict";t.e=function(e){return Object(a.a)({url:"/admin/button/page",method:"get",params:e})},t.a=function(e){return Object(a.a)({url:"/admin/button/add",method:"post",data:e})},t.c=function(e,t){return Object(a.a)({url:"/admin/button/getButtonByMenuIdOrRoleId/"+e,method:"get",params:t})},t.d=function(e){return Object(a.a)({url:"/admin/button/get/"+e,method:"get"})},t.b=function(e){return Object(a.a)({url:"/admin/button/delete/"+e,method:"delete"})},t.f=function(e,t){return Object(a.a)({url:"/admin/button/put/"+e,method:"put",data:t})};var a=n("vLgD")},iSzD:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n("CDju"),o=n("R8ai"),i={props:["menuId"],data:function(){return{list:null,query:"",total:null,listQuery:{page:1,pageSize:5,name:"",menuId:""},title:"",dialogStatus:"",dialogFormVisible:!1,form:this.initObj(),dialogMenuVisible:!1,roleToMenuId:"",rules:{name:[{required:!0,message:"请输入名称",trigger:"blur"}],code:[{required:!0,message:"请输入编码",trigger:"blur"}]}}},methods:{initObj:function(){return{id:"",code:"",name:"",menuId:"",enabled:"0"}},resetTemp:function(){this.form=this.initObj()},queryList:function(){this.listQuery.name=this.query,this.getList()},getList:function(e){var t=this;this.listQuery.menuId=this.menuId,void 0!=e&&null!=e&&(this.listQuery.menuId=e),Object(o.e)(this.listQuery).then(function(e){t.list=e.data.list,t.total=e.data.total})},cancel:function(e){this.dialogFormVisible=!1,this.$refs[e].resetFields()},handleClose:function(e){this.cancel("form"),e()},handleEdit:function(e,t){var n=this;Object(o.d)(t.id).then(function(e){n.form=e.data,n.dialogFormVisible=!0,n.dialogStatus="update",n.title="修改按钮"})},update:function(e){var t=this;this.$refs[e].validate(function(n){if(!n)return!1;Object(o.f)(t.form.id,t.form).then(function(){t.cancel(e),t.getList(),t.$notify({title:"成功",message:"更新成功",type:"success",duration:2e3})})})},handleDelete:function(e,t){var n=this;this.$confirm("是否刪除该记录？","记录",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o.b)(t.id).then(function(){n.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),n.getList()})})},toCreate:function(){this.resetTemp(),this.dialogFormVisible=!0,this.dialogStatus="create",this.title="新增按钮"},create:function(e){var t=this;this.$refs[e].validate(function(n){if(!n)return!1;t.form.menuId=t.menuId,Object(o.a)(t.form).then(function(){t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.cancel(e),t.getList()})})},handleSizeChange:function(e){},handleCurrentChange:function(e){}}},r={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"button"}},[n("div",{attrs:{id:"query"}},[n("el-row",[n("el-col",{attrs:{span:8}},[n("el-input",{staticStyle:{width:"96%"},attrs:{placeholder:"请输入角色名称"},model:{value:e.query,callback:function(t){e.query=t},expression:"query"}})],1),e._v(" "),n("el-col",{attrs:{span:16}},[n("el-button-group",[n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.queryList()}}},[e._v("查询")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.toCreate()}}},[e._v("新增")])],1)],1)],1)],1),e._v(" "),n("el-table",{staticClass:"system-table",staticStyle:{width:"100%"},attrs:{data:e.list,"highlight-current-row":!0}},[n("el-table-column",{attrs:{align:"center",label:"序号",type:"index",width:"90"}}),e._v(" "),n("el-table-column",{attrs:{label:"按钮名称",sortable:""},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.name))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"编码"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.code))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},["1"==t.row.enabled?n("el-tag",{attrs:{type:"success"}},[e._v("启用")]):n("el-tag",{attrs:{type:"danger"}},[e._v("禁用")])],1)]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"操作",width:"300px"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(n){e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),n("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(n){e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),n("div",{staticClass:"pagination-container"},[n("el-pagination",{attrs:{"current-page":e.listQuery.page,"page-sizes":[5,10,15,20],"page-size":e.listQuery.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.listQuery,"page",t)}}})],1),e._v(" "),n("el-dialog",{attrs:{visible:e.dialogFormVisible,"before-close":e.handleClose,width:"25%",title:e.title},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[n("el-form",{ref:"form",attrs:{model:e.form,inline:!1,rules:e.rules,"label-width":"90px"}},[n("el-form-item",{attrs:{label:"名称",prop:"name"}},[n("el-input",{staticStyle:{width:"80%"},attrs:{placeholder:"请输入名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"编码",prop:"code"}},[n("el-input",{staticStyle:{width:"80%"},attrs:{placeholder:"请输入编码"},model:{value:e.form.code,callback:function(t){e.$set(e.form,"code",t)},expression:"form.code"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"是否可用",prop:"enabled"}},[n("el-switch",{attrs:{"active-value":"1","inactive-value":"0"},model:{value:e.form.enabled,callback:function(t){e.$set(e.form,"enabled",t)},expression:"form.enabled"}})],1)],1),e._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.cancel("form")}}},[e._v("取 消")]),e._v(" "),"create"==e.dialogStatus?n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.create("form")}}},[e._v("确 定")]):n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.update("form")}}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var l={components:{ButtonView:n("VU/8")(i,r,!1,function(e){n("ml9W")},"data-v-65e6703f",null).exports},watch:{filterText:function(e){this.$refs.menuTree.filter(e)}},created:function(){this.getTree()},data:function(){return{state:"see",form:this.initObj(),filterText:"",defaultProps:{children:"menus",label:"menuName"},menuTreeDate:null,listLoading:!1}},methods:{initObj:function(){return{id:"",menuName:"",menuCode:"",levelcode:"",parentId:"",parentName:"",href:"",component:"",icon:"",menuType:"",enabled:"0",note:"",sort:null}},filterNode:function(e,t){return!e||-1!==t.menuName.indexOf(e)},getTree:function(){var e=this;Object(a.e)("-1").then(function(t){e.menuTreeDate=t.data,e.form=t.data[0],e.state="see",e.$refs.button.getList(e.form.id)})},clickTree:function(e){this.form=e,this.state="see",this.$refs.button.getList(e.id)},expandTree:function(e){console.log("expand")},toCreate:function(){var e=this;this.state="add";var t=this.form.id,n=this.form.menuName,o=this.form.levelcode;this.resetTemp(),this.form.parentId=t,this.form.parentName=n,Object(a.c)(t,o).then(function(t){e.form.levelcode=t.data})},createMenu:function(e){var t=this;this.$refs[e].validate(function(e){e&&Object(a.a)(t.form).then(function(){t.getTree(),t.$notify({title:"成功",message:"菜单新增成功",type:"success",duration:2e3})})})},toUpdate:function(){this.state="edit"},updateMenu:function(e){var t=this;this.$refs[e].validate(function(e){e&&Object(a.d)(t.form.id,t.form).then(function(){t.getTree(),t.$notify({title:"成功",message:"菜单修改成功",type:"success",duration:2e3})})})},toDeleted:function(){var e=this;this.$confirm("此操作将永久删除, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a.b)(e.form.id).then(function(t){t.data?(e.getTree(),e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3})):e.$notify({title:"失败",message:"请先删除下级菜单",type:"error",duration:2e3})})})},resetTemp:function(){this.form=this.initObj()}}},s={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"menu"}},[n("el-row",{directives:[{name:"loading",rawName:"v-loading.body",value:e.listLoading,expression:"listLoading",modifiers:{body:!0}}]},[n("el-col",{attrs:{span:5}},[n("el-input",{attrs:{placeholder:"输入关键字进行过滤"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),n("el-tree",{ref:"menuTree",staticClass:"filter-tree",staticStyle:{"margin-top":"10px"},attrs:{data:e.menuTreeDate,props:e.defaultProps,"default-expand-all":!0,"filter-node-method":e.filterNode,"default-expanded-keys":[0,1]},on:{"node-click":e.clickTree,"node-expand":e.expandTree}})],1),e._v(" "),n("el-col",{attrs:{span:19}},[n("div",{staticClass:"right-layout-from"},["see"==this.state?n("div",{staticClass:"top-button"},[n("el-button-group",[n("el-button",{attrs:{type:"primary","native-type":"submit",icon:"plus"},on:{click:function(t){e.toCreate()}}},[e._v("添加")]),e._v(" "),n("el-button",{attrs:{type:"primary",icon:"edit"},on:{click:function(t){e.toUpdate()}}},[e._v("编辑")]),e._v(" "),n("el-button",{attrs:{type:"danger",icon:"delete"},on:{click:function(t){e.toDeleted()}}},[e._v("删除")])],1)],1):e._e(),e._v(" "),n("div",{staticClass:"top-button"},["add"==this.state?n("el-button",{attrs:{type:"primary","native-type":"submit"},on:{click:function(t){e.createMenu("form")}}},[e._v("保存")]):e._e(),e._v(" "),"edit"==this.state?n("el-button",{attrs:{type:"primary","native-type":"submit"},on:{click:function(t){e.updateMenu("form")}}},[e._v("保存")]):e._e()],1),e._v(" "),n("el-card",{staticClass:"box-card",staticStyle:{"margin-bottom":"10px"}},[n("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[n("el-row",{attrs:{"aria-disabled":""}},[n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"菜单名称",prop:"menuName"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.menuName,callback:function(t){e.$set(e.form,"menuName",t)},expression:"form.menuName"}}):n("el-input",{model:{value:e.form.menuName,callback:function(t){e.$set(e.form,"menuName",t)},expression:"form.menuName"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"父级节点",prop:"parentName"}},[n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.parentName,callback:function(t){e.$set(e.form,"parentName",t)},expression:"form.parentName"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"菜单编码",prop:"menuCode"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.menuCode,callback:function(t){e.$set(e.form,"menuCode",t)},expression:"form.menuCode"}}):n("el-input",{model:{value:e.form.menuCode,callback:function(t){e.$set(e.form,"menuCode",t)},expression:"form.menuCode"}})],1)],1)],1),e._v(" "),n("el-row",[n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"资源路径",prop:"href"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.href,callback:function(t){e.$set(e.form,"href",t)},expression:"form.href"}}):n("el-input",{model:{value:e.form.href,callback:function(t){e.$set(e.form,"href",t)},expression:"form.href"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"前端组件",prop:"component"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.component,callback:function(t){e.$set(e.form,"component",t)},expression:"form.component"}}):n("el-input",{model:{value:e.form.component,callback:function(t){e.$set(e.form,"component",t)},expression:"form.component"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"图标",prop:"icon"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.icon,callback:function(t){e.$set(e.form,"icon",t)},expression:"form.icon"}}):n("el-input",{model:{value:e.form.icon,callback:function(t){e.$set(e.form,"icon",t)},expression:"form.icon"}})],1)],1)],1),e._v(" "),n("el-row",[n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"层级编码",prop:"levelcode"}},[n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.levelcode,callback:function(t){e.$set(e.form,"levelcode",t)},expression:"form.levelcode"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"是否可用",prop:"enabled"}},[n("el-switch",{attrs:{"active-value":"1","inactive-value":"0"},model:{value:e.form.enabled,callback:function(t){e.$set(e.form,"enabled",t)},expression:"form.enabled"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"请求资源类型",prop:"menuType"}},["see"==this.state?n("el-select",{attrs:{placeholder:"请选择机构类别",disabled:"disabled"},model:{value:e.form.menuType,callback:function(t){e.$set(e.form,"menuType",t)},expression:"form.menuType"}},[n("el-option",{attrs:{label:"link",value:"link"}}),e._v(" "),n("el-option",{attrs:{label:"menu",value:"menu"}})],1):n("el-select",{attrs:{placeholder:"请选择机构类别"},model:{value:e.form.menuType,callback:function(t){e.$set(e.form,"menuType",t)},expression:"form.menuType"}},[n("el-option",{attrs:{label:"link",value:"link"}}),e._v(" "),n("el-option",{attrs:{label:"menu",value:"menu"}})],1)],1)],1)],1),e._v(" "),n("el-row",[n("el-col",{attrs:{span:8}},[n("el-form-item",{attrs:{label:"排序",prop:"sort"}},["see"==this.state?n("el-input",{attrs:{disabled:"disabled"},model:{value:e.form.sort,callback:function(t){e.$set(e.form,"sort",t)},expression:"form.sort"}}):n("el-input",{model:{value:e.form.sort,callback:function(t){e.$set(e.form,"sort",t)},expression:"form.sort"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:16}},[n("el-form-item",{attrs:{label:"机构说明",prop:"note"}},["see"==this.state?n("el-input",{attrs:{type:"textarea",disabled:"disabled"},model:{value:e.form.note,callback:function(t){e.$set(e.form,"note",t)},expression:"form.note"}}):n("el-input",{attrs:{type:"textarea"},model:{value:e.form.note,callback:function(t){e.$set(e.form,"note",t)},expression:"form.note"}})],1)],1)],1)],1)],1),e._v(" "),n("el-card",[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",[e._v("按钮管理")])]),e._v(" "),n("button-view",{ref:"button",attrs:{menuId:e.form.id}})],1)],1)])],1)],1)},staticRenderFns:[]};var u=n("VU/8")(l,s,!1,function(e){n("ChOy")},null,null);t.default=u.exports},ml9W:function(e,t,n){var a=n("0zBP");"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);n("rjj0")("71c8a701",a,!0)},xIYo:function(e,t,n){(e.exports=n("FZ+f")(!1)).push([e.i,"\n#menu{\n    padding: 20px;\n}\n.right-layout-from{\n  margin-left: 20px;\n}\n.top-button{\n  margin-bottom: 20px;\n}\n.grid-content{\n    border-radius: 4px;\n    min-height: 36px;\n}\n",""])}});