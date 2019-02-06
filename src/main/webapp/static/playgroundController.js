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
    $("#header").text(event.sport.type+' с '+ Date.foevent.timeStart + ' по ' + event.timeEnd);
    $(event.users).each(function (i, user) {
        $("#user-trs").append(
            "<tr id=''>" +
            "   <td>"+user.name+"</td>" +
            "</tr>"
        );
    })
}