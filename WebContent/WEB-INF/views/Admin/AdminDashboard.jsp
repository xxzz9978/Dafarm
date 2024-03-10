<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8" />
<!-- 인터넷 설정 -->
<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
<!-- 반응형 웹페이지 설정(Bootstrap) -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<!-- 위의 탭 이름 설정 -->
<title>다팜 | 대시보드</title>
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
<script
	src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>
<!-- 위의 탭 아이콘 -->
<link rel="icon"
	href="${path}/resources/Admin_Resources/assets/img/main_image.png" />
<!-- 스타일 -->
<link href="${path}/resources/Admin_Resources/css/styles.css"
	rel="stylesheet" />
<link
	href="${path}/resources/Admin_Resources/css/DashboardProgressbar.css"
	rel="stylesheet" />
<!-- 폰트 설정 -->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- 차트 설정 -->
<script src="${path }/resources/Admin_Resources/js/dashboard_chart.js"></script>
</head>
<!-- body -->
<body class="sb-nav-fixed">
	<jsp:include page="include/AdminTopbar.jsp" />
	<!-- 사이드바 전체적인 큰 틀 -->
	<div id="layoutSidenav">
		<!-- 사이드바 틀 -->
		<div id="layoutSidenav_nav">
			<jsp:include page="include/AdminSidebar.jsp" />
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">대시보드</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">대시보드</li>
					</ol>
					<div class="row">
						<div class="col-xl-3 col-lg-6 mb-4">
							<!-- 수익 -->
							<div class="bg-white rounded-lg p-5 shadow">
								<h2 class="h6 font-weight-bold text-center mb-4">수익</h2>

								<!-- Progress bar 1 -->
								<div class="progress mx-auto" data-value='80'>
									<span class="progress-left"> <span
										class="progress-bar border-primary"></span>
									</span> <span class="progress-right"> <span
										class="progress-bar border-primary"></span>
									</span>
									<div
										class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
										<div class="h2 font-weight-bold">
											80<sup class="small">%</sup>
										</div>
									</div>
								</div>
								<!-- END -->

								<!-- Demo info -->
								<div class="row text-center mt-4">
									<div class="col-6 border-right">
										<div class="h4 font-weight-bold mb-0">28%</div>
										<span class="small text-gray">전 주</span>
									</div>
									<div class="col-6">
										<div class="h4 font-weight-bold mb-0">60%</div>
										<span class="small text-gray">전 달</span>
									</div>
								</div>
								<!-- END -->
							</div>
						</div>
						<!-- 방문자 수 -->
						<div class="col-xl-3 col-lg-6 mb-4">
							<div class="bg-white rounded-lg p-5 shadow">
								<h2 class="h6 font-weight-bold text-center mb-4">방문자 수</h2>

								<!-- Progress bar 2 -->
								<div class="progress mx-auto" data-value='25'>
									<span class="progress-left"> <span
										class="progress-bar border-danger"></span>
									</span> <span class="progress-right"> <span
										class="progress-bar border-danger"></span>
									</span>
									<div
										class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
										<div class="h2 font-weight-bold">
											25<sup class="small">%</sup>
										</div>
									</div>
								</div>
								<!-- END -->

								<!-- Demo info-->
								<div class="row text-center mt-4">
									<div class="col-6 border-right">
										<div class="h4 font-weight-bold mb-0">28%</div>
										<span class="small text-gray">전 주</span>
									</div>
									<div class="col-6">
										<div class="h4 font-weight-bold mb-0">60%</div>
										<span class="small text-gray">전 달</span>
									</div>
								</div>
								<!-- END -->
							</div>
						</div>
						<!-- 거래량 -->
						<div class="col-xl-3 col-lg-6 mb-4">
							<div class="bg-white rounded-lg p-5 shadow">
								<h2 class="h6 font-weight-bold text-center mb-4">거래량</h2>

								<!-- Progress bar 3 -->
								<div class="progress mx-auto" data-value='76'>
									<span class="progress-left"> <span
										class="progress-bar border-success"></span>
									</span> <span class="progress-right"> <span
										class="progress-bar border-success"></span>
									</span>
									<div
										class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
										<div class="h2 font-weight-bold">
											76<sup class="small">%</sup>
										</div>
									</div>
								</div>
								<!-- END -->

								<!-- Demo info -->
								<div class="row text-center mt-4">
									<div class="col-6 border-right">
										<div class="h4 font-weight-bold mb-0">28%</div>
										<span class="small text-gray">전 주</span>
									</div>
									<div class="col-6">
										<div class="h4 font-weight-bold mb-0">60%</div>
										<span class="small text-gray">전 달</span>
									</div>
								</div>
								<!-- END -->
							</div>
						</div>

						<div class="col-xl-3 col-lg-6 mb-4">
							<div class="col-xl-12" style="height: 100%;">
								<!-- 수정된 부분 -->
								<div class="p-3 pt-4 shadow" style="height: 100%;">
									<!-- 카드 테두리 없애고 수정 -->
									<h2 class="h6 font-weight-bold text-center mt-3 mb-4">최근거래내역</h2>
								
									<div class="row">
										
										<div class="col-12">
											<!-- 수정된 부분 -->
											<div class="card border-0">
												<!-- 테두리 없애고 수정 -->
												<div class="card-body">
												<c:forEach var="order" items="${orderList }" varStatus="status">
													<h5 class="card-title fs-6 fw-bold">
														<a href="${path}/Admin/trade/AdminTradeLogInfo?order_number=${order.order_number}">주문번호 : ${order.order_number}</a>
														</h5>
													<p class="card-text fs-6 mb-1">
														판매자 : No.${order.seller_num } / 구매자 : No.${order.user_num }
														</p>
													<p class="card-text fs-6 mb-0">
													거래금액 : <fmt:formatNumber value="${profitList[status.index].seller_profit }" pattern='#,###'/> 원
														</p>
												</c:forEach>
												</div>
											</div>
										</div>
									
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header" style="background-color: #008748; color: white;">
									<i class="fas fa-chart-area me-1"></i> 총 수익
								</div>
								<div class="card-body">
									<canvas id="revenue_total_chart" width="100%" height="40"></canvas>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header" style="background-color: #008748; color: white;">
									<i class="fas fa-chart-bar me-1"></i> 판매자 가입자 수
								</div>
								<div class="card-body">
									<canvas id="seller_count_chart" width="100%" height="40"></canvas>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header"
									style="background-color: #008748; color: white;">
									<i class="fas fa-cart-shopping me-1"></i> <a href="${path}/Admin/table/AdminBuyerTables" style="color:white;">구매자 정보</a>
								</div>
								<div class="card-body">
									<table id="buyertablesSimple">
										<thead>
											<tr>
												<th>회원번호</th>
												<th>이름</th>
												<th>아이디</th>
												<th>　</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>회원번호</th>
												<th>이름</th>
												<th>아이디</th>
												<th>　</th>
											</tr>
										</tfoot>
										<tbody>

											<c:forEach var="user" items="${userList}">
												<tr>
													<td>${user.user_num}</td>
													<td>${user.user_name}</td>
													<td>${user.user_id}</td>
													<td><a href="${path}/Admin/table/AdminBuyerInfo?user_num=${user.user_num}" class="btn btn-primary btn-sm">정보 수정/삭제</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header"
									style="background-color: #008748; color: white;">
									<i class="fas fa-store me-1"></i> <a href="${path}/Admin/table/AdminSellerTables" style="color:white;">판매자 정보</a>
								</div>
								<div class="card-body">
									<table id="sellertablesSimple">
										<thead>
											<tr>
												<th>회원번호</th>
												<th>이름</th>
												<th>아이디</th>
												<th>　</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>회원번호</th>
												<th>이름</th>
												<th>아이디</th>
												<th>　</th>
											</tr>
										</tfoot>

										<tbody>
											<c:forEach var="seller" items="${sellerList}">
												<tr>
													<td>${seller.seller_num}</td>
													<td>${seller.seller_name}</td>
													<td>${seller.seller_id}</td>
													<td><a href="${path}/Admin/table/AdminSellerInfo?seller_num=${seller.seller_num}" class="btn btn-primary btn-sm">정보 수정/삭제</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 mt-auto">
				<jsp:include page="include/AdminFooter.jsp" />
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${path}/resources/Admin_Resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		
	</script>
	<script
		src="${path}/resources/Admin_Resources/assets/demo/chart-bar-demo.js"></script>
	<script
		src="${path}/resources/Admin_Resources/assets/demo/chart-pie-demo.js"></script>
	<script
		src="${path}/resources/Admin_Resources/js/simple-datatables.min.js"></script>
	<script
		src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>
</body>

</html>