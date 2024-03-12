<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DAFARM</title>
<link rel="stylesheet"
	href="${path}resources/seller_style/board_read.css">
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />

			<main>
				<div class="main">
					<div class="back_page">

						<div class="go_inquiry">
							<!-- 목록으로 넘어가는 버튼 -->
							<a href="${path}seller/board/menu" class="board_list_btn">
								목록보기</a>
						</div>
					</div>
					<div class="contain_border">
						<div class="main_container">
							<div class="form-grop">
								<label id="board_title">${readContentBean.seller_board_title }</label>
							</div>

							<div class="main_head_line">
								<div class="main_head_line_dis">
									<div class="main_head_line_r">
										<label id="board_see_num">조회수 :
											${readContentBean.seller_board_view_count} /</label> <label
											id="board_time">작성 시각 :
											${readContentBean.seller_board_access_date}</label>
									</div>
								</div>
							</div>
							<div class="main_contain_m">
								<textarea id="board_content" disabled="disabled">${readContentBean.seller_board_content }</textarea>
							</div>
						</div>
					</div>
				</div>
			</main>

</body>
</html>