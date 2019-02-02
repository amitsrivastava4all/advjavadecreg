<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("userid")!=null){
	session.removeAttribute("userid");
	%>
	<h2>Logout SuccessFully</h2>
	<script>
setTimeout(()=>{
	location.href="index.jsp";
},5000)
	</script>
<% 	
}
else{
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>