
// 추천 버튼 클릭
function recommendFunction(form, event){
    event.preventDefault();
    var isRecommend = form.IsRecommend.value;
    var postNum = form.POST_NUM.value;
    var email = form.userEmail.value;
    var recommend = form.recommend.value;

    if(isRecommend == 0){
        addRecommend(email, postNum, recommend);
    }else{
        deleteRecommend(email, postNum, recommend);
    }
}

function addRecommend(email, postNum, recommend){
    $.ajax({
        url: "/view/recommend/PUT",
        type: "PUT",
        data: {
            EMAIL: email,
            POST_NUM: postNum,
            RECOMMEND: recommend
        },
    }).done(function (fragment) {
        $('#recommendField').replaceWith(fragment);
    });
}

function deleteRecommend(email, postNum, recommend){
    $.ajax({
        url: "/view/recommend/DELETE",
        type: "DELETE",
        data: {
            EMAIL: email,
            POST_NUM: postNum,
            RECOMMEND: recommend
        },
    }).done(function (fragment) {
        $('#recommendField').replaceWith(fragment);
    });
}
