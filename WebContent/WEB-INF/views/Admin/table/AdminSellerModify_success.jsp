<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value='${pageContext.request.contextPath}/'/>
<script>
	
	location.href = '${path}Admin/table/AdminSellerInfo?seller_num=${adminModifySellerBean.seller_num}'   
</script>