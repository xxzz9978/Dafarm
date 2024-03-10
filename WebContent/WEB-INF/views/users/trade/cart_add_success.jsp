<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value="${pageContext.request.contextPath }/"/>
<script>
	alert("해당 상품을 장바구니에 담았습니다.");
	location.href = "${path}users/trade/order_list"
</script>