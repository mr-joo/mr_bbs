<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CONTENT DETAIL</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="color: #5e5e5e">글상세</h3>
    <table class="table">
        <thead>
        <tr>
            <th>
                <div class="tb-title" style="text-align: center">Title</div>
            </th>
            <th>
                ${post.title}
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <div style="text-align: right">Date : ${post.createDate}</div>
                <div style="text-align: right">Name : ${post.name}</div>
            </td>
        </tr>
        <tr>
            <td>
                <div>${post.mainText}</div>
            </td>
        </tr>
        </tbody>
    </table>

    <button type="button" class="btn pull-left">수정</button>
    <button type="button" class="btn pull-left">삭제</button>

    <button type="button" class="btn pull-right">목록</button>
    <input type="submit" class="btn pull-right" value="저장">
</div>

<div class="container">
    <form class="reply">
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Reply</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" style="width: 1000px"></textarea>
        </div>
        <input type="submit" class="btn pull-right" value="댓글 등록">
    </form>
</div>
</body>
</html>
