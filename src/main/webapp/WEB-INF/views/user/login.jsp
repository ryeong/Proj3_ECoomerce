<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale= 1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>



</head>
<body>	
		<div class="col-lg-12" width = "400px">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="/user/login">
					<h3 style="text-align: center;">로그인 화면</h3>
					
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="user_id" maxlength="10">
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="user_pw" maxlength="15">
					</div>
					
					<input type="submit" class="btn btn-primary form-control"  value="로그인">
				</form>
				
				<form action="/user/register" method="get" style= "margin-top: 10px;">
					<input type="submit" class="btn btn-primary form-control"  value="회원가입">
				</form> 

			</div>
		</div>
	
	
</body>
</html>