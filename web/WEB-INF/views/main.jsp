<%@ taglib prefix="sc" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BBS</title>
    <link href="<sc:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">게시판</h3>
    <table class="table">
        <colgroup>
            <col style="text-align: center; width: 20px">
            <col style="text-align: center; width: 300px">
            <col style="text-align: center; width: 200px">
            <col style="text-align: center; width: 300px">
        </colgroup>
        <thead style="text-align: center">
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Title</th>
            <th scope="col">Name</th>
            <th scope="col">Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${postList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><a href="/detail/${post.postNum}">${post.title}</a></td>
                <td>${post.name}</td>
                <td>${post.createDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/write">
        <input type="button" class="btn pull-right" value="글쓰기">
    </a>
</div>
</body>
</html>
