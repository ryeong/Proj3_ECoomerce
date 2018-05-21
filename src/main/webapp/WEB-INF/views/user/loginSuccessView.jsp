<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>${login.user_id}</div>
		<div>${login.user_name}님환영합니다</div>
	</div><br>

	<form action="/user/logout" method="post">
		<div class="container" style="display: inline-block;">
			<span class="btn-group">
				<button type="submit" class="btn btn-default"
					style="margin-right: 20px; margin-left: 15px;">로그아웃</button>
				<button formaction="/user/modify" formmethod="get"
					type="submit" class="btn btn-default">회원수정</button>
			</span>
		</div>
	</form>
</body>
</html>


