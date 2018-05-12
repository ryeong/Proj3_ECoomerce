<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
   <div class="container">
      <div class="col-lg-8">
         <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="/user/register">
               <input type="hidden" name="type" value="0">
               <h3 style="text-align: center;">회원가입 화면</h3>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="아이디"
                     name="user_id" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="password" class="form-control" placeholder="비밀번호"
                     id = "user_pw" name="user_pw" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="이름"
                     name="user_name" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="date" class="form-control" placeholder="생년월일"
                     name="user_birthdate" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="주소"
                     name="user_address" maxlength="20" required="required">
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="핸드폰번호"
                     name="user_phonenumber" maxlength="20" required="required">
               </div>

               <div class="form-group" style="text-align: center;">
                  <div class="btn-group" data-toggle="buttons">
                     <label class="btn btn-primary active"> 
                     <input type="radio" name="user_gender" autocomplete="off" value="man" checked>남자
                     </label> 
                     <label class="btn btn-primary"> 
                        <input type="radio" name="user_gender" autocomplete="off" value="woman" checked>여자
                     </label>
                  </div>
               </div>
               <input type="submit" class="btn btn-primary form-control"
                  value="회원가입" >
            </form>
         </div>
      </div>
   </div>
</body>
</html>