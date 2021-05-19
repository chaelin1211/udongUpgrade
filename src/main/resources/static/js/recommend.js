
// 추천 버튼 클릭
function recommendFunction(form, event) {
    event.preventDefault();
    var isRecommend = form.IsRecommend.value;
    var postNum = form.POST_NUM.value;
    var recommend = form.recommend.value;

    if (isRecommend == 0) {
        addRecommend(postNum, recommend);
    } else {
        deleteRecommend(postNum, recommend);
    }
}

function addRecommend(postNum, recommend) {
    $.ajax({
        url: "/view/recommend/PUT",
        type: "PUT",
        data: {
            POST_NUM: postNum,
            RECOMMEND: recommend
        },
        error: function () {
            alert("로그인 후에 추천 가능합니다.");
        },
        success: function (fragment) {
            $('#recommendField').replaceWith(fragment);
        }
    })
}

function deleteRecommend(postNum, recommend) {
    $.ajax({
        url: "/view/recommend/DELETE",
        type: "DELETE",
        data: {
            POST_NUM: postNum,
            RECOMMEND: recommend
        },
    }).done(function (fragment) {
        $('#recommendField').replaceWith(fragment);
    });
}
