<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/" />
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>DAFARM</title>
<!-- CSS -->
<link rel="stylesheet" href="${path}resources/user_style/trade_information.css">
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<link rel="stylesheet" href="${path}resources/user_style/styles.css" />
<!-- JQuery -->
<script src="${path}resources/js/jquery-3.7.1.min.js"></script>
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
<!-- FontAwesome -->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/users/include/top.jsp" />
	<div id="layoutSidenav_content">
	<div class="container-fluid px-4">
		<div class="card mb-4">
			<div class="card-body">
				<div class="table_price">
				<h1>배송 정보</h1>
					<table id="market_price">
						<thead>
							<tr>
								<th>주문 번호</th>
								<th>물품 이름</th>
								<th>판매자</th>
								<th>주문 일자</th>
								<th>배송 업체</th>
								<th>송장 번호</th>
								<th>배송 현황</th>
							</tr>
						</thead>	
						<tfoot>
							<tr>
								<th>주문 번호</th>
								<th>물품 이름</th>
								<th>판매자</th>
								<th>주문 일자</th>
								<th>배송 업체</th>
								<th>송장 번호</th>
								<th>배송 현황</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="info" items="${information_list}">
								<tr>
									<td>${info.order_number }</td>
									<td>${info.item_name }</td>
									<td>${info.seller_name }</td>
									<td>${info.order_date.substring(0, 10) }</td>
									<td>${info.delivery_company }</td>
									<td>${info.delivery_number }</td>
									<td>${info.order_status }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
