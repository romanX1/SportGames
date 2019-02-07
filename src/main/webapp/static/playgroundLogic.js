function playGroundsByType(typeId, typeName) {
    $.ajax({
        url: "/api/playgrounds/byId/"+typeId,
        type: "GET",
        async: false,
        data: typeId,
        success: function (data) {
            var tbl=$('#pg_tbl');
            $('#header1').text(typeName);
            document.title='Площадки на которых доступен '+typeName;
            tbl.empty();
            $.each(data, function (i, v) {
                console.log('added address');
                tbl.append('<tr><td>'+data[i].address+'</td></tr>');
            });
        }
    });
}
