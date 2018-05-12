<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<!-- 
			<link rel="stylesheet" href="css/bootstrap.css">
			<link rel="stylesheet" href="css/custom.css"> 
			<script src="js/bootstrap.js"></script> 
		-->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	
	
	
	
		<title>Insert title here</title>
		<style type="text/css">
		
			body {
				background-color: #4E7B93;
				background-repeat: no-repeat;
				background-size: cover;
			}
			
			#body {
				background-color: #4E7B93;
				background-repeat: no-repeat;
				background-size: cover;
			}
			
			#container {
				width: 1000px;
				height: 1000px;
				margin: 0 auto;
				border: 1px solid black;
				background-color: #E5E5E5;
				border-radius: 5px;
			}
			
			header, footer {
				position: relative;
				width: 1000px;
				height: 100px;
				border: 1px solid black;
				border-radius: 5px;
			}
			
			#topMenu {
				height: 100px;
				width: 1000px;
			}
			
			#topMenu ul li {
				list-style: none;
				text-align: center;
				font-size: 20px;
				margin-left: 30px;
			}
			
			#aside {
				width: 250px;
				height: 800px;
				border: 1px solid black;
				float: left;
			}
			
			#section {
				float: left;
			}
			
			#content {
				border: 1px solid black;
				width: 746px;
				height: 798px;
			}
			
			footer {
				width: 1000px;
				height: 100px;
				clear: left;
				color: black;
			}
		</style>
	</head>

	<body>
		<div id="container" >
				<header>
					<jsp:include page="header.jsp"></jsp:include>
				</header>
				
				<div id = "aside">
					<div id = "loginForm" style = "height: 300px">
						<!-- 기본값: 로그인 하지 않았거나 로그아웃 및 회원탈퇴했을 때 보여지는 페이지-->
						<c:if test="${login eq null }">
							<jsp:include page="../views/user/login.jsp"></jsp:include>
						</c:if>
						
						<!-- 로그인 했을 때 보여지는 페이지-->
						<c:if test="${login ne null }">
							<jsp:include page="../views/user/loginSuccessView.jsp"></jsp:include>
						</c:if>
					</div>
					
					
					 <div id = "sideMenuForm" style = "height: 500px">
						<jsp:include page="../views/sideMenu.jsp"></jsp:include>
					</div> 
				</div>
				
				<section>	
					<!-- 기본값: 아무런 입력도 들어오지 않았을 때-->
					<c:if test="${content eq null }">
						<jsp:include page="home.jsp"></jsp:include>
					</c:if>
					
					<!-- 사용자가 어떤 버튼을 누르거나 기능을 요청 했을 때 해당 페이지가 이곳에 출력되야 함 -->
					<c:if test="${content ne null }">
						<jsp:include page="${content}"></jsp:include>
					</c:if>								
				</section>
	
				<footer>
					<jsp:include page="footer.jsp"></jsp:include>
				</footer>
		</div>
	</body>
</html>