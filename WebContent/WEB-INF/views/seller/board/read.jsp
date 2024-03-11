<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerProductReadPage.css" />
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<main>
					<div class="SellerStore">
						<h1>상품 정보</h1>
					</div>
					<div class="product_detail">
						<div class="harf1">
							<label for="" class="product_list_name">상품명</label> <input
								type="text" class="product_name" readonly="true"
								value="${readProductBean.product_name }" /> <label for=""
								class="product_list_price">상품 가격</label> <input type="text"
								class="product_writer_price" readonly="true"
								value="${readProductBean.product_price }" />
							<p class="product_writer_price_p">원</p>
							<label for="" class="product_list_quantity">수량 / 단위</label> <input
								type="text" class="product_writer_quantity" readonly="true"
								value="${readProductBean.product_quantity }" />
							<p class="product_writer_quantity_p">개</p>
							<input type="text" class="product_writer_weight" readonly="true"
								value="${readProductBean.product_weight }" /> 
								<label for=""
								class="product_list_description">상품 설명</label>
							<input class="product_writer_description"
								readonly="true" value="${readProductBean.product_description }" />
						</div>
					</div>

					<div class="harf2">
						<label for="product_list_image" class="product_list_image">첨부
							이미지</label>
						<div class=imgDIV>
							<c:if test="${readProductBean.product_image != null}">
								<img src="${path}resources/upload/${readProductBean.product_image}" />
							</c:if>
						</div>
						<h5>주의 사항</h5>
						<p class="notice1">- 상품 사진은 하나만 등록 가능합니다.</p>
						<p class="notice2">- 등록 상품과 관계없는 사진은 삭제 될 수 있습니다.</p>
						<p class="notice3">- 타인에게 불쾌감을 주는 사진은 삭제 될 수 있습니다.</p>
					</div>
					<c:if
						test="${readProductBean.product_writer_num == loginSellerBean.seller_num }">
						<div class="modify_delete1">
							<a href="${path}seller/board/modify?product_idx=${product_idx}"
								class="read_modify">수정</a>
						</div>
						<div class="modify_delete2">
							<a href="${path}seller/board/delete?product_idx=${product_idx}"
								class="read_delete">삭제</a>
						</div>
					</c:if>
				</main>
			</main>
		</article>
	</section>
</body>
</html>