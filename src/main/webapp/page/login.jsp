<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Life个人系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/validate/bootstrapValidator.min.js"></script>
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/signin.css">
    <link rel="stylesheet" href="assets/js/validate/bootstrapValidator.min.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
    <script type="text/javascript">
    	$(function(){
    		$('#loginForm').bootstrapValidator({
    			message: 'This value is not valid',
            	feedbackIcons: {
               	valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
	            fields: {
	                userName: {//验证input项：验证规则
	                    message: '用户名验证失败',
	                    validators: {
	                        notEmpty: {//非空验证：提示消息
	                            message: '用户名不能为空'
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
    	function todo(){
    		alert("待完善")
    		return false
    	}
    </script>
</head>
<body> 
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <div class="container">
        <div class="" id="login-wrapper" style="padding: 15% 0px 0px 0px">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div id="logo-login">
                        <h2>Life个人系统
                        </h2>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box"> 
                        <form id="loginForm" role="form" action="/jay/user/login">
                            <div class="form-group">
                                <!--a href="#" class="pull-right label-forgot">Forgot email?</a-->
                                <label for="inputUsernameEmail">用户名</label>
                                <input type="text" id="inputUsernameEmail" name="userName" class="form-control" placeholder="用户名登陆">
                            </div>
                            <div class="form-group">
                                <!--a href="#" class="pull-right label-forgot">Forgot password?</a-->
                                <label for="inputPassword">密码</label>
                                <input type="password" id="inputPassword"  name="password" class="form-control" placeholder="输入密码">
                            </div>
                            <div class="checkbox pull-left">
                                <label>
                                    <input type="checkbox">记住用户名</label>
                            </div>
                            <button class="btn btn btn-primary pull-right" type="submit"> 登 录
                            </button>
                        </form>
                        <a class="forgotLnk" href="index.html"></a>
                        <div class="or-box">
                            <center><span class="text-center login-with">用户登录或 <b>以下合作伙伴登录</b></span></center>
                            <div class="row">
                                <div class="col-md-6 row-block">
                                    <a href="javascript:void(0)"  class="btn btn-facebook btn-block" onclick="todo()">
                                        <span class="entypo-facebook space-icon" ></span>Facebook</a>
                                </div>
                                <div class="col-md-6 row-block">
                                    <a href="javascript:void(0)"  class="btn btn-twitter btn-block" onclick="todo()">
                                        <span class="entypo-twitter space-icon" ></span>Twitter</a>
                                        
                                </div>
                            </div>
                            <div style="margin-top:25px" class="row">
                                <div class="col-md-6 row-block">
                                    <a href="javascript:void(0)"  class="btn btn-google btn-block" onclick="todo()"><span class="entypo-gplus space-icon"></span>Google +</a>
                                </div>
                                <div class="col-md-6 row-block">
                                    <a href="javascript:void(0)"  class="btn btn-instagram btn-block" onclick="todo()"><span class="entypo-instagrem space-icon"></span>Instagram</a>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="row-block">
                            <div class="row">
                                <div class="col-md-12 row-block">
                                    <a href="regist.jsp" class="btn btn-primary btn-block">新用户注册</a>
                                </div>
                            </div>
                        </div
                        <div class="row-block">
	                        <div class="row">
		                    </div>
                        </div>
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



