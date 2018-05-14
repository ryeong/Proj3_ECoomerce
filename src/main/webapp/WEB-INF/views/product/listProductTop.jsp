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
							
							<td><form action="/product/productDetail"> 
			 				 <%-- <input type="hidden" name="product_size" value="${productDTO.product_size}"> --%>
			 				 <input type="hidden" name="product_id" value="${productDTO.product_id}">
							 <img src="${productDTO.product_image}" name="${productDTO.product_image}">
							 <input type="submit" src="${productDTO.product_image}" value="이미지">
							</form></td>
							
							
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
		
		
		<!-- 페이징 처리 -->
		전체 게시글의 수 ${pm.startPageNum}<br>
		시작 페이지 ${pm.startPageNum}<br>
		끝 페이지 ${pm.endPageNum}<br>
		총 몇페이지가 필요한지 ${pm.totalPage}<br>
		한 페이지 ${pm.cri.page}<br>
		한 페이지 당 몇 개 글  ${pm.cri.perPage}<br>
		
		<div class="row text-center">
			<ul class="pagination">
				<c:if test="${pm.cri.page>1}">
					<li><a href="/product/listProductTop?product_itemType=1&product_sortType=0&page=${pm.cri.page-1}&perPage=${pm.cri.perPage}">&laquo;</a></li>
				</c:if>
			
			
				<c:forEach var="idx" begin="${pm.startPageNum}" end="${pm.endPageNum}">
					<li class="${idx==pm.cri.page?'active':''}"> 
						<a href="/product/listProductTop?product_itemType=1&product_sortType=0?page=${idx}&perPage=${pm.cri.perPage}">${idx}<br></a>
					</li>
				</c:forEach>
				
				<c:if test="${pm.cri.page<pm.totalPage}">
					<li><a href="/product/listProductTop?product_itemType=1&product_sortType=0?page=${pm.cri.page+1}&perPage=${pm.cri.perPage}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		
	

</body>
</html>