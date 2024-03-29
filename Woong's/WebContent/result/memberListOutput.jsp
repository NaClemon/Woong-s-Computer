<%@page import="com.dev.vo.MemberVO" %>
<%@page import="com.dev.vo.GameVO" %>
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
   
    height: 100px;
    margin: auto;
    text-align: center;
  }
</style>
    
</head>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">웅이네 컴퓨터</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
             <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Product.jsp">Product</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Game.jsp">Game</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Log-in.jsp">Log-in</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('Resources/img/computer3.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>Game Rank</h1>
              <span class="subheading">Top Ranking.</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Post Content -->
    <script type="text/javascript">
        $(document).ready(function () {
            $("button[name=ok]").click(function () {
                $("form[name=groupMemberInfo]")
                .attr({ action: "groupMemberManage.php?value="+$(this).val(), method: "post" })
                .submit();
            });
        });
</script>

<% ArrayList<GameVO> list = (ArrayList<GameVO>)request.getAttribute("list");
   if(!list.isEmpty()) {%>
   	<table border="3">
   		<tr><th>순위</th><th>이미지</th><th>게임 이름</th><th>출시 날짜</th><th>가격</th></tr>
   		
   		<% for (int i=0;i<list.size();i++){
   			GameVO member = list.get(i); %>
   		<tr><td><%=member.getGame_id() %><%out.println(list.get(i)); %></td>
   			<td><a href="gamepage.jsp?Gname=<%=member.getGame_name()%>&Gimg=<%=member.getImg_url()%>"><img src='<%=member.getImg_url()%>'></a> </td>
   			<td><%=member.getGame_name() %></td>
   			<td><%=member.getGame_date() %></td>
   			<td><%=member.getGame_price() %>원</td>			
   		</tr>
   		
   	<%	}
   	}else{
   		System.out.print("<h3>등록된 회원정보가 없습니다.</h3>");
   	}%>
   	</table>


 <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; 최재웅 & 최진호 & 손광호</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="Resources/vendor/jquery/jquery.min.js"></script>
    <script src="Resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="Resources/js/clean-blog.min.js"></script>

</body>
</html>