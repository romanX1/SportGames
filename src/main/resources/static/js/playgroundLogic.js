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

function setPGs(data) {
    var tbl = $('#pg_tbl_1');
    document.title = 'Площадки на которых доступен ' + data['type'];
    tbl.empty();
    tbl.append('<div class="panel-heading">Адреса площадок</div>');
    $('#thead_sport').html(data['type'] + " <button type=\"button\" class=\"btn btn-success\" style=\"float: right;\" data-toggle=\"modal\" data-target=\"#addPG\">Предложить площадку</button>")
    $.each(data['data'], function (i, v) {
        console.log('added address');
        tbl.append('<div class="panel-body" style="cursor: pointer;" onclick="setEventsForPlaygrond('+v.id+',\''+data['type']+'\')">'+v.address+'</div>');
    });
}

function supplyPlayground() {
    var allSports = getAllSports();
    var formsData = $('#PGsports').val();
    var formsAddr = $('#PGaddress').val();
    var adrPG = [];
    $.each(formsData, function (i, v) {
        adrPG[i] = allSports[formsData[i] - 1];
    });

    $.ajax({
        url: "/api/playgrounds/supply",
        contentType: "application/json; charset=utf-8",
        beforeSend: function (request) {
            request.setRequestHeader("X-CSRF-TOKEN", $('[name=_csrf]').val());
        },
        method: "POST",
        data: JSON.stringify({
            'address': formsAddr,
            'sports': adrPG
        }),
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
    tbl.append('<div class="panel-heading">Расписание</div>');
    var events=getEventsByPlaygroundAndType(id, type);
    $.each(events, function (i, v) {
        tbl.append('<div class="panel-body" style="cursor: pointer;" onclick="setUsersForEvent('+v.id+')">'+
            v.timeStart.hour+':'+v.timeStart.minute+':'+v.timeStart.second+' - '+
            v.timeEnd.hour+':'+v.timeEnd.minute+':'+v.timeEnd.second+'</div>');
    });
}

function setUsersForEvent(id) {
    alert(id);
}