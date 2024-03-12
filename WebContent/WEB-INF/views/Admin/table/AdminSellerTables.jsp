<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=chrome" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>다팜 | 판매자 정보</title>
        <!-- DataTables -->
        <link href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <!-- DataTables -->
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="${path}/resources/Admin_Resources/js/simple-datatables.min.js"></script>
        <link href="${path}/resources/Admin_Resources/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
 <!-- body -->
 <body class="sb-nav-fixed">
	<jsp:include page="../include/AdminTopbar.jsp"/>
	<!-- 사이드바 전체적인 큰 틀 -->
	<div id="layoutSidenav">
		<!-- 사이드바 틀 -->
		<div id="layoutSidenav_nav">
			<jsp:include page="../include/AdminSidebar.jsp"/>
		</div>
		<div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">판매자 회원정보</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/Admin/AdminDashboard">메인</a></li>
                            <li class="breadcrumb-item active">회원 정보</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header" style="background-color: #008748; color: white;">
                                <i class="fas fa-store me-1"></i>
                                판매자 정보
                            </div>
                            <div class="card-body">
                                <table id="sellertablesSimple">
                                    <thead>
                                        <tr>
                                            <th>판매자 번호</th>
                                            <th>이름</th>
                                            <th>아이디</th>
                                            <th>비밀번호</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                            <th>가입일자</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>판매자 번호</th>
                                            <th>이름</th>
                                            <th>아이디</th>
                                            <th>비밀번호</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                            <th>가입일자</th>
                                            <th></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="seller" items="${sellerList}">
          								  <tr>
							                <td>${seller.seller_num}</td>
							                <td>${seller.seller_name}</td>
							                <td>${seller.seller_id}</td>
							                <td>${seller.seller_password}</td>
							                <td>${seller.seller_email}</td>
							                <td>${seller.seller_address}</td>
							                <td>${seller.seller_access_date}</td>
							                <td><a href="${path}/Admin/table/AdminSellerInfo?seller_num=${seller.seller_num}" class="btn btn-primary btn-sm">상세 정보</a></td>
							            </tr>
							        	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <jsp:include page="../include/AdminFooter.jsp"/>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${path}/resources/Admin_Resources/js/scripts.js"></script>
        <script src="${path}/resources/Admin_Resources/js/simple-datatables.min.js"></script>
        <script src="${path}/resources/Admin_Resources/js/datatables-simple-demo.js"></script>
    </body>
</html>
