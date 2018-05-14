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
<style>

 #img{
		width:200px;
	}
</style>
    </head>
<body>
<h1>상품 상의</h1>
<div class="container">
		<div class="row">
			<h1>검색 목록</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>제품번호</th>
						<th>제품이미지</th>
						<th>제품이름</th>
						<th>제품가격</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="productDTO">
						<tr>
							<td>${productDTO.product_id}</td>
							<td><a href="#">${productDTO.product_image}</a></td>
							<td>${productDTO.product_name}</td>
							<td>${productDTO.product_price}</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



<%-- <!-- 상품 상의 전체 목록-->

		<c:forEach items="${list}" var="product">
  			<div class="container-fluid">
			  <div class="row">
			    <div class="col-sm-3" style="background-color:lavender;">
			    	<div><img id = "img" alt="${product.product_name}" src="//melted.co.kr/web/product/small/201804/5999_shop1_497844.gif"></div>
			    	<div>${product.product_name}</div> 
			    	<div>${product.product_price}</div> 
			    	<div>${productListTop.product_itemType}</div>
			    	<div>${productListTop.product_sortType}</div>
			    </div> 
			  </div>
		</div>
		</c:forEach> --%>
		
	

</body>
</html>