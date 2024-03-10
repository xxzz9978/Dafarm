<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>DAFARM</title>
</head>
<body>
	<div class="header" id="header_id">
					<a href="${path}main">
						<img class="logo" src="${path}resources/img/mainLogo.png"/>
					</a>
				
			<ul class="nav">
			<c:choose>
				<c:when test="${loginUserBean.userLogin == true }">
					<li><a href="${path}users/trade/order_list" class="top_text">구매하기</a></li>
					<li><a href="${path}users/board/main" class="top_text">공지사항</a></li>
					<li><a href="${path}users/trade/information" class="top_text">배송현황</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${path}users/user/not_login" class="top_text">구매하기</a></li>
					<li><a href="${path}users/user/not_login" class="top_text">공지사항</a></li>
					<li><a href="${path}users/user/not_login" class="top_text">배송현황</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
				
			<ul class="user">		
	 			<c:choose>
					
					<c:when test="${loginUserBean.userLogin == true }">
					<!-- 로그인 상태 -->
						<li>
							<a href="${path}users/trade/cart" class="top_text">장바구니</a>
						</li>
						<li>
							<a href="${path}users/user/logout" class="top_text">로그아웃</a>
						</li>
						<li>
							<a href="${path}users/user/modify" class="top_text">마이페이지</a>
						</li>
					</c:when>
					
					<c:otherwise>
					<!-- 로그아웃 상태 -->
						<li>
							<a href="${path}users/user/join" class="top_text">회원가입</a>
						</li>
						<li>
							<a href="${path}users/user/login" class="top_text">로그인</a>
						</li>
					</c:otherwise>
					
				</c:choose>
				</ul>
			</div>
</body>
</html>