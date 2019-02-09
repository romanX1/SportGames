function getAllSports(){
    var sports;
    $.ajax({
        url: "/api/sport/all",
        type: "GET",
        async: false,
        success: function (data) {
            sports=data;
        }
    });
    return sports;
}