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
		<table class="table">
			<tr>
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Contents</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>
			
			<tr>
				<td>${vo.num}</td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.contents}</td>
				<td>${vo.createDate}</td>
				<td>${hit}</td>
			</tr>
		</table>
		
		<div>
			<c:forEach items="${vo.noticeFileVOs}" var="fileVO">
				<a href="./noticeFileDown?fileNum=${fileVO.fileNum}">${fileVO.oriName}</a>
			</c:forEach>
		</div>
		
		
		<a href="./${board}Update?num=${vo.num}" class="btn btn-primary">Update</a>
		<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger">Delete</a>
	</div>

</div>

</body>
</html>