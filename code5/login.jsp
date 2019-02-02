<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String uid = request.getParameter("userid");
String password = request.getParameter("pwd");
if(uid!=null && password!=null){
	if(uid.equals(password)){
		session.setAttribute("userid", uid);
		response.sendRedirect("dashboard.jsp");
		//response.sendRedirect("dashboard.jsp?userid="+uid);
	}
	else{
%>		
	<h2>Invalid Userid or Password </h2>
	<% 
	}
}
%>

<form action='login.jsp' method='post'>
<input name="userid" type='text' placeholder='Type UserName'>
<br>
<input name="pwd" type='password' placeholder='Type Password'>
<br>
<button type='submit'>Login</button>
</form>
</body>
</html>