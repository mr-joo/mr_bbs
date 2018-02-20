<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2018-02-20
  Time: 오후 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CONTENT DETAIL</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/detail.css"/>" rel="stylesheet">
</head>
<body>
<h3 style="color: #5e5e5e">글상세</h3>
<table class="table">
    <thead>
    <tr>
        <th>
            <div class="tb-title" style="text-align: center">Title</div>
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <div style="text-align: right">Date :</div>
            <div style="text-align: right">Name :</div>
        </td>
    </tr>
    <tr>
        <td>
            <div>본문 들어갈 자리</div>
        </td>
    </tr>
    </tbody>
</table>

<button type="button" class="btn pull-left">수정</button>
<button type="button" class="btn pull-left">삭제</button>

<button type="button" class="btn pull-right">목록</button>
<input type="submit" class="btn pull-right" value="저장">
</body>
</html>
