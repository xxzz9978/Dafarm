<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<!-- 인터넷 설정 -->
	<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
	<!-- 반응형 웹페이지 설정(Bootstrap) -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<!-- JQuery -->
	<script
	src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	<script
	src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"
	integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c="
	crossorigin="anonymous"></script>
	<!-- sweetalert -->
	<script src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>
	<!-- DataTables -->
	<link href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<!-- DataTables -->
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" type="text/css">
	<script src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>
	<!-- 위의 탭 아이콘 -->
	<link rel="icon" href="${path}/resources/Admin_Resources/assets/img/main_image.png" />
	<!-- 스타일 -->
	<link href="${path}/resources/Admin_Resources/css/styles.css" rel="stylesheet" />
	<link href="${path}/resources/Admin_Resources/css/DashboardProgressbar.css" rel="stylesheet" />
	<!-- 폰트 설정 -->
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>	
</head>
<body>
	<!-- 맨 위의 바 설정 -->
	<nav class="sb-topnav navbar navbar-expand" style="background-color: #003b1f;">
		<!-- 네비게이션 바 위의 로고, 이름 설정하는곳 -->
		<a class="navbar-brand ps-3" href="${path}/Admin/AdminDashboard">
			<!-- 로고 이미지 설정 -->
			<img src="${path}/resources/Admin_Resources/assets/img/main_image.png" alt="main_image" class="img-fluid"
				style="height: 70px; width: auto; margin-left: 55px;" />
		</a>
		<!-- 네비게이션 바 껐다 켰다 버튼 -->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
				class="fas fa-bars"></i></button>
		<!-- 네비게이션 바 검색 -->
		<!-- <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
					aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button"><i
						class="fas fa-search"></i></button>
			</div>
		</form> -->
		<!-- 네비게이션 바 맨 오른쪽 위 아이템 -->
		<ul class="navbar-nav ms-auto d-flex flex-row order-0 order-lg-1">
			<!-- 네비게이션 바 아이템 (아래로 쫘르륵 나오게) -->
			<li class="nav-item dropdown" style="margin-right: 10px;">
				<!-- 아래로 쫘르륵 나오게 해주는 버튼 -->
				<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
				<!-- 아래로 쫘르륵 나오는 아이템 리스트 -->
				<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">설정</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>
					<li><a id="logout" class="dropdown-item" >로그아웃</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</body>
</html>