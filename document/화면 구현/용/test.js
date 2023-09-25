$(document).ready(function(){
    $('.list_category li').on('click', function() {
        $('.list_category li').removeClass('selected');
        $(this).addClass('selected');
    });
});