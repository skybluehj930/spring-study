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
		<h3>ID : ${member.id}</h3>
		<h3>Name : ${member.name}</h3>
		<h3>Age : ${member.age}</h3>
		<h3>Birth : ${member.birth}</h3>
		<h3>FileName : ${member.memberFileVO.fileName}</h3>
		<h3>OriName : ${member.memberFileVO.oriName}</h3>
		<img src="../resources/upload/${member.memberFileVO.fileName}">
	
	</div>

</div>	
	
	
</body>
</html>