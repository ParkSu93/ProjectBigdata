<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>빅데이터</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/profile.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script src="js/bootstrap.js"></script>
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#profile-image1').on('click', function() {
				$('#profile-image-upload').click();
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
				<li class="active"><a href="teacherMain.html">강의<span class="sr-only"></span></a></li>
				<li><a href="#">프로필</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
					aria-haspopup="true" arie-expanded="false">3<span class="caret"></span></a>
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


<div class="container" style="margin: auto">
	<div class="row">
		<h2>프로필을 수정하거나 확인하세용</h2>

		<div class="col-md-7 ">
			<div class="panel panel-default">
				<div class="panel-heading">  <h4 >User Profile </h4></div>
				<div class="panel-body">
					<div class="box box-info">

						<div class="box-body">
							<div class="col-sm-6">
								<div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 

									<input id="profile-image-upload" class="hidden" type="file">
									<div style="color:#999;" >클릭</div>
									<!--Upload Image Js And Css-->


								</div>
								<br>

								<!-- /input-group -->
							</div>
							<div class="col-sm-6">
								<h4 style="color:#00b1b1;">강사</h4></span>
								<span id="username" name="username"><p>${memberInfo.username}</p></span>            
							</div>
							<div class="clearfix"></div>
							<hr style="margin:5px 0 5px 0;">


							<div class="col-sm-5 col-xs-6 tital " id="id" name="id" >Id:</div><div class="col-sm-7 col-xs-6 ">${memberInfo.id}</div>
							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="username" name="username">이름:</div><div class="col-sm-7"> ${memberInfo.username}</div>
							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="brithday" name="brithday">생년 월일:</div><div class="col-sm-7"> ${memberInfo.birthday}</div>
							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="email" name="email">이메일:</div><div class="col-sm-7">${memberInfo.email}</div>

							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="phonenum" name="phonenum">핸드폰번호:</div><div class="col-sm-7">${memberInfo.phonenum}</div>

							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="addr" name="addr">주소:</div><div class="col-sm-7">${memberInfo.addr}</div>

							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="introduce" name="introduce">자기소개:</div><div class="col-sm-7">${memberInfo.introduce}</div>

							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="edu_background" name="edu_background">학력:</div><div class="col-sm-7">${memberInfo.edu_background}</div>

							<div class="clearfix"></div>
							<div class="bot-border"></div>

							<div class="col-sm-5 col-xs-6 tital " id="career" name="career">경력:</div><div class="col-sm-7">${memberInfo.career}</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->

					</div>

				</div> 
			</div>
		</div>  
	</div>
</div>
</body>
</html> 