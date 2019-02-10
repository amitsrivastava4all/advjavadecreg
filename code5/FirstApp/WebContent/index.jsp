<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:a action="hello">Welcome</s:a>
<br>
<hr>
<s:form action="login" method="post">
<s:textfield name="userid" label="Userid"/>

<s:password name="pwd" label="Password"/>
<s:submit value="Login"></s:submit>

</s:form>
</body>
</html>