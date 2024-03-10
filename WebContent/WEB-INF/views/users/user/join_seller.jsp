<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}resources/user_style/user_join_seller.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<title>DAFARM</title>
<script>
// Seller가 중복 확인 버튼 클릭했을 때
function checkSellerIdExist(){
	var seller_id = $("#seller_id").val()
	if(seller_id.length == 0){
		alert('아이디를 입력해주세요.')
		return
	}
	$.ajax({
		url : '${path}users/user/checkSellerIdExist/' + seller_id,
		type : 'get',
		dataType : 'text',
		success : function(result){
			if(result.trim() == 'true'){
				alert('사용할 수 있는 아이디 입니다.')
				$("#sellerIdExist").val('true')
			}else{
				alert('사용할 수 없는 아이디 입니다.')
				$("#sellerIdExist").val('false')
			}
		}
	})
}

// Seller 아이디란에 입력하면 무조건 false (초기 Reset)
function resetsellerIdExist(){
	$("#sellerIdExist").val('false')
}
</script>
</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="top">
				<c:import url="/WEB-INF/views/users/include/top.jsp" />
			</div>
			
			<!-- 회원가입 영역 -->
			
			<div class="join_area">
				<div class="join_enter_area">
		
					
				<div class="switch_join_form">
					<a href="${path}users/user/join" id="switch_user_join">
					<br />
						구매자 회원가입
					</a>
					<a href="${path}users/user/join_seller" id="switch_seller_join">
					<br />
						판매자 회원가입
					</a>
				</div>
				
					<!-- 구매자 회원가입 FORM -->
					<form:form action="${path}users/user/join_pro_seller" method="post" modelAttribute="joinSellerBean" class="seller_join_form">
						<!-- 유효성 검사 여부 보내기 -->
						<form:hidden path="sellerIdExist"/>
						<ul id="seller_join_form">
							<li class="seller_id">
								<form:label path="seller_id">아이디</form:label> <br />
          						<form:input path="seller_id" placeholder="8~20자리 / 영문, 숫자 사용가능" onkeypress="resetSellerIdExist()"/>
								<button type="button" id="seller_id_check_dupli" onclick="checkSellerIdExist()">중복확인</button>
								<form:errors path="seller_id" style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_password">
								<form:label path="seller_password">비밀번호</form:label>
       							<form:password path="seller_password" placeholder="8~20자리 / 영문, 숫자 조합"/>
       							<form:errors path='seller_password' style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_password_check">
								<form:label path="seller_password_check">비밀번호 확인</form:label>
       							<form:password path="seller_password_check" placeholder="비밀번호 확인"/>
       							<form:errors path='seller_password_check' style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_name">
								<form:label path="seller_name">이름</form:label>
      							<form:input path="seller_name" placeholder="이름 입력"/>
    							<form:errors path="seller_name" style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_phone">
								<form:label path="seller_phone">전화번호</form:label>
      							<form:input path="seller_phone" placeholder="'-' 빼고 숫자만 입력" />
    							<form:errors path="seller_phone" style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_email">
								<form:label path="seller_email">이메일</form:label>
      							<form:input path="seller_email" placeholder="team24@dafarm.com" />
    							<form:errors path="seller_email" style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_address">
								<form:label path="seller_address">주소</form:label>
      							<form:input path="seller_address" id="address_kakao_seller" placeholder=" - " />
    							<form:errors path="seller_address" style='color:red; font-size:10px;'/>
							</li>
							<li class="seller_license">
								<div class="business_name">
									<form:label path="business_name">사업자명</form:label>
									<form:input path="business_name"/>
									<form:errors path="business_name" style='color:red'/>
								</div>
								<div class="business_number">
									<form:label path="business_number">사업자 번호</form:label>
									<form:input path="business_number"/>
									<form:errors path="business_number" style='color:red'/>
								</div>
								<div class="business_account">
									<form:label path="business_account">사업자 계좌번호</form:label>
									<form:input path="business_account"/>
									<form:errors path="business_account" style='color:red'/>
								</div>
								<div class="business_report">
									<form:label path="business_report">통신판매업신고</form:label>
									<form:checkbox path="business_report"/>
								</div>
							</li>
							<li class="submit">
								<form:button type="submit">회원가입</form:button>
							</li>
						</ul>
					</form:form>
			
				</div>
			</div>
			
			
		</div>
	</div>
	<!--end area-->
	<div class="bottom">
		<c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	</div>
	
<!-- 다음 지도 API 참조 및 JavaScript 구현 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	    
<!-- User & Seller 회원가입 창 전환 및 주소 입력용 KakaoMap API Script -->
<script>
$(document).on('click', "#address_kakao_seller", function(){
    //카카오 지도 발생
    new daum.Postcode({
        oncomplete:function(data){ //선택시 입력값 세팅
            document.getElementById("address_kakao_seller").value = data.address; // 주소 넣기
        }
    }).open({
        autoClose: true // 검색 결과 선택 후 자동으로 팝업 닫기
    });
}); 
</script>

</body>
</html>