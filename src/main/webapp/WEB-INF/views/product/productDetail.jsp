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
				<label for="image">상품 이미지</label>
			
				<div class="form-control"><img src="${productDto.product_image}" name="${productDto.product_image}" id="image"></div>
				
			</div>
			<div class="form-group">
				<label for="name">상품 이름</label>
				<input readonly="readonly" class="form-control" name="${productDto.product_name}" value="${productDto.product_name}" id="name">
			</div>
					
			
			<div class="form-group">
				<label for="price">상품 가격</label>
				<input readonly="readonly" class="form-control" name="${productDto.product_price}" value="${productDto.product_price}" id="price">
			</div>
			
			<div class="form-group">
                    <label for="size">상품 사이즈:&nbsp;</label>
                    <select id="sizeSelect">
                   	<option value="0">상품 사이즈를 선택하세요.</option>
                   
                   	<c:forEach items="${productDto.product_size}" var="productDtoSize" >
                   		<option>${productDtoSize}</option>
                   	</c:forEach>
                   </select>
                  </div>
			</div>
			<div class="form-group">
                    <label for="quantity">상품 수량:&nbsp;</label>
                    <select id="quantitySelect">
                   	<option value="0">상품 수량을 선택하세요.</option>
                   	<c:forEach items="${productDto.product_quantity}" var="productDtoQuantity" >
                   		<option>${productDtoQuantity}</option>
                   	</c:forEach>
                   </select>
                  </div>
			</div>
		
			
			<%-- <div >
				<select name = "produt_id" style="width: 100px;">
					<c:forEach items="${productDTOCheck}" var="prodDTO">
					
					<!-- c:if문 써줘야? ajax써줘야?-->
						<option >상품 사이즈:${prodDTO.product_size}/상품수량:${prodDTO.product_quantity}</option>
					</c:forEach>
				</select>
				
			</div> --%>
		
		
			
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