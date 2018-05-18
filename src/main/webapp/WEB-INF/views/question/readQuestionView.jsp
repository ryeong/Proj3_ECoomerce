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
	<form action="">
		<input type="hidden" name="bno" value="${dto.bno}">
	</form>
	<div class="container">
		<div class="row">
			<div class="form-group">
				<label for="title">제목</label>
				<input readonly="readonly" class="form-control" name="title" value="${dto.title}" />
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input class="form-control" value ="${dto.writer}" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<%-- <input name="content" id="content" value="${vo.content}" readonly="readonly"/> --%>
				<textarea cols="150" rows="10" name="content" id="content" readonly="readonly">${dto.content}</textarea>
			</div>
			<div class="form-group">
				<button class="btn btn-success">수정</button>
				<button class="btn btn-danger">삭제</button>
				<button class="btn btn-warning">목록보기</button>
			</div>
		</div>
	</div>
</body>
</html>