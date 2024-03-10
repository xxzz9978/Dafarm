<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/seller_style/SellerStoreStopPage.css">
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<div class="SellerStore">
					<h1>스토어</h1>
				</div>
				<div class="buttonDiv">
					<div class="selling">
						<h1>
							<a href="${path }seller/board/store">판매중(0)</a>
						</h1>
					</div>
					<div class="stop">
						<h1>
							<a href="${path }seller/board/stopStore">일시 중지(1)</a>
						</h1>
					</div>
				</div>
				<div class="SellerGoods">
					<img src="${path }/resources/img/chil.jpg" alt="">
					<div class="GoodsName">청양고추꽈리고추</div>
					<div class="GoodsDetails">1kg당</div>
					<div class="GoodsQuantity">999개</div>
					<div class="GoodsPrice">19,990원</div>
					<div class="GoodsInfo">어쩌구 저쩌구 소개글 어쩌구...</div>
					<div>
						<button class="GoodsDelete">삭제</button>
					</div>
				</div>
				<div class="plusGoods">
					<a href="${path }seller/board/plusGoods"><img
						src="${path }/resources/img/plusGoods.png" alt=""></a>
				</div>
			</main>
		</article>
	</section>
</body>
</html>