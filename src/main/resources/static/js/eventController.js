
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
                    "<tr class='tr-link blue-grey-text' data-href='/event/"+v.id+"' class='blue-grey-text'>" +
                    "<td><input name ='t1' type='hidden' value='"+v.timeStart+"' />" + v.timeStart.split("@")[0] + " </td>" +
                    "<td style='text-align: center'> " + v.timeStart.split("@")[1].split(":")[0]+ ":" + v.timeStart.split("@")[1].split(":")[0] + " - " + v.timeEnd.split("@")[1].split(":")[0]+ ":" + v.timeEnd.split("@")[1].split(":")[1] + "</td>" +
                    "<td>" + v.sport.type + "</td>" +
                    "<td>" + v.playground.address + "</td>" +
                    "<td>" + v.users.length + "</td>" +
                    "</tr>")
            });


            let trs = $(tbl).children();
            $(tbl).empty();
            //
            trs.sort(function (a, b) {
                let date2 = $(a).find("[name ='t1']").val().split(' ');
                let date1 = $(b).find("[name ='t1']").val().split(' ');
                //return date1[2] < date2[2] ? date1[2] - date2[2]
                return  date2[1] < date1[1] ? date2[1].localeCompare(date1[1])
                    :  date2[0] - date1[0];

            });
            $(trs).each(function(i, v) {
                $(tbl).append(v);
            });

            $('tr[data-href].tr-link').on("click", function() {
                document.location = $(this).data('href');
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
//