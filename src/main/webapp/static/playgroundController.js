function playGroundsByType(type){
    $.ajax({
        url: "/playgroundRest",
        type: "POST",
        data:{type: type},
        success: function(data){
        alert(data);
        }
    });
}