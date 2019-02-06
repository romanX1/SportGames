function playGroundsByType(typeId) {
    $.ajax({
        url: "/api/playgrounds/getBySportType/"+typeId,
        type: "GET",
        data: type,
        success: function (data) {
            alert(data);
        }
    });
}