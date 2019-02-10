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

