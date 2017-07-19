<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>빅데이터</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
<link href="http://cdn.alloyui.com/3.0.1/aui-css/css/bootstrap.min.css"
	rel="stylesheet"></link>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/index.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">출석부스터</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="teacherMain.jsp">강의<span class="sr-only"></span></a></li>
					<li><a href="teacherProfile.jsp">프로필</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toogle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						arie-expanded="false">3<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">3-1</a></li>
							<li><a href="#">3-2</a></li>
							<li><a href="#">3-3</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="내용을 입력하세요.">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toogle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						arie-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="index.html">로그인</a></li>
							<li><a href="index.html">로그아웃</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="glyphicon glyphicon-tags"></span> <span
								class="panel-span panel-left">출석부</span>
						</h3>
					</div>
					<div class="panel-body">
						<table class="table" style="table-layout:fixed;">
							<thead>
								<tr id="main_tr">
									<th class="tr_name">학생 이름</th>
								</tr>
							</thead>
							<tbody class="tr_btn" style="padding: 10px">
								<tr id="tr_index">
									<td id="r_lec_name" name="r_lec_name">박영수</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			var day_num = 60; //day 받으면 됨
			var attend_student = null; //여기서 수강 학생 받으셈.
			$(document).ready(function() {
				var main_tr = $("#main_tr");
				var th_tr = $("#tr_index");
				console.log(main_tr);

				for (var i = 1; i <= day_num; i++) {
					main_tr.append('<th>' + i + '일</th>');
				}
				
				main_tr.append('<th style="width: 20px">출석률</th>');
				console.log(th_tr);
				//여기서 for 구문 하나 더써서 학생 이름까지 돌리삼
				for(var i=1;i <=day_num;i++){
					th_tr.append('<td><input type="text" class="td_day td_'+i+'_day"/></td>');
				}
			});
		</script>
		<style type="text/css">
			.td_day{
				width: 20px;
			}
		</style>
</body>
</html>