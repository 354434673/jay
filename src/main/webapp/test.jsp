<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>无标题文档</title> 
</head> 

<body> 
<input type="button" id="btn" value="免费获取验证码" onclick="settime(this)" /> 
<script type="text/javascript"> 
var countdown=60; 
function settime(val) { 
if (countdown == 0) { 
val.removeAttribute("disabled");    
val.value="免费获取验证码"; 
countdown = 60; 
} else { 
val.setAttribute("disabled", true); 
val.value="重新发送(" + countdown + ")"; 
countdown--; 
} 
setTimeout(function() { 
settime(val) 
},1000) 
} 
</script> 
</body> 
</html> 