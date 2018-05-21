<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
	</head>
	<body>
		<div class="container" style = "width :946px; " >
            <div id = "topImage2">
            	<img alt="결제하기" src="/resources/image/cart_topTitle03.jpg" style = "width :910px">
            </div>
            <br>
            <span>주문번호: </span>
            <h3>[결제내역]</h3>            
            <table class="table table-condensed">
              <thead>
                <tr align="center" class="info">
                  <th colspan="4">상품</th>
                  <th>옵션</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>주문금액</th>
                </tr>
              </thead>
              <tbody>        
                	<c:forEach items="${cart_list}" var="cart_dto">
	              		<tr>       
	                    	<td colspan="2" class = "product_img">
	                        	<input type = "hidden" value="${cart_dto.cart_id}">
	                            <img src="${cart_dto.product_image}" alt="제품 사진" width="100px" height="100px">
	                       	</td>
	                        <td colspan="2" class = "product_name">${cart_dto.product_name}</td>
	                        <td class = "product_opt">${cart_dto.cart_product_size}</td>
	                        <td class = "product_price">${cart_dto.product_price} 원</td>
	                        <td>
	                          	${cart_dto.cart_product_quantity}
		                		<input type = "hidden" value = "${cart_dto.product_id}">
	                        </td> 	
	                        <td class = "product_sum">
		                           <%--  <script>
		                            	var a = $(".product_num").val();
		                            	var b = $(".product_price").text();		                           
		                            	console.log(a);
		                            	console.log(b);
		                            	console.log(sum(a,b));
		                            </script>원 --%> 
	                    	</td>
	                	</tr> 
              	</c:forEach>
                </tbody>
            </table>
    	</div>
	</body>
</html>