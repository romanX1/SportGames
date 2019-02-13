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