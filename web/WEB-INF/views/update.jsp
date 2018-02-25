<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WRITE</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">글 수정</h3>
    <form action="/update/${post.postNum}" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input name="title" type="text" class="form-control" id="title"
                        style="width: 1000px" value="${post.title}"></input>
        </div>

        <div class="form-group">
            <label for="mainText">내용</label>
            <textarea name="mainText" class="form-control" id="mainText" rows="3"
                           style="width: 1000px">${post.mainText}</textarea>
        </div>

        <input type="submit" class="btn pull-right" value="저장">
    </form>

    <form action="/bbs" method="get">
        <input type="submit" class="btn pull-right" value="목록"></input>
    </form>
</div>
</body>
</html>
