webpackJsonp([1],{"88mR":function(e,t,n){"use strict";t.e=function(e){return Object(i.a)({url:"/admin/user/page",method:"get",params:e})},t.a=function(e){return Object(i.a)({url:"/admin/user/add",method:"post",data:e})},t.c=function(e){return Object(i.a)({url:"/admin/user/get/"+e,method:"get"})},t.d=function(e){return Object(i.a)({url:"/admin/user/getUserById",method:"get"})},t.b=function(e){return Object(i.a)({url:"/admin/user/delete/"+e,method:"delete"})},t.f=function(e,t){return Object(i.a)({url:"/admin/user/put/"+e,method:"put",data:t})},t.g=function(e){return Object(i.a)({url:"/admin/user/saveUserRole",method:"post",data:e})};var i=n("vLgD")},N54q:function(e,t,n){"use strict";t.h=function(e){return Object(i.a)({url:"/admin/role/page",method:"get",params:e})},t.a=function(e){return Object(i.a)({url:"/admin/role/add",method:"post",data:e})},t.e=function(e){return Object(i.a)({url:"/admin/role/get/"+e,method:"get"})},t.c=function(e){return Object(i.a)({url:"/admin/role/delete/"+e,method:"delete"})},t.i=function(e,t){return Object(i.a)({url:"/admin/role/put/"+e,method:"put",data:t})},t.d=function(){return Object(i.a)({url:"/admin/role/enabled/",method:"get"})},t.g=function(e){return Object(i.a)({url:"/admin/role/getRoleByUserId/"+e,method:"get"})},t.b=function(e,t){return Object(i.a)({url:"/admin/role/addRoleRes/"+e,data:t,method:"post"})},t.f=function(e){return Object(i.a)({url:"/admin/role/getResIdByRoleId/"+e,method:"get"})};var i=n("vLgD")},p3rn:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=n("88mR"),l=n("N54q"),o={data:function(){return{list:null,query:"",title:"",total:null,listQuery:{page:1,pageSize:10,username:"",email:""},dialogStatus:"",dialogFormVisible:!1,dialogRoleFormVisible:!1,form:this.initObj(),rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"},{min:3,max:20,message:"长度在3到20个字符",trigger:"blur"}],email:[{type:"email",message:"请输入有效的邮箱格式",trigger:"blur"}]},dialogRolelist:null,userRole:{userId:"",roles:[]}}},created:function(){this.getList()},methods:{initObj:function(){return{id:"",username:void 0,password:void 0,email:void 0,note:""}},resetTemp:function(){this.form=this.initObj()},queryList:function(){this.listQuery.username=this.query,this.listQuery.email=this.query,this.getList()},getList:function(){var e=this;Object(i.e)(this.listQuery).then(function(t){e.list=t.data.list,e.total=t.data.total})},cancel:function(e){this.dialogFormVisible=!1,this.$refs[e].resetFields()},handleClose:function(e){this.cancel("form"),e()},handleEdit:function(e,t){var n=this;Object(i.c)(t.id).then(function(e){n.form=e.data,n.dialogFormVisible=!0,n.dialogStatus="update",n.title="修改用户"})},update:function(e){var t=this;this.$refs[e].validate(function(n){if(!n)return!1;Object(i.f)(t.form.id,t.form).then(function(){t.cancel(e),t.getList(),t.$notify({title:"成功",message:"更新成功",type:"success",duration:2e3})})})},handleDelete:function(e,t){var n=this;this.$confirm("是否刪除该用户？","删除用户",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.b)(t.id).then(function(){n.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),n.getList()})})},toCreate:function(){this.resetTemp(),this.dialogFormVisible=!0,this.dialogStatus="create",this.title="新增用户"},create:function(e){var t=this;this.$refs[e].validate(function(n){if(!n)return!1;Object(i.a)(t.form).then(function(){t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.cancel(e),t.getList()})})},handlePermission:function(e,t){var n=this;Object(l.d)().then(function(e){n.dialogRoleFormVisible=!0,n.dialogRolelist=e.data,Object(l.g)(t.id).then(function(e){e.data.forEach(function(e){n.$refs.roleTable.toggleRowSelection(n.dialogRolelist.find(function(t){return t.id===e.id}))}),n.userRole.userId=t.id})})},handleSizeChange:function(e){this.listQuery.pageSize=e,this.getList()},handleCurrentChange:function(e){this.listQuery.page=e,this.getList()},handleSelectionChange:function(e){this.userRole.roles=e},roleCancel:function(){this.dialogRoleFormVisible=!1,this.userRole.roles=[],this.userRole.userId=""},roleUpdate:function(){var e=this;Object(i.g)(this.userRole).then(function(){e.$notify({title:"成功",message:"角色分配成功",type:"success",duration:2e3}),e.roleCancel()})}}},a={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"user"}},[n("el-card",[n("div",{attrs:{id:"query"}},[n("el-row",[n("el-col",{attrs:{span:8}},[n("el-input",{staticStyle:{width:"96%"},attrs:{placeholder:"请输入姓名或账户"},model:{value:e.query,callback:function(t){e.query=t},expression:"query"}})],1),e._v(" "),n("el-col",{attrs:{span:16}},[n("el-button-group",[n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.queryList()}}},[e._v("查询")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.toCreate()}}},[e._v("新增")])],1)],1)],1)],1),e._v(" "),n("el-table",{staticClass:"system-table",staticStyle:{width:"100%"},attrs:{data:e.list,"highlight-current-row":!0}},[n("el-table-column",{attrs:{align:"center",label:"序号",type:"index",width:"90"}}),e._v(" "),n("el-table-column",{attrs:{label:"账户",sortable:""},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.username))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"邮箱"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.email))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"备注"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.note))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"操作",width:"300px"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(n){e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),n("el-button",{attrs:{size:"mini",type:"info"},on:{click:function(n){e.handlePermission(t.$index,t.row)}}},[e._v("角色分配")]),e._v(" "),n("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(n){e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),n("div",{staticClass:"pagination-container"},[n("el-pagination",{attrs:{"current-page":e.listQuery.page,"page-sizes":[10,20,30,50],"page-size":e.listQuery.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.listQuery,"page",t)}}})],1),e._v(" "),n("el-dialog",{attrs:{visible:e.dialogFormVisible,"before-close":e.handleClose,width:"40%",title:e.title},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[n("el-form",{ref:"form",attrs:{model:e.form,inline:!0,rules:e.rules,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"帐户",prop:"username"}},[n("el-input",{attrs:{placeholder:"请输入姓名"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[n("el-input",{attrs:{placeholder:"请输入账户"},model:{value:e.form.email,callback:function(t){e.$set(e.form,"email",t)},expression:"form.email"}})],1),e._v(" "),"create"==e.dialogStatus?n("el-form-item",{attrs:{label:"密码",placeholder:"请输入密码",prop:"password"}},[n("el-input",{attrs:{type:"password"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1):e._e(),e._v(" "),"create"==e.dialogStatus?n("el-form-item",{attrs:{label:"确认密码",placeholder:"请输入密码",prop:"password"}},[n("el-input",{attrs:{type:"password"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1):e._e(),e._v(" "),n("el-form-item",{attrs:{label:"备注",prop:"note"}},[n("el-input",{attrs:{type:"textarea",autosize:{minRows:3,maxRows:5},placeholder:"请输入备注"},model:{value:e.form.note,callback:function(t){e.$set(e.form,"note",t)},expression:"form.note"}})],1)],1),e._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.cancel("form")}}},[e._v("取 消")]),e._v(" "),"create"==e.dialogStatus?n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.create("form")}}},[e._v("确 定")]):n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.update("form")}}},[e._v("确 定")])],1)],1),e._v(" "),n("el-dialog",{attrs:{visible:e.dialogRoleFormVisible},on:{"update:visible":function(t){e.dialogRoleFormVisible=t}}},[n("el-table",{ref:"roleTable",staticStyle:{width:"100%"},attrs:{data:e.dialogRolelist,"tooltip-effect":"dark"},on:{"selection-change":e.handleSelectionChange}},[n("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),n("el-table-column",{attrs:{label:"角色名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.roleName))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"角色编码"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.roleCode))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"备注"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.note))]}}])})],1),e._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.roleCancel()}}},[e._v("取 消")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.roleUpdate()}}},[e._v("确 定")])],1)],1)],1)],1)},staticRenderFns:[]},r=n("VU/8")(o,a,!1,null,null,null);t.default=r.exports}});