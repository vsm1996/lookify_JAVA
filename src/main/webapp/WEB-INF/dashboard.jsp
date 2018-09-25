<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify!</title>
</head>
<body>
<a href="/songs/new"> Add New</a>
<a href="/search/TopTen"> Top Ten Songs</a>

<form action="/search" method="get">
<input type="text" name="searchInput"/>
<input type="submit" value="Search Artist"/>
</form>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
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