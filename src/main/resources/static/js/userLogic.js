function getUserByName(name) {
    $.ajax({
        url: "/api/users/" + name ,
        type: "GET",
        async: false,
        success: function (event) {
            result = event;
        }
    });
    return result;
}

function checkParam(){

}
function checkDuplicateName(name){
    $.ajax({
        url: "/api/users/" + name ,
        type: "GET",
        async: false,
        success: function (answer){
            if(answer){
                $("#warning").style=display:on;
            }
        }
    })
}
function TestLogin1(login){

    if(/^[a-zA-Z1-9]+$/.test(login) === false)
    {alert('В логине должны быть только латинские буквы'); return false;}
    if(login.length < 4 || login.length > 20)
    { alert('В логине должен быть от 4 до 20 символов'); return false;}
    if(parseInt(login.substr(0, 1)))
    {alert('Логине должен начинаться с буквы'); return false;}

    return true;
}
