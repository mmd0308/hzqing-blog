webpackJsonp([18],{Ip6F:function(n,t,e){var o=e("MV3n");"string"==typeof o&&(o=[[n.i,o,""]]),o.locals&&(n.exports=o.locals);e("rjj0")("6d459785",o,!0)},MV3n:function(n,t,e){(n.exports=e("FZ+f")(!1)).push([n.i,'\n.login-container {\n  position: fixed;\n  height: 100%;\n  width: 100%;\n  background-color: #f1f1f1;\n}\n.login-container input:-webkit-autofill {\n    -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;\n    -webkit-text-fill-color: #fff !important;\n}\n.login-container input {\n    background: transparent;\n    border: 0px;\n    -webkit-appearance: none;\n    border-radius: 0px;\n    padding: 12px 5px 12px 15px;\n    color: #969696;\n    height: 47px;\n}\n.login-container .el-input {\n    display: inline-block;\n    height: 47px;\n    width: 85%;\n}\n.login-container .tips {\n    font-size: 14px;\n    color: #969696;\n    margin: 20px 0px;\n    text-align: center;\n}\n.login-container .svg-container {\n    padding: 6px 5px 6px 15px;\n    color: #889aa4;\n    vertical-align: middle;\n    width: 30px;\n    display: inline-block;\n}\n.login-container .svg-container_login {\n      font-size: 20px;\n}\n.login-container .title {\n    font-size: 18px;\n    color: #969696;\n    margin: auto;\n    text-align: center;\n    font-weight: 400;\n    padding: 30px 0px 0px;\n}\n.login-container .title .title-item {\n      padding: 0px 0px  5px;\n      margin: 0px 15px;\n      display: inline;\n}\n.login-container .title .title-item:hover {\n      border-bottom: 2px solid #e05143;\n}\n.login-container .title .check-item {\n      color: #e05143;\n      border-bottom: 2px solid #e05143;\n}\n.login-container .login-register {\n    width: 400px;\n    margin: 120px auto;\n    background: #fff;\n}\n.login-container .login-form {\n    padding: 40px 35px 35px 35px;\n    border-radius: 4px;\n}\n.login-container .el-form-item {\n    border: 1px solid rgba(255, 255, 255, 0.1);\n    background: rgba(0, 0, 0, 0.1);\n    border-radius: 5px;\n    color: #454545;\n}\n.login-container .show-pwd {\n    position: absolute;\n    right: 10px;\n    top: 7px;\n    font-size: 16px;\n    color: #889aa4;\n    cursor: pointer;\n    -webkit-user-select: none;\n       -moz-user-select: none;\n        -ms-user-select: none;\n            user-select: none;\n}\n.login-container .thirdparty-button {\n    position: absolute;\n    right: 35px;\n    bottom: 28px;\n}\n.login-container .more-sign {\n    margin-top: 20px;\n    text-align: center;\n}\n.login-container .more-sign h6 {\n    position: relative;\n    margin: 0 0 20px;\n    font-size: 11px;\n    color: #b5b5b5;\n    font-weight: 500;\n}\n.login-container .more-sign h6:before {\n    content: "";\n    border-top: 1px solid #b5b5b5;\n    display: block;\n    position: absolute;\n    width: 60px;\n    top: 5px;\n    left: 30px;\n}\n.login-container .more-sign h6:after {\n    content: "";\n    border-top: 1px solid #b5b5b5;\n    display: block;\n    position: absolute;\n    width: 60px;\n    top: 5px;\n    right: 30px;\n}\n.login-container .login-icon {\n    width: 32px !important;\n    height: 32px !important;\n    margin: 0 15px;\n}\n',""])},VcNA:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=e("g+7B"),i={name:"login",data:function(){return{loginForm:{username:"",password:""},regForm:{nickName:"",phone:"",password:"",email:""},loginRules:{username:[{required:!0,trigger:"blur",message:"请输入邮箱或者手机号"}],password:[{required:!0,trigger:"blur",validator:function(n,t,e){t.length<5?e(new Error("密码不能小于5位")):e()}}]},regRules:{nickName:[{required:!0,trigger:"blur",message:"请输入昵称"}]},loading:!1,pwdType:"password",formStates:"login"}},methods:{showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleLogin:function(){var n=this;this.$refs.loginForm.validate(function(t){if(!t)return console.log("登录校验错误"),!1;n.loading=!0,n.$store.dispatch("Login",n.loginForm).then(function(){n.loading=!1,n.$router.push({path:"/index"})}).catch(function(){n.loading=!1})})},handleRegister:function(){var n=this;this.$refs.regForm.validate(function(t){if(!t)return console.log("注册校验错误"),!1;n.loading=!0,Object(o.d)(n.regForm).then(function(){n.$notify({title:"成功",message:"恭喜你！你已注册成功，请登录！",type:"success",duration:2e3}),n.loading=!1,n.formStates="login"})})},checkForm:function(n){this.formStates=n}}},s={render:function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{staticClass:"login-container"},[e("div",{staticClass:"login-register"},[e("h3",{staticClass:"title"},[e("div",{class:{"check-item":"login"===n.formStates,"title-item":!0},on:{click:function(t){n.checkForm("login")}}},[n._v("登录")]),n._v(" "),e("b",[n._v("|")]),n._v(" "),e("div",{class:{"check-item":"register"===n.formStates,"title-item":!0},on:{click:function(t){n.checkForm("register")}}},[n._v(" 注册")])]),n._v(" "),"login"===n.formStates?e("el-form",{ref:"loginForm",staticClass:"card-box login-form",attrs:{autoComplete:"on",model:n.loginForm,rules:n.loginRules,"label-position":"left","label-width":"0px"}},[e("el-form-item",{attrs:{prop:"username"}},[e("span",{staticClass:"svg-container svg-container_login"},[e("svg-icon",{attrs:{"icon-class":"user"}})],1),n._v(" "),e("el-input",{attrs:{name:"username",type:"text",autoComplete:"on",placeholder:"邮箱或手机号"},model:{value:n.loginForm.username,callback:function(t){n.$set(n.loginForm,"username",t)},expression:"loginForm.username"}})],1),n._v(" "),e("el-form-item",{attrs:{prop:"password"}},[e("span",{staticClass:"svg-container"},[e("svg-icon",{attrs:{"icon-class":"password"}})],1),n._v(" "),e("el-input",{attrs:{name:"password",type:n.pwdType,autoComplete:"on",placeholder:"密码"},nativeOn:{keyup:function(t){if(!("button"in t)&&n._k(t.keyCode,"enter",13,t.key))return null;n.handleLogin(t)}},model:{value:n.loginForm.password,callback:function(t){n.$set(n.loginForm,"password",t)},expression:"loginForm.password"}}),n._v(" "),e("span",{staticClass:"show-pwd",on:{click:n.showPwd}},[e("svg-icon",{attrs:{"icon-class":"eye"}})],1)],1),n._v(" "),e("div",{staticClass:"tips"},[e("span",{staticStyle:{"margin-right":"20px"}},[n._v("用户名: guest")]),n._v(" "),e("span",[n._v(" 密码: guest")])]),n._v(" "),e("el-button",{staticStyle:{width:"100%","border-radius":"25px"},attrs:{type:"primary",loading:n.loading},nativeOn:{click:function(t){t.preventDefault(),n.handleLogin(t)}}},[n._v("\n        登 录\n      ")]),n._v(" "),e("div",{staticClass:"more-sign"},[e("h6",[n._v("社交帐号登录")]),n._v(" "),e("div",[e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"weibo"}})],1),n._v(" "),e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"weixin"}})],1),n._v(" "),e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"qq"}})],1)],1)])],1):n._e(),n._v(" "),"register"===n.formStates?e("el-form",{ref:"regForm",staticClass:"card-box login-form",attrs:{autoComplete:"on",model:n.regForm,rules:n.regRules,"label-position":"left","label-width":"0px"}},[e("el-form-item",{attrs:{prop:"nickName"}},[e("span",{staticClass:"svg-container svg-container_login"},[e("svg-icon",{attrs:{"icon-class":"user"}})],1),n._v(" "),e("el-input",{attrs:{type:"text",autoComplete:"on",placeholder:"昵称"},model:{value:n.regForm.nickName,callback:function(t){n.$set(n.regForm,"nickName",t)},expression:"regForm.nickName"}})],1),n._v(" "),e("el-form-item",{attrs:{prop:"email"}},[e("span",{staticClass:"svg-container svg-container_login"},[e("svg-icon",{attrs:{"icon-class":"reg-email"}})],1),n._v(" "),e("el-input",{attrs:{type:"text",autoComplete:"on",placeholder:"邮箱"},model:{value:n.regForm.email,callback:function(t){n.$set(n.regForm,"email",t)},expression:"regForm.email"}})],1),n._v(" "),e("el-form-item",{attrs:{prop:"phone"}},[e("span",{staticClass:"svg-container svg-container_login"},[e("svg-icon",{attrs:{"icon-class":"phone"}})],1),n._v(" "),e("el-input",{attrs:{type:"text",autoComplete:"on",placeholder:"手机号"},model:{value:n.regForm.phone,callback:function(t){n.$set(n.regForm,"phone",t)},expression:"regForm.phone"}})],1),n._v(" "),e("el-form-item",{attrs:{prop:"password"}},[e("span",{staticClass:"svg-container"},[e("svg-icon",{attrs:{"icon-class":"password"}})],1),n._v(" "),e("el-input",{attrs:{name:"password",type:n.pwdType,autoComplete:"on",placeholder:"密码"},nativeOn:{keyup:function(t){if(!("button"in t)&&n._k(t.keyCode,"enter",13,t.key))return null;n.handleRegister(t)}},model:{value:n.regForm.password,callback:function(t){n.$set(n.regForm,"password",t)},expression:"regForm.password"}}),n._v(" "),e("span",{staticClass:"show-pwd",on:{click:n.showPwd}},[e("svg-icon",{attrs:{"icon-class":"eye"}})],1)],1),n._v(" "),e("el-button",{staticStyle:{width:"100%","border-radius":"25px"},attrs:{type:"primary",loading:n.loading},nativeOn:{click:function(t){t.preventDefault(),n.handleRegister(t)}}},[n._v("\n        注 册\n      ")]),n._v(" "),e("div",{staticClass:"more-sign"},[e("h6",[n._v("社交帐号注册")]),n._v(" "),e("div",[e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"weibo"}})],1),n._v(" "),e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"weixin"}})],1),n._v(" "),e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"待开发....",placement:"bottom-end"}},[e("svg-icon",{staticClass:"login-icon",attrs:{"icon-class":"qq"}})],1)],1)])],1):n._e()],1)])},staticRenderFns:[]};var a=e("VU/8")(i,s,!1,function(n){e("Ip6F")},null,null);t.default=a.exports}});