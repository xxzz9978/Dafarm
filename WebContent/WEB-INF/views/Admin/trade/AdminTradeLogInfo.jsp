<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>다팜 | 거래 상세보기 </title>
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
<!-- DataTables -->
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="${path}/resources/Admin_Resources/js/simple-datatables.min.js"></script>
<link href="${path}/resources/Admin_Resources/css/styles.css"
	rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- SweetAlert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${path}/resources/Admin_Resources/js/seller_delete.js"></script>
</head>
<!-- body -->
<body class="sb-nav-fixed">
	<jsp:include page="../include/AdminTopbar.jsp" />
	<!-- 사이드바 전체적인 큰 틀 -->
	<div id="layoutSidenav">
		<!-- 사이드바 틀 -->
		<div id="layoutSidenav_nav">
			<jsp:include page="../include/AdminSidebar.jsp" />
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">거래 상세 정보</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a
							href="${path}/Admin/AdminDashboard">메인</a></li>
						<li class="breadcrumb-item active"><a
							href="${path}/Admin/trade/AdminTradeLog">거래내역</a></li>
						<li class="breadcrumb-item active">거래정보 상세보기</li>
					</ol>
					<div class="card mb-4">
						<div class="card-header"
							style="background-color: #008748; color: white;">
							<i class="fas fa-user-edit"></i> 거래정보
						</div>
						<div class="card-body">
							<table class="table">
								<tbody>
									<tr>
										<th colspan="4" class="align-middle text-center card-header"
										style="background-color: #008748; color: white;">판매자 정보</th>
									</tr>
									<tr>
										<th class="align-middle text-center border-start border-end">주문번호</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0"  value="${orderInfo.order_number }"
											readonly></td>
										<th class="align-middle text-center border-start border-end">진행상태</th>
										<td class="align-middle text-center border-end"><input type="text"
											class="form-control border-0" 
											value="${orderInfo.order_status }" readonly></td>
									</tr>
									<tr>
										<th class="align-middle text-center border-start border-end">주문날짜</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" value="${orderInfo.order_date }"
											readonly></td>
										<th class="align-middle text-center border-start border-end">판매금액</th>
										<td class="align-middle text-center border-end"><input type="text"
											class="form-control border-0" 
											value="${profitInfo.seller_profit }" readonly></td>

									</tr>
									<tr>
										<th class="align-middle text-center border-start border-end">판매자명</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" value="${orderInfo.seller_name }"
											readonly></td>
										<th class="align-middle text-center border-start border-end">판매자 연락처</th>
										<td class="align-middle text-center border-end"><input type="text"
											class="form-control border-0" value="${orderInfo.seller_phone }"></td>
									</tr>
									<tr>
										<th class="align-middle text-center border-start border-end">상품명</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0" value="${orderInfo.item_name }"
											readonly></td>
										<th class="align-middle text-center border-start border-end">배송회사</th>
											<td class="align-middle text-center border-end"><input type="text"
												class="form-control border-0" name="account" value="${orderInfo.delivery_company}"
												readonly></td>	
										
									</tr>
								</table>
								<table class="table">
									
										<tr>
											<th colspan="4" class="align-middle text-center card-header"
											style="background-color: #008748; color: white;">구매자 정보</th>
										</tr>
										<tr>
											<th class="align-middle text-center border-start border-end">구매자명</th>
											<td class="align-middle text-center"><input type="text"
												class="form-control border-0" value="${orderInfo.user_name }"
												readonly></td>
											<th class="align-middle text-center border-start border-end">구매자 연락처</th>
											<td class="align-middle text-center border-end"><input type="text"
												class="form-control border-0" name="account" value="${orderInfo.user_phone}"
												readonly></td>
										</tr>
										<tr>
											<th class="align-middle text-center border-start border-end">주소</th>
											<td colspan="3" class="align-middle text-center border-end"><input type="text"
												class="form-control border-0" value="${orderInfo.address }" readonly></td>
										</tr>

									</tbody>
								</table>
								
							

						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<jsp:include page="../include/AdminFooter.jsp" />
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${path}/resources/Admin_Resources/js/scripts.js"></script>
	<script
		src="${path}/resources/Admin_Resources/js/simple-datatables.min.js"></script>
	<script
		src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>

</body>
</html>
