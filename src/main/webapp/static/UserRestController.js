var RestGet = function() {

    $.ajax({
        type: 'GET',
        url:  "/outdoorpanel",
        success: function(result) {
            alert("At " + result.time
                + ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });

}