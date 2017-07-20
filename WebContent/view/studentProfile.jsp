<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/profile.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>
<script src="https://www.jsviews.com/download/jsrender.js"></script>
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
	var user = null;
	$(document).ready(function() {
		$("#modifyUser").click(function() {
			$(".modal").show();
			$(".modal").modal();
		});
		$(".btc").click(function() { //모달창 상에서 close
			lecture = "hi";
			console.log(lecture);
		});
		$(".bts").click(function() { //모달창 상에서 stroe

			$(".modal").hide();
		});
	});
</script>
</head>
<body>
	<div class="container" style="margin: auto">
		<div class="row">
			<h2>프로필을 수정하거나 확인하세용</h2>

			<div class="col-md-7 ">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h4 style="display: inline-block;">User Profile</h4>
							<div class="pull-right text-center"
								style="padding-right: 10px; padding-top: 5px">
								<span class="panel-title btn-group">
									<button id="modifyUser" ng-disabled="underCreation"
										type="button" class="btn btn-default btn-sm"
										ng-click="addUser()">
										<span class="glyphicon glyphicon-pencil text-primary"></span>
										<span class="text-primary"><strong>수정</strong></span>
									</button>
								</span>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="box box-info">

							<div class="box-body">
								<div class="col-sm-6">
									<div align="center">
										<img alt="User Pic"
											src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
											id="profile-image1" class="img-circle img-responsive">

										<input id="profile-image-upload" class="hidden" type="file">
										<div style="color: #999;">클릭</div>
										<!--Upload Image Js And Css-->


									</div>
									<br>

									<!-- /input-group -->
								</div>
								<div class="col-sm-6">
									<h4 style="color: #00b1b1;">학생</h4>
									</span> <span id="username" name="username"><p>${memberInfo.username}</p></span>
								</div>
								<div class="clearfix"></div>
								<hr style="margin: 5px 0 5px 0;">


								<div class="col-sm-5 col-xs-6 tital " id="id" name="id">Id:</div>
								<div class="col-sm-7 col-xs-6 ">${memberInfo.id}</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="username"
									name="username">이름:</div>
								<div class="col-sm-7">${memberInfo.username}</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="brithday"
									name="brithday">생년 월일:</div>
								<div class="col-sm-7">${memberInfo.birthday}</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="email" name="email">이메일:</div>
								<div class="col-sm-7">${memberInfo.email}</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="phonenum"
									name="phonenum">핸드폰번호:</div>
								<div class="col-sm-7">${memberInfo.phonenum}</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="addr" name="addr">주소:</div>
								<div class="col-sm-7">${memberInfo.addr}</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital " id="introduce"
									name="introduce">자기소개:</div>
								<div class="col-sm-7">${memberInfo.introduce}</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- line modal -->
	<div class="modal fade" id="squarespaceModal" tabindex="-1"
		role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close btc" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h3 class="modal-title" id="lineModalLabel">프로필 수정</h3>
				</div>
				<div class="modal-body">
					<!-- content goes here -->
					<form>
						<div class="form-group">
							<div class="form-group">
								<label>강의이름</label> <input type="text" class="form-control mdf"
									id="lec_name" name="lec_name" placeholder="강의 이름">
							</div>
							<div class="form-group">
								<label>강의용 비밀번호</label> <input type="password"
									class="form-control mdf" id="lec_password" name="lec_password"
									placeholder="강의용 비밀번호">
							</div>
							<div class="form-group">
								<label>강의 전체 일수</label> <input type="text"
									class="form-control mdf" id="lec_totall_date"
									name="lec_totall_date" placeholder="dd일">
							</div>
							<div class="form-group">
								<label>학생 인원</label> <input type="text" class="form-control mdf"
									id="enroll_num" name="enroll_num" placeholder="dd명">
							</div>
							<div class="form-group">
								<label>강의 소개</label> <input type="text" class="form-control mdf"
									id="lec_outline" name="lec_outline" placeholder="강의 소개">
							</div>
							<div class="form-group">
								<label>강의 목표</label> <input type="text" class="form-control mdf"
									id="lec_goal" name="lec_goal" placeholder="강의 목표">
							</div>
							<div class="form-group">
								<label>수업 시간</label> <input type="text" class="form-control mdf"
									id="lec_time" name="lec_time" placeholder="수업 시간">
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
								role="button">저장</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>