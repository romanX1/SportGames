function playGroundsByType(typeId) {
    $.ajax({
        url: "/api/playgrounds/byId/"+typeId,
        type: "GET",
        assync: false,
        data: typeId,
        success: function (data) {
            var tbl=$('#pg_tbl');
            tbl.empty();
            $.each(data, function (i, v) {
                console.log('added address');
                tbl.append('<tr><td>'+data[i].address+'</td></tr>');
            });
        }
    });
}