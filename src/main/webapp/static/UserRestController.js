function RestGet(type) {

    $.ajax({
        type: 'GET',
        url:  "/outdoorpanel",
        data:{type: type},
        success: function(result) {
            alert(result.message);
        },
    });

}