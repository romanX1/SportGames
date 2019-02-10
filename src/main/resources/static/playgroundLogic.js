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
    var tbl = $('#pg_tbl');
    document.title = 'Площадки на которых доступен ' + data['type'];

    $('#thead_sport').html(data['type'] + " <button type=\"button\" class=\"btn btn-success\" style=\"float: right;padding:0\" data-toggle=\"modal\" data-target=\"#addPG\">Предложить площадку</button>")
    $.each(data['data'], function (i, v) {
        console.log('added address');
        tbl.append('<div class="row"><div class="col-lg-4" style="padding:0"><a class="list-group-item list-group-item-info" style="cursor: pointer">' + v.address + '</a></div>' +
            '<div class="col-lg-4" style="padding:0"><a class="list-group-item list-group-item-info" style="cursor: pointer">\' + v.events[0] + \'</a></div>' +
            '<div class="col-lg-4" style="padding:0"><a class="list-group-item list-group-item-info" style="cursor: pointer">\' + v.event[0] + \'</a></div></div>');
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