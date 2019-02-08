function playGroundsByType(typeId, typeName) {
    $.ajax({
        url: "/api/playgrounds/byId/"+typeId,
        type: "GET",
        assync: false,
        data: typeId,
        success: function (data) {
            var tbl=$('#pg_tbl');
            document.title='Площадки на которых доступен '+typeName;
            tbl.empty();
            $('#thead_sport').text('Адреса площадок с '+typeName)
            $.each(data, function (i, v) {
                console.log('added address');
                tbl.append('<li class="list-group-item list-group-item-info">'+data[i].address+'</li>');
            });
        }
    });
}