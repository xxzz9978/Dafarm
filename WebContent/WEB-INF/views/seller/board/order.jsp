<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerOrderPage.css">
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<div class="SellerOrderImage">
					<img src="${path }/resources/img/orderIconBold.png">
					<h1>&nbsp;주문</h1>
				</div>
				<!-- 배송 관련 박스 부분들 묶어주는 div 입니다. -->
				<div class="OrderCountBox">
					<div class="CountBox HvrBtn">
						<div class="CountBoxContent">
							<a href="${path }seller/board/order?order_status=전체">전체</a>
						</div>
						<div class="Count">${count }</div>
					</div>
					<div class="CountBox HvrBtn">
						<div class="CountBoxContent">
							<a href="${path }seller/board/order?order_status=입금대기"
								class="CountBoxContent">입금대기</a>
						</div>
						<div class="Count">${count1 }</div>
					</div>
					<div class="CountBox HvrBtn">
						<div class="CountBoxContent">
							<a href="${path }seller/board/order?order_status=결제완료"
								class="CountBoxContent">결제완료</a>
						</div>
						<div class="Count">${count2 }</div>
					</div>
					<div class="CountBox HvrBtn">
						<div class="CountBoxContent">
							<a href="${path }seller/board/order?order_status=발송대기"
								class="CountBoxContent">발송대기</a>
						</div>
						<div class="Count">${count3 }</div>
					</div>
					<div class="CountBox HvrBtn">
						<div class="CountBoxContent">
							<a href="${path }seller/board/order?order_status=발송완료"
								class="CountBoxContent">발송완료</a>
						</div>
						<div class="Count">${count4 }</div>
					</div>
				</div>

				<table class="OrderTable">
					<thead>
						<tr class="HeaderContent">
							<th class="OrderNumber">주문번호</th>
							<th class="OrderStatus">주문상태</th>
							<th class="OrderDate">주문날짜</th>
							<th class="DeliveryCompany">택배사</th>
							<th class="DeliveryNumber">운송장</th>
							<th class="SellerName">판매자</th>
							<th class="SellerPhone">판매자전화번호</th>
							<th class="ItemName">상품명</th>
							<th class="ReceiverName">구매자</th>
							<th class="ReceiverPhone">구매자전화번호</th>
							<th class="Address">주소</th>
							<th class="modifyButton">수정버튼</th>
							<!-- <th class="AddressNumber">우편번호</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach var='obj' items="${orderList }">
							<tr class="HeaderContent">
								<td class="OrderNumber">${obj.order_number }</td>
								<td class="OrderStatus">${obj.order_status }</td>
								<td class="OrderDate">${obj.order_date }</td>
								<td class="DeliveryCompany">${obj.delivery_company }</td>
								<td class="DeliveryNumber">${obj.delivery_number }</td>
								<td class="SellerName">${obj.seller_name }</td>
								<td class="SellerPhone">${obj.seller_phone }</td>
								<td class="ItemName">${obj.item_name }</td>
								<td class="ReceiverName">${obj.user_name  }</td>
								<td class="ReceiverPhone">${obj.user_phone  }</td>
								<td class="Address">${obj.address }</td>
								<td class="modifyButton"><a href="${path }seller/board/order_modify?order_number=${obj.order_number } "><button>수정</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 여기서부터 수정해야하는 구간(페이징 처리) -->
				<div class="PageButtonContainer">
					<ul class="PageButtonContent">

						<c:choose>
							<c:when test="${orderPageBean.prevPage <=0 }">
								<li class="PrevPageButton"><a href="#"
									class="PrevPageDisableContent">이전</a></li>
							</c:when>
							<c:otherwise>
								<li class="PrevPageButton"><a
									href="${root }order?order_status=${order_status }&orderPage=${orderPageBean.prevPage}"
									class="PrevContent"> 이전</a></li>
							</c:otherwise>
						</c:choose>


						<c:forEach var='idx' begin="${orderPageBean.min }"
							end="${orderPageBean.max }">
							<c:choose>
								<c:when test="${idx == orderPageBean.currentPage }">
									<li class="MiddleButton"><a
										href="${root }order?order_status=${order_status }&orderPage=${idx}"
										class="MiddleButtonActiveContent">${idx }</a></li>
								</c:when>
								<c:otherwise>
									<li class="MiddleButton"><a
										href="${root }order?order_status=${order_status }&orderPage=${idx}"
										class="MiddleButtonContent">${idx }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>



						<c:choose>
							<c:when test="${orderPageBean.max >= orderPageBean.pageCnt }">
								<li class="NextButton"><a href="#"
									class="NextButtonDisableContent">다음</a></li>
							</c:when>
							<c:otherwise>
								<li class="NextButton"><a
									href="${root }order?order_status=${order_status }&orderPage=${orderPageBean.nextPage}"
									class="NextButtonContent">다음</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</main>
		</article>
	</section>
</body>
</html>