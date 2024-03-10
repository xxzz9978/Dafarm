<%@page import="kr.co.dafarm.dao.SellerProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAFARM : 스토어</title>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerStorePage.css" />
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<div class="SellerStore">
					<h1>스토어</h1>
				</div>
				<div class="prodcutCount">
					<h1>등록 상품 현황 ( ${count } )</h1>
				</div>
				<table class="productListTable" id='board_list'>
					<thead>
						<tr class="tableBorderTrMenu">
							<th class="tableBorderMenu">등록 번호</th>
							<th class="tableBorderMenu">상품 명</th>
							<th class="tableBorderMenu">상품 수량 / 단위</th>
							<th class="tableBorderMenu">상품 가격</th>
							<th class="tableBorderMenu">등록 일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var='obj' items="${productList }">
							<tr class="tableBorderTr">
								<td class="tableBorder">${obj.product_idx }</td>
								<td class="tableBorder"><a
									href='${path }seller/board/read?product_idx=${obj.product_idx }'>${obj.product_name}</a></td>
								<td class="tableBorder">${obj.product_quantity }&nbsp;/&nbsp;${obj.product_weight}</td>
								<td class="tableBorder">${obj.product_price }  &nbsp;원</td>
								<td class="tableBorderMenuLast">${obj.product_date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="plusGoods">
					<a href="${path }seller/board/plusGoods">상품 등록 </a>
				</div>
			</main>
		</article>
	</section>
</body>
</html>