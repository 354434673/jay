<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Life个人系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="<%=path%>/page/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/page/assets/js/validate/bootstrapValidator.min.js"></script>
   <!--  <link rel="stylesheet" href="assets/css/style.css"> -->
    <link rel="stylesheet" href="<%=path%>/page/assets/css/loader-style.css">
    <link rel="stylesheet" href="<%=path%>/page/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/page/assets/css/signin.css">
    <link rel="stylesheet" href="<%=path%>/page/assets/js/validate/bootstrapValidator.min.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="<%=path%>/page/assets/ico/minus.png">
    <script type="text/javascript">
    	$(function(){
    		$('#registForm').bootstrapValidator({
    			message: 'This value is not valid',
            	feedbackIcons: {
               	valid: 'glyphicon glyphicon-ok',
                validating: 'glyphicon glyphicon-refresh'
            },
	            fields: {
	                userName: {//验证input项：验证规则
	                    message: '用户名验证失败',
	                    validators: {
	                        notEmpty: {//非空验证：提示消息
	                            message: '用户名不能为空'
	                        },
	                        stringLength: {
	                         min: 6,
	                         max: 30,
	                         message: '用户名长度必须在6到30之间'
	                     	},
	                     	threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
	                     	remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
		                         url: '<%=path%>/validata/userName',//验证地址
		                         message: '该用户已存在',//提示消息
		                         type: 'POST'//请求方式
		                         /**自定义提交数据，默认值提交当前input value
		                          *  data: function(validator) {
		                               return {
		                                   password: $('[name="passwordNameAttributeInYourForm"]').val(),
		                                   whatever: $('[name="whateverNameAttributeInYourForm"]').val()
		                               };
		                            }
		                          */
		                    },
	                    }
	                },
	                realName:{
	                    validators: {
	                        notEmpty: {
	                            message: '真实姓名不能为空'
	                        },
	                        regexp: {
                        	 	regexp: /^[\u0391-\uFFE5]+$/,
                         		message: '真实姓名只能为中文'
                    		},
	                        different: {//不能和用户名相同
		                         field: 'userName',//需要进行比较的input name值
		                         message: '不能和用户名相同'
		                     },		
	                    }
	                },
	                email: {
	                    validators: {
	                        notEmpty: {
	                            message: '邮箱地址不能为空'
	                        },
	                        emailAddress: {
                        		message: '请输入正确的邮件地址如：xxxx@xx.com'
                     		}		
	                    }
	                },
	                idCard:{
	                    validators: {
	                        notEmpty: {
	                            message: '身份证不可为空'
	                        },
	                        stringLength:{
	                        	min:16,
	                        	max:18,
	                        	message: '请输入16位或18位身份证'
	                        }
	                    }
	                },
	                telphone:{
	                    validators: {
	                        stringLength:{
	                        	min:11,
	                        	max:11,
	                        	message: '电话号码不符合长度'
	                        },
	                        regexp: {
                        	 	regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                         		message: '请输入正确的手机号码'
                    		}
	                    }
	                },
	                password:{
	                    validators: {
	                    	notEmpty: {
	                            message: '密码不可为空'
	                        },
	                        stringLength:{
	                        	min:6,
	                        	max:20,
	                        	message: '密码长度在6到20之间'
	                        },
	                        regexp: {
                            	regexp: /^[a-zA-Z0-9_]+$/,
                            	message: '密码只能包含大写、小写、数字和下划线'
                        	}
	                    }
	                },
	            }
    		})
    	})
    </script>
</head>
<body> 
    <div class="container">
        <div class="" id="login-wrapper" style="padding: 5% 0px 0px 0px">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div id="logo-login">
                        <h3>Life注册
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box"> 
                        <form id="registForm" role="form" action="<%=path%>/user/regist" method="post">
                            <div class="form-group">
                                <label for="inputUsernameEmail">用户名</label>
	                                <div class="input-group">
	                                <input type="text" id="inputUsernameEmail" name="userName" class="form-control" placeholder="Enter userName">
	                            	<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                            		</div>
                            </div>
                            <div class="form-group">
                                <label for="inputRealUserName">真实姓名</label>
                            	<div class="input-group">
                                <input type="text" id="inputRealUserName"  name="realName" class="form-control" placeholder="Enter realName">
                            	<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                            	</div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">密码</label>
                                <div class="input-group">
                                <input type="password" id="inputPassword"  name="password" class="form-control" placeholder="Enter Password">
                            	<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            	</div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail">邮箱</label>
                                   <div class="input-group">
								      <input id="inputEmail"  class="form-control" name="email" type="email" placeholder="Enter email">
								      <div class="input-group-addon">@</div>
								    </div>
                            </div>
                            <div class="form-group">
                                <label for="inputidCard">身份标示</label>
                                <div class="input-group">
                                <input type="text" id="inputIdCard" name="idCard" class="form-control" placeholder="Enter IdCard">
                            	<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                            	</div>
                            </div>
                            <div class="form-group">
                                <label for="inputTel">电话号码</label>
                                <div class="input-group">
                                <input type="text" id="inputTel"  name="telphone" class="form-control" placeholder="Enter Tel">
                            	<div class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span></div>
                            	</div>
                            </div>
                            <div class="form-group">
                                <label for="inputBir">生日</label>
                                <input type="text" id="inputBir"  name="birthday" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">性别:</label>
									<select name="sex" class="form-control">
									  <option value="1" selected="selected">男</option>
									  <option value="2">女</option>
									  <option value="3">未知</option>
									</select>
                            </div>
                            <div style="margin-top: 5px" align="right">
                            	带图标为必填项
                            </div>
                            <div style="margin-top: 5px"/>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">确认注册</button>
                            <a class="btn btn-info btn-block" href="<%=path%>/page/login/login.jsp">返回用户登录</a>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <p>&nbsp;</p>
        <div style="text-align:center;margin:0 auto;">
            <h6 style="color:#fff;">Copyright(C)2016 fjcloudsoft.com All Rights Reserved<br />
				仅供个人所有</h6>
        </div>
    </div>
</body>
</html>