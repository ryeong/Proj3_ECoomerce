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
            <div id = "topImage">
            	<img alt="장바구니" src="/image/cart_topTitle01.jpg">
            </div>
            
            <h2>[장바구니]</h2>            
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th colspan="4">상품</th>
                  <th>옵션</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>합계</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${cart_list}" var="cart_dto">
              		<%-- <tr>
                		<td><a href  = "">${cart_dto.}</a></td>
                  		<td>${cart_dto.product_dto.}</td>
                  		<td>${cart_dto.cart_price}</td>
                  		<td>${cart_dto.cart_size}</td>
                  		<td>${cart_dto.cart_size}</td>
                	</tr> --%>
              	</c:forEach>
              	
              	<tr>
                	<td>사진 제품명</td>
                	<td>250</td>
                	<td>2000 원</td>
                	<td><input type = "number">1</td>
                	<td>가격 * 수량</td>
                </tr>
              </tbody>
            </table>
          </div>
    </body>
</html>