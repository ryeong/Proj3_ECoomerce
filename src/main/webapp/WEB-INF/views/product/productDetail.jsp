<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<form action="">
		<input type="hidden" name="product_id" value="${productDTO.product_id}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPage" value="${cri.perPage}">

		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
	</form>

	<div class="container">
		<div class="row">
			<div class="form-group">
				<label for="title">상품 이미지</label>
				<input readonly="readonly" class="form-control" name="title" value="${productDTO.product_image}" id="image">
			</div>
			<div class="form-group">
				<label for="writer">상품 이름</label>
				<input readonly="readonly" class="form-control" name="writer" value="${productDTO.product_name}" id="name">
			</div>		
			<div class="form-group">
				<label for="content">상품 가격</label>
				<input readonly="readonly" class="form-control" name="writer" value="${productDTO.product_price}" id="price">
			</div>
			<div class="form-group">
				<label for="content">상품 수량</label>
				<input readonly="readonly" class="form-control" name="writer" value="${productDTO.product_quantity}" id="quantity">
			</div>
			
			<div class="form-group">
				<button class="btn btn-info">목록 보기</button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var $form = $("form");
			
			$(".btn-info").on("click", function(){ 
				$form.attr("method", "get");
				$form.attr("action", "/product/listProductTop");
				$form.submit();
			});
			
		});
	
	</script>
	
</body>
</html>