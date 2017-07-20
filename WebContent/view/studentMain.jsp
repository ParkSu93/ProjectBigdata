<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>빅데이터</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/index.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<script src="js/bootstrap.js"></script>
	<script src="https://www.jsviews.com/download/jsrender.js"></script>
	<style type="text/css">
	body {
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
	
	
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

#wrapper {
	width: 100%;
	height: 50%;
	position: relative;
		margin-top: 100px;
}
</style>
	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</head>
<body>
	<%@include file="navbar_student.jsp" %> 
	<div id="wrapper">
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
								<td id="my_lec_teacher_name" name="my_lec_teacher_name">100</td>
								<td id="my_lec_time" name="my_lec_time">30명</td>
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
							<td id="total_lec_teacher_name" name="total_lec_teacher_name">100</td>
							<td id="total_lec_time" name="total_lec_time">30명</td>
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
</div>

<!-- 출석부 확인 -->
<div class="modal fade my_mdl_lecture" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close btc" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="lineModalLabel">출석 확인</h3>
			</div>
			<div class="modal-body">
				<!-- content goes here -->
				<div class="ct">
					<div class="row">
						<div class="col-xs-12">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-tags"></span> <span
										class="panel-span panel-left">출석부</span>

									</h3>
								</div>
								<div class="panel-body"  style="overflow-x: scroll;">
									<table class="table">
										<thead>
											<tr id="main_tr">
												<th class="tr_name" >학생 이름</th>
											</tr>
										</thead>
										<tbody class="tr_btn" style="padding: 10px">
											<tr id="sub_tr">
												<td id="r_lec_name" name="r_lec_name">박영수</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group"
				aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default btc"
					data-dismiss="modal" role="button">닫기</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" id="saveImage"
					class="btn btn-default btn-hover-green bts" data-action="save"
					role="button">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<!-- 강의 추가 -->
<div class="modal fade add_lecture" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close btc" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="lineModalLabel">강의목록</h3>
			</div>
			<div class="modal-body">
				<!-- content goes here -->
				<form>
					<div class="form-group">
						<div class="form-group">
							<label>강의 이름</label>
							<h5>강의 이름을 써주세용</h5>
						</div>
						<div class="form-group">
							<label>강사 이름</label> 
							<h5>강사 이름을 써주세용</h5>
						</div>
						<div class="form-group">
							<label>강의용 비밀번호</label> <input type="password"
							class="form-control mdf" id="lec_password" name="lec_password"
							placeholder="강의용 비밀번호">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group"
				aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default btc"
					data-dismiss="modal" role="button">닫기</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" id="saveImage"
					class="btn btn-default btn-hover-green bts" data-action="save"
					role="button">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
		var my_mdl_lecture=[]; //선택한 강의의 출석현황.
		var my_lecture=[]; //내가 듣고 있는 lecture 목록. 받아오고
		var total_lecture=[]; //전체 목록. 받아오고
		var index_add_lecture=null;//추가할 강의 인덱스
		var index_my_lecture=null;//내가 보고싶은 강의 인덱스

		var show_my_lecture = function(){
			for(var i=1;i<=my_lecture.length;i++){ //요기가 my_lecture 받아오는 부분.
				var str = '<tr id="tr_index"><td id="my_lec_name" name="my_lec_name">'+'c언어'+'</td><td id="my_lec_teacher_name" name="my_lec_total_date">'+'100'+'</td><td id="my_lec_time" name="my_lec_name">'+'30명'+'</td><td id="my_lec_check" name="my_lec_check"><button type="button" class="btn btn-success btn-circle my_lecture"><i class="glyphicon glyphicon-link"></i></button></td></tr>'
			}
		};
		var show_total_lecture = function(){
			for(var i=1;i<=total_lecture.length;i++){ //요기가 전체 받아오는 부분.
				var str = '<tr id="tr_index"><td id="total_lec_name" name="total_lec_name">'+'c언어'+'</td><td id="total_lec_teacher_name" name="total_lec_total_date">'+'100'+'</td><td id="total_lec_time" name="r_lec_name">'+'30명'+'</td><td id="total_lec_check" name="total_lec_check"><button type="button" class="btn btn-success btn-circle total_lecture"><i class="glyphicon glyphicon-link"></i></button></td></tr>'
			}
		};

		var show_my_mdl_lecture = function(){ //출석 표출용 mdl 함수 출석,결석,지각
			var total_day = 90;
			var start_day = 10;
			var attandence_list = [];
			//받아온 다음에 넣어주고,
			var main_tr = $("#main_tr");
			var sub_tr = $("#sub_tr");

			for(var i=1;i<=total_day;i++){
				main_tr.append('<th>'+i+'일</th>');
			}
			main_tr.append('출석률');

			//여기서 리스트 받아와서 출력만 해주면 됨.
			for(var i=1;i<start_day;i++){
				sub_tr.append('<th> x </th>');
			}

			for(var i=start_day;i<=total_day+start_day;i++){
				sub_tr.append('<th>'+i+'일</th>');
			}
		};

		$(document).ready(function(){
			show_my_lecture();
			show_total_lecture();
			$(".tr_btn").on("click", ".my_lecture", function() { //나의 강의 목록 출석 확인
				var index_my_lecture = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
				console.log(index_my_lecture);
				$(".my_mdl_lecture").show();
				$(".my_mdl_lecture").modal();
				show_my_mdl_lecture();
			});

			$(".tr_btn").on("click", ".total_lecture", function() { //나의 강의 목록 출석 확인
				index_add_lecture = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
				console.log(index_add_lecture);
				//모달창
				$(".add_lecture").show();
				$(".add_lecture").modal();
			});

			$(".bts").click(function() { //모달창 상에서 total_lecture 추가
				// lecture = {
				// 	lec_name : $("#lec_name").val(),
				// 	lec_password : $("#lec_password").val(),
				// 	lec_outline : $("#lec_outline")
				// 	.val(),
				// 	lec_goal : $("#lec_goal").val(),
				// 	lec_time : $("#lec_time").val(),
				// 	lec_total_date : $(
				// 		"#lec_total_date")
				// 	.val(),
				// 	enroll_num : $("#enroll_num")
				// 	.val()
				// };

				// lecture.lec_check = '<button type="button" class="btn btn-success btn-circle moveAttandence"><i class="glyphicon glyphicon-link"></i></button>';
				// console.log(lecture);
				// $(".modal").hide();

				// //jsrender를 이용한 테이블 추가.
				// var tmpl = $.templates("#contact_template");ㅇㅇ
				// var str = tmpl.render(lecture);
				// $(".tr_btn").append(str);
			});
		});
	</script>

	<%@include file="footer.jsp"%>
</body>
</html>