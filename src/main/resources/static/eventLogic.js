
function getAuth(id) {
    $.ajax({
        url: "/api/events/"+id+"/join",
        type: "GET",
        async: false,
        success: function (user) {

            //$(event.users).each(function (i, user) {
                $("#user-trs").append(
                    "<tr id=''>" +
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

            //$(event.users).each(function (i, user) {
            $("#user-trs").remove(
                "<tr id=''>" +
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