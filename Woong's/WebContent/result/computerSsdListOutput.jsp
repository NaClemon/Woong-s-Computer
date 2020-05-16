<%@page import="com.dev.vo.ComputerVO" %>
<%@page import="com.dev.vo.MemberVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

  <head>

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

<style>
  table, th, td {
    border: 5px solid #bcbcbc;
  }
  table {
   
    height: 100px;
    margin: auto;
    text-align: center;
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
  }
  .explain{
  	font-family:arial;
	font-size:30px;
	color:#000000;
  	background-color:#E1E2E4;
  	width: 800px;
  	margin:auto;
  	text-align: justify;
  }
</style>

<style>

/* 블로그메뉴 */


div, ul, li { margin:0; padding:0; }

#blogMenu {
	float:right;
	margin:0px 5px 3px 5px;
	padding:0 0 3px 0;
	box-shadow: 0px 0px 15px rgba(0,0,0,.3);
	-moz-box-shadow: 0px 0px 15px rgba(0,0,0,.3);
	-webkit-box-shadow: 0px 0px 15px rgba(0,0,0,.3);
	-o-box-shadow: 0px 0px 15px rgba(0,0,0,.3);
	-moz-border-radius: 3px;
	-khtml-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	background-color:#454545;
}

#blogMenu ul li {
	float:left;
	list-style-type:none;
}

#blogMenu a {
	height:16px;
	color:#FFFFFF;
	font-family:arial;
	font-size:15px;
	padding:0 10px 0 10px;
	text-decoration:none;
}

#blogMenu a:hover {
	color:#D4F4FA;
	border-bottom:3px solid #FAED7D;
}

#blogMenu ul ul {
	display:none;
	position:absolute;
	background-color:#454545;
}

#blogMenu ul li:hover ul {
	display: block;
}

#blogMenu ul ul li {
	float:none;
}

</style>

  </head>

 <body lang="ko" class="ko">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index2.jsp">웅이네 컴퓨터</a>
        <div id="blogMenu">
			<ul>
				<li><a href="index2.jsp"><%= session.getAttribute("id") %>님 안녕하세요.</a></li>
				<li><a href="#">PRODUCT</a>
					<ul>
						<li><a href="computerCpuList.do">CPU</a></li>
						<li><a href="computerRamList.do">RAM</a></li>
						<li><a href="computerMaiList.do">MAIN-BOARD</a></li>
						<li><a href="computerSsdList.do">SSD</a></li>
						<li><a href="computerHddList.do">HDD</a></li>
						<li><a href="computerVgaList.do">VGA</a></li>
						<li><a href="computerPowList.do">POWER</a></li>
						<li><a href="computerCasList.do">CASE</a></li>
					</ul>
				</li>
				<li><a href="memberList.do">GAME</a>
				</li>
				<li><a href="logout.jsp">LOG-OUT</a></li>
			</ul>
		</div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('Resources/img/computer1.JPG')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>Product</h1>
              <span class="subheading">SSD List</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <br><div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
          <h1>SDD</h1>
        </div>
      </div>
    </div>
    </div><br>
            		    <% ArrayList<ComputerVO> list = (ArrayList<ComputerVO>)request.getAttribute("list");
   					if(!list.isEmpty()) {%>
 					<table border="3">
   					<thead><tr><th>이미지</th><th>SSD 이름</th><th>가격</th></tr></thead>
   					<% for (int i=0;i<list.size();i++){
   						ComputerVO ssd = list.get(i); %>
   						<tr style="background-color:#F1F1F3">
   						<td><a href="#"><img src='<%=ssd.getJino_ssd_img()%>'></a></td>
   						<td class="Gname"><%=ssd.getJino_ssd_name() %></td>
   						<td class="Gprice"><%=ssd.getJino_ssd_price() %>원</td></tr>
   					<%	}
   					}else{
   					System.out.print("<h3>등록된 정보가 없습니다.</h3>");
   					}%>
					</table><br>

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
