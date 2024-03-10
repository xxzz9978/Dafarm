<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='path' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAFARM : 판매자 프리미엄 페이지</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link rel="stylesheet"
	href="${path }/resources/seller_style/SellerPremiumPage.css">
</head>
<body>
	<c:import url="/WEB-INF/views/seller/include/SideTopPage.jsp" />
	<section>
		<article>
			<main>
				<div class="PremiumTitle">프리미엄 관리</div>
				<div class="PremiumContainer">
					<!-- 상단부 컨테이너 -->
					<div class="BookMarkContainer">
						<!-- 등록 상품 품목 컨테이너 -->
						<div class="BookMarkTitle">[등록 상품 품목 정보]</div>
						<div class="BookMarkHeader">
							<!-- 등록 상품 품목 헤더 -->
							<div class="BookHeaderName">품목</div>
							<div class="BookHeaderMeasure">단위</div>
							<div class="BookHeaderPrice">현재가</div>
							<div class="BookHeaderYesterday">전일비</div>
							<div class="BookHeaderRatio">등락률</div>
							<div class="BookHeaderVolume">1개월전</div>
							<div class="BookHeaderRegist">등록가</div>
							<div class="BookHeaderSell">등록수량</div>
							<div class="BookHeaderProfit">예상판매수익</div>
						</div>

						<!-- 등록 상품 품목 데이터 -->

						<c:forEach var="productBean" items="${sellerProductBean }">
							<c:forEach var="price" items="${kamisAPIBean.price }">
								<c:if
									test="${price.productName eq productBean.product_name and price.product_cls_code eq '01'}">
									<div class="BookMarkContent">
										<div class="BookContentName">${price.productName }</div>
										<div class="BookContentMeasure">${price.unit }</div>
										<div class="BookContentPrice">${price.dpr1 }</div>
										<div class="BookContentYesterday">${price.dpr2 }</div>

										<div class="BookContentRatio">
											<c:choose>
												<c:when test="${price.value < '0' }">
													<img class="RatioTriangle"
														src="${path }/resources/img/blue_triangle.png">
													<div class="RatioText">${price.value }</div>
												</c:when>
												<c:otherwise>
													<img class="RatioTriangle"
														src="${path }/resources/img/red_triangle.png">
													<div class="RatioText">${price.value }</div>
												</c:otherwise>
											</c:choose>
										</div>

										<div class="BookContentVolume">${price.dpr3 }</div>
										<div class="BookContentRegist">${productBean.product_price }</div>
										<div class="BookContentSell">${productBean.product_quantity }</div>

										<div class="BookContentProfit">
											<script>
												// productBean.product_price와 productBean.product_quantity 값을 가져와서 JavaScript 변수에 할당
												var productPrice = "${productBean.product_price}"
														.replace(",", "");
												var productQuantity = "${productBean.product_quantity}"
														.replace(",", "");

												// JavaScript로 연산 수행
												var totalPrice = productPrice * productQuantity;
												
												 var formatted_price = totalPrice.toLocaleString(); // 패턴 적용
												
												 // 결과를 HTML 요소에 표시
												document.write(formatted_price);
												
											</script>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>

					</div>
					<div class="ProfitGraphContainer">
						<div class="ProfitGraphTitle">[${month }월 TOP 5 수익]</div>
						<div class="ProfitPieChartContainer">
							<canvas class="ProfitPieChart"></canvas>
						</div>
					</div>
				</div>
				<div class="PremiumContainer">
					<div class="ProfitInfoContainer">
						<div class="ProfitInfoTitle">[${year }년 수익 그래프]</div>
						<div class="ProfitInfoBarChartContainer">
							<canvas class="ProfitInfoBarChart"></canvas>
						</div>
					</div>
					<div class="RecentTradeContainer">
						<div class="RecentTradeTitle">[최근 거래 내역]</div>
						<div class="RecentTradeHeader">
							<div class="RecentHeaderNumber">주문번호</div>
							<div class="RecentHeaderItem">품목</div>
							<div class="RecentHeaderName">주문자</div>
							<div class="RecentHeaderDate">주문날짜</div>
							<div class="RecentHeaderProfit">판매수익</div>
						</div>
						<c:forEach var="order" items="${sellerOrderBean }"
							varStatus="status">
							<div class="RecentTradeContent">
								<div class="RecentContentNumber">${order.order_number }</div>
								<div class="RecentContentItem">${order.item_name }</div>
								<div class="RecentContentName">${order.user_name }</div>
								<div class="RecentContentDate">${order.order_date }</div>
								<div class="RecentContentProfit">
									<fmt:formatNumber
										value="${sellerProfitBean[status.index].seller_profit }"
										pattern="###,###,###" />
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="PremiumContainer"></div>
			</main>
		</article>
	</section>
	<script>
		// 데이터
		var data = {
			labels : [ '${piechartBean[0].item_name}', '${piechartBean[1].item_name}', '${piechartBean[2].item_name}', '${piechartBean[3].item_name}', '${piechartBean[4].item_name}' ],
			datasets : [ {
				data : [ ${piechartBean[0].seller_profit}, ${piechartBean[1].seller_profit}, ${piechartBean[2].seller_profit}, ${piechartBean[3].seller_profit}, ${piechartBean[4].seller_profit} ], // 각 항목의 값
				backgroundColor : [ 'red', 'blue', 'yellow', 'green', 'purple' ]
			} ]
		};

		// Pie chart 그리기
		// 클래스 이름으로 요소를 선택하고 첫 번째 요소를 선택합니다.
		var canvas = document.getElementsByClassName('ProfitPieChart')[0];

		// getContext() 메서드를 호출합니다.
		var ctx = canvas.getContext('2d');
		var ProfitPieChart = new Chart(ctx, {
			type : 'pie',
			data : data,
			options : {}
		});
	</script>
	<script>
		// 데이터
		var barcolor = '#55cc77';
		var data = {
			labels : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
					'10월', '11월', '12월' ],
			datasets : [ {
				label : '수입',
				data : [ ${jan}, ${feb}, ${mar}, ${apr}, ${may}, ${jun}, ${jul}, ${aug}, ${sep}, ${oct}, ${nov}, ${dec} ],
				backgroundColor : [ barcolor, barcolor, barcolor, barcolor,
						barcolor, barcolor, barcolor, barcolor, barcolor,
						barcolor, barcolor, barcolor ],
				borderColor : [ barcolor, barcolor, barcolor, barcolor,
						barcolor, barcolor, barcolor, barcolor, barcolor,
						barcolor, barcolor, barcolor ],
				borderWidth : 1
			} ]
		};

		// 바 차트 그리기
		var canvas = document.getElementsByClassName('ProfitInfoBarChart')[0];
		var ctx = canvas.getContext('2d');
		var ProfitInfoBarChart = new Chart(ctx, {
			type : 'bar',
			data : data,
			options : {
				scales : {
					y : {
						beginAtZero : true,
						ticks : {
							stepSize : 1
						}
					}
				}
			}
		});
	</script>
</body>
</html>