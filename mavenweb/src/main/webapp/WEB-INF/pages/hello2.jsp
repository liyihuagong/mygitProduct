<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC练习Demo</title>
</head>
<body>
	<h1>传递过来的数据是 : ${message}</h1>
	<h2>
		use JSP templates written with JSTL,JSP Standard Tag Library, <br>使用JSP
		标准标记库获得后端传过来的数据</br>
	</h2>
	<h3>Here "\${message}" is the attribute which we have setup inside
		the Controller. You can have multiple attributes to be displayed
		inside your view.</h3>
	<h3>\${message}是在Controller里返回的属性</h3>
</body>
</html>
