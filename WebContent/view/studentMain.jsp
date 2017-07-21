<%@page import="controller.Converter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
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

#wrapper-main{
	width: 100%;
	height: 50%;
	position: relative;
	margin-top: 80px;
}
</style>
	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</head>
<body>
<%
	ArrayList allList =(ArrayList)request.getAttribute("allList"); //학생이 듣고있는거
	String result = Converter.convertToJson(allList);
%>
<div id = "a" style = display:none>
<%= result %>
</div>
<%
	ArrayList totalList =(ArrayList)request.getAttribute("totalList");
	String result2 = Converter.convertToJson(totalList);
	MemberVO mem = (MemberVO)session.getAttribute("mem");
	String id=mem.getId();
%>
<div id = "b" style = display:none>
<%= result2 %>
</div>
<div id = "c" ><%=id%></div>

	<%@include file="navbar_student.jsp" %> 
	<div id="wrapper-main">
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
							<tr id="tb_index">
							
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
					<tbody class="tb_btn" style="padding: 10px">
						<tr id="tr_index">
							
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
										<tbody class="sub_tr_btn" style="padding: 10px">
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
							<h5 id="lecture_name"></h5>
						</div>
						<div class="form-group">
							<label>강사 이름</label> 
							<h5 id="teacher_name"></h5>
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
$(document).ready(function() {		
				 lecture = $("#a").html();
				lecture2 = JSON.parse(lecture)
				console.log(lecture2);
				 //jsrender를 이용한 테이블 추가.
			    var tmpl = $.templates("#contact_template");
			    var str = tmpl.render(lecture2);
			    $(".tr_btn").append(str);
		});
</script>   
   <script type="text/javascript">
$(document).ready(function() {		
				 lecture = $("#b").html();
				lecture3 = JSON.parse(lecture)
				console.log(lecture3);
				 //jsrender를 이용한 테이블 추가.
			    var tmpl = $.templates("#contact_template2");
			    var str = tmpl.render(lecture3);
			    $(".tb_btn").append(str);
		});
</script>  

<script type="text/javascript">
		var my_mdl_lecture=[]; //선택한 강의의 출석현황.
		var my_lecture=[]; //내가 듣고 있는 lecture 목록. 받아오고
		var total_lecture=[]; //전체 목록. 받아오고
		var index_add_lecture=null;//추가할 강의 인덱스
		var index_my_lecture=null;//내가 보고싶은 강의 인덱스

		var show_my_mdl_lecture = function(){ //출석 표출용 mdl 함수 출석,결석,지각
			var total_day = 90;
			var start_day = 10;
			var index_my_lecture = null;
			var index_add_lecture = null;
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

			for(var i=start_day;i<=total_day;i++){
				sub_tr.append('<th>'+i+'일</th>');
			}
		};

		$(document).ready(function(){
			$(".sub_tr_btn").on("click", ".my_lecture", function() { //나의 강의 목록 출석 확인
				index_my_lecture = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
				console.log(index_my_lecture);
				$(".my_mdl_lecture").show();
				$(".my_mdl_lecture").modal();
				show_my_mdl_lecture();
			});

			$(".tb_btn").on("click", ".total_lecture", function() { //전체 강의 목록 출석
				index_add_lecture = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
				console.log(index_add_lecture);
				console.log(lecture3);
				 $("#lecture_name").html(lecture3[index_add_lecture-1].lec_name);
				 $("#teacher_name").html(lecture3[index_add_lecture-1].teacher_name);
				//모달창
				$(".add_lecture").show();
				$(".add_lecture").modal();
			});

			$(".bts").click(function() { //모달창 상에서 total_lecture 추가
				var id = $("#c").html();
			console.log(id);
				var course = { 
					student_id : id,
					lec_no : lecture3[index_add_lecture-1].lec_no
				};
				console.log(course);
				
				$.ajax({
				url:'addMyLecture.do', //이쪽 url로
				type:'post', //포스트형식으로
				data: course , //데이터 user를 보낸다. 근데 데이터는 무조건 {변수:변수값, 변수:변수값};
				success:function(data){
					my_lecture = data.my_list;
					total_lecture = data.total_list;
					
					console.log(my_lecture);
					console.log(my_lecture);
					
				    var tmpl = $.templates("#contact_template");
				    var str = tmpl.render(my_lecture);
				    $(".tr_btn").html(str);
				    
				    var tmpl = $.templates("#contact_template2");
				    var str = tmpl.render(total_lecture);
				    $(".tb_btn").html(str);
				}
			});
				$(".add_lecture").hide();
			});
		});
	</script>
	
<script id="contact_template" type="text/x-jsrender">
   <tr>
      <td>{{:lec_name}}</td>
      <td>{{:username}}</td>
      <td>{{:lec_time}}</td>
      <td>{{:my_lec_check}}</td>
   </tr>
</script>
<script id="contact_template2" type="text/x-jsrender">
   <tr>
      <td>{{:lec_name}}</td>
      <td>{{:username}}</td>
      <td>{{:lec_time}}</td>
      <td>{{:total_lec_check}}</td>
   </tr>
</script>

	<%@include file="footer.jsp"%>
</body>
</html>