<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
				.modal-header {
			padding-bottom: 5px;
		}

		.modal-footer {
			padding: 0;
		}

		.modal-footer .btn-group button {
			height: 40px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
			border: none;
			border-right: 1px solid #ddd;
		}

		.modal-footer .btn-group:last-child>button {
			border-right: 0;
		}

		.btn-circle {
			width: 30px;
			height: 30px;
			text-align: center;
			padding: 6px 0;
			font-size: 12px;
			line-height: 1.428571429;
			border-radius: 15px;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".tr_btn").on("click", ".my_lecture", function() { //나의 강의 목록 출석 확인
			var index = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
			console.log(index);
			});

			$(".tr_btn").on("click", ".total_lecture", function() { //나의 강의 목록 출석 확인
			var index = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
			console.log(index);
			});
		});
	</script>
</head>
<body>
	<%@include file="navbar_student.jsp" %> 
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="glyphicon glyphicon-tags"></span> <span
							class="panel-span panel-left">내가 듣는 강의 목록</span>
						</h3>
					</div>
					<div class="panel-body">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object"
									src="images/temp1.jpg">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading" value="나야나">${memberInfo.username}</h4>
								<br>
								<h5 class="media-heading" value="너야너">${memberInfo.introduce}</h5>
								<br> <br>
							</div>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>강의 이름</th>
								<th>강사 이름</th>
								<th>강의 시간</th>
								<th>강의 확인</th>
							</tr>
						</thead>
						<tbody class="tr_btn" style="padding: 10px">
							<tr id="tr_index">
								<td id="my_lec_name" name="my_lec_name">c언어</td>
								<td id="my_lec_teacher_name" name="my_lec_totall_date">100</td>
								<td id="my_lec_time" name="my_lec_name">30명</td>
								<td id="my_lec_check" name="my_lec_check">
									<button type="button"
									class="btn btn-success btn-circle my_lecture">
									<i class="glyphicon glyphicon-heart"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="glyphicon glyphicon-tags"></span> <span
						class="panel-span panel-left">전체 강의 목록</span>
					</h3>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th>강의 이름</th>
							<th>강사 이름</th>
							<th>강의 시간</th>
							<th>강의 추가</th>
						</tr>
					</thead>
					<tbody class="tr_btn" style="padding: 10px">
						<tr id="tr_index">
							<td id="total_lec_name" name="total_lec_name">c언어</td>
							<td id="total_lec_teacher_name" name="total_lec_totall_date">100</td>
							<td id="total_lec_time" name="total_lec_name">30명</td>
							<td id="total_lec_check" name="total_lec_check">
								<button type="button"
								class="btn btn-success btn-circle total_lecture">
								<i class="glyphicon glyphicon-star"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
		var my_lecture=[]; //내가 듣고 있는 lecture 목록. 받아오고
		var total_lecture=[]; //전체 목록. 받아오고
		var show_my_lecture = function(){
			for(var i=1;i<=my_lecture.length;i++){ //요기가 my_lecture 받아오는 부분.
				var str = '<tr id="tr_index"><td id="my_lec_name" name="my_lec_name">'+'c언어'+'</td><td id="my_lec_teacher_name" name="my_lec_totall_date">'+'100'+'</td><td id="my_lec_time" name="my_lec_name">'+'30명'+'</td><td id="my_lec_check" name="my_lec_check"><button type="button" class="btn btn-success btn-circle my_lecture"><i class="glyphicon glyphicon-link"></i></button></td></tr>'
			}
		}
		var show_totall_lecture = function(){
			for(var i=1;i<=total_lecture.length;i++){ //요기가 전체 받아오는 부분.
				var str = '<tr id="tr_index"><td id="total_lec_name" name="total_lec_name">'+'c언어'+'</td><td id="total_lec_teacher_name" name="total_lec_totall_date">'+'100'+'</td><td id="total_lec_time" name="r_lec_name">'+'30명'+'</td><td id="total_lec_check" name="total_lec_check"><button type="button" class="btn btn-success btn-circle total_lecture"><i class="glyphicon glyphicon-link"></i></button></td></tr>'
			}
		}
		$(document).ready(function(){
			show_my_lecture();
			show_totall_lecture();
		});
	</script>
</body>
</html>