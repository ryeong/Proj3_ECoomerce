<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html >
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
		<div class="row">
			<form  method="post">
				<div class="form-group">
					<label for = "title">제목</label>
					<input class="form-control" name="title" id="title" required="required"/>
				</div>
				<div class="form-group">
					<label class="writer">작성자</label>
					<input class="form-control" name="writer" id="writer" required="required"/>
				</div>
				<div class="form-group">
					<label class="content">내용</label>
					<textarea class="form-control" name="content" id="content" rows="2" required="required"></textarea>
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-success" type="submit">등록</button>
				<button class="btn btn-warning" type="reset">목록보기</button>	
			</div>
		</div>
	</div>
	

	
	<script type="text/javascript">
	$(document).ready(function() {
		$("button[type='submit']").click(function(event) {
			$("form").submit();
						
		});
		
		$("button[type='reset']").click(function() {
			location.href="../question/listall";
		});
			
	});
	</script>
	</body>
</html>