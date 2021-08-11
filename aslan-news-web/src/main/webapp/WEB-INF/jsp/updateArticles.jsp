<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Update Article</title>
</head>
<body>
<br><br>
<p align="center">
    | <a href="${pageContext.request.contextPath}/articles">TO ARTICLES</a> |
    <br><br>
<h1 align="center">Update <td>${user.username}</td> Article</h1>
</p>
<br><br>
<br><br>
<table align="center">
    <c:forEach items="${articles}" var="article">
        <c:if test="${(sessionScope.user.id==article.author.id)}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/article?title=${article.title}">${article.title}</a></td>
            <td>${article.text}</td>
            <td><fmt:setLocale value="en-EN"/>
                    <fmt:parseDate value="${article.date}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
                    <fmt:formatDate value="${parsedDate}"/>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/updateArticles?id=${article.id}">
                    <button type="submit" name="update" >update</button>
                </form>
            </td>
        </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
