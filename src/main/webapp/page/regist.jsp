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
   <!--  <link rel="stylesheet" href="assets/css/style.css"> -->
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/signin.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
</head>
<body> 
    <div class="container">
        <div class="" id="login-wrapper" style="padding: 5% 0px 0px 0px">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div id="logo-login">
                        <h2>Life注册
                        </h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box"> 
                        <form role="form" action="/jay/user/regist" method="post">
                            <div class="form-group">
                                <label for="inputUsernameEmail">用户名</label>
                                <input type="text" id="inputUsernameEmail" name="userName" class="form-control" placeholder="Enter userName">
                            </div>
                            <div class="form-group">
                                <label for="inputRealName">真实姓名</label>
                                <input type="text" id="inputRealName"  name="realName" class="form-control" placeholder="Enter realName">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">密码</label>
                                <input type="password" id="inputPassword"  name="password" class="form-control" placeholder="Enter Password">
                            </div>
                            <div class="form-group">
                                <label for="inputEmail">邮箱</label>
                                   <div class="input-group">
								      <div class="input-group-addon">@</div>
								      <input id="inputEmail"  class="form-control" name="email" type="email" placeholder="Enter email">
								    </div>
                            </div>
                            <div class="form-group">
                                <label for="inputidCard">身份标示</label>
                                <input type="text" id="inputIdCard" name="idCard" class="form-control" placeholder="Enter IdCard">
                            </div>
                            <div class="form-group">
                                <label for="inputTel">电话号码</label>
                                <input type="text" id="inputTel"  name="telphone" class="form-control" placeholder="Enter Tel">
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
									</select>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">确认注册</button>
                            </button>
                        </form>
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