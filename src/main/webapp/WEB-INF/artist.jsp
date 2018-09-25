<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<a href="/dashboard"> Dashboard</a>
<p>Songs By Artist: <c:out value="${searchInput}"/></p>
<a href="/songs/new"> Add New</a>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${artistSongs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"> <c:out value="${song.title}"/> </a></td>
            <td><c:out value="${song.rating}"/></td>
            <td> <a href="/songs/${ song.id }/delete"> Delete </a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>