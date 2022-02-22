$(document).ready(function() {
    $('#fullpage').fullpage({
        //options here
        autoScrolling: true,
        scrollHorizontally: true,
        sectionsColor: ['pink', 'yello', 'red', 'blue'],
        anchors: ['firstPage', 'secondPage', 'thirdPage', 'fourthPage'],
        menu: '#myMenu',
        navigation: true,
        navigationPosition: 'right',
        navigationTooltips: ['first page', 'second page', 'third page', 'fourth page'],
        slidesNavigation: true,
        slidesNavPosition: 'bottom',
        sectionSelector: '.section',



    });

});

var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();
$(window).scroll(function(event) { didScroll = true; });
setInterval(function() {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);


$(function() {
    $('.bxslider').bxSlider({
        mode: 'fade',
        infiniteLoop: true,
        hideControlOnEnd: true,
        captions: true,
        slideWidth: 600,
        captions: false,
        controls: false,
        infiniteLoop: true,
        auto: true,
        autoHover: true,
        pager: false
    });
});


var text = $('.text').text(),
    textArr = text.split('');

$('.text').html('');

$.each(textArr, function(i, v) {
    if (v == ' ') { $('.text').append('<span class="space"></span>'); }
    $('.text').append('<span>' + v + '</span>');
})


// map
var btn1 = document.getElementById("btn1");
var btn2 = document.getElementById("btn2");
var btn3 = document.getElementById("btn3");
// 각각 버튼에 이벤트 추가
btn1.addEventListener("click", changeMap1);
btn2.addEventListener("click", changeMap2);
btn3.addEventListener("click", changeMap3);


// AOS 애니메이션



// function initMap() {
//     navigator.geolocation.getCurrentPosition(
//         function(position) {

//             var location = { lat: position.coords.latitude, lng: position.coords.longitude };

//             var map = new google.maps.Map(
//                 document.getElementById('map'), {
//                     zoom: 16,
//                     center: location

//                 });
//             var marker = new google.maps.Marker({
//                 position: location,
//                 map: map,
//                 title: "여기 계시군요!"
//             });

//         }

//     )

// }