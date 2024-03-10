<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"
	integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c="
	crossorigin="anonymous"></script>
<!-- DataTables -->
<link
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script
	src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" type="text/css">
</head>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerSimplePage2.css" />
<%
Date date = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMddHHmmss");
String today = sf.format(date);
String today1 = sf.format(date);
sf1 = new SimpleDateFormat("yyy년 MM월 dd일 기준");
sf = new SimpleDateFormat("MM월 dd일 기준");
today = sf.format(date);
today1 = sf1.format(date);
%>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<h1 class="notice">공지사항</h1>
				<div class="admin_notice_seller">
					<table id="boardDatatablesSimple">
				<tr class="inquiry_tr">
					<th class="board_title">제목</th>
					<th class="board_access_date">날짜</th>
					<th class="board_views">조회수</th>
				</tr>
				<tbody>
		
						<tbody>
							<c:forEach var="contentList" items="${contentList }">
						<tr>
							<td><a href="noticeRead?seller_board_num=${contentList.seller_board_num}&page=${page}">${contentList.seller_board_title}</a></td>
							<td>${contentList.seller_board_access_date }</td>
							<td>${contentList.seller_board_view_count }</td>
						</tr>
					</c:forEach>
						</tbody>
					</table>
				</div>
				<h3 class="kamis_name">
					시세표 (
					<%=today%>
					)
				</h3>
				<div class="kamis_table">

					<div id="layoutSidenav_content">
						<div class="container-fluid px-4">
							<div class="card mb-4">
								<div class="card-body">
									<div class="table_price">

										<table id="market_price">
											<thead>
												<tr class="fixed">
													<th>품목</th>
													<th>단위</th>
													<th>가격 (원)</th>
													<th>등락률</th>
													<th>전일</th>
													<th>1개월전</th>
													<th>1년전</th>
												</tr>
											</thead>
											<tfoot>
												<tr>
													<th>품목</th>
													<th>단위</th>
													<th>가격 (원)</th>
													<th>등락률</th>
													<th>전일</th>
													<th>1개월전</th>
													<th>1년전</th>
												</tr>
											</tfoot>
											<tbody>
												<c:forEach var='price' items='${kamisAPIBean.price }'>
													<c:if
														test="${not empty price.category_name and not (price.category_name eq '축산물' or price.category_name eq '수산물') and price.product_cls_code eq '01'}">
														<tr>
															<td>${price.productName}</td>
															<td>${price.unit }</td>
															<td>${price.dpr1 }</td>
															<c:choose>
																<c:when
																	test="${not empty price.value and price.value ne '-' and price.value gt 0.0}">
																	<td>${price.value}<img
																		src="${path}resources/img/red_triangle.png"
																		style="width: 10px"></td>
																</c:when>
																<c:otherwise>
																	<td>0.0<img
																		src="${path}resources/img/blue_triangle.png"
																		style="width: 10px"></td>
																</c:otherwise>
															</c:choose>
															<td>${price.dpr2 }</td>
															<td>${price.dpr3 }</td>
															<td>${price.dpr4 }</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			<h1 class="order_h1">주문 현황</h1>
			<table class="order_list">
				<tr class="tabletr">
				<td class="todaytd"><%=today1 %></td>
				<td class="count_td"></td>
				<td class="COUNT"></td>
				<td class="clicktd"></td>
			</tr>
				<tr class="tabletr">
				<td class="text"><a href="${path }seller/board/order?order_status=결제완료">신규주문(결제완료)</a></td>
				<td class="count_td"><a href="${path }seller/board/order?order_status=결제완료">${count2 }</a></td>
				<td class="COUNT">건</td>
				<td class="clicktd"><a href="${path }seller/board/order?order_status=결제완료"><img src="${path }/resources/img/click.png" class="click"></a></td>
					
				</tr class="tabletr">
				<tr class="tabletr">
					
				<td class="text"><a href="${path }seller/board/order?order_status=발송대기">발송 대기</a></td>
					<td class="count_td"><a href="${path }seller/board/order?order_status=발송대기">${count3 }</a></td>
					<td class="COUNT">건</td>
					<td class="clicktd"><a href="${path }seller/board/order?order_status=발송대기"><img src="${path }/resources/img/click.png" class="click"></a></td>
					
				</tr>
				<tr class="tabletr">
					
				<td class="text"><a href="${path }seller/board/order?order_status=발송완료">발송 완료</a></td>
					<td class="count_td"><a href="${path }seller/board/order?order_status=발송완료">${count4 }</a></td>
					<td class="COUNT">건</td>
					<td class="clicktd"><a href="${path }seller/board/order?order_status=발송완료"><img src="${path }/resources/img/click.png" class="click"></a></td>
				
				</tr>
			</table>

			<h1 class="price_h1">수익 현황</h1>
			<table class="price_list">
				<tr class="tabletr">
				<td class="todaytd"><%=today1 %></td>
				<td class="count_td"></td>
				<td class="COUNT"></td>
				<td  class="clicktd"></td>
			</tr>
				<tr class="tabletr">
					
				<td class="text"><a href="${path }seller/board/order?order_status=결제완료">판매금액</a></td>
				<td class="count_td">
    <c:choose>
        <c:when test="${sellerProfit == null}">
            <a href="${path }seller/board/order?order_status=결제완료">0</a>
        </c:when>
        <c:otherwise>
            <a href="${path }seller/board/order?order_status=결제완료">
                <fmt:formatNumber value="${sellerProfit }" pattern="###,###" />
            </a>
        </c:otherwise>
    </c:choose>
</td>
				<td class="COUNT">원</td>
				<td  class="clicktd"><a href="${path }seller/board/order?order_status=결제완료"><img src="${path }/resources/img/click.png" class="click"></a></td>
					
				</tr>
				<tr class="tabletr">
					
					<td class="text"><a href="${path }seller/board/order?order_status=발송대기">배송비</a></td>
					<td class="count_td"><a href="${path }seller/board/order?order_status=발송대기">${count3 }</a></td>
					<td class="COUNT">원</td>
					<td  class="clicktd"><a href="${path }seller/board/order?order_status=발송대기"><img src="${path }/resources/img/click.png" class="click"></a></td>

				</tr>
				<tr class="tabletr">
					<td class="text"><a href="${path }seller/board/order?order_status=발송완료">주문수</a></td>
					<td class="count_td"><a href="${path }seller/board/order?order_status=발송완료">${count }</a></td>
					<td class="COUNT">건</td>
					<td class="clicktd"><a href="${path }seller/board/order?order_status=발송완료"><img src="${path }/resources/img/click.png" class="click"></a></td>
					
				</tr>
			</table>
			</main>
		</article>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${path}resources/user_script/simple-datatables.min.js"></script>
	<script src="${path}resources/user_script/datatables-simple.js"></script>
</body>
</html>