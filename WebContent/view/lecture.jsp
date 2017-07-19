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
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script src="js/bootstrap.js"></script>
	<style type="text/css">
	</style>
	<script type="text/javascript">
		$(decumnet).ready(function(){
			$('#content').load('navbar_teacher.html', null, function(responseText, textStatus, xhr) {
    			alert(textStatus); // see what the response status is
    		});
		});
	</script>
</head>
<body>
	<div id="content"></div>
</body>
</html>
