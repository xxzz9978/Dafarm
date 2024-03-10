<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=chrome" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>DAFARM</title>
<!-- CSS -->
<link rel="stylesheet" href="${path}resources/user_style/trade_payment.css">
<link rel="stylesheet"
   href="${path}resources/user_style/include_top.css" />
<link rel="stylesheet"
   href="${path}resources/user_style/include_bottom.css" />
<!-- JQuery -->
<script src="${path}resources/user_script/jquery-3.7.1.min.js"></script>
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
<!-- FontAwesome -->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
   crossorigin="anonymous"></script>
<script src="${path}resources/user_script/trade_cart.js"></script>
<!-- 포트원 결제 -->
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 포트원 결제 -->
</head>
<body class="sb-nav-fixed">
      <!-- head -->
      <div class="top">
         <c:import url="/WEB-INF/views/users/include/top.jsp" />
      </div>
      <div id="layoutSidenav_content">
      <div class="container-fluid px-4">
         <div class="card mb-4">
            <div class="card-body">
            
               <h2>구매자 정보</h2>
               
               <form>
                     <div>이름 : ${payment_info[0].user_name}</div> <br />
                     <div>이메일 : ${payment_info[0].user_email}</div> <br />
                     <div>휴대폰 번호 : ${payment_info[0].user_phone}</div> <br />
                     <div>배송 주소 : ${payment_info[0].user_address}</div> <br />
               </form>
               
               <div class="table_price">
                  <h2>결제 상품 정보</h2>
                  <table id="market_price">
                     <thead>
                        <tr>
                           <th>상품 이름</th>
                           <th>가격 (원)</th>
                           <th>단위</th>
                           <th>수량 (개)</th>
                           <th>상품 번호</th>
                           <th>판매 회원 (번호)</th>
                           <th>판매 회원 (성명)</th>
                           <th>판매 회원 (Tel)</th>
                           <th>총 가격 (원)</th>
                        </tr>
                     </thead>
                     <tfoot>
                        <tr>
                           <th>상품 이름</th>
                           <th>가격 (원)</th>
                           <th>단위</th>
                           <th>수량 (개)</th>
                           <th>상품 번호</th>
                           <th>판매 회원 (번호)</th>
                           <th>판매 회원 (성명)</th>
                           <th>판매 회원 (Tel)</th>
                           <th>총 가격 (원)</th>
                        </tr>
                     </tfoot>
                     <tbody>
                        <c:forEach var="pi" items="${payment_info}">
                           <tr>
                              <td>${pi.product_name}</td>
                              <td>${pi.product_price}</td>
                              <td>${pi.product_weight}</td>
                              <td>${pi.product_quantity}</td>
                              <td>${pi.product_idx}</td>
                              <td>${pi.product_writer_num}</td>
                              <td>${pi.seller_name}</td>
                              <td>${pi.seller_phone}</td>
                              <td>${pi.product_price * pi.product_quantity}</td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
   </div>
   
   <!-- 총 가격을 계산하여 출력하는 JavaScript 코드 추가 -->
   <script>
      var total_price = 0;
      $(document).ready(function() {
         // 각 제품의 가격과 수량을 곱하여 총 가격을 계산합니다.
         $("table#market_price tbody tr").each(function() {
            var price = parseInt($(this).find("td:eq(1)").text());
            var quantity = parseInt($(this).find("td:eq(3)").text());
            total_price += price * quantity;
         });
         var formatted_price = total_price.toLocaleString(); // 패턴 적용
         // 계산된 전체 총 가격을 하단에 출력합니다.
         $("h4#total_price").text(formatted_price + "원");
      });
   </script>
    
   <div class = "total_price_line"> 
   	<div class="total_price_line2">
   		<h3>결제 예정 금액</h3>
   		<h4 id="total_price"> 원</h4>
   	</div>
   </div>
      <script>
        var IMP = window.IMP; 
        IMP.init("imp26153568"); 
      
        var today = new Date();   
        var hours = today.getHours(); // 시
        var minutes = today.getMinutes();  // 분
        var seconds = today.getSeconds();  // 초
        var milliseconds = today.getMilliseconds();
        var makeMerchantUid = hours +  minutes + seconds + milliseconds;
        
       
        function requestPay() {
            IMP.request_pay({
                pg : 'tosspay',
                pay_method : 'card',
                merchant_uid: makeMerchantUid, //상점에서 생성한 고유 주문번호
                name : '토스페이 일반결제' ,   //필수 파라미터 입니다.
                amount : total_price,
                buyer_email : '${payment_info[0].user_email}',
                buyer_name : '${payment_info[0].user_name}',
                buyer_tel : '${payment_info[0].user_phone}',
                buyer_postcode : '123-456',
                buyer_addr : '${payment_info[0].user_address}',
                m_redirect_url : '${path}users/trade/payment_success'
            }, function (rsp) { // callback
                if (rsp.success) {
                    location.href='${path}users/trade/payment_success'
                } else {
                    console.log(rsp);
                }
            });
        }
    </script>
    
  
</head>
<body>
	<div class="paymentbtn">
    	<button onclick="requestPay()">결제하기</button>
    </div>
	   <div class="bottom">
	      <c:import url="/WEB-INF/views/users/include/bottom.jsp" />
	   </div>
	
   <!-- Bootstrap -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
   <script src="${path}resources/user_script/simple-datatables.min.js"></script>
   <script src="${path}resources/user_script/datatables-simple.js"></script>
</body>

</html>