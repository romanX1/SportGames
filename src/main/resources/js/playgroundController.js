function playGroundsByType(type){
    $.ajax({
        url: "rest/PlaygroundRestController",
        type: "POST",
        data:type,
        success: function(data){}
    });
}