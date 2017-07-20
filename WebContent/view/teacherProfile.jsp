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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#profile-image1').on('click', function() {
			$('#profile-image-upload').click();
		});
		$("#modifyUser").click(function(){
			
		});
	});
</script>
</head>
<body>
	<%@include file="navbar_teacher.jsp"%>

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
										<h4 style="color: #00b1b1;">강사</h4>
										<span id="username" name="username"><p>${memberInfo.username}</p></span>
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

									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<div class="col-sm-5 col-xs-6 tital " id="edu_background"
										name="edu_background">학력:</div>
									<div class="col-sm-7">${memberInfo.edu_background}</div>

									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<div class="col-sm-5 col-xs-6 tital " id="career" name="career">경력:</div>
									<div class="col-sm-7">${memberInfo.career}</div>
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
