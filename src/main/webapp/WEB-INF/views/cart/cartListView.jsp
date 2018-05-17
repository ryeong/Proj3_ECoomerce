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
        <div class="container" style = "width :946px; " >
            <div id = "topImage1">
            	<img alt="장바구니" src="/resources/image/cart_topTitle01.jpg" style = "width :910px">
            </div>
            
            <!-- <h3>[장바구니](el태그.수량)</h3> -->
            <!-- 테스트용 코드 -->
            <h3>[장바구니 목록]</h3>            
            <table class="table table-condensed">
              <thead>
                <tr align="center" class="info">
                  <th colspan="4" ><input type = "checkbox" id="allCheck">상품</th>
                  <th>옵션</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>합계</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${cart_list}" var="cart_dto">
	              		<tr>       
	                    	<td colspan="2" class = "product_img">
	                        	<input type = "hidden" value="${cart_dto.cart_id}">
	                           	<input class = "checkbox" type = "checkbox" value="${cart_dto.product_id}">
	                            <a href ="#"><img src="${cart_dto.product_image}" alt="제품 사진" width="100px" height="100px"></a> 
	                        <td colspan="2" class = "product_name"> <a href = "#">${cart_dto.product_name}</a></td>
	                        <td class = "product_opt">${cart_dto.cart_product_size}</td>
	                        <td class = "product_price">${cart_dto.product_price} 원</td>
	                        <td>
	                            <input type = "number" size="3" maxlength="3" class = "product_num" value = "${cart_dto.cart_product_quantity}"> 
		                		<input type = "hidden" value = "${cart_dto.product_id}">
		                		<button type="button" class="btn btn_modify">변경</button>
	                        </td> 	
	                        <td class = "product_sum">
		                           <%--  <script>
		                            	var a = $(".product_num").val();
		                            	var b = $(".product_price").text();		                           
		                            	console.log(a);
		                            	console.log(b);
		                            	console.log(sum(a,b));
		                            </script>원 --%> 
		                   		<input type = "hidden" value = "${cart_dto.cart_id}"> 
			                	<button type="button" class="btn btn_delete">삭제</button>
	                    	</td>
	                	</tr> 
              	</c:forEach>  
                
           		</tbody>
            </table>
            <form action="/payment/orderProduct">
            	<button type="submit" class="btn btn-danger btn_order">결제하기</button>
            </form>
                  
          </div>
          
          <script>
          	$(document).ready(function() {
	          	addBtnEvent();
	            
				$(".btn_order").on("click",function (event) {
	                
	            });
				
				$("#allCheck").change(function(){
					if($(this).is(":checked")){
						$(".checkbox").prop("checked",true);					
					}else{
						$(".checkbox").prop("checked",false);
					}
				});
				
				function getAllCartList() {
					$.getJSON("/cart/getAllCartList", function(data) {
						console.log(data);
						
						$("tbody tr").remove();
						
						$.each(data, function(i){				
							var str = "<tr>";
							str += "<td colspan='2' class = 'product_img'>";
								str += "<input type = 'hidden' value='" + data[i].cart_id + "'>";
								str += "<input class = 'checkbox' type = 'checkbox' value='" + data[i].product_id + "'>";
								str += "<a href ='#'><img src='" + data.product_image + "' alt='제품 사진' width='100px' height='100px'></a>";
							str += "</td>";
							
							str += "<td colspan='2' class = 'product_name'><a href = '#'>"+ data[i].product_name + "</a></td>";
							str += "<td class = 'product_opt'>"+ data[i].cart_product_size +"</td>";
							str += "<td class = 'product_price'>" + data[i].product_price + "원</td>";
							str += "<td>"
								str += "<input type = 'number' size='3' maxlength='3' class = 'product_num' value = '" + data[i].cart_product_quantity + "'>";
								str += "<input type = 'hidden' value = '" + data[i].product_id + "'>";
								str += "<button type='button' class='btn btn_modify'>변경</button>";
							str += "</td>";
							str += "<td class = 'product_sum'>";
								str += "<input type = 'hidden' value = '" + data[i].cart_id + "'>";
								str += "<button type='button' class='btn btn_delete'>삭제</button>"
							str += "</td>"
							str += "</tr>";
							
							$("tbody").append(str);
						});
						addBtnEvent();			
					});
					
					
				}
			
				function addBtnEvent(){
					$(".btn_modify").on("click",function (event) {          	        
		                
		                $.ajax({
		    				type: "post",
		    				url: "/cart/modifyCart",
		    				dataType: "text",
		    				data: {
		    					cart_id: $(this).prev().val(),
		    					product_num: $(this).prev().prev().val()
		    				},
		    				success: function(result){
		    					if(result == "MODIFY_CART_SUCCESS"){
		    						getAllCartList();
		    						alert("장바구니가 수정되었습니다.");
		    					}
		    				}
		    				
		    			});
		            });
					
					  $(".btn_delete").on("click",function (event) {
			                var cart_id = $(this).prev().val();
			                console.log(cart_id);
			                /* var cart_id_array = new Array();
							$(".checkbox").each(function(){
			                	var checkbox = $(this);
			                	var $form = $("form"); 
			                	if(checkbox.is(":checked")){
			                		var cart_id = checkbox.prev().val();
			                		cart_id_array.cart_id = cart_id;
			                	} 
			                }); */
			                $.ajax({
			    				type: "post",
			    				url: "/cart/deleteCart",
			    				dataType: "text",
			    				data: {
			    					cart_id: $(this).prev().val(),
			    				},
			    				success: function(result){
			    					if(result == "DELETE_CART_SUCCESS"){
			    						getAllCartList();
			    						alert("장바구니가 삭제되었습니다.");
			    					}
			    				}		
			    			});
			            });
				}
				
				function sum(a,b){
					return a * b;
				}
          	});
          </script>
    </body>
</html>