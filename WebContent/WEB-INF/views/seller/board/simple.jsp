<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerSimplePage.css" />
<%
Date date = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
String today = sf.format(date);
sf = new SimpleDateFormat("MM.dd");
today = sf.format(date);
%>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<h1 class="notice">공지사항</h1>
				<div class="admin_notice"></div>
				<h1 class="kamis">시세표</h1>
				<div class="kamis_list">
					<table>
						<thead>
							<tr>
								<th>품목</th>
								<th>단위</th>
								<th>가격(<%=today%>)
								</th>
								<th>등락률</th>
								<th>전일</th>
								<th>1개월전</th>
								<th>1년전</th>
							</tr>
						</thead>
						<thead>
						<tbody>
							<c:forEach var='price' items='${kamisAPIBean.price }'>
								<c:if test="${not empty price.category_name and not (price.category_name eq '축산물' or price.category_name eq '수산물')}">
									<tr>
										<td>${price.productName}</td>
										<td>${price.unit }</td>
										<td>${price.dpr1 }</td>
										<c:choose>
											<c:when
												test="${not empty price.value and price.value ne '-' and price.value gt 0.0}">
												<td>${price.value }<img
													src="${path }/resources/img/red_triangle.png"
													style="width: 10px">
												</td>
											</c:when>
											<c:otherwise>
											
												<td>${price.value = 0.0 }<img
													src="${path }/resources/img/blue_triangle.png"
													style="width: 10px">
												</td>
											</c:otherwise>
										</c:choose>
										<td>${price.dpr2 }</td>
										<td>${price.dpr3 }</td>
										<td>${price.dpr4 }</td>
									</tr>
									</c:if>
							</c:forEach>
						</thead>
					</table>
				</div>
				<h1 class="order_h1">주문 현황</h1>
				<div class="order_list">
					<p class="today">2024년 3월 5일 기준</p>
					<li class="new_order"><a href=""><span>신규주문(결제완료)</span>
							<p class="new_order_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click"> </a></li>
					<li class="Delivery"><a href=""><span>발송 대기중</span>
							<p class="Delivery_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click"> </a></li>
					<li class="Delevery_end"><a href=""><span>발송 완료</span>
							<p class="Delevery_end_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click"> </a></li>
				</div>
				<h1 class="price_h1">수익 현황</h1>
				<div class="price_list">
					<p class="today">2024년 3월 5일 기준</p>
					<li class="new_price"><a href=""> <span>판매금액</span>
							<p class="new_price_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click">
					</a></li>
					<li class="Delivery_price"><a href=""><span>배송비</span>
							<p class="Delivery_price_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click"> </a></li>
					<li class="order_count"><a href=""><span>주문수</span>
							<p class="order_count_count">0</p>
							<p class="COUNT">건</p> <img src="img/click.png" alt=""
							class="click"> </a></li>
				</div>
			</main>
		</article>
	</section>
</body>
</html>