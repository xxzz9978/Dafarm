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
<link rel="stylesheet" href="${path}resources/seller_style/board_main.css">
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
<section>
	<article>
		<main>
			<div class="main">
		<div class="index_main">
			<h2 id="post">공지사항</h2>
		</div>
		<div class="inquiry_list">
			<!-- border 만들기 -->
			<!-- 제일 위에 많이 들어오는 문의와 그에 대한 답들을 넣어 고정-->
			<table class="inquiry_table">
				<tr class="inquiry_tr">
					<th class="board_title">제목</th>
					<th class="board_access_date">날짜</th>
					<th class="board_views">조회수</th>
				</tr>
				<tbody>
					<c:forEach var="contentList" items="${contentList }">
						<tr>
							<td><a href="${path }seller/seller_user/noticeRead?seller_board_num=${contentList.seller_board_num}&page=${page}">${contentList.seller_board_title}</a></td>
							<td>${contentList.seller_board_access_date }</td>
							<td>${contentList.seller_board_view_count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="main_footer">
			<div class="input_post">

				<ul class="pagination justify-content-center">
					<c:choose>
						<c:when test="${pageBean.prevPage <=0 }">
							<li class="page-item disabled">
							<a href="#" class="page-link">이전</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
							<a href="${path }seller/seller_user/menu?page=${pageBean.prevPage}"
								class="page-link"> 이전</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var='idx' begin="${pageBean.min }"
						end="${pageBean.max }">
						<c:choose>
							<c:when test="${idx == pageBean.currentPage }">
								<li class="page-item active"><a
									href="${path }seller/seller_user/menu?page=${idx}" class="page-link">${idx }</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${path }seller/board/menu?page=${idx}" class="page-link">${idx }</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${pageBean.max >= pageBean.pageCnt }">
							<li class="page-item disabled"><a href="#" class="page-link">다음</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a
								href="${path }seller/board/menu?page=${pageBean.nextPage}"
								class="page-link">다음</a></li>
						</c:otherwise>
					</c:choose>
				</ul>

			</div>
		</div> 
	</div>
		</main>
	</article>
</section>

</body>
</html>