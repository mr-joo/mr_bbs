<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2018-02-20
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WRITE</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">글쓰기</h3>
    <form:form modelAttribute="post">
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <form:input path="title" type="text" class="form-control" id="exampleFormControlInput1"
                        style="width: 1000px"></form:input>
        </div>

        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <form:textarea path="main_text" class="form-control" id="exampleFormControlTextarea1" rows="3"
                           style="width: 1000px"></form:textarea>
        </div>

        <input type="submit" class="btn pull-right" value="저장">
    </form:form>

    <form action="bbs" method="get">
        <input type="submit" class="btn pull-right" value="목록"></input>
    </form>
</div>
</body>
</html>
