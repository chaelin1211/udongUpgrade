
function check(form) {
    var ID = form.ID.value;
    var PASSWORD = form.PASSWORD.value;
    if (ID == "" || PASSWORD == "") {
        $(".warning").text("모든 값을 입력해주세요");
        return false;
    }
    else {
        $(".warning").text("");
        return true;
    }
}

function pswCheck(form) {
    var PASSWORD = form.PASSWORD;
    var C_PASSWORD = form.C_PASSWORD;
    if (PASSWORD.value != C_PASSWORD.value) {
        return false;
    }
    else return true;
}

function fieldCheck(form) {
    var NAME = form.NAME;
    var ID = form.ID;
    var TEL = form.TEL;
    var PASSWORD = form.PASSWORD;
    if (NAME.value == "" || TEL.value == "" || PASSWORD == "" || ID.value == "") {
        return false;
    }
    else {
        return true;
    }
}
function check(form) {
    var checkPSW = $("#checkPSW");
    var checkField = $("#checkField");
    var interestField = $("#interestField");
    var CheckList = $("input:checkbox[name='INTEREST']:checked");
    var pswWarning = "<p>비밀번호가 일치하지 않습니다.</p>";
    var fieldWarning = "<p>모든 값을 입력해주세요.</p>";
    var CheckWarning = "<p>관심분야를 한개 이상 선택해주세요.</p>";
    checkPSW.css("color", "red");
    checkField.css("color", "red");
    interestField.css("color", "red");
    checkField.text("");
    checkPSW.text("");
    interestField.text("");
    var flag = false;

    //비밀번호와 확인이 같은지 체크
    if (!pswCheck(form)) {
        checkPSW.append(pswWarning);
        flag = false;
    }
    else {
        checkPSW.text("");
        flag = true;
    }

    //빈 값이 있는지 체크
    if (!fieldCheck(form)) {
        checkField.append(fieldWarning);
        flag = false;
    }
    else {
        checkField.text("");
        flag = flag ? true : false;
    }

    //체크박스 체크
    if (CheckList.length == 0) {
        interestField.append(CheckWarning);
        flag = false;
    }
    else {
        interestField.text("");
        flag = flag ? true : false;
    }
    return flag;
}


function checkUser(form) {
    var userID = form.userID.value
    if (userID == "") {
        alert("로그인이 필요합니다.")
        return false
    }
    return true
}

function checkAdmin(form) {
    var goodURL = "/admin/answer"  //이곳에 인증이 되었을때 이동할 페이지  입력
    alert("패스워드를 입력하셔야 합니다.")

    var password = prompt("PASSWD 입력", "")

    if (password == null) {
        alert("출입금지")
        location = "/home"         // 실패시 이동 주소       history.back();를 넣어도 됨
    }
    else {
        var combo = password
        var total = combo.toLowerCase()

        if (total == "1234") {                // 비밀번호
            alert("안녕하세요...어서오십시요...")
            location = goodURL
        }
        else {
            alert("출입금지")
            location = "/home"    // 실패시 이동 주소      history.back();를 넣어도 됨
        }
    }
}

function checkComment(form){
    var result = checkUser(form)
    if(result==false) return false

    if(form.CONTENT.value == ""){
        alert("내용을 입력하세요")
        return false
    }else{
        return true
    }
}

function test(){
    alert("object")
    return false
}
$(document).ready(function(){
    reformTime();
});
function reformTime() {
    var time = document.getElementById('hiddenCommentTime').value;
    var string = "";

    const nowDate = new Date();
    const writeDate = new Date(time);

    var year = nowDate.getFullYear() - writeDate.getFullYear();
    if (year == 0) {
        var month = nowDate.getMonth() - writeDate.getMonth();
        if (month == 0) {
            var date = nowDate.getDate() - writeDate.getDate();
            if (date == 0) {
                var h = nowDate.getHours() - writeDate.getHours();
                if (h != 0) {
                    string = string + h + "시간 전";
                } else {
                    string = string + "방금 전";
                }
            } else {
                string = string + date + "일 전";
            }
        } else {
            string = string + month + "개월 전";
        }
    } else {
        string = string + year + "년 전";
    }
    var id = document.getElementById('commentNum').value;
    document.getElementById(id).innerHTML=string;
}