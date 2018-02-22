<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2018-02-19
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BBS</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">게시판</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col" style="text-align: center; width: 20px">No.</th>
            <th scope="col" style="text-align: center; width: 400px">Content</th>
            <th scope="col" style="text-align: center; width: 20px">Name</th>
            <th scope="col" style="text-align: center; width: 30px">Date</th>
        </tr>
        </thead>
    </table>

    <form action="/write" method="get">
        <input type="submit" class="btn pull-right" value="글쓰기">
    </form>
</div>
</body>
</html>
