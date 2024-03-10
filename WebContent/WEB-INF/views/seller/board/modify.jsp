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
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerModifyPage.css" />
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
						<form:form action="${path }seller/board/modify_pro" method="post"
							modelAttribute="modifyProductBean" enctype="multipart/form-data">
							<div class="harf1">
								<form:hidden path="product_idx" />
								<form:label path="product_name" class="product_list_name">상품명 </form:label>
								<form:input path="product_name" class="product_writer_name"></form:input>
								<form:label path="product_price" class="product_list_price">상품 가격</form:label>
								<p class="product_writer_price_p">원</p>
								<form:input path="product_price" class="product_writer_price"></form:input>
								<form:label path="product_quantity"
									class="product_list_quantity">수량 / 단위</form:label>
								<form:input path="product_quantity"
									class="product_writer_quantity"></form:input>
										<p class="product_writer_quantity_p">개</p>
								<form:input path="product_weight" class="product_writer_weight"></form:input>
								<form:label path="product_description"
									class="product_list_description">상품 설명</form:label>
								<form:input path="product_description" class="product_writer_description" />
								<div class="imageButton">
									<form:input path="upload_file" class="upload_file" type="file" accept="image/*" />
								</div>
							</div>
							
							<div class="harf2">
							<label for="product_list_image" class="product_list_image">첨부 이미지</label>
							<div class=imgDIV>
								<c:if test="${modifyProductBean.product_image != null }">
									<img src="${path }resources/upload/${modifyProductBean.product_image }" width="100%" />
								</c:if>
							</div>	
								<h5>주의 사항</h5>
								<p class="notice1">- 상품 사진은 하나만 등록 가능합니다.</p>
								<p class="notice2">- 등록 상품과 관계없는 사진은 삭제 될 수 있습니다.</p>
								<p class="notice3">- 타인에게 불쾌감을 주는 사진은 삭제 될 수 있습니다.</p>

								<div class="modify_delete1">
									<form:button class="read_modify">저장</form:button>
								</div>
								<div class="modify_delete2">
									<a href="${path }seller/board/read?product_idx=${product_idx}"
										class="read_delete">취소</a>
								</div>
							</div>
						</form:form>
					</div>
				</main>
			</main>
		</article>
	</section>
</body>
</html>