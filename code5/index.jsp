<%@ page import="java.util.Date" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%! int counter =0;
%>
<p>Current Date and Time is <%=new Date() %></p>
<a href="login.jsp">Login</a>
<%

counter++;
int a=100;
int b= 200;
int c = a + b;
out.println("<h2>Sum is "+c+" <h2>");
%>

<h1>sum is <%=c %></h1>
<p>U Visited this page<%=counter %></p>
</body>
</html>









