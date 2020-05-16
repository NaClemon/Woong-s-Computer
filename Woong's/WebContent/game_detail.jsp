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
    
    <%ArrayList<GameVO> list = (ArrayList<GameVO>)request.getAttribute("list");
GameVO game = list.get(0);%>

    <header class="masthead" style="background-image: url('<%=game.getImg_url() %>')">
      <div class="overlay"></div>
       <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1></h1>
              <span class="subheading"></span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Post Content -->

    <%if(!list.isEmpty()){%>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
          <h1><%=game.getGame_name() %></h1><br>
        </div>
      </div>
     </div>
    </div>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
          <div><img src="<%=game.getImg_url() %>"></div><br>
        </div>
      </div>
     </div>
    </div>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
          <h2><%=game.getGame_price() %>원</h2><br>
        </div>
      </div>
     </div>
    </div>
        
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
           <div>
			<div>
			<table>
			<thead class="thead">
				<tr>
					<td>출시 일자</td>
					<td>개발사</td>
					<td>배급사</td>
				</tr>
			</thead>	
				<tr>
					<td width="200px" style="background-color:#E1E2E4"><%=game.getGame_date() %></td>
					<td width="250px" style="background-color:#E1E2E4"><%=game.getGame_dev() %></td>
					<td width="250px" style="background-color:#E1E2E4"><%=game.getGame_pub() %></td>
				</tr>
			</table>
			</div>
		   </div>
        </div>
      </div>
     </div>
    </div><br><br>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
          <table>
          	<thead class="thead"><tr><td>게임 설명</td></tr></thead>
          	<tr><td class="explain"><%=game.getGame_cont() %></td></tr></table><br><br>
        </div>
      </div>
     </div>
    </div><br>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
           <div>
			
			<form action="min_com.do">
			<div>
				<table>
				<thead class="thead">
				<tr>
					<td>운영체제</td>
					<td></td>
					<td>CPU</td>
					<td></td>
					<td>RAM</td>
					<td></td>
					<td>VGA</td>
					<td></td>
				</tr>
				</thead>
				<tr>
					<td style="height: 200px"><%=game.getMin_os() %></td>
					<td><input type="text" name="game_name" value="<%=game.getGame_name() %>" hidden></td>
					<td><%=game.getMin_proc() %></td>
					<td><input type="text" name="mincpu" value="<%=game.getMin_cpu() %>" hidden></td>
					<td style="width:90px";><%=game.getMin_mem() %></td>
					<td><input type="text" name="minram" value="<%=game.getMin_ram() %>" hidden></td>
					<td><%=game.getMin_graphic() %></td>
					<td><input type="text" name="mingpu" value="<%=game.getMin_gpu() %>" hidden></td>
				</tr>
				</table><br>
				    <div class="container">
      					<div class="row">
       		 				<div class="col-lg-100% col-md-100 mx-auto">
          						<div class="post-preview">
									<input type="submit" value="최소 견적" class="button" style="cursor:pointer">
					  	 		</div>
 	  						</div>
  	 					</div>
  					</div>
			</div>
			</form><br><br>
			<form action="rec_com.do">
			<div>
				<table>
				<thead class="thead">
				<tr>
					<td>운영체제</td>
					<td></td>
					<td>CPU</td>
					<td></td>
					<td>RAM</td>
					<td></td>
					<td>VGA</td>
					<td></td>
				</tr>
				</thead>
				<tr>
					<td style="height: 200px"><%=game.getRec_os() %></td>
					<td><input type="text" name="game_name" value="<%=game.getGame_name() %>" hidden></td>
					<td><%=game.getRec_proc() %></td>
					<td><input type="text" name="reccpu" value="<%=game.getRec_cpu() %>" hidden></td>
					<td style="width:90px";><%=game.getRec_mem() %></td>
					<td><input type="text" name="recram" value="<%=game.getRec_ram() %>" hidden></td>
					<td><%=game.getRec_graphic() %></td>
					<td><input type="text" name="recgpu" value="<%=game.getRec_gpu() %>" hidden></td>
				</tr>
				</table><br>
				    <div class="container">
      					<div class="row">
       		 				<div class="col-lg-100% col-md-100 mx-auto">
          						<div class="post-preview">
									<input type="submit" value="권장 견적" class="button" style="cursor:pointer">
					  	 		</div>
 	  						</div>
  	 					</div>
  					</div>
			</div>
			</form>
		</div>
		<%} else{
			System.out.print("ㄴ아러");}%>
	   </div>
 	  </div>
  	 </div>
  	</div><br><br>

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