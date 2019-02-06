var getUsers = function() {

    $.ajax({
        url: "/api/users/getAllUsers/"+typeId,
        type: "GET",
        data: type,
        success: function (data) {
            alert(data);
        }
    });
}