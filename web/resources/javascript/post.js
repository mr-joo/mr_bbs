$(document).ready(function () {

    var $title = $("#title");
    var $mainText = $("#mainText");
    var $name = $("#name");

    function checkValid() {
        var title = $title.val();
        var mainText = $mainText.val();
        var name = $name.val();

        if (!title) {
            alert("제목을 입력해주세요.");
            return false;
        }

        if (title.length > 20) {
            alert("제목은 20자까지 입력 가능합니다.");
            return false;
        }

        if (!mainText) {
            alert("내용을 입력해주세요.");
            return false;
        }

        if (mainText.length > 200) {
            alert("내용은 200자까지 입력 가능합니다.");
            return false;
        }

        if (!name) {
            alert("작성자 이름을 입력해주세요.");
            return false;
        }

        if (name.length > 20) {
            alert("작성자 이름은 20자까지 입력 가능합니다.");
            return false;
        }

        if (!confirm("저장하시겠습니까?")) {
            return false;
        }

        return true;
    }

    $("#postForm").on("submit", function (event) {

        event.preventDefault();

        if (checkValid() === false) {
            return;
        }

        var post = {
            title : $title.val(),
            mainText : $mainText.val(),
            name : $name.val()
        };

       $.ajax({
           type : "POST",
           url : "/createPost",
           dataType : "text",
           data : post,
           success : function (result) {
               console.log(result);
               console.log(true);
               console.log("true");
               if (result == "true") {
                   alert("저장 되었습니다.");
                   location.href = "/bbs";
               } else {
                   alert("저장 실패했습니다.");
               }
           },
           fail : function () {
               alert("저장 실패했습니다.");
           }
       });
    });

    $("#delete").click(function () {
        if (!confirm("삭제하시겠습니까?")) {
            return false;
        }

        alert("삭제되었습니다.");
        return true;
    });
});