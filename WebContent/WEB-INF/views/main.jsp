<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>DAFARM</title>
<!-- CSS -->
<link rel="stylesheet" href="${path}resources/user_style/main.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<link rel="stylesheet" href="${path}resources/user_style/styles.css" />
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"
integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c="
crossorigin="anonymous"></script>
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
</head>
<%
Date date = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
String today = sf.format(date);
sf = new SimpleDateFormat("MM.dd");
today = sf.format(date);
%>
<body class="sb-nav-fixed">
	<div class="wrap">
		<div class="intro_bg">
			<div class="top">
				<c:import url="/WEB-INF/views/users/include/top.jsp" />
			</div>
			<!-- advertisement -->
			<div class="advertisement">
				<div class="advertisement_content">
					<c:import url="/WEB-INF/views/users/include/advertisement.jsp" />
				</div>
			</div>
		</div>
	
		<!--intro end-->
		<ul class="amount">
			<li>
				<div>
					<div class="contents_1">${kamisAPIBean.price[randomNum0].productName}</div>
					<div class="contents_2">${kamisAPIBean.price[randomNum0].unit} / ${kamisAPIBean.price[randomNum0].dpr1 } 원</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents_1">${kamisAPIBean.price[randomNum1].productName}</div>
					<div class="contents_2">${kamisAPIBean.price[randomNum1].unit} / ${kamisAPIBean.price[randomNum1].dpr1 } 원</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents_1">${kamisAPIBean.price[randomNum2].productName}</div>
					<div class="contents_2">${kamisAPIBean.price[randomNum2].unit} / ${kamisAPIBean.price[randomNum2].dpr1 } 원</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents_1">${kamisAPIBean.price[randomNum3].productName}</div>
					<div class="contents_2">${kamisAPIBean.price[randomNum3].unit} / ${kamisAPIBean.price[randomNum3].dpr1 } 원</div>
				</div>
			</li>
		</ul>
		<!--amount end-->
		<div id="layoutSidenav_content">
			<div class="container-fluid px-4">
				<div class="card mb-4">
					<div class="card-body">
						<div class="table_price">
							<h3><%=today%> 기준 시세표</h3>
							<table id="market_price">
								<thead>
									<tr>
										<th>품목</th>
										<th>단위</th>
										<th>가격 (원)
										</th>
										<th>등락률</th>
										<th>전일</th>
										<th>1개월전</th>
										<th>1년전</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>품목</th>
										<th>단위</th>
										<th>가격 (원)
										</th>
										<th>등락률</th>
										<th>전일</th>
										<th>1개월전</th>
										<th>1년전</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var='price' items='${kamisAPIBean.price }'>
										<c:if
											test="${not empty price.category_name and not (price.category_name eq '축산물' or price.category_name eq '수산물')}">
											<tr>
												<td>${price.productName}</td>
												<td>${price.unit }</td>
												<td>${price.dpr1 }</td>
												<c:choose>
													<c:when
														test="${not empty price.value and price.value ne '-' and price.value gt 0.0}">
														<td>${price.value}<img
															src="${path}resources/img/red_triangle.png"
															style="width: 10px"></td>
													</c:when>
													<c:otherwise>
														<td>0.0<img
															src="${path}resources/img/blue_triangle.png"
															style="width: 10px"></td>
													</c:otherwise>
												</c:choose>
												<td>${price.dpr2 }</td>
												<td>${price.dpr3 }</td>
												<td>${price.dpr4 }</td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="py-4 bg-light mt-auto">
		<c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	</footer>
	<!-- Bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="${path}resources/user_script/simple-datatables.min.js"></script>
	<script src="${path}resources/user_script/datatables-simple.js"></script>
</body>

</html>