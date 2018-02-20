<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
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
    <link href="<c:url value="/resources/css/write.css"/>" rel="stylesheet">
</head>
<body>
<h3 style="color: #5e5e5e">글쓰기</h3>
<form>
    <div class="form-group">
        <label for="exampleFormControlInput1">Title</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" style="width: 800px">
    </div>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">Textarea</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" style="width: 800px"></textarea>
    </div>
</form>

<button type="button" class="btn pull-right">목록</button>
<input type="submit" class="btn pull-right" value="저장">
</body>
</html>
