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
		<form action="/payment/addToCart" method="post">
			<input type = "hidden" name = "cart_id" value ="5">
			<input type = "hidden" name = "cart_product_quantity" value ="1">
			<input type = "hidden" name = "cart_product_id" value ="10">
			<input type = "hidden" name = "cart_product_size" value ="210">
			
			<button type="submit" class="btn btn_addToCart">장바구니 추가</button>
			<button type="submit" class="btn btn_orderProduct" formaction="/payment/orderProduct" formmethod="post">구매하기</button>
		</form>
		
		<script type="text/javascript">
			$(".btn_addToCart").on("click",function(){
				$("input")
			});
		</script>
	</body>
</html>