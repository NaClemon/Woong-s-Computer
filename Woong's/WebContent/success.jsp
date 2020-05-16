<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
if(session.getAttribute("id")==null){
%>
<%response.sendRedirect("index.jsp"); %>
<%
}%>
<%response.sendRedirect("index2.jsp"); %>
</body>
</html>