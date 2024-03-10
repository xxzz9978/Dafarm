<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>다팜 | 차트</title>
<link href="${path}/resources/Admin_Resources/css/styles.css"
	rel="stylesheet" />
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"
	integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c="
	crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<!-- DatePicker -->
<link href="${path}/resources/Admin_Resources/css/DatepickerStyle.css"
	rel="stylesheet" />
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
					<h1 class="mt-4">차트</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="${path}/Admin/AdminDashboard">메인</a></li>
						<li class="breadcrumb-item active">차트</li>
					</ol>
					<div class="card mb-4 mt-3">
						<div
							class="card-header d-flex justify-content-between align-items-center">
							<!-- 좌측에 아이콘과 텍스트 정렬 -->
							<div class="d-flex align-items-center">
								<div class="mb-0 row">
									<div class="col startDate">
										<input type="text" id="startDatepicker" class="form-control"
											style="width=120px; text-align: center;">
									</div>
									<div class="col endDate">
										<input type="text" id="endDatepicker" class="form-control"
											style="width=120px; text-align: center;">
									</div>
									<div class="col">
										<button class="btn btn-sm" id="dateApplyBtn" style="margin-top:2px">
											<i class="me-1 align-middle"></i> 적용
										</button>
									</div>
								</div>
							</div>
							<!-- 우측에 버튼 그룹 정렬 -->
						</div>
						<div class="card-body">
							<canvas id="myChart" width="100%" height="30"></canvas>
						</div>
						<div class="card-footer small text-muted">
							<div class="d-flex justify-content-between align-items-center">
								<div class="chart-buttons-left">
									<button class="btn btn-sm" id="weeklyChartButton">
										<i class="me-1 align-middle"></i> 주간
									</button>
									<button class="btn btn-sm" id="monthlyChartButton">
										<i class="me-1 align-middle"></i> 월간
									</button>
								</div>
								<div class="chart-buttons-right">
									<button class="btn btn-sm" onclick="" id="barChartButton">
										<i class="me-1 align-middle"></i> 바
									</button>
									<button class="btn btn-sm" onclick="" id="areaChartButton">
										<i class="me-1 align-middle"></i> 에어리어
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<div class="container mt-2 mb-4">
				<div class="d-flex">
					<div class="card flex-grow-1 col-lg-4">
						<div class="card-header d-flex justify-content-center">사이트</div>
						<div class="card-body">
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input
										class="form-check-input site-checkbox additional-checkbox"
										type="checkbox" value="" id="revenue_total"> <label
										class="form-check-label" for="revenue_total"> 총 수익 </label>
								</div>
							</div>
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input class="form-check-input site-checkbox" type="checkbox"
										value="" id="revenue_commission"> <label
										class="form-check-label" for="revenue_commission"> 수수료 수익 </label>
								</div>
							</div>
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input class="form-check-input site-checkbox" type="checkbox"
										value="" id="revenue_advertising"> <label
										class="form-check-label" for="revenue_advertising"> 광고 수익 </label>
								</div>
							</div>
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input class="form-check-input site-checkbox" type="checkbox"
										value="" id="revenue_membership"> <label
										class="form-check-label" for="revenue_membership"> 멤버쉽 수익
									</label>
								</div>
							</div>
						</div>
					</div>

					<div class="card flex-grow-1 mx-4 col-lg-4">
						<div class="card-header d-flex justify-content-center">구매자</div>
						<div class="card-body">
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input class="form-check-input buyer-checkbox" type="checkbox"
										value="" id="buyerCount"> <label
										class="form-check-label" for="buyerCount"> 구매자 회원수
									</label>
								</div>
							</div>
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input
										class="form-check-input buyer-checkbox additional-checkbox"
										type="checkbox" value="" id="buyerCheckbox2"> <label
										class="form-check-label" for="buyerCheckbox2"> 추가항목1 </label>
								</div>
							</div>
						</div>
					</div>

					<div class="card flex-grow-1 col-lg-4">
						<div class="card-header d-flex justify-content-center">판매자</div>
						<div class="card-body">
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input class="form-check-input seller-checkbox" type="checkbox"
										value="" id="sellerCount"> <label
										class="form-check-label" for="sellerCount"> 판매자
										회원수 </label>
								</div>
							</div>
							<div class="card-body d-flex justify-content-center">
								<div class="form-check">
									<input
										class="form-check-input seller-checkbox additional-checkbox"
										type="checkbox" value="" id="sellerProfit"> <label
										class="form-check-label" for="sellerProfit"> 전체 판매자 수익
									</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="py-4 bg-light mt-auto">
				<jsp:include page="../include/AdminFooter.jsp" />
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src ="${path }/resources/Admin_Resources/js/chart.js"></script>
	
</body>
</html>
