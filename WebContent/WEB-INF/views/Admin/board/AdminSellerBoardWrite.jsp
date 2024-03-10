<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=chrome" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>다팜 | 판매자 공지사항 글 작성</title>
        <!-- JQuery -->
		<script src="https://code.jquery.com/jquery-3.7.1.js"
		integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
		crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"
		integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c="
		crossorigin="anonymous"></script>
		<!-- SweetAlert2 -->
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="${path}/resources/Admin_Resources/js/seller_board_write.js"></script>
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
		               <h1 class="mt-4">판매자 공지사항 글 작성</h1>
		               <ol class="breadcrumb mb-4">
		                   <li class="breadcrumb-item"><a href="${path}/Admin/AdminDashboard">메인</a></li>
		                   <li class="breadcrumb-item"><a href="${path}/Admin/board/AdminSellerBoardList">판매자 공지사항 글 목록</a></li>
		                   <li class="breadcrumb-item active">판매자 공지사항 글 작성</li>
		               </ol>
		               <form:form action="${path }/Admin/board/AdminSellerBoardWrite_pro" method="post" modelAttribute="adminSellerBoardBean" enctype="multipart/form-data">
		               	   <form:hidden path="seller_board_num" />
		               	   <form:hidden path="seller_board_view_count" />
		                   <div class="mb-3">
		                       <label for="title" class="form-label">제목</label>
		                       <form:input path="seller_board_title" placeholder="게시물 제목을 입력하세요" class="form-control" />
		                   </div>
		                   <div class="mb-3">
		                       <label for="content" class="form-label">내용</label>
		                       <form:textarea path="seller_board_content" rows="5" placeholder="내용 작성" class="form-control"/>
		                   </div>
		                   <div class="text-end">
		                       <form:button type="submit" 
		                       class="btn btn-primary">작성하기</form:button>
		                       <button onclick="return board_write_cancel(event)" 
		                       type="button" class="btn btn-secondary">취소</button>
		                   </div>
		               </form:form>
		           </div>
		       	</main>
                <footer class="py-4 bg-light mt-auto">
                    <jsp:include page="../include/AdminFooter.jsp"/>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>
</html>
