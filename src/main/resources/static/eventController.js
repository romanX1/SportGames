$(document).ready(function () {
    getAllPlaygrounds();

    $("#id_btn").on("click", function () {
        getAllPlaygrounds();
    });
});

function getAllPlaygrounds() {
    $.ajax({
        url: "/api/playgrounds/",
        type: "GET",
        async: false,

        success: function (grounds) {
            var select = $('#exampleFormControlSelect1');
            $.each(grounds, function (index, value) {
                select.append('<option value="'+value.id+'">' + value.address + '</option>')
            });
        }
    })
}


function getAuth(id) {
    $.ajax({
        url: "/api/events/"+id+"/join",
        type: "GET",
        async: false,
        success: function (user) {

            //$(event.users).each(function (i, user) {
            $("#user-trs").append(
                "<tr id="+ user.id+">" +
                "   <td>"+ user.name+"</td>" +
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
        url: "/api/events/"+id+"/del",
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
            "<tr id="+user.id+">" +
            "   <td>"+user.name+"</td>" +
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
            var tbl=$('#tablebody_1');
            tbl.empty();
            $.each(data, function (i, v) {
                tbl.append("<tr>" +
                    "<td>"+ v.playground.address +"</td>" +
                    "<td>"+ v.sport.type +"</td>" +
                    "<td>"+ v.timeStart.dayOfMonth + " " + v.timeStart.month + " " + v.timeStart.year + " " + v.timeStart.hour + ":" + v.timeStart.minute + "</td>" +
                    "<td style='text-align: center'>"+ v.timeEnd.hour + ":" + v.timeEnd.minute +"</td>" +
                    "<td>"+ v.users.length+"</td>" +
                    "<td>" +
                    "<form method='get' action='/event' > " +
                    "<input type='hidden' name='eventId' value='"+v.id+"'>" +
                    "<button type='submit'>открыть событие</button>" +
                    "</form>" +
                    "</td>" +
                    "</tr>")
            });
        }
    });
}

function getEventsByPlaygroundAndType(id, type) {
    var events;
    $.ajax({
        url:"api/events/"+id+"/"+type,
        type:"GET",
        async:false,
        success:function (data) {
            events=data;
        }
    });
    return events;
}
