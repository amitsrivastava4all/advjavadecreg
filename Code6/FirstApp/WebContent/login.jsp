<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.errorMessage{
color:red;
}
</style>

</head>
<body>
<%-- <s:a action="hello">Welcome</s:a> --%>
<br>
<hr>
<s:form action="login" method="post">
<s:textfield name="userid" key="userid"/>

<s:password name="pwd" key="pwd"/>
<s:submit value="Login"></s:submit>

</s:form>
</body>
</html>