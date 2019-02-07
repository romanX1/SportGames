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