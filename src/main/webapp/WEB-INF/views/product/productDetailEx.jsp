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
			<input type = "hidden" name = "cart_id" value ="10" class = "cart_id">
			<input type = "hidden" name = "cart_product_quantity" value ="1" class = "cart_product_quantity">
			<input type = "hidden" name = "cart_product_id" value ="10" class = "cart_product_id">
			<input type = "hidden" name = "cart_product_size" value ="210" class = "cart_product_size">
			<input type = "hidden" name = "cart_user_id" value ="test1" class = "cart_user_id">

			
			<button type="submit" class="btn btn_addToCart">장바구니 추가</button>
			<button type="submit" class="btn btn_orderProduct" formaction="/payment/moveToOrderPage" formmethod="post">구매하기</button>
		</form>
		
		<script type="text/javascript">
			$(".btn_addToCart").on("click",function(){
				var cart_id = $("input")[0].value;
				var cart_product_quantity = $("input")[1].value;
				var cart_product_id = $("input")[2].value;
				var cart_product_size = $("input")[3].value;
				var cart_user_id = $("input")[4].value;
				
				$.ajax({
					type: "post",
					url: "/payment/addToCart",
					dataType: "text",
					data:{
						cart_id : cart_id,
						cart_product_quantity : cart_product_quantity,
						cart_product_id : cart_product_id,
						cart_product_size : cart_product_size,
						cart_userId : cart_user_id
					},
					success: function(result){
						if(result == "ADDTOCART_SUCCESS"){
							alert("장바구니에 추가되었습니다!")
						}
					}
				});
			});
			

		</script>
	</body>
</html>