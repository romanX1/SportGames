function playGroundsByType(typeId, typeName) {
    $.ajax({
        url: "/api/playgrounds/byId/"+typeId,
        type: "GET",
        assync: false,
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

function getUserForEventById(id) {
    var result = {};
    $.ajax({
        url: "/api/events/" + id + "/users",
        type: "GET",
        async: false,
        success: function (users) {
            result = users;
        }
    });
    return result;
}

function getEventById(id) {
    var result = {};
    $.ajax({
        url: "/api/events/" + id ,
        type: "GET",
        async: false,
        success: function (event) {
            result = event;
        }
    });
    return result;
}

function getAndFillEventForModal(id) {
    var event = getEventById(id);
    fillEventToModal(event);
}

function fillEventToModal(event) {
    $("#header").text(event.sport.type+' с '+ event.timeStart + ' по ' + event.timeEnd);
    $(event.users).each(function (i, user) {
        $("#user-trs").append(
            "<tr id=''>" +
            "   <td>"+user.name+"</td>" +
            "</tr>"
        );
    })
}