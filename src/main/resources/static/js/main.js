// $(document).ready(function () {
//     // $('.nav-link [href="'+location.pathname+'"]').parent().addClass('active');
//   //  $( '#topheader .navbar-nav' ).find( 'li.active' ).removeClass( 'active' );
//     $( this ).parent( 'li' ).addClass( 'active' );
// });
// $(document).ready(function() {
//    // $(".nav .nav-link").on("click", function(){
//         $(".nav").find(".active-item").removeClass("active-item");
//         $(this).addClass("active-item");
//
// });

function activateItem(item) {
    $(".nav-item").removeClass("active-item")
    $("#" + item).addClass("active-item");
}
//
// $( '#topheader .navbar-nav a' ).on( 'click', function () {
//     $( '#topheader .navbar-nav' ).find( 'li.active' ).removeClass( 'active' );
//     $( this ).parent( 'li' ).addClass( 'active' );
// });
