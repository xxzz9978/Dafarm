<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>DAFARM</title>
<!-- CSS -->
<link rel="stylesheet" href="${path}resources/user_style/trade_cart.css">
<link rel="stylesheet"
	href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet"
	href="${path}resources/user_style/include_bottom.css" />
<!-- JQuery -->
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
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
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script src="${path}resources/user_script/trade_cart.js"></script>
</head>
<body class="sb-nav-fixed">
	<!-- head -->
	<div class="top">
		<c:import url="/WEB-INF/views/users/include/top.jsp" />
	</div>
	<div id="layoutSidenav_content">
		<div class="container-fluid px-4">
			<div class="card mb-4">
				<div class="card-body">
					<div class="table_price">
						<h2>장바구니</h2>
						<table id="market_price">
							<thead>
								<tr>
									<th>상품 이름</th>
									<th>상품 가격 (원)</th>
									<th>상품 단위</th>
									<th>상품 수량 (개)</th>
									<th>상품 번호</th>
									<th>상품 등록 회원 번호</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>상품 이름</th>
									<th>상품 가격 (원)</th>
									<th>상품 단위</th>
									<th>상품 수량 (개)</th>
									<th>상품 번호</th>
									<th>상품 등록 회원 번호</th>
									<th></th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="cl" items="${cart_list}">
									<tr>
										<td>${cl.product_name }</td>
										<td>${cl.product_price}</td>
										<td>${cl.product_weight }</td>
										<td>${cl.product_quantity }</td>
										<td>${cl.product_idx }</td>
										<td>${cl.product_writer_num }</td>
										<td><a href="${path}users/trade/delete?cart_num=${cl.cart_num}&user_num=${cl.user_num}"
										class="btn btn-primary btn-sm">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="main_footer">
		<div class="mfooter">
			<!-- DAFARM_Market_Script파일에서 Purchase로 넘어감 -->
			<!-- <input type="button" id="Purchase" value="결제하기"> -->
			<a href="${path}users/trade/payment"> <input type="button"
				id="Purchase" value="결제하기">
			</a>
		</div>
	</div>
	<div class="bottom">
		<c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	</div>
	

	<!-- Bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="${path}resources/user_script/simple-datatables.min.js"></script>
	<script src="${path}resources/user_script/datatables-simple.js"></script>
</body>
</html>