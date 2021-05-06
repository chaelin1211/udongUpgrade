// 댓글 체크
// 댓글 내용 체크 + 로그인 확인
function checkComment(event, form) {
    event.preventDefault();

    var content = form.CONTENT;
    var email = form.EMAIL;

    var result = checkUser(email.value);
    if (result == false) return false;

    if (content.value == "") {
        alert("내용을 입력하세요")
        return false;
    } else {
        insertComment(form);
        content.value="";
        return true;
    }
}

// 댓글 삽입
function insertComment(form) {
    var EMAIL = form.EMAIL.value;
    var CONTENT = form.CONTENT.value;
    var POST_NUM = form.POST_NUM.value;
    // var CATEGORY_NAME = form.CATEGORY_NAME.value;
    $.ajax({
        url: "/view/create",
        type: "POST",
        data: {
            EMAIL: EMAIL,
            CONTENT: CONTENT,
            POST_NUM: POST_NUM,
            // CATEGORY_NAME: CATEGORY_NAME,
        },
    })
        .done(function (fragment) {
            $('#commentTable').replaceWith(fragment);
        });
}

// 댓글 삭제
function deleteComment(form) {
    var CO_NUM = form.CO_NUM.value;
    var EMAIL = form.EMAIL.value;
    var POST_NUM = form.POST_NUM.value;
    var CATEGORY_NAME = form.CATEGORY_NAME.value;
    $.ajax({
        url: "/view/delete",
        type: "DELETE",
        data: {
            CO_NUM: CO_NUM,
            EMAIL: EMAIL,
            POST_NUM: POST_NUM,
            CATEGORY_NAME: CATEGORY_NAME,
        },
    }).done(function (fragment) {
        $('#commentTable').replaceWith(fragment);
        return true;
    });
}

// 댓글 수정전 화면 수정 -> 댓글 update
function editFunction(form, event) {
    event.preventDefault();

    var content = form.CONTENT;
    var originContent = form.ORIGIN_CONTENT;
    var eventButton = event.submitter;
    var deleteButton = form.cancelButton;
    var editButton = form.editButton;

    if (eventButton.value == "수정") {
        eventButton.value = "확인";
        deleteButton.style.display = "inline";
        content.style.display = "inline";
    }
    else {
        editButton.value = "수정";
        deleteButton.style.display = "none";
        content.style.display = "none";
        if (content.value != "" && content.value != originContent.value) {
            updateComment(form);
        }
    }
    content.value = originContent.value;
}

// 댓글 update
function updateComment(form) {
    var CO_NUM = form.CO_NUM.value;
    var updateData = {
        CO_NUM: CO_NUM,
        EMAIL: form.EMAIL.value,
        POST_NUM: form.POST_NUM.value,
        CATEGORY_NAME: form.CATEGORY_NAME.value,
        CONTENT: form.CONTENT.value
    }

    $.ajax({
        url: "/view/update",
        type: "PUT",
        data: updateData,
    }).done(function (fragment) {
        $('#commentTable').replaceWith(fragment);
    });
}

