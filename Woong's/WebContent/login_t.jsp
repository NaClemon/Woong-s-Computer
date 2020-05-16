<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성</title>
</head>
<body>
<h3>회원가입</h3>
${error}

<form action="memberLogin.do" method = "post">
	ID: <input type = "text" name = id> <br>
	비밀 번호 : <input type = "password" name="passwd"> <br>
	<input type = "submit" value ="가입">

</form>

</body>
</html>