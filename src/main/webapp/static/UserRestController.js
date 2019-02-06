var RestGet = function() {

    $.ajax({
        type: 'GET',
        url:  "/outdoorpanel",
        success: function(result) {
            alert(result.message);
        },
    });

}