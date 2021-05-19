

function signIn(userId) {
    // var userId = document.getElementById("userId").value;
    $.ajax({
        url: "/user/signIn",
        type: "GET",
        data: {
            userId: userId
        },
    })
        .done(function (fragment) {
            $('#userInform').replaceWith(fragment);
        });
}

$(document).ready(
    function setList() {
        $.ajax({
            url: "/arealist",
            type: "GET",
            data: {
            },
        })
            .done(function (fragment) {
                $("#sortList").replaceWith(fragment);
            });
    }
);
