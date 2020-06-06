<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>

<div class="container">
	<div class="row">
		<h1>${board} List</h1>
		<table class="table">
			<tr>
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>
			
			<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.createDate}</td>
				<td>${vo.hit}</td>
			</tr>
			
			</c:forEach>
		
		</table>
		<c:catch>
		<c:if test="${member.id eq 'admin'}">
			<a href="./${board}Write" class="btn btn-danger">Write</a>
		</c:if>
		</c:catch>
	
	</div>

</div>


</body>
</html>