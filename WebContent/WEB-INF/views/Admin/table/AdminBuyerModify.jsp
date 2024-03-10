<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>다팜 | 회원 상세 정보/수정</title>
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
<script src="${path}/resources/Admin_Resources/js/buyer_modify.js"></script>
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
						<h1 class="mt-4">구매자 상세 정보</h1>
						<ol class="breadcrumb mb-4">
							<li class="breadcrumb-item"><a
								href="${path}/Admin/AdminDashboard">메인</a></li>
							<li class="breadcrumb-item active"><a
								href="${path}/Admin/table/AdminBuyerTables">구매자 정보</a></li>
							<li class="breadcrumb-item active">구매자 상세 정보/수정</li>
						</ol>
						<div class="card mb-4">
							<div class="card-header"
								style="background-color: #008748; color: white;">
								<i class="fas fa-user-edit"></i> 구매자 정보 수정
							</div>
							<div class="card-body">
								<form:form action="${path}/Admin/table/AdminBuyerModify_pro"
									onsubmit="return buyer_modify(event)" method="post" 
									modelAttribute="adminUserBean">
									<table class="table">
										<tbody>
											<tr>
												<th colspan="4" class="align-middle text-center card-header"
												style="background-color: #008748; color: white;">구매자 정보</th>
											</tr>
											<tr>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(255, 0, 0, 0.2);">회원번호</th>
												<td class="align-middle text-center"><form:input
														class="form-control border-0" path="user_num"
														readonly="true" /></td>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(255, 0, 0, 0.2);">가입일</th>
												<td class="align-middle text-center border-end"><form:input
														class="form-control border-0" path="user_access_date"
														readonly="true" /></td>
											</tr>
											<tr>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(0, 255, 0, 0.2);">이름</th>
												<td class="align-middle text-center"><form:input
														class="form-control border-0" path="user_name"/></td>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(0, 255, 0, 0.2);">전화번호</th>
												<td class="align-middle text-center border-end"><form:input
														class="form-control border-0" path="user_phone" /></td>

											</tr>
											<tr>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(0, 255, 0, 0.2);">이메일</th>
												<td class="align-middle text-center"><form:input
														class="form-control border-0" path="user_email" /></td>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(0, 255, 0, 0.2);">주소</th>
												<td class="align-middle text-center border-end"><form:input
														class="form-control border-0" path="user_address" /></td>
											</tr>
											<tr>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(255, 0, 0, 0.2);">아이디</th>
												<td class="align-middle text-center"><form:input
														class="form-control border-0" path="user_id" readonly="true"/></td>
												<th class="align-middle text-center border-start border-end"
												style="background-color:rgba(0, 255, 0, 0.2);">비밀번호</th>
												<td class="align-middle text-center border-end"><form:input
														class="form-control border-0" path="user_password" /></td>
											</tr>
											
										<tr>
										<th class="align-middle text-center border-start border-end" style="background-color:rgba(255, 0, 0, 0.2)">구매횟수</th>
										<td class="align-middle text-center"><input type="text"
											class="form-control border-0"
											value="${adminProfitBean.orderCount } 건" readonly></td>
										<th class="align-middle text-center border-start border-end" style="background-color:rgba(255, 0, 0, 0.2)">사용금액 합계</th>
										<td class="align-middle text-center border-end"><input type="text"
											class="form-control border-0"
											value="<fmt:formatNumber value='${adminProfitBean.totalProfit}' pattern='#,###'/> 원" readonly></td>
									</tr>
										
									</table>
									<div class="row text-center">
										<div class="col-sm-8 offset-sm-2">
											<a class="btn btn-primary"
												style="background-color: #FF0004; border-color: black; color: LE;"
												onclick="location.href='${path}/Admin/table/AdminBuyerInfo?user_num=${adminUserBean.user_num }'">취소</a>
											<form:button type="submit" class="btn btn-primary"
												style="background-color: #008748; border-color: black; color: white;"
												onclick="buyer_modify(event, ${adminUserBean.user_num})">저장</form:button>
										</div>
									</div>
								</form:form>
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
