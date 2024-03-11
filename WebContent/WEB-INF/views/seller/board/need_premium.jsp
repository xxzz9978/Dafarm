<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value="${pageContext.request.contextPath }/"/>
<script>
	alert("프리미엄 회원 맴버쉽 가입이 필요합니다.");
	location.href = "${path}seller/board/addPremium"
</script>