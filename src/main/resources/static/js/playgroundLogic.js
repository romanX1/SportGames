function playGroundsByType(typeId, typeName) {
    var playgrounds = {};
    $.ajax({
        url: "/api/playgrounds/byId/" + typeId,
        type: "GET",
        async: false,
        data: typeId,
        success: function (data) {
            playgrounds['type'] = typeName;
            playgrounds['data'] = data;
        }
    });
    return playgrounds;
}

function getCoords(value){
    var geo;
    var inpt=$('#PGpoint');
    var myGeocoder = ymaps.geocode($(value).val());
    setTimeout( () => {
        myGeocoder.then(function (res) {
            geo = res;
            console.log(geo);
            console.log(geo['geoObjects']['properties']['_data']['metaDataProperty']['GeocoderResponseMetaData']['Point']['coordinates']);
            inpt.val(geo['geoObjects']['properties']['_data']['metaDataProperty']['GeocoderResponseMetaData']['Point']['coordinates']);

        });
    }, 1000);
    // $(value).val(geo['geoObjects']['properties']['_data']['metaDataProperty']['GeocoderResponseMetaData']['SourceMetaDataList']['GeocoderResponseMetaData']['request']);
}

function setPGs(data) {
    init(data);
    var tbl = $('#pg_tbl_1');
    document.title = 'Площадки на которых доступен ' + data['type'];
    $("#map_modal_h4").empty();
    $("#map_modal_h4").append(data['type']);
    tbl.empty();
    tbl.append('<div class="panel-heading">Адреса площадок</div>');
    $('#thead_sport').html(data['type'] + " <button type=\"button\" style=\"float:right;padding:0;display:inline-block\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#addPG\">Предложить площадку</button>" +
        "<button type=\"button\" style=\"float:right;padding:0;display:inline-block;margin-right:2px\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#showMap\">Показать на карте</button>");
    $.each(data['data'], function (i, v) {
        console.log('added address');
        tbl.append('<div class="panel-body" style="cursor: pointer;" onclick="setEventsForPlaygrond('+v.id+',\''+data['type']+'\')"><a>'+v.address+'</a></div>');
    });
}

function supplyPlayground() {
    var allSports = getAllSports();
    var formsData = $('#PGsports').val();
    var formsAddr = $('#PGaddress').val();
    var coordinates=$('#PGpoint').val();
    var adrPG = [];
    $.each(formsData, function (i, v) {

        adrPG[i] = allSports[formsData[i] - 1];
    });


    coordinates = $(coordinates.split(','))
    let point = {
        'x' : Number.parseFloat(coordinates[1]),
        'y' : Number.parseFloat(coordinates[0])
    };
    let playground = {
        'address': formsAddr,
        'sports': adrPG,
        'coordinates': point
    };

    $.ajax({
        url: "/api/playgrounds/supply",
        contentType: "application/json; charset=utf-8",
        beforeSend: function (request) {
            request.setRequestHeader("X-CSRF-TOKEN", $('[name=_csrf]').val());
        },
        method: "POST",
        data: JSON.stringify(playground),
        success:
            function (data) {
                console.log(data);
                $('#supply_close').click()
                $('#btnPGresult').click();
                $('#result_h4').text("Площадка добавлена");

            },
            error: function (error) {
                $('#supply_close').click()
                $('#btnPGresult').click();
                $('#result_h4').text("Ошибка при добавлении площадки");
                console.log(error);
            }
    });
}

function setEventsForPlaygrond(id, type){
    var tbl= $('#pg_tbl_2');
    tbl.empty();
    tbl.append('<div class="panel-heading">Расписание и участники <a href="/addnewevent?id='+id+'&type='+type+'" type="button" class="btn btn-success" style="float: right;padding: 0 0.5% 0 0.5%;" data-toggle="modal">Добавить событие</a></div>');
    var events=getEventsByPlaygroundAndType(id, type);
    $.each(events, function (i, v) {
        var date=v.timeStart.split("@")[0];
        var timeStart=v.timeStart.split("@")[1];
        var timeEnd=v.timeEnd.split("@")[1]
        tbl.append('<div class="panel-body" style="cursor: pointer;" ><a target="_blank" href="/event?eventId='+v.id+'">'+
            date+' с '+timeStart+' по '+ timeEnd+' зарегестрировано '+v.users.length+' участников</a></div>');
    });
}
