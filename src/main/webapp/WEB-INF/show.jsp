<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
<a href="/dashboard"> Dashboard</a>
<p>Title -   <c:out value="${ song.title }" /> </p>
<p> Artist -    <c:out value="${ song.artist }"/> </p>
<p>Rating (1-10) -  <c:out value="${ song.rating }" /></p>
<a href="/songs/${ song.id }/delete"> Delete </a>
</body>
</html>