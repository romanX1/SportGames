function TestLogin1(login){
    if(/^[\w]{1}[\w-\.]*@[\w-]+\.[a-z]{2,4}$/i.test(login) === false)
    {alert('Указан неверный формат email'); return false;}
    // if(login.length < 4 || login.length > 20)
    // { alert('В логине должен быть от 4 до 20 символов'); return false;}
    // if(parseInt(login.substr(0, 1)))
    // {alert('Логине должен начинаться с буквы'); return false;}
    return true;
}

function TestPass() {
    var pass1 = $("#password").val();
    var pass2 = $("#password2").val();
    if (pass1 == pass2) {
        $("#warning2").hide();
        return true;
    } else {
    $("#warning2").show();
    return false;
}
}
function isExist(name){
    $.ajax({
        url: "/api/users/{name}",
        type: "GET",
        async: false,
        success: function (answer) {
            if (answer){
                $("#warning").show();
            } else{
                $("#warning").hide();
            }
        }
    });
    return sports;
}