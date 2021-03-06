<%@page import="controller.Converter"%>
<%@page import="java.util.ArrayList"%>
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
		overflow-y: scroll;
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
	height: 100%;
	position: relative;
	margin-top: 80px;
	margin-bottom: 80px;

}
      .container{
         margin-top: 100px;
      }
   </style>

   <script type="text/javascript">
   var lecture = null; //모달강의 저장용
   var lecture_list; //모달 강의 리스트용 처음 시작할 때, 서버로 부터 한번 아이디에 해당하는 모든 강의 받아오고, 뿌려준다. 그리고 추가하는 형식
   
   $(document).ready(function() {      
      lecture_list = $("#a").html();
      lecture2 = JSON.parse(lecture_list)
      console.log(lecture2);
             //jsrender를 이용한 테이블 추가.
             var tmpl = $.templates("#contact_template");
             var str = tmpl.render(lecture2);
             $(".tr_btn").append(str);
         });


   $(document).ready(function() {
      $("#addUser").click(function() { //강의추가
         console.log("h");
         $(".modal_add").show();
         $(".modal_add").modal();
      });
      
      $("#deleteUser").click(function() { //강의추가
           console.log("d");
           $(".modal_del").show();
           $(".modal_del").modal();
        });
      
      $(".delete_bts").click(function(){ //강의 제거
         
         var name = {lec_name : $("#del_lec_name").val()};
          $.ajax({
            url:'deleteLecture.do', //이쪽 url로
            type:'post', //포스트형식으로
            data: name , //데이터 user를 보낸다. 근데 데이터는 무조건 {변수:변수값, 변수:변수값};
            success:function(data){
            	$(".tr_btn").empty();
            	
               lecture_list = $("#a").html();
               lecture2 = JSON.parse(lecture_list)
               
               //jsrender를 이용한 테이블 추가.
               var tmpl = $.templates("#contact_template");
//               var str = tmpl.render(lecture_list);
               var str = tmpl.render(lecture2);
               $(".tr_btn").append(str);
            }
         });
          
          $(".modal_del").hide();
      });

      $(".tr_btn").on("click", ".moveAttandence", function() { //출석부 페이지로 고고싱
         var index = $(this).parent().parent().index(); //index 안에 해당하는 listindex들어가있음
         console.log(index-1);
         console.log(lecture2[index-1]);
         
         window.location = 'myAttendance.do';
         
        /*  $.ajax({
            url:'myAttendance.do', //이쪽 url로
            type:'post', //포스트형식으로
            data: lecture2[index-1] , //데이터 user를 보낸다. 근데 데이터는 무조건 {변수:변수값, 변수:변수값};
            success:function(data){
            	
            }
         }); */
     });
      
      $(".btc").click(function() { //모달창 상에서 close
         lecture = "hi";
         console.log(lecture);
      });
      $(".bts").click(function() { //모달창 상에서 stroe
         lecture = {
            lec_name : $("#lec_name").val(),
            lec_password : $("#lec_password").val(),
            lec_outline : $("#lec_outline").val(),
            lec_goal : $("#lec_goal").val(),
            lec_time : $("#lec_time").val(),
            lec_total_date : $("#lec_totall_date").val(),
            enroll_num : $("#enroll_num").val()
         };

         lecture.lec_check = '<button type="button" class="btn btn-success btn-circle moveAttandence"><i class="glyphicon glyphicon-link"></i></button>';
         console.log(lecture);

         //첫번째로 LectureController를 만들고, RequestMapping 함수를 만든다.
         //아무거나 url을 만든다.
         $(".modal").hide();
         
         $.ajax({
            url:'regLecture.do', //이쪽 url로
            type:'post', //포스트형식으로
            data:lecture, //데이터 user를 보낸다. 근데 데이터는 무조건 {변수:변수값, 변수:변수값};
            success:function(data){
               
            }
        });
         
         //jsrender를 이용한 테이블 추가.
         var tmpl = $.templates("#contact_template");
         var str = tmpl.render(lecture);
         $(".tr_btn").append(str);

     });
  });
</script>
<script id="contact_template" type="text/x-jsrender">
   <tr>
      <td>{{:lec_name}}</td>
      <td>{{:lec_total_date}}</td>
      <td>{{:enroll_num}}</td>
      <td>{{:lec_time}}</td>
      <td>{{:lec_check}}</td>
   </tr>
</script>
</head>

<body>

   <%
   ArrayList list =(ArrayList)request.getAttribute("list");
   String result = Converter.convertToJson(list);
   %>
   <div id = "a" style = "display:none">
      <%= result %>
   </div>


   <%@include file="navbar_teacher.jsp"%>
	<div id="wrapper-main">
   <div class="container">
      <div class="row">
         <div class="col-xs-12">
            <div class="panel panel-primary">
               <div class="panel-heading">
                  <h3 class="panel-title">
                     <span class="glyphicon glyphicon-tags"></span> <span
                     class="panel-span panel-left">강의목록</span>
                     <div class="pull-right text-center">
                        <span class="panel-title btn-group">
                        <button id="deleteUser" ng-disabled="underCreation" type="button"
                           class="btn btn-default btn-sm" ng-click="deleteUser()">
                           <span class="glyphicon glyphicon-plus text-primary"></span> <span
                           class="text-primary"><strong>강의제거</strong></span>
                        </button>
                     </span>
                  </div>
                  <div class="pull-right text-center">
                     <span class="panel-title btn-group">
                        <button id="addUser" ng-disabled="underCreation" type="button"
                        class="btn btn-default btn-sm" ng-click="addUser()">
                        <span class="glyphicon glyphicon-plus text-primary"></span> <span
                        class="text-primary"><strong>강의추가</strong></span>
                     </button>
                  </span>
               </div>
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
                  <h4 class="media-heading">${memberInfo.username}</h4>
                  <br>
                  <h5 class="media-heading">${memberInfo.introduce}</h5>
                  <br> <br>
               </div>
            </div>
         </div>
         <table class="table">
            <thead>
               <tr>
                  <th>강의 이름</th>
                  <th>강의 총 일수</th>
                  <th>현재 듣는 학생 수</th>
                  <th>수업 시간</th>
                  <th>강의실 입장</th>
               </tr>
            </thead>
            <tbody class="tr_btn" style="padding: 10px">
               <tr id="tr_index">

               </tr>
            </tbody>
         </table>
      </div>
   </div>

</div>
</div>
</div>

<!-- line modal -->
<div class="modal fade modal_add" id="squarespaceModal" tabindex="-1"
role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
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

<div class="modal fade modal_del" id="squarespaceModal" tabindex="-1"
role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
<div class="modal-dialog">
   <div class="modal-content">
      <div class="modal-header">
         <button type="button" class="close btc" data-dismiss="modal">
            <span aria-hidden="true">×</span><span class="sr-only">Close</span>
         </button>
         <h3 class="modal-title" id="lineModalLabel">강의제거</h3>
      </div>
      <div class="modal-body">
         <!-- content goes here -->
         <form>
            <div class="form-group">
               <div class="form-group">
                  <label>강의이름</label> <input type="text" class="form-control mdf"
                  id="del_lec_name" name="del_lec_name" placeholder="강의 이름">
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
            class="btn btn-default btn-hover-green delete_bts" data-action="save"
            role="button">저장</button>
         </div>
      </div>
   </div>
</div>
</div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>