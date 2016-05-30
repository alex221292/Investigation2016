
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

jQuery(document).ready(function ($) {

    var sessionData = "${sessionScope.itemsCount}";
    $('#jsontest').html(sessionData);

    $("#add-item").submit(function (event) {

        // Prevent the form from submitting via the browser.
        event.preventDefault();

        searchViaAjax();

    });

});

function searchViaAjax() {

    var productItem = {};
    productItem["productId"] = $("#productid").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "additem",
        data : JSON.stringify(productItem),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });

    function display(data) {
        var json = JSON.stringify(data, null, 4) + "</pre>";
        $('#jsontest').html(json);
    }

}