<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten</title>
</head>
<body>
<a href="/dashboard"> Dashboard</a>
<p> Top Ten Songs:</p>

<c:forEach items="${songs}" var="song">
<p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"> <c:out value="${song.title}"/> </a> - <c:out value="${song.artist}"/> </p>
</c:forEach>


</body>
</html>