<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

		<div class="list-group" height = "400px">
			<a href="/product/listProduct?product_itemType=0&product_sortType=0" class="list-group-item list-group-item-info">베스트</a>
			
			<a href="/product/listProduct?product_itemType=1&product_sortType=0" class="list-group-item list-group-item-action list-group-item-primary">상의</a>
			
			<a href="/product/listProduct?product_itemType=2&product_sortType=0" class="list-group-item list-group-item-action list-group-item-primary">하의</a>
			
		  	<a href="/product/listProduct?product_itemType=3&product_sortType=0" class="list-group-item list-group-item-action list-group-item-primary">신발</a>
		  	
		  	
		  <!-- 	<form action="/product/listProduct"> 
			 <input type="hidden" name="product_itemType" value="1">
			 <input type="hidden" name="product_sortType" value="0">
			 <input type="button" class="list-group-item list-group-item-action list-group-item-primary" name="productTop" value="상의">
			</form> -->
		</div> 