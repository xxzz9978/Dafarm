<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}resources/user_style/user_join.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<script src="${path}/resources/user_script/jquery-3.7.1.min.js"></script>
<title>DAFARM</title>
<script>
// User가 중복 확인 버튼 클릭했을 때
function checkUserIdExist(){
	var user_id = $("#user_id").val()
	console.log(user_id)
	if(user_id.length == 0){
		alert('아이디를 입력해주세요.')
		return
	}
	$.ajax({
		url : '${path}users/user/checkUserIdExist/' + user_id,
		type : 'get',
		dataType : 'text',
		success : function(result){
			if(result.trim() == 'true'){
				alert('사용할 수 있는 아이디 입니다.')
				$("#userIdExist").val('true')
			}else{
				alert('사용할 수 없는 아이디 입니다.')
				$("#userIdExist").val('false')
			}
		}
	})
}

// User 아이디란에 입력하면 무조건 false (초기 Reset)
function resetUserIdExist(){
	$("#userIdExist").val('false')
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
					<form:form action="${path}users/user/join_pro_user" method="post" modelAttribute="joinUserBean" class="user_join_form">
						<!-- 유효성 검사 여부 보내기 -->
						<form:hidden path="userIdExist"/>
						<ul id="user_join_form">
							<li class="user_id">
								<form:label path="user_id">아이디</form:label> <br />
          						<form:input path="user_id" placeholder="8~20자리 / 영문, 숫자 사용가능" onkeypress="resetUserIdExist()"/>
								<button type="button" id="user_id_check_dupli" onclick="checkUserIdExist()">중복확인</button>
								<form:errors path="user_id" style='color:red; font-size:10px;'/>
							</li>
							<li class="user_password">
								<form:label path="user_password">비밀번호</form:label>
       							<form:password path="user_password" placeholder="8~20자리 / 영문, 숫자 조합"/>
       							<form:errors path='user_password' style='color:red; font-size:10px;'/>
							</li>
							<li class="user_password_check">
								<form:label path="user_password_check">비밀번호 확인</form:label>
       							<form:password path="user_password_check" placeholder="비밀번호 확인"/>
       							<form:errors path='user_password_check' style='color:red; font-size:10px;'/>
							</li>
							<li class="user_name">
								<form:label path="user_name">이름</form:label>
      							<form:input path="user_name" placeholder="이름 입력"/>
    							<form:errors path="user_name" style='color:red; font-size:10px;'/>
							</li>
							<li class="user_phone">
								<form:label path="user_phone">전화번호</form:label>
      							<form:input path="user_phone" placeholder="'-' 빼고 숫자만 입력" />
    							<form:errors path="user_phone" style='color:red; font-size:10px;'/>
							</li>
							<li class="user_email">
								<form:label path="user_email">이메일</form:label>
      							<form:input path="user_email" placeholder="team24@dafarm.com" />
    							<form:errors path="user_email" style='color:red; font-size:10px;'/>
							</li>
							<li class="user_address">
								<form:label path="user_address">주소</form:label>
      							<form:input path="user_address" id="address_kakao_user" placeholder=" - " />
    							<form:errors path="user_address" style='color:red; font-size:10px;'/>
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
/* User 주소 검색 팝업 script */   
$(document).on('click', "#address_kakao_user", function(){
    //카카오 지도 발생
    new daum.Postcode({
        oncomplete:function(data){ //선택시 입력값 세팅
            document.getElementById("address_kakao_user").value = data.address; // 주소 넣기
        }
    }).open({
        autoClose: true // 검색 결과 선택 후 자동으로 팝업 닫기
    });
});
</script>

</body>
</html>