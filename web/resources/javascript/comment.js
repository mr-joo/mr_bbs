$(document).ready(function () {

    $("td[class=comment-area] > input[name=updateComment]").click(function () {
        var $self = $(this);

        var $commentSpan = $self.parent().children("span[name=comment]");
        var commentVal = $commentSpan.text();
        $commentSpan.hide();


        var $commentBox = $self.parent().children("textarea[name=updateCommentText]");
        $commentBox.val(commentVal);
        $commentBox.show();

        $self.hide();

        var $deleteBtn = $self.parents().children("input[name=deleteComment]");
        $deleteBtn.hide();

        var $checkBtn = $self.parents().children("input[name=check]");
        $checkBtn.show();

        var $cancelBtn = $self.parents().children("input[name=cancel]");
        $cancelBtn.show();
    });

    $("td[class=comment-area] > input[name=check]").click(function () {
        var $self = $(this);
        var $commentNum = $self.parents().children("input[name=commentNum]");
        var $commentBox = $self.parents().children("textarea[name=updateCommentText]");
        var $updateComment = $self.parents().children("span[name=comment]");
        var $checkBtn = $self.parents().children("input[name=check]");
        var $cancelBtn = $self.parents().children("input[name=cancel]");
        var $updateBtn = $self.parents().children("input[name=updateComment]");
        var $deleteBtn = $self.parents().children("input[name=deleteComment]");

        $.post("/updateComment",
            {
                commentText: $commentBox.val(),
                commentNum: $commentNum.val()
            },
            function () {
                alert("댓글이 수정되었습니다.");
                $updateComment.text($commentBox.val());
                $updateComment.show();
                $commentBox.hide();
                $checkBtn.hide();
                $cancelBtn.hide();
                $updateBtn.show();
                $deleteBtn.show();
            }
        );
    });

    $("td[class=comment-area] > input[name=cancel]").click(function () {
        var $self = $(this);

        $self.parents().children("textarea[name=updateCommentText]").hide();

        $("td[class=comment-area] > span[name=comment]").show();

        $("td[class=comment-area] > input[name=check]").hide();

        $self.hide();

        $("td[class=comment-area] > input[name=deleteComment]").show();

        $("td[class=comment-area] > input[name=updateComment]").show();
    });

    $("td[class=comment-area] > input[name=deleteComment]").click(function () {
        var $self = $(this);

        var $commentNum = $self.parents().children("input[name=commentNum]");
        var $commentBox = $self.parents().children("textarea[name=updateCommentText]");

        $.get("/deleteComment",
            {
                commentText: $commentBox.val(),
                commentNum: $commentNum.val()},
            function () {
                alert("댓글이 삭제되었습니다.");
                $self.parent().parent().remove();
        })
    })
});