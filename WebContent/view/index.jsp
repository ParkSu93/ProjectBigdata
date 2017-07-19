<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<html lang="ko">
<head>
	<title>빅데이터</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/index.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script src="js/bootstrap.js"></script>
	<style type="text/css">
		body {
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
		#teacher_flag{
			vertical-align: middle;
		}
		.panel-login { /*이건 틀에 해당하는 그림자*/
			border-color: #ccc;
			-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
			-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
			box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
		}
		.panel-login>.panel-heading {
			color: #00415d;
			background-color: #fff;
			border-color: #fff;
			text-align:center;
		}
		.panel-login>.panel-heading a{
			text-decoration: none;
			color: #666;
			font-weight: bold;
			font-size: 15px;
			-webkit-transition: all 0.1s linear;
			-moz-transition: all 0.1s linear;
			transition: all 0.1s linear;
		}
		.panel-login>.panel-heading a.active{
			color: #029f5b;
			font-size: 18px;
		}
		.panel-login>.panel-heading hr{
			margin-top: 10px;
			margin-bottom: 0px;
			clear: both;
			border: 0;
			height: 1px;
			background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
			background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
			background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
			background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
		}
		.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
			height: 45px;
			border: 1px solid #ddd;
			font-size: 16px;
			-webkit-transition: all 0.1s linear;
			-moz-transition: all 0.1s linear;
			transition: all 0.1s linear;
		}
		.panel-login input:hover,
		.panel-login input:focus {
			outline:none;
			-webkit-box-shadow: none;
			-moz-box-shadow: none;
			box-shadow: none;
			border-color: #ccc;
		}
		.btn-login {
			background-color: #59B2E0;
			outline: none;
			color: #fff;
			font-size: 14px;
			height: auto;
			font-weight: normal;
			padding: 14px 0;
			text-transform: uppercase;
			border-color: #59B2E6;
		}
		.btn-login:hover,
		.btn-login:focus {
			color: #fff;
			background-color: #53A3CD;
			border-color: #53A3CD;
		}
		.forgot-password {
			text-decoration: underline;
			color: #888;
		}
		.forgot-password:hover,
		.forgot-password:focus {
			text-decoration: underline;
			color: #666;
		}

		.btn-register {
			background-color: #1CB94E;
			outline: none;
			color: #fff;
			font-size: 14px;
			height: auto;
			font-weight: normal;
			padding: 14px 0;
			text-transform: uppercase;
			border-color: #1CB94A;
		}
		.btn-register:hover,
		.btn-register:focus {
			color: #fff;
			background-color: #1CA347;
			border-color: #1CA347;
		}
		.radioBtn .notActive{
			float: left;
			color: #3276b1;
			background-color: #fff;
		}

	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#radioBtn a').click(function() {
				console.log("hi");
				var sel = $(this).data('title');
				var tog = $(this).data('toggle');
				$(this).parent().next('.' + tog).prop('value', sel);

				if(sel == 'N'){
					console.log("N");
					$("#edu_background").hide(100);	
					$("#career").hide(100);	
				}else{
					console.log("Y");
					$("#edu_background").show(100);	
					$("#career").show(100);	
				}
				$(this).parent().find('a[data-toggle="' + tog + '"]').not('[data-title="' + sel + '"]').removeClass('active').addClass('notActive');
				$(this).parent().find('a[data-toggle="' + tog + '"][data-title="' + sel + '"]').removeClass('notActive').addClass('active');
			});
		});

		$(function() {
			$('#login-form-link').click(function(e) {
				$("#login-form").delay(100).fadeIn(100);
				$("#register-form").fadeOut(100);
				$('#register-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});
			$('#register-form-link').click(function(e) {
				$("#register-form").delay(100).fadeIn(100);
				$("#login-form").fadeOut(100);
				$('#login-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});

		});
	</script>

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">출석부스터</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">안뇽<span class="sr-only"></span></a></li>
				<li><a href="#">방가워</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
					aria-haspopup="true" arie-expanded="false">영수야<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">3-1</a></li>
						<li><a href="#">3-2</a></li>
						<li><a href="#">3-3</a></li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="내용을 입력하세요.">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
					aria-haspopup="true" arie-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="index.html">로그인</a></li>
						<li><a href="index.html">로그아웃</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>



<center>
	<div class='row' style="width: 1000px">
		<div id="login" > 
			<div class="row"  display: inline-block>
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-login">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<a href="#" class="active" id="login-form-link">로그인</a>
								</div>
								<div class="col-xs-6">
									<a href="#" id="register-form-link">회원 가입</a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form id="login-form" action="login.do" method="post" role="form" style="display: block;">
										<div class="form-group">
											<input type="text" name="id" id="username" tabindex="1" class="form-control" placeholder="id" value="">
										</div>
										<div class="form-group">
											<input type="password" name="password" id="password" tabindex="1" class="form-control" placeholder="Password">
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
												</div>
											</div>
										</div>
									</form>
									<form id="register-form" action="join.do" method="post" role="form" style="display: none;">
										<div class="form-group">
											<input type="text" name="id" id="id" tabindex="1" class="form-control" placeholder="Id" value="${mem.id}">
										</div>
										<div class="form-group">
											<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="${mem.email}">
										</div>
										<div class="form-group">
											<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="${mem.username}">
										</div>
										<div class="form-group">
											<input type="password" name="password" id="password" tabindex="1" class="form-control" placeholder="Password" value="${mem.password}">
										</div>
										<div class="form-group">
											<input type="text" name="birthday" id="brithday" tabindex="1" class="form-control" placeholder="Brithday" value="${mem.birthday}">
										</div>
										<div class="form-group">
											<input type="text" name="phonenum" id="phonenum" tabindex="1" class="form-control" placeholder="Phonenum" value="${mem.phonenum}">
										</div>
										<div class="form-group">
											<input type="text" name="addr" id="addr" tabindex="1" class="form-control" placeholder="Addr" value="${mem.addr}">
										</div>
										<div class="form-group">
											<input type="text" name="introduce" id="introduce" tabindex="1" class="form-control" placeholder="Introduce Your Self" value="${mem.introduce}">
										</div>
										<div class="form-group">
											<input type="text" name="edu_background" id="edu_background" tabindex="1" class="form-control" placeholder="Edu_background" value="" style="display:none;">
										</div>
										<div class="form-group">
											<input type="text" name="career" id="career" tabindex="1" class="form-control" placeholder="Career" value=""  style="display:none;">
										</div>

										<div class="form-group">
											<div class="row">
												<div class="col-sm-4">
													<div class="input-group">
														<div id="radioBtn" class="btn-group">
															<a class="btn btn-primary btn-sm active" data-toggle="happy" data-title="N" value="N">학생</a>
															<a id= "teacher_flag" class="btn btn-primary btn-sm notActive" data-toggle="happy" data-title="Y" value="Y">강사</a>
														</div>
														<input type="hidden" name="happy" id="happy">
													</div>
												</div>
												<div class="col-md-8" >
													<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</center>

<hr>

</body>
</html> 