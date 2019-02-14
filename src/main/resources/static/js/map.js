ymaps.ready(init);

function init(data) {
    $('#map').empty();
    if (data['create'] == 'true') {
        var myPlacemark, myMap = new ymaps.Map("map", {
            center: [59.939095, 30.315868],
            zoom: 10
        }, {
            searchControlProvider: 'yandex#search'
        });

        // Слушаем клик на карте.
        myMap.events.add('click', function (e) {
            var coords = e.get('coords');

            // Если метка уже создана – просто передвигаем ее.
            if (myPlacemark) {
                myPlacemark.geometry.setCoordinates(coords);
            }
            // Если нет – создаем.
            else {
                myPlacemark = createPlacemark(coords);
                myMap.geoObjects.add(myPlacemark);
                // Слушаем событие окончания перетаскивания на метке.
                myPlacemark.events.add('dragend', function () {
                    getAddress(myPlacemark.geometry.getCoordinates());
                });
            }
            getAddress(coords);
        });

        // Создание метки.
        function createPlacemark(coords) {
            return new ymaps.Placemark(coords, {
                iconCaption: 'поиск...'
            }, {
                preset: 'islands#violetDotIconWithCaption',
                draggable: true
            });
        }

        // Определяем адрес по координатам (обратное геокодирование).
        function getAddress(coords) {
            myPlacemark.properties.set('iconCaption', 'поиск...');
            ymaps.geocode(coords).then(function (res) {
                var firstGeoObject = res.geoObjects.get(0);

                myPlacemark.properties
                    .set({
                        // Формируем строку с данными об объекте.
                        iconCaption: [
                            // Название населенного пункта или вышестоящее административно-территориальное образование.
                            firstGeoObject.getLocalities().length ? firstGeoObject.getLocalities() : firstGeoObject.getAdministrativeAreas(),
                            // Получаем путь до топонима, если метод вернул null, запрашиваем наименование здания.
                            firstGeoObject.getThoroughfare() || firstGeoObject.getPremise()
                        ].filter(Boolean).join(', '),
                        // В качестве контента балуна задаем строку с адресом объекта.
                        balloonContent: firstGeoObject.getAddressLine()
                    });
                $('#PGaddress').val(myPlacemark['properties']['_data']['balloonContent']);
                $('#PGadrCor').val(myPlacemark['properties']['_data']['balloonContent']);
                $('#PGpoint').val(myPlacemark['geometry']['_coordinates']);

            });
        }
    } else {
        var allPG;
        if (data['data'].length > 0 || data['type']!==undefined) {
            allPG = data['data'];
        } else {
            console.log(data);
            $.ajax({
                url: "/api/playgrounds/",
                type: "GET",
                async: false,
                success: function (data) {
                    allPG = data;
                }
            });
        }
        console.log(data);
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
    // var userCoor=ipLookUp();
    // myMap.add(new ymaps.Placemark([55.694843, 37.435023], {
    //     balloonContent: 'цвет <strong>носика Гены</strong>',
    //     iconCaption: 'Очень длиннный, но невероятно интересный текст'
    // }));
}

function init(data) {
    $('#map').empty();
    if (data['create'] == 'true') {
        var myPlacemark, myMap = new ymaps.Map("map", {
            center: [59.939095, 30.315868],
            zoom: 10
        }, {
            searchControlProvider: 'yandex#search'
        });

        // Слушаем клик на карте.
        myMap.events.add('click', function (e) {
            var coords = e.get('coords');

            // Если метка уже создана – просто передвигаем ее.
            if (myPlacemark) {
                myPlacemark.geometry.setCoordinates(coords);
            }
            // Если нет – создаем.
            else {
                myPlacemark = createPlacemark(coords);
                myMap.geoObjects.add(myPlacemark);
                // Слушаем событие окончания перетаскивания на метке.
                myPlacemark.events.add('dragend', function () {
                    getAddress(myPlacemark.geometry.getCoordinates());
                });
            }
            getAddress(coords);
        });

        // Создание метки.
        function createPlacemark(coords) {
            return new ymaps.Placemark(coords, {
                iconCaption: 'поиск...'
            }, {
                preset: 'islands#violetDotIconWithCaption',
                draggable: true
            });
        }

        // Определяем адрес по координатам (обратное геокодирование).
        function getAddress(coords) {
            myPlacemark.properties.set('iconCaption', 'поиск...');
            ymaps.geocode(coords).then(function (res) {
                var firstGeoObject = res.geoObjects.get(0);

                myPlacemark.properties
                    .set({
                        // Формируем строку с данными об объекте.
                        iconCaption: [
                            // Название населенного пункта или вышестоящее административно-территориальное образование.
                            firstGeoObject.getLocalities().length ? firstGeoObject.getLocalities() : firstGeoObject.getAdministrativeAreas(),
                            // Получаем путь до топонима, если метод вернул null, запрашиваем наименование здания.
                            firstGeoObject.getThoroughfare() || firstGeoObject.getPremise()
                        ].filter(Boolean).join(', '),
                        // В качестве контента балуна задаем строку с адресом объекта.
                        balloonContent: firstGeoObject.getAddressLine()
                    });
                $('#PGaddress').val(myPlacemark['properties']['_data']['balloonContent']);
                $('#PGadrCor').val(myPlacemark['properties']['_data']['balloonContent']);
                $('#PGpoint').val(myPlacemark['geometry']['_coordinates']);

            });
        }
    } else {
        var allPG;
        if (data['data'].length > 0 || data['type']!==undefined) {
            allPG = data['data'];
        } else {
            console.log(data);
            $.ajax({
                url: "/api/playgrounds/",
                type: "GET",
                async: false,
                success: function (data) {
                    allPG = data;
                }
            });
        }
        console.log(data);
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
    // var userCoor=ipLookUp();
    // myMap.add(new ymaps.Placemark([55.694843, 37.435023], {
    //     balloonContent: 'цвет <strong>носика Гены</strong>',
    //     iconCaption: 'Очень длиннный, но невероятно интересный текст'
    // }));
}


