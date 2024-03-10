<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}resources/user_style/user_login_seller.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<title>DAFARM</title>
</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="top">
				<c:import url="/WEB-INF/views/users/include/top.jsp" />
			</div>
			
			<!-- 로그인 영역 -->
			
			<div class="login_area">
				<div class="login_enter_area">
				
				<div class="switch_login_form">
					<a href="${path}users/user/login" id="switch_user_login">
					<br />
						구매자 로그인
					</a>
					<a href="${path}users/user/login_seller" id="switch_seller_login">
					<br />
						판매자 로그인
					</a>
				</div>
					<!-- 로그인 상태 -->
					<c:if test="${fail == true}">
						<div class="alert alert-danger">
							<h3>로그인 실패</h3>
							<p>아이디 비밀번호를 확인해주세요</p>
						</div>
					</c:if>
					<!-- Seller 로그인 form -->
					<form:form action="${path}users/user/login_pro_seller" method="post" modelAttribute="tempLoginSellerBean" class="seller_login_form">
						<div id="login_form">
						<div class="id">
							<form:label path="seller_id">아이디</form:label>
							<form:input path="seller_id" placeholder="판매자 회원 로그인 ID"/>
							<form:errors path="seller_id" style="color:red"/>
						</div>
						
						<div class="password">
							<form:label path="seller_password">비밀번호</form:label>
							<form:password path="seller_password" placeholder="판매자 회원 로그인 PW"/>
							<form:errors path="seller_password" style="color:red"/>
						</div>
							<form:button type="submit" id="submit_login">로그인</form:button>
						</div>
						
						<ul class="seller_account">
							<li><a href="${path}users/user/join_seller">회원가입</a></li>
						</ul>
					</form:form>
				</div>
			</div>
			<!-- 로그인 영역 -->
		</div>
	</div>
	<!--end area-->
	<div class="bottom">
				<c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	</div>
	    
<script>
	/* 
	$(document).on('click',"#switch_seller_login", function() {
		$(".user_login_form").hide();
        $(".seller_login_form").show();
        $(this).css("background-color", " rgba(0, 59, 31, 0.85)");
        $(this).css("color", "#fff");
        $("#switch_user_login").css("background-color", "#fff");
        $("#switch_user_login").css("color", "#000");
	});

	$(document).on('click',"#switch_user_login", function() {
		$(".seller_login_form").hide();
		$(".user_login_form").show();
		$(this).css("background-color", " rgba(0, 59, 31, 0.85)");
		$(this).css("color", "#fff");
		$("#switch_seller_login").css("background-color", "#fff");
		$("#switch_seller_login").css("color", "#000");
	});
	 */
</script>

</body>
</html>