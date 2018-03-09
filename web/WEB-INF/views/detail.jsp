<%@ taglib prefix="sc" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>CONTENT DETAIL</title>
    <link href="<sc:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script src="/resources/javascript/jquery-3.3.1.js"></script>
    <script src="/resources/javascript/custom.js"></script>
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
        </tr>
        </thead>
        <tbody>
        <tr style="text-align: center">
            <td>
                ${post.title}
            </td>
        </tr>
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
        <tr>
            <td>
                <img src="" class="img-thumbnail">
            </td>
        </tr>
        </tbody>
    </table>

    <form action="/update/${post.postNum}" method="get">
        <input type="submit" class="btn pull-left" value="수정">
    </form>

    <form action="/delete/${post.postNum}" method="get">
        <input type="submit" class="btn pull-left" id="delete" value="삭제"></input>
    </form>

    <form action="/bbs" method="get">
        <input type="submit" class="btn pull-right" value="목록"></input>
    </form>
</div>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>
                <div class="reply-title" style="text-align: center">Comment</div>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/insertComment" method="post">
                    <div class="form-group">
                    <textarea name="commentText" class="form-control" id="commentText" rows="3"
                              style="width: 1100px"></textarea>
                    </div>

                    <input type="hidden" name="postNum" value="${post.postNum}">
                    <input type="submit" class="btn pull-right" value="댓글 등록">
                </form>
            </td>
        </tr>

        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td class="comment-area">
                    <span name="comment">${comment.commentText}</span>
                    <textarea name="updateCommentText" class="form-control" rows="3"
                              style="width: 1100px; display:none;"></textarea>

                    <input type="hidden" name="commentNum" value="${comment.commentNum}">

                    <input type="button" name="deleteComment" class="btn pull-right" value="삭제">
                    <input type="button" name="updateComment" class="btn pull-right" value="수정">
                    <input type="button" name="cancel" class="btn pull-right" style="display:none;" value="취소">
                    <input type="button" name="check" class="btn pull-right" style="display:none;" value="확인">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
