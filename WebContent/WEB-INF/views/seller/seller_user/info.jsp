<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAFARM : 회원 정보</title>
<link rel="stylesheet"
	href="${path }resources/seller_style/SellerInfoPage.css">
<script src="//code.jquery.com/jquery.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<div class="SellerInfo">
					<h1>판매자 회원 정보</h1>

					<form:form method="post"
						action="${path }seller/seller_user/modify_pro"
						modelAttribute="modifySellerBean">
						<div class="BasicTitle">기본 정보</div>
						<div class="BasicInfo">
							판매자 이름
							<form:input path="seller_name" class="SellerName info"
								readonly="readonly" />
						</div>
						<div class="BasicInfo">
							아이디
							<form:input path="seller_id" class="SellerId info"
								readonly="readonly" />
						</div>
						<div class="BasicInfo">
							비밀번호
							<form:input path="seller_password" class="SellerPassword info" />
						</div>
<%-- 					필요한 부분인지 의문
						<div class="BasicInfo">
							비밀번호 확인
							<form:input path="seller_password_check"
								class="SellerPassword info" />
							<form:errors path="seller_password_check" style="color:red" />
						</div>
	 --%>					
						<div class="BasicInfo">
							핸드폰 번호
							<form:input path="seller_phone" class="SellerPhone info "/>
						</div>

						<div class="BasicInfo">
							이메일
							<form:input path="seller_email" class="SellerEmail info" />
							<!-- 이메일 인증 할 건지 확인할 것 -->
						</div>
						<div class="BasicInfo">
							주소
							<form:input path="seller_address" class="SellerAddress info"
								readonly="readonly" />
						</div>

						<div class="ShopInfo">사업자 정보</div>

						<div class="BasicInfo">
							사업자명
							<form:input path="business_name" type="text" class="info"
								readonly="readonly" />
						</div>
						<div class="BasicInfo">
							사업자 번호
							<form:input path="business_number" type="text" class="info"
								readonly="readonly" />
						</div>
						<div class="BasicInfo">
							통신판매업신고
							<form:input path="business_report" type="text" class="info"
								readonly="readonly" />
						</div>
						<div class="SellerAccount">
							사업자계좌번호
							<form:input path="business_account" type="text" class="info"
								readonly="readonly" />
						</div>
						<form:button class="EditButton">수정하기</form:button>
					</form:form>
				</div>
			</main>
		</article>
	</section>
</body>
</html>