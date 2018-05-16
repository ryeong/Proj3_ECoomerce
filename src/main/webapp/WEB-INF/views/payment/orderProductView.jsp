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
            <div id = "topImage">
            	<img alt="주문/결제" src="/resources/image/cart_topTitle02.jpg" style = "width :910px">
            </div>
            
            <!-- <h3>[장바구니](el태그.수량)</h3> -->
            <!-- 테스트용 코드 -->
            <h3>[주문내역]</h3>            
            <table class="table table-condensed" style = "height: 700px;">
              <thead>
                <tr align="center" class="info">
                  <th colspan="4">상품</th>
                  <th>옵션</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>합계</th>
                </tr>
              </thead>
              <tbody>
              		<%-- <tr>       
                            <td colspan="2" class = "product_img">
                            	<input type = "checkbox" value="${제품 번호}">
                            	<a href =""><img src="${cart_dto.product_dto.product_img}" alt="제품 사진" width="100px" height="100px"></a>
                            </td>
                            <td colspan="2" class = "product_name"> <a href = "#">${cart_dto.product_dto.product_name}</a></td>
                            <td class = "product_opt">${cart_dto.product_dto.product_size}</td>
                            <td class = "product_price">${cart_dto.product_dto.product_price} 원</td>
                            <td><input type = "number" value = "${cart_dto.cart_num}" size="3" maxlength="3" class = "product_num"> <button type="button" class="btn btn_modify">변경</button></td> 	
                            <td class = "product_sum"><script>${cart_dto.cart_price} * ${cart_dto.cart_num}</script>  <button type="button" class="btn btn_delete">삭제</button></td>
                	</tr> 
                	<tr >
	                	<td colspan="2" class = "product_img">	               
	                		<img src="${cart_dto.product_dto.product_img}" alt="제품 사진" width="100px" height="100px">
	                	</td>
	                	<td colspan="2" class = "product_name">
	                		<a href = "#">${cart_dto.product_dto.product_name}</a>
	                	</td>
	                	<td class = "product_opt">${cart_dto.product_dto.product_size}</td>
	                	<td class = "product_price">${cart_dto.product_dto.product_price} 원</td>
	                	<td>${cart_dto.cart_num}</td> 	
	                	<td class = "product_sum"><script>${cart_dto.cart_price} * ${cart_dto.cart_num}</script> </td>
	                </tr>
                	--%>
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
              	
	              <%-- 	<!-- 연습용 코드 -->
	              	<c:forEach begin="0" end="10">
		              	<tr >
		                	<td colspan="2" class = "product_img">	               
		                		<img src="" alt="제품 사진" width="200px" height="200px">
		                	</td>
		                	<td colspan="2" class = "product_name">
		                		<a href = "#">sdjhsafsafssssssssssssssssssal</a>
		                	</td>
		                	<td class = "product_opt">250</td>
		                	<td class = "product_price">2000 원</td>
		                	<td>1</td> 	
		                	<td class = "product_sum">가격 * 수량 </td>
		                </tr>
	                </c:forEach>      --%>       
                </tbody>
            </table>
            
            <div id = "tbl_one" style="float: left; margin-top: 20px;  margin-left: 10px;">
	            <h3>[01.구매자 정보]</h3>
	            <table class="table table-bordered" style = "width: 400px;">
	              <thead>
	                <tr align="center" class="info">
	                  <th>주문자</th>
	                  <th>휴대폰</th>
	                  <th>이메일</th>              
	                </tr>
	              </thead>
	              <tbody>
		         	  <tr >
		              	<td>${session.user_name}</td>
		              	<td>${session.user_phoneNumber}</td>
		              	<td>${session.user_email}</td>	
		              </tr>          
	            </table>   
	        </div>
	        
	        <div id = "tbl_two" style="float: right; margin-top: 20px; margin-right: 10px;">
	            <h3>[02.결제정보]</h3>
	            <table class="table table-bordered" style = "width: 400px;">
	              <thead>
	                <tr align="center" class="info">
	                  <th>총 구매금액</th>
	                  <th>결제</th>              
	                </tr>
	              </thead>
	              <tbody>
		         	  <tr >
		              	<td></td>
		              	<td>
		              		<form action="/payment/orderProduct" method="post">
		              			<button style="margin-left: 40px" type="submit"  class="btn btn-danger btn_order" >주문하기</button>
		              		</form>
		              	</td>
		              </tr>          
	            </table>   
	        </div>                       
          </div>
	</body>
</html>