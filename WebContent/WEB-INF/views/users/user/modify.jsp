<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}resources/user_style/user_modify.css">
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<title>DAFARM</title>
<!-- 회원 정보 수정 뷰단 -->
</head>
<body>
    <div class="container">
        <div class="top">
            <c:import url="/WEB-INF/views/users/include/top.jsp" />
        </div>
        <div class="main">
        
            <form:form action="${path}users/user/modify_pro" method="post" class="info_modify_form" modelAttribute="modifyUserBean">
                <div class="user_info_form">
                    <h2>회원 정보 수정</h2>
                    <div class="user_info_modify_form">
                        <ul id="user_modify_form">
                       	 	<li class="user_name">
                                <form:label path="user_name"><h3>이름</h3></form:label>
                                <form:input path="user_name" name="user_name" readonly="true"/>
                            </li>
                            <li class="user_id">
                                <form:label path="user_id"><h3>아이디</h3></form:label>
                                <form:input path="user_id" name="user_id" readonly="true"/>
                            </li>
                            <li class="user_password">
								<form:label path="user_password"><h3>비밀번호</h3></form:label>
								<form:password path="user_password" name="user_password" placeholder="8~16자리 / 영문, 숫자 조합"/>
								<br />
                               	<form:errors path="user_password" style='color:red; font-size:12px;'/>
                            </li>
                            <li class="user_password_check">
                                <form:label path="user_password_check"><h3>비밀번호 확인</h3></form:label>
								<form:password path="user_password_check" name="user_password_check" placeholder="8~16자리 / 영문, 숫자 조합"/>
								<br />
                               	<form:errors path="user_password_check" style='color:red; font-size:12px;'/>
                            </li>
                            <li class="user_phone">
                            	<form:label path="user_phone"><h3>전화번호</h3></form:label>
								<form:input path="user_phone" name="user_phone" placeholder="'-' 빼고 숫자만 입력"/>
								<br />
                               	<form:errors path="user_phone" style='color:red; font-size:12px;'/>
                            </li>
                            <li class="user_email">
                           		<form:label path="user_email"><h3>이메일</h3></form:label>
								<form:input path="user_email" name="user_email" placeholder="team24@dafarm.com"/>
								<br />
                               	<form:errors path="user_email" style='color:red; font-size:12px;'/>
                            </li>
                            <li class="user_address">
                            	<form:label path="user_address"><h3>주소</h3></form:label>
								<form:input path="user_address" name="address_detail" id="address_kakao_modify" placeholder=" - "/>
								<br />
                               	<form:errors path="user_address" style='color:red; font-size:12px;'/>
                            </li>
                            <li class="submit">
                            	<form:button>정보수정</form:button>
                            </li>
                        </ul>
                    </div>
                </div>
            </form:form>

        </div>
        </div>

   <div class="bottom">
      <c:import url="/WEB-INF/views/users/include/bottom.jsp" />
   </div>
</body>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	    

<script>
	/* 회원 정보 주소 수정용 카카오맵 */
	$(document).on('click', "#address_kakao_modify", function(){
		//카카오 지도 발생
		new daum.Postcode({
			oncomplete:function(data){ //선택시 입력값 세팅
				document.getElementById("address_kakao_modify").value = data.address; // 주소 넣기
				documetn.querySelector("input[name=address_detail]").focus(); // 상세입력 포커싱
			}
		}).open();
	});
	
</script>
</html>