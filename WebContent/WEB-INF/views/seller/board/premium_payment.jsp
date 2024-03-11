<%@page import="kr.co.dafarm.dao.SellerProductDao"%>
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
	href="${path }/resources/seller_style/Sellerpremium_payment.css" />
<!-- JQuery -->
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<!-- DataTables -->
<link
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script
	src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" type="text/css">
<!-- FontAwesome -->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script src="${path}resources/user_script/trade_cart.js"></script>
<!-- 포트원 결제 -->
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 포트원 결제 -->
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<main>
		<div class="main_title">
			<h3>DAFARM PREMIUM</h3>
			<div id="main_title_body">
				<h1>DAFARM을 PREMIUM 맴버쉽으로 사용하세요</h1>
			</div>
		</div>

		<script>
			var IMP = window.IMP;
			IMP.init("imp26153568");

			var today = new Date();
			var hours = today.getHours(); // 시
			var minutes = today.getMinutes(); // 분
			var seconds = today.getSeconds(); // 초
			var milliseconds = today.getMilliseconds();
			var makeMerchantUid = hours + minutes + seconds + milliseconds;

			function requestPay() {
				IMP.request_pay({
					pg : 'kakaopay',
					pay_method : 'card',
					merchant_uid : makeMerchantUid, //상점에서 생성한 고유 주문번호
					name : '카카오페이 일반결제', //필수 파라미터 입니다.
					amount : 12000,
					buyer_email : '${sellerBean.seller_email}',
					buyer_name : '${sellerBean.seller_name}',
					buyer_tel : '${sellerBean.seller_phone}',
					buyer_postcode : '123-456',
					buyer_addr : '${sellerBean.seller_address}',
					m_redirect_url : '${path}seller/board/payment_success'
				}, function(rsp) { // callback
					if (rsp.success) {
						location.href = '${path}seller/board/payment_success'
					} else {
						console.log(rsp);
					}
				});
			}
		</script>

		<div class="main_body">
			<label>DAFARM에서 상품등록 5개 이상 가능 및 프리미엄 관리 페이지 사용 가능</label> <label>12,000원/월
				* VAT 포함 * 취소 불가</label>
			<div class="main_btn">
				<button class="registBtn" onclick="requestPay()">DAFARM
					Premium 가입</button>
			</div>
		</div>

	</main>
</body>
</html>