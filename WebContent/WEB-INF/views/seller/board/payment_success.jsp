<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value="${pageContext.request.contextPath }/"/>
<script>
	alert("결제가 완료되었습니다.");
	location.href = "${path}seller/board/seller_payment_success"
</script>
