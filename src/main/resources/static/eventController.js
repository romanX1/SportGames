
function getAuth(id) {
    $.ajax({
        url: "/api/events/" + id + "/join",
        type: "GET",
        async: false,
        success: function (user) {

            //$(event.users).each(function (i, user) {
            $("#user-trs").append(
                "<tr id=" + user.id + ">" +
                "   <td>" + user.name + "</td>" +
                "</tr>"
            );
            // })
        },

        error: function (error) {
            console.log(error)
        }
    });
}

function deleteAuth(id) {
    $.ajax({
        url: "/api/events/" + id + "/del",
        type: "GET",
        async: false,
        success: function (user) {
            var elem = document.getElementById(user.id);
            elem.remove();
        },

        error: function (error) {
            console.log(error)
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
        url: "/api/events/" + id,
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
    $("#header").text(event.sport.type + ' с ' + event.timeStart + ' по ' + event.timeEnd);
    $(event.users).each(function (i, user) {
        $("#user-trs").append(
            "<tr id=" + user.id + ">" +
            "   <td>" + user.name + "</td>" +
            "</tr>"
        );
    })
}

function getAllSportEvents() {
    $.ajax({
        url: "api/events/",
        type: "GET",
        async: false,
        success: function (data) {
            var tbl = $('#tablebody_1');
            tbl.empty();
            $.each(data, function (i, v) {
                tbl.append(
                    "<tr>" +
                    "<td><input name ='t1' type='hidden' value='"+v.timeStart+"' />" + v.timeStart.split("@")[0] + " </td>" +
                    "<td style='text-align: center'> " + v.timeStart.split("@")[1] + "  " + v.timeEnd.split("@")[1] + "</td>" +
                    "<td>" + v.sport.type + "</td>" +
                    "<td>" + v.playground.address + "</td>" +
                    "<td>" + v.users.length + "</td>" +
                    "<td>" +
                    "<form method='get' action='/event' > " +
                    "<input type='hidden' name='eventId' value='" + v.id + "'>" +
                    "<button type='submit'>открыть событие</button>" +
                    "</form>" +
                    "</td>" +
                    "</tr>")
            });

            let trs = $(tbl).children();
            $(tbl).empty();
            //
            trs.sort(function (a, b) {
                let date1 = $(a).find("[name ='t1']").val().split(' ');
                let date2 = $(b).find("[name ='t1']").val().split(' ');
                //return date1[2] < date2[2] ? date1[2] - date2[2]
                return  date2[1] < date1[1] ? date2[1].localeCompare(date1[1])
                    :  date2[0] - date1[0];

            });
            $(trs).each(function(i, v) {
                $(tbl).append(v);
            });
        }
    });
}

function getEventsByPlaygroundAndType(id, type) {
    var events;
    $.ajax({
        url: "api/events/" + id + "/" + type,
        type: "GET",
        async: false,
        success: function (data) {
            events = data;
        }
    });
    return events;
}
