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
<link rel="stylesheet"
	href="${path}resources/user_style/trade_order_list.css">
<link rel="stylesheet"
	href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet"
	href="${path}resources/user_style/include_bottom.css" />
<link rel="stylesheet" href="${path}resources/user_style/styles.css" />
<!-- JQuery -->
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/users/include/top.jsp" />
	<div id="layoutSidenav_content">
		<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-body">
							<h1 class="mt-2">상세 정보 페이지</h1>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th class="align-middle text-center">이미지</th>
										<td width="400px" height="400px"><img src="${path }resources/upload/${product_info.product_image}" width="400px" height="400px"/></td>
									</tr>
									<tr>
										<th class="align-middle text-center">상품명</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" name="name1"
											value="${product_info.product_name }" readonly></td>
										<th class="align-middle text-center">상품 가격</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" name="name1"
											value="${product_info.product_price }" readonly>
										</td>
									</tr>
									<tr>
										<th class="align-middle text-center">상품 무게</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" name="number"
											value="${product_info.product_weight }" readonly></td>
										<th class="align-middle text-center">상품 갯수</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" name="quantity"
											value="${product_info.product_quantity }"></td>
									</tr>
									<tr>
										<th colspan="2" class="align-middle text-center">상품 설명</th>
										<th colspan="2" class="align-middle text-center">상품 등록일</th>
									</tr>
									<tr>
										<td colspan="2" class="align-middle text-center"><input type="email"
											class="form-control border-0" name="email"
											value="${product_info.product_description }"  readonly></td>
										<td colspan="2" class="align-middle text-center"><input type="text"
											class="form-control border-0" name="id"
											value="${product_info.product_date.substring(0, 10)}" readonly></td>
									</tr>
								</tbody>
							</table>
							<div class="row text-center">
								<div class="col-sm-8 offset-sm-2">
								<a href="${path}users/trade/cart_add?
										user_num=${loginUserBean.user_num}&user_name=${loginUserBean.user_name}&
										product_name=${product_info.product_name}&product_price=${product_info.product_price}&
										product_weight=${product_info.product_weight}&product_quantity=${product_info.product_quantity}&
										product_date=${product_info.product_date.substring(0, 10)}&product_writer_num=${product_info.product_writer_num}&
										product_idx=${product_info.product_idx}"
										class="btn btn-primary"
										style="background-color: #008748; color: white;">장바구니 담기</a></td>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>
</html>