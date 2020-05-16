<%@page import="com.dev.vo.MemberVO" %>
<%@page import="com.dev.vo.GameVO" %>
<%@page import="com.dev.vo.ComputerVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>웅이네 컴퓨터</title>

    <!-- Bootstrap core CSS -->
    <link href="Resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="Resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="Resources/css/clean-blog.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="http://malsup.github.com/jquery.cycle2.js"></script>
<style>
  table, th, td {
    border: 5px solid #bcbcbc;
  }
  table {
   

  }
    thead{
  	font-family:arial;
	font-size:30px;
	color:#FFFFFF;
  	background-color:#454545;
  }
  .Gname{
    font-family:arial;
	font-size:35px;
	width: 400px;
  }
  .Gprice{
  	font-family:arial;
	font-size:25px;
	width: 150px;
  }
  .button{
  	background-color:#6182FA;
  	color:#FFFFFF;
  	font-family:arial;
  	font-size:30px;
  	box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-moz-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-webkit-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-o-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	border-radius: 15px;
  }
  .font{
  	font-family:arial;
	font-size:25px;
	height: 100px;
    margin: auto;
    text-align: center;
    box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-moz-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-webkit-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
	-o-box-shadow: 0px 0px 30px rgba(0,0,0,.3);
    border-radius: 20px;
    background-color:#D3FAFD;
  }
  .explain{
  	font-family:arial;
	font-size:20px;
	color:#000000;
  	background-color:#E1E2E4;
  	width: 400px;
  	margin:auto;
  	text-align: justify;
  }
</style>
    
</head>
<body>

    <!-- Post Content -->
    
	<br><br><br>
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
			<%int sum = (int)request.getAttribute("sum"); %>
			<br><br><table class="font"><td><h1>Price : <%=sum %>원</h1></td></table>
          </div>
      	</div>
      </div>
    </div><br><br><br><br><br><br><hr>

    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
            <input type="button" onclick="window.close();" value="확인" class="button" style="cursor:pointer">
          </div>
      	</div>
      </div>
    </div><br>

    <!-- Bootstrap core JavaScript -->
    <script src="Resources/vendor/jquery/jquery.min.js"></script>
    <script src="Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="Resources/js/clean-blog.min.js"></script>

</body>
</html>