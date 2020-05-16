<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.PrintWriter" %>
 
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 

<title>Insert title here</title>

</head>

<body>

<%
String x = (String)request.getAttribute("success");
String id = (String)request.getAttribute("id");

if(x !=null){
session.setAttribute("id", id);
response.sendRedirect("success.jsp");

}

else if (x == null ){

PrintWriter script = response.getWriter();

script.println("<script>");

script.println("alert('로그인 실패!')");

script.println("history.back()");

script.println("</script>");

}


%>

</body>

</html>

