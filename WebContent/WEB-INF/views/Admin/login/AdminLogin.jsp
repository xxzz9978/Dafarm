<!-- login -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>다팜 | 로그인</title>
    <link href="${path}/resources/Admin_Resources/css/styles.css" rel="stylesheet" />
    <link rel="icon" href="${path}/resources/Admin_Resources/assets/img/icon.png"/> 
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<c:if test="${param.error != null}">
	<div class="alert alert-danger" role="alert">
	    로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인해주세요.
	</div>
</c:if>
<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
		<!--<img id="backgroundImage" src="assets/img/login_background.jpg" alt="" />-->
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg rounded-lg mt-5 ">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">관리자 로그인</h3></div>
                                <form id="loginForm" action="${path }/Admin/login/login" method="post">
                                <div class="card-body">
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="inputID" type="id" placeholder="아이디" />
                                        <label for="inputID">아이디</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="inputPassword" type="password" placeholder="Password" />
                                        <label for="inputPassword">비밀번호</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center mt-4 mb-0 ">
                                        <button type="submit" class="btn btn-primary">로그인</button>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
        <div id="layoutAuthentication_footer">
            <footer class="py-4 bg-light mt-auto">
                <jsp:include page="../include/AdminFooter.jsp"/>
            </footer>
            <div id="notificationContainer" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); z-index: 1000;">
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="${path}/resources/Admin_Resources/js/scripts.js"></script>
   	<%--  <script src="${path}/resources/Admin_Resources/js/login_logic.js"></script> --%>
</body>
</html>
