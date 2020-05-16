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
    font-family:arial;
	font-size:30px;
    height: 100px;
    margin: auto;
    text-align: justify;
  }
  .thead{
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
	padding:0 10px 0 15px;
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
    <header class="masthead" style="background-image: url('Resources/img/space.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-100% col-md-10 mx-auto">
            <div class="page-heading">
              <h1>computer estimate</h1>
              <span class="subheading">minimum specification.</span>
            </div>
          </div>
        </div>
      </div>
    </header>


    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
			<div>
				<img src="http://photo3.enuri.com/data/images/service/img_300/15067000/15067410.jpg">
			</div>
          </div>
      	</div>
      </div>
    </div><br><br><br>



<form action="calccom.do" method="post" name="form">
	<table>
		<tr>
		<td class="thead">CPU</td>
		<%ArrayList<ComputerVO> list1 = (ArrayList<ComputerVO>)request.getAttribute("list_cpu");
						if(!list1.isEmpty()){%>
			<td>
				<select name="cpu" style="cursor:pointer">
					<% for (int i=0;i<list1.size();i++){
					ComputerVO cpu = list1.get(i);%>
   					<option value="<%=cpu.getCpu_id()%>"><%=cpu.getCpu_name() %></option>
   					
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">RAM</td>
		<%ArrayList<ComputerVO> list2 = (ArrayList<ComputerVO>)request.getAttribute("list_ram");
						if(!list2.isEmpty()){%>
			<td>
				<select name="ram" style="cursor:pointer">
					<% for (int i=0;i<list2.size();i++){
					ComputerVO ram = list2.get(i); %>
   					<option value="<%=ram.getRam_id()%>"><%=ram.getRam_name() %></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">VGA</td>
		<%ArrayList<ComputerVO> list_gpu = (ArrayList<ComputerVO>)request.getAttribute("list_gpu");
						if(!list_gpu.isEmpty()){%>
			<td>
				<select name="gpu" style="cursor:pointer">
					<% for (int i=0;i<list_gpu.size();i++){
					ComputerVO gpu = list_gpu.get(i); %>
   					<option value="<%=gpu.getVga_id()%>"><%=gpu.getVga_name() %></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">Main Board</td>
		<%ArrayList<ComputerVO> list_mb = (ArrayList<ComputerVO>)request.getAttribute("list_mb");
						if(!list_mb.isEmpty()){%>
			<td>
				<select name="mb" style="cursor:pointer">
					<% for (int i=0;i<list_mb.size();i++){
					ComputerVO mb = list_mb.get(i); %>
   					<option value="<%=mb.getMb_id()%>"><%=mb.getMb_name() %></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">CASE</td>
		<%ArrayList<ComputerVO> list_case = (ArrayList<ComputerVO>)request.getAttribute("list_case");
						if(!list_case.isEmpty()){%>
			<td>
				<select name="case" style="cursor:pointer">
					<% for (int i=0;i<list_case.size();i++){
					ComputerVO case1 = list_case.get(i); %>
   					<option value="<%=case1.getCase_id()%>"><%=case1.getCase_name() %></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">HDD</td>
		<%ArrayList<ComputerVO> list_hdd = (ArrayList<ComputerVO>)request.getAttribute("list_hdd");
						if(!list_hdd.isEmpty()){%>
			<td>
				<select name="hdd" style="cursor:pointer">
					<% for (int i=0;i<list_hdd.size();i++){
					ComputerVO hdd = list_hdd.get(i); %>
   					<option value="<%=hdd.getHdd_id()%>"><%=hdd.getHdd_name() %></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">SSD</td>
		<%ArrayList<ComputerVO> list_ssd = (ArrayList<ComputerVO>)request.getAttribute("list_ssd");
						if(!list_ssd.isEmpty()){%>
			<td>
				<select name="ssd" style="cursor:pointer">
					<% for (int i=0;i<list_ssd.size();i++){
					ComputerVO ssd = list_ssd.get(i); %>
   					<option value="<%=ssd.getSsd_id()%>"><%=ssd.getSsd_name()%></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
		<tr>
		<td class="thead">POWER</td>
		<%ArrayList<ComputerVO> list_power = (ArrayList<ComputerVO>)request.getAttribute("list_power");
						if(!list_power.isEmpty()){%>
			<td>
				<select name="power" style="cursor:pointer">
					<% for (int i=0;i<list_power.size();i++){
					ComputerVO power = list_power.get(i); %>
   					<option value="<%=power.getPower_id()%>"><%=power.getPower_name()%></option>
   					<%}
   						}else{
   							System.out.print("sdaflj");
   					}%>
				</select>
			</td>
		</tr>
	</table><br><br>

<script>
function PopMin(){
    var gsWin = window.open('about:blank','payviewer','width=500, height=500, left=700, top=250');
    var frm =document.form;
    frm.action = "calccom.do";
    frm.target ="payviewer";
    frm.method ="post";
    frm.submit();
}
</script>
	
    <div class="container">
      <div class="row">
        <div class="col-lg-100% col-md-100 mx-auto">
          <div class="post-preview">
			<input type="button" value="계산하기" class="button" style="cursor:pointer" onclick='PopMin()'>
          </div>
        </div>
      </div>
    </div><br><br>
</form>	

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