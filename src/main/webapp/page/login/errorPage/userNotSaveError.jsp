<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>用户激活</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="<%=path%>/page/assets/js/jquery.min.js"></script>
   <!--  <link rel="stylesheet" href="assets/css/style.css"> -->
    <link rel="stylesheet" href="<%=path%>/page/assets/css/loader-style.css">
    <link rel="stylesheet" href="<%=path%>/page/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/page/assets/css/signin.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="<%=path%>/page/assets/ico/minus.png">
</head>
<body> 
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <div class="container">
        <div class="" id="login-wrapper" style="padding: 20% 0px 0px 0px">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div id="logo-login" >
                        <h3>登录异常
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box" align="center"> 
                        	<font face="微软雅黑" size="3">用户不存在</font>
                        <hr>
                        <div class="row-block">
                            <div class="row">
                                <div class="col-md-12 row-block">
                                	<a href="<%=path%>/page/login/regist.jsp" class="btn btn-success" style="width: 150px">新用户注册</a>
                                   	<a href="<%=path%>/page/login/login.jsp" class="btn btn-info" style="width: 150px">返回用户登录</a>
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



