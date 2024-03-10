<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerPlusGoodsPage.css" />
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />

	<section>
		<article>
			<main>

				<div class="plusStore">
					<h1>상품 등록</h1>
					<button>임시 저장</button>
				</div>

				<form:form method="post" action="${path}seller/board/addOrder_pro"
					modelAttribute="addOrderBean" enctype="multipart/form-data">
					<!-- 상품 명 -->
					<form:hidden path="Order_writer_num" />
					<div class="subPlusStore">
						<h3>주문번호</h3>
						<h3 class="star">*</h3>
						<form:input path="order_number"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>주문상태</h3>
						<h3 class="star">*</h3>
						<form:input path="order_status"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>주문날짜</h3>
						<h3 class="star">*</h3>
						<form:input path="order_date"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>택배사</h3>
						<h3 class="star">*</h3>
						<form:input path="delivery_company"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>운송장</h3>
						<h3 class="star">*</h3>
						<form:input path="delivery_number"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>판매자</h3>
						<h3 class="star">*</h3>
						<form:input path="seller_name"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>판매자전화번호</h3>
						<h3 class="star">*</h3>
						<form:input path="seller_phone"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>상품명</h3>
						<h3 class="star">*</h3>
						<form:input path="item_name"></form:input>
					</div>
					<div class="subPlusStore">
						<h3>구매자</h3>
						<h3 class="star">*</h3>
						<form:input path="receiver_name"></form:input>
					</div>
				
				<div class="subPlusStore">
						<h3>구매자전화번호</h3>
						<h3 class="star">*</h3>
						<form:input path="receiver_phone"></form:input>
					</div>
				
				<div class="subPlusStore">
						<h3>우편번호</h3>
						<h3 class="star">*</h3>
						<form:input path="address_number"></form:input>
					</div>
				
				<div class="subPlusStore">
						<h3>주소</h3>
						<h3 class="star">*</h3>
						<form:input path="address"></form:input>
					</div>
				
				
				
					<div class="submit">
						<form:button path="submit">등록</form:button>
					</div>
				</form:form>
			</main>
		</article>
	</section>
</body>
</html>