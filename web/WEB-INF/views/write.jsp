<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>WRITE</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script src="/resources/javascript/jquery-3.3.1.js"></script>
    <script src="/resources/javascript/custom.js"></script>
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">글쓰기</h3>
    <form action="createPost" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">제목</label>
            <input name="title" type="text" class="form-control" id="title"
                        style="width: 1000px"></input>
        </div>

        <div class="form-group">
            <label for="mainText">내용</label>
            <textarea name="mainText" class="form-control" id="mainText" rows="3"
                           style="width: 1000px"></textarea>
        </div>

        <div class="form-group">
            <label for="uploadFile">첨부 파일</label>
            <input type="file" name="uploadFile" id="uploadFile">
        </div>

        <div class="form-group">
            <label for="name">작성자</label>
            <input name="name" class="form-control" id="name"
                      style="width: 300px"></input>
        </div>

        <input type="submit" class="btn pull-right" id="submit" value="저장">
    </form>

    <form action="bbs" method="get">
        <input type="submit" class="btn pull-right" value="목록"></input>
    </form>
</div>
</body>
</html>
