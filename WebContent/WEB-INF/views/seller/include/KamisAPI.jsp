<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
Date date = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
String today = sf.format(date);
sf = new SimpleDateFormat("MM.dd");
today = sf.format(date);
%>
<body>
	<table>
		<thead>
			<tr>
				<th>품목</th>
				<th>단위</th>
				<th>가격(<%=today%>)
				</th>
				<th>등락률</th>
				<th>전일</th>
				<th>1개월전</th>
				<th>1년전</th>
			</tr>
		</thead>
		<thead>
			<c:forEach var='price' items='${kamisAPIBean.price }'>
				<tr>
					<th>${price.productName}</th>
					<th>${price.unit }</th>
					<th>${price.dpr1 }</th>
					<c:choose>
						<c:when test="${price.value > 0.0 }">
							<th>${price.value }
							<img src="${path }/resources/img/red_triangle.png" style="width:10px">
							</th>
						</c:when>
						<c:otherwise>
							<th>${price.value = 0.0 }
							<img src="${path }/resources/img/blue_triangle.png" style="width:10px">
							</th>
						</c:otherwise>
					</c:choose>
					<th>${price.dpr2 }</th>
					<th>${price.dpr3 }</th>
					<th>${price.dpr4 }</th>
				</tr>
			</c:forEach>

		</thead>
	</table>
</body>
</html>