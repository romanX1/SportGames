function playGroundsByType(typeId, typeName) {
    var playgrounds={};
    $.ajax({
        url: "/api/playgrounds/byId/"+typeId,
        type: "GET",
        async: false,
        data: typeId,
        success: function (data) {
            playgrounds['type']=typeName;
            playgrounds['data']=data;
        }
    });
    return playgrounds;
}
function setPGs(data) {
    var tbl=$('#pg_tbl');
    document.title='Площадки на которых доступен '+data['type'];
    tbl.empty();
    $('#thead_sport').html("Адреса площадок с "+data['type'] +" <button type=\"button\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#addPG\">Предложить площадку</button>")
    $.each(data['data'], function (i, v) {
        console.log('added address');
        tbl.append('<li class="list-group-item list-group-item-info">'+v.address+'</li>');
    });
}

function setPGmodal() {
    var sports=getAllSports();
    // <option>Mustard</option>
    // <option>Ketchup</option>
    // <option>Relish</option>
}
