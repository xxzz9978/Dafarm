<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>판매자 페이지 사이드, 탑 바 부분</title>
<link rel="stylesheet"
	href="${path }resources/seller_style/SideTopPage.css">
</head>
<body>
<body>
	<section> 
	<article> 
	<header>
	<div class="side">
		<div class="DafarmLogo">
			<a href="${path }seller/seller_user/main"> <img
				src="${path }resources/img/MainColorDAFARMLOGO.png">
			</a>
		</div>

		<div class="top">
			<a href="${path}main ">로그아웃</a>
		</div>

		<div class="SellerInfo1">
			<div class="SellerImg">
				<img src="${path }resources/img/SellerIcon.png">
				<p id="seller">판매자</p>
			</div>
			<button>
				<a href="${path }seller/seller_user/info">회원 정보 수정</a>
			</button>
		</div>

		<div class="nav">
			<div class="simple">
				<a href="${path }seller/seller_user/main"> <img
					src="${path }resources/img/simple.png"> &nbsp; &nbsp; 요약
				</a>
			</div>

			<div class="order">
				<a href="${path }seller/board/order"> <img
					src="${path }resources/img/order.png"> &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; 주문
				</a>
			</div>

			<div class="store">
				<a href="${path }seller/board/store"> <img
					src="${path }resources/img/store.png"> &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; 상점
				</a>
			</div>
			<div class="premium">
				<a href="${path }seller/board/premium"> <img
					src="${path }resources/img/premium.png"> &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; 프리미엄 관리
				</a>
			</div>
			<div class="menu">
				<a href="${path }seller/board/addPremium"> <img
					src="${path }resources/img/premiumSgin.png"> &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; 프리미엄 가입
				</a>
			</div>

			<div class="menu1">
				<a href="${path }seller/seller_user/menu"> <img
					src="${path }resources/img/noticeIcon.png"> &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; 공지사항
				</a>
			</div>
		</div>
	</div>
	</header>  
	</article> 
	</section>
</body>
</html>