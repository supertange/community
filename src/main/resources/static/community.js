function postComment() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    commentToTarget(questionId, 1, content);
}

function commentToTarget(targetId, type, content) {
    if (!content) {
        alert("不能回复空内容")
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=Iv1.81af48c6c8c2952b&redirect_uri=http://localhost:8080/callback&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message)
                }
            }
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    commentToTarget(commentId, 2, content);
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comment = $("#comment-" + id);
    if (comment.hasClass("in")) {
        //折叠
        comment.removeClass("in");
        e.classList.remove("active")
    } else {
        $.getJSON("/comment/" + id, function (data) {
            console.log(data)
            var commentBody = $("comment-body-" + id);
            // commentBody.appendChild();
            var items=[];
            $.each(data, function (comment) {
                $("<div/>", {
                    "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments",
                    "id": "comment-" + id,
                    html: items.join("")
                }).appendTo(commentBody);
            });
            $("<div/>", {
                "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comments",
                "id": "comment-" + id,
                html: items.join("")
            }).appendTo(commentBody);
        });
        //展开
        comment.addClass("in");
        e.classList.add("active")
    }
}