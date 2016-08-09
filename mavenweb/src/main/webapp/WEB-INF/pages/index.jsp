<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Page Redirection重定向</title>
</head>
<body>
	<h2>Spring 页面重定向</h2>
	<p>Click below button to redirect the result to new page</p>
	<p>点击下面的按钮,重定向到新的页面,也即 index.jsp 重定向到 final.jsp</p>
	<form:form method="GET" action="/mavenweb/redirect">
		<table>
			<tr>
				<td><input type="submit" value="Redirect Page" /></td>
			</tr>
		</table>
	</form:form>
	
	<h2>Spring Landing Pag</h2>  
    <p>Click below button to get a simple HTML page</p>  
    <p>点击下面的按钮,得到一个 HTML 页面</p>  
    <form:form method="GET" action="/mavenweb/staticPage">  
        <table>  
            <tr>  
                <td><input type="submit" value="Get HTML Page" /></td>  
            </tr>  
        </table>  
    </form:form>  
</body>
</html>
