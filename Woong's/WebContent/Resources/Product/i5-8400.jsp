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
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="../css/clean-blog.min.css" rel="stylesheet">
    
    <script>
    var c_result = 0;
    function calc()
    {
    	num=document.getElementById('num').value;
    	price = 140000;
    	if (num == 0)
    	{
    		alert('수량을 입력해주세요.');
    		document.getElementById('result').innerHTML = '총 가격 : ';
    	}
    	else 
    	{
    		c_result = 0;
    		c_result += price * num;
    		document.getElementById('result').innerHTML = '총 가격 : ' + c_result;
    		document.getElementById('result2').value = c_result;
    	}
    }
    function reset()
    {
    	document.getElementById('num').value = 0; 
    	document.getElementById('result').innerHTML = '총 가격 : ';
    }
    </script>
    

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="../../index.jsp">웅이네 컴퓨터</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="../../index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../../Product.jsp">Product</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../../Game.jsp">Game</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../../Log-in.jsp">Log-in</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('../img/computer1.JPG')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>Product</h1>
              <span class="subheading">This is what you want.</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
       		<div id="block">
				<img src="i5-8400.jpg">
                <p>인텔 8세대 Core i5-8400 Desktop Processor 6 Cores up to 4.0 GHz LGA 1151 300 Series 65W</p>
                <p id=price>140000원</p>
                <p>수량&nbsp;&nbsp;&nbsp;<input id="num" type="number" name="number" min="1" placeholder="0" required></p>
      			<p id="result">총 가격 : </p>
      			<input type="text" id ="result1" name="name" value="Two-Button Blazer"style="display:none;">
      			<input type="text" id ="result2" name="price" value=""style="display:none;">
      			<button type="button" value="총 가격 계산" onclick="calc()" style="width:160px;">총 가격 계산</button>
				<input type="submit" value="주문하기">
            </div><br>       
        </div>
      </div>
    </div>

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
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="../js/clean-blog.min.js"></script>

  </body>

</html>
