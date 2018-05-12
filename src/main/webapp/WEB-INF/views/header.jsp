<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
	<nav id="topMenu" style="text-align:center;" class="navbar navbar-inverse">	
		<div class="navbar-header" style="vertical-align:botton;">
			<button type="button" class="navbar-toggle collapsed" 
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<a class="navbar-brand" href="/" style="font-size:50px;"><br>&nbsp;&nbsp;Project3</a>
		</div>
		 <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
			<ul id="manuItem" class="nav navbar-nav" style = "width:800px;">
				<li><a class="active" href="#">마이페이지</a></li>
				<li><a class="active" href="/cart/cartList">장바구니</a></li>
				<li><a class="active" href="#">Q&A</a></li>
				<li><a class="active" href="#">회원관리</a></li>
				<li><a class="active" href="#">상품관리</a></li>
			</ul>
		</div>
	</nav>
	