$(document).ready(function () {
    $('.nav li [href="'+location.pathname+'"]').parent().addClass('active');
});