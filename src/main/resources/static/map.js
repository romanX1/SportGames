ymaps.ready(init);

function init(data) {
    $('#map').empty();
    var allPG;
    if(data['data'].length>0){
        allPG=data['data'];
   } else{ $.ajax({
        url: "/api/playgrounds/",
        type: "GET",
        async: false,
        success:function (data) {
            allPG = data;
        }
    });}

    var myMap = new ymaps.Map("map", {
            center: [59.939095, 30.315868],
            zoom: 10
        }, {
            searchControlProvider: 'yandex#search'
        });

    $.each(allPG, function (i, v) {
        myMap.geoObjects
            .add(new ymaps.Placemark([v.coordinates.x, v.coordinates.y], {
                balloonContent: v.address
            }, {
                preset: 'islands#blueCircleDotIcon'
            }));
    });

}
