<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>회원수정 화면</title>
</head>
<body>
   <div class="container" style = "width :946px; margin: 0 auto;" >
      <div class="col-lg-12">
         <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="/user/modify">
               <h3 style="text-align: center;">회원수정 화면</h3>
               <div class="form-group">
                  <input type="text" class="form-control" value="${login1.user_id}" name="user_id" maxlength="20" readonly="readonly">
               </div>
               <div class="form-group">
                  <input type="password" class="form-control" value="${login1.user_pw}" id = "user_pw" name="user_pw" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" value="${login1.user_name}" name="user_name" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" value="${login1.user_address}" name="user_address" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" value="${login1.user_phonenumber}" name="user_phonenumber" maxlength="20" required="required">
               </div>
               <input type="submit" class="btn btn-primary form-control"  value="수정 완료" >
            </form>
			<form action="/user/delete" method="post">
               <input type="submit" class="btn btn-primaty form-control" value="회원 탈퇴">
            </form>
         </div>
      </div>
   </div>

</body>
</html>