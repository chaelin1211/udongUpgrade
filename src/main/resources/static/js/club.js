function searchClubLoaction(form, event) {
    event.preventDefault();

    var areaName = form.AREA_NAME.value;

    $.ajax({
        url: "/club/search/location",
        type: "GET",
        data: {
            AREA_NAME: areaName
        }
    }).done(function (fragment) {
        $("#clubList").replaceWith(fragment);
    })
}

function searchClubInterest(form, event) {
    event.preventDefault();

    var interestName = form.INTEREST_NAME.value;

    $.ajax({
        url: "/club/search/interest",
        type: "GET",
        data: {
            INTEREST_NAME: interestName
        }
    }).done(function (fragment) {
        $("#clubList").replaceWith(fragment);
    })
}

function checkBoxFunction() {
    var inputField = document.getElementById("PINField");
    var checkBoxValue = document.getElementById("pinCheckField");
    if(checkBoxValue.checked == true){
        inputField.disabled = false;
    }else {
        inputField.disabled = true;
    }
}