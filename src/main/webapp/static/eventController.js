function getAllPlaygrounds() {
    $.ajax({
        url: "/api/playgrounds/",
        type: "GET",
        assync: false,

        success: function (grounds) {
            var select =$('#exampleFormControlSelect1');
            $.each(grounds, function(index,value){
                select.append($('<option>', {
                value:index,
                text:value
                }
            ));
        });
}});
}
