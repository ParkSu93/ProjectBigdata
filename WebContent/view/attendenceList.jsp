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
      .search-form .form-group {
         float: right !important;
         transition: all 0.35s, border-radius 0s;
         width: 32px;
         height: 32px;
         background-color: #fff;
         box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
         border-radius: 25px;
         border: 1px solid #ccc;
      }

      .search-form .form-group input.form-control {
         padding-right: 20px;
         border: 0 none;
         background: transparent;
         box-shadow: none;
         display: block;
      }

      .search-form .form-group input.form-control::-webkit-input-placeholder {
         display: none;
      }

      .search-form .form-group input.form-control:-moz-placeholder {
         /* Firefox 18- */
         display: none;
      }

      .search-form .form-group input.form-control::-moz-placeholder {
         /* Firefox 19+ */
         display: none;
      }

      .search-form .form-group input.form-control:-ms-input-placeholder {
         display: none;
      }

      .search-form .form-group:hover, .search-form .form-group.hover {
         width: 100%;
         border-radius: 4px 25px 25px 4px;
      }

      .search-form .form-group span.form-control-feedback {
         position: absolute;
         top: -1px;
         right: -2px;
         z-index: 2;
         display: block;
         width: 34px;
         height: 34px;
         line-height: 34px;
         text-align: center;
         color: #3596e0;
         left: initial;
         font-size: 14px;
      }
   </style>
   <script type="text/javascript">
      var search_id = null; //검색한 이름
      var attend_student_list = null; //받아올 학생 리스트.
      $(document).ready(function(){ 
         $("input[name=search]").keydown(function (key) { //학생 검색
            if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
              search_id=$("#search").val(); //찾기
              console.log("search_id");
              $("#search").val("");
           }
        });
         $("#storeUser").click(function(){ //저장 눌렀을때 바로 db에 뿌린다. 그리고 다시 그려?
            console.log(2);
         });

         $("#checkUser").click(function(){ //버튼 눌렀을 때.
            console.log(1);
         });
      });
   </script>
</head>
<body>
   <%@include file="navbar_teacher.jsp" %> 

   <div class="container">
      <div class="row">
         <h4 style="display: inline-block;"> 회원검색 </h4>
         <div class="col-md-4">
            <div class="search-form">
               <div class="form-group has-feedback">
                  <label for="search" class="sr-only">Search</label> <input
                  type="text" class="form-control" name="search" id="search"
                  placeholder="search"> <span
                  class="glyphicon glyphicon-search form-control-feedback"></span>
               </div>
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
                     class="panel-span panel-left">출석부</span>
                     <div class="pull-right text-center">
                        <span class="panel-title btn-group">
                           <button id="storeUser" ng-disabled="underCreation" type="button"
                           class="btn btn-default btn-sm" ng-click="addUser()" style="padding-left: 10px">
                           <span class="glyphicon glyphicon-exclamation-sign  text-primary"></span> <span
                           class="text-primary"><strong>저장</strong></span>
                        </button>
                     </span>
                  </div>
                  <div class="pull-right text-center">
                     <span class="panel-title btn-group">
                        <button id="checkUser" ng-disabled="underCreation" type="button"
                        class="btn btn-default btn-sm" ng-click="addUser()" style="padding-right: 10px">
                        <span class="glyphicon glyphicon-user  text-primary"></span> <span
                        class="text-primary"><strong>일괄출석</strong></span>
                     </button>
                  </span>
               </div>
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
                  <tr id="tr_index">
                     <td id="r_lec_name" name="r_lec_name">박영수</td>
                  </tr>
               </tbody>
            </table>
         </div>
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
         //여기서 for 구문 하나 더써서 학생 이름까지 돌리삼+학생이름 해서
         for (var i = 1; i <= day_num; i++) {
            th_tr.append('<td><input type="text" class="td_day td_'+i+'_day"/></td>');
            //한번 더 유저에 해당하는 값 뿌려주고.
         }
      });
   </script>
   <style type="text/css">
      .td_day{
         width: 35px;
      }
      .table{
		}
		#r_lec_name{
			width: 50px;
		}

      }
      #r_lec_name{
         width: 50px;
      }
   </style>
</body>
</html>