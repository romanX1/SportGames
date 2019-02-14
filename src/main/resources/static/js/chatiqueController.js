// function sendMessage() {
//     var user=$('#userName').val();
//     var text=$('#MSGtext').val();
//     var message={};
//
// }
//
// $(document).ready(function () {
//     setInterval(()=>{
//         getAndSetMessages(location.pathname.split("=")[1]);
//     }, 3000);
// });
//
// function getAndSetMessages(id) {
//     var messages=$('#messages');
//     $.ajax({
//         URL: "/api/chatique/get"+id,
//         async: false,
//         method: "GET",
//         success: function (data) {
//             $.each(data, function (i, v) {
//                 messages.append("<div>"+v['dateTime']+" - "+v['user']+":"+v['message']+"</div>");
//             });
//         }
//     });
// }