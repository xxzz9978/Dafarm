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
<div class="container-fluid px-4">
	<div class="d-flex align-items-center justify-content-between small">
		<div>Copyright &copy; Your Website 2023</div>
		<div>
			<a href="#">Privacy Policy</a>
			&middot;
			<a href="#">Terms &amp; Conditions</a>
		</div>
	</div>
</div>
</body>
</html>