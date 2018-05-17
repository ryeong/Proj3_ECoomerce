<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html >
<html>
    <head>
<!--     	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
    <title>Insert title here</title>
   	</head>
<body>
	
	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
				</thead>
				<tbody>
					<c:forEach items="${qlist}" var="board">
					  <tr>
					    <td>${board.bno}</td>
					    <td>${board.title}</td>
					    <td>${board.writer}</td>
					    <td>${board.regdate}</td>
					    <td>${board.viewcnt}</td>
					  </tr>
				  	</c:forEach>
			  	</tbody>
			</table>		
		</div>
		<div class="row">
			<div class = "col-xs-3">
				<a href = "/question/write" class="btn btn-info">글쓰기</a>
			</div>
		</div>
	</div>



</body>
</html>