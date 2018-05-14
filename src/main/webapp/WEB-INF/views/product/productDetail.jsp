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

<h1>상품 자세히보기</h1>
<hr>

<%-- <form action="">
		<input type="hidden" name="product_id" value="${productDtoList.ProductDTO.product_id}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPage" value="${cri.perPage}">
</form> --%>


<div class="container">
		<div class="row">
			<div class="form-group">
				<label for="title">상품 이미지</label>
				<input readonly="readonly" class="form-control" name="image" value="${productDtoList.ProductDTO.product_image}" id="image">
			</div>
			<div class="form-group">
				<label for="writer">상품 이름</label>
				<input readonly="readonly" class="form-control" name="name" value="${productDtoList.ProductDTO.product_name}" id="name">
			</div>
					
			
			<div class="form-group">
				<label for="content">상품 가격</label>
				<input readonly="readonly" class="form-control" name="price" value="${productDtoList.ProductDTO.product_price}" id="price">
			</div>
			
		<form action = "#" method = "post" style="clear: right; margin-top: 10px;">
			<input type = "hidden" name ="product_id" value = "${productDtoList.ProductDTO.product_id}">
			
			<div >
				<b>친구목록</b> 
				<select name = "produt_id" style="width: 100px;">
					<c:forEach items="${productDTOCheck}" var="prodDTO">
					
					<!-- c:if문 써줘야? ajax써줘야?-->
						<option >상품 사이즈:${prodDTO.product_size}/상품수량:${prodDTO.product_quantity}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-default">
		      		<span class="glyphicon glyphicon-check"></span> 이동
		    	</button>
			</div>
		</form>	
		
			
		<%-- 
			
			<form action ="" method="post">
			<div class="form-group">
				<input type = "hidden" name="product_id" value="${productDtoList.ProductDTO.product_id}">
				<button type="submit" class="btn btn-default" style="margin-left: 150px;">
			      		<span class="glyphicon glyphicon-search"></span> ID찾기
			    </button>
				<label for="content">상품 수량</label>
				<input readonly="readonly" class="form-control" name="quantity" value="${productDtoList.ProductDTO.product_quantity}" id="quantity">
			</div>
			</form>
 --%>			
			<c:forEach items="${productDtoList}" var="productDtoList">
			<div class="form-group">
				<label for="content">상품 사이즈</label>
				<input readonly="readonly" class="form-control" name="quantity" value="${productDtoList.productDTO.product_quantity}" id="quantity">
			</div>
			</c:forEach>
			
			<form action="/product/listProduct?product_itemType=1&product_sortType=0">
				<div class="form-group">
				<button class="btn btn-info">목록 보기</button>
				</div>
			</form>
			
		</div>
	</div>


<%-- ${productDTO.product_id}<br> --%>
	<%-- <form action="">
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
	
	</script> --%>
	
</body>
</html>