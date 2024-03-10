<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DAFARM</title>
<link rel="stylesheet" href="${path}resources/user_style/board_read.css">
<link rel="stylesheet" href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet" href="${path}resources/user_style/include_bottom.css" />
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<title>DAFARM</title>
</head>
<body>
	<div class="container">

		<div class="top">
		<c:import url="/WEB-INF/views/users/include/top.jsp" />
		</div>

		<div class="main">
			<div class="back_page">

				<div class="go_inquiry">
					<!-- 목록으로 넘어가는 버튼 -->
					<a href="${path}users/board/main" class="board_list_btn"> 목록보기</a>
				</div>
			</div>
			<div class="contain_border">
				<div class="main_container">
					<div class="form-grop">
						<label id="board_title" >${readContentBean.user_board_title }</label>
					</div>
					
				<div class="main_head_line">
					<div class="main_head_line_dis">
						<div class="main_head_line_r">
							<label id="board_see_num" >조회수 : ${readContentBean.user_board_view_count} /</label>
							<label id="board_time">작성 시각 : ${readContentBean.user_board_access_date}</label>
						</div>
					</div>
				</div>
				<div class="main_contain_m">
						<textarea id="board_content" disabled="disabled">${readContentBean.user_board_content }</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom">
		<c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	</div>
	</div>
</body>
</html>