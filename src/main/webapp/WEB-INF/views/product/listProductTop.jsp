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

/* #product_img{
		width:200px;
	} */
</style>
    </head>
<body>
<h1>상품 상의</h1>
<!-- 상품 상의 전체 목록-->
		<c:forEach items="${list}" var="productDTO">
  			<div class="container-fluid">
			  <div class="row">
			    <div class="col-sm-3" style="background-color:white;">
			    	<div><img id = "product_img" alt="${productDTO.product_name}" src="${productDTO.product_image}"></div>
			    	<div>${productDTO.product_name}</div> 
			    	<div>${productDTO.product_price}</div> 
			    	<%-- <div>${productListTop.product_itemType}</div>
			    	<div>${productListTop.product_sortType}</div> --%>
			    </div> 
			  </div>
		</div>
		</c:forEach>
		
	<%-- 	
		<div class="row text-center">
			<ul class="pagination">
			
				<c:if test="${pm.cri.page>1}">
					<li><a href="/product/listProduct?product_Type=${product_itemType}&product_sortType=${product_sortType}
					&page=${pm.cri.page-1}&perPage=${pm.cri.perPage}">&laquo;</a></li>
				</c:if>
			
				<c:forEach var="idx" begin="${pm.startPageNum}" end="${pm.endPageNum}">
					<li class="${idx==pm.cri.page?'active':''}"> 
						<a href="/product/listProduct?product_Type=${product_itemType}&product_sortType=${product_sortType}
						&page=${idx}&perPage=${pm.cri.perPage}">${idx}<br></a>
					</li>
				</c:forEach>
				
				<c:if test="${pm.cri.page<pm.totalPage}">
					<li><a href="/product/listProduct?product_Type=${product_itemType}&product_sortType=${product_sortType}
					&page=${pm.cri.page+1}&perPage=${pm.cri.perPage}">&raquo;</a></li>
				</c:if>
			</ul>
		</div> --%>

</body>
</html>