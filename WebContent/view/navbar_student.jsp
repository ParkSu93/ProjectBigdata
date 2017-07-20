<%@ page pageEncoding="utf-8"%>
<nav class="navbar navbar-default" >
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="studentMain.jsp">출석부스터</a>
	</div>
	<div class="collapse navbar-collapse"
	id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
		<li class="active"><a href="studentMain.jsp">강의<span class="sr-only"></span></a></li>
		<li><a href="profile.do">프로필</a></li>
		
		</ul>
		<form class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="내용을 입력하세요.">
			</div>
			<button type="submit" class="btn btn-default">검색</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			
					<li><a href="index.jsp">로그아웃</a></li>
				
			</ul>
		</div>
	</div>
</nav>