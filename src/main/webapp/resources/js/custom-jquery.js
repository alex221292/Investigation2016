var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

jQuery(document).ready(function ($) {

    $('.products').submit(function (event) {

        event.preventDefault();

        var target = $( event.target );
        addItemViaAjax(target.find('#productid').val());

    });

    $('.box-content-categories').click(function (event) {

        event.preventDefault();

        var target = $( event.target );
        getPageContext(target.attr("class"));

    });

    getPageContext(1);

    $('body').append('<div id="blackout"></div>');

    var boxWidth = 400;

    var currentCategory = $.cookie('currentCategory');
    if (currentCategory == null) currentCategory = 1;

    function centerBox() {

        /* Preliminary information */
        var winWidth = $(window).width();
        var winHeight = $(document).height();
        var scrollPos = $(window).scrollTop();
        /* auto scroll bug */

        /* Calculate positions */

        var disWidth = (winWidth - boxWidth) / 2
        var disHeight = scrollPos + 150;

        /* Move stuff about */
        $('.popup-box').css({'width': boxWidth + 'px', 'left': disWidth + 'px', 'top': disHeight + 'px'});
        $('#blackout').css({'width': winWidth + 'px', 'height': winHeight + 'px'});

        return false;
    }


    $(window).resize(centerBox);
    $(window).scroll(centerBox);
    centerBox();

    $('[class*=popup-link]').click(function (e) {

        e.preventDefault();
        e.stopPropagation();

        var name = $(this).attr('class');
        var id = name[name.length - 1];
        var scrollPos = $(window).scrollTop();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "cart/api/prepareOrder",
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log(data);
                displayPopUp(data);
            },
            error: function (e) {
                console.log(e);
            },
            done: function (e) {
                console.log(e);
            }
        });

        $('#popup-box-' + id).show();
        $('#blackout').show();
        $('html,body').css('overflow', 'hidden');

        /* Fixes a bug in Firefox */
        $('html').scrollTop(scrollPos);

    });
    $('[class*=popup-box]').click(function (e) {
        /* Stop the link working normally on click if it's linked to a popup */
        e.stopPropagation();
    });
    $('html').click(function () {
        var scrollPos = $(window).scrollTop();
        /* Hide the popup and blackout when clicking outside the popup */
        $('[id^=popup-box-]').hide();
        $('#blackout').hide();
        $("html,body").css("overflow", "auto");
        $('html').scrollTop(scrollPos);
    });
    $('.close').click(function () {
        var scrollPos = $(window).scrollTop();
        /* Similarly, hide the popup and blackout when the user clicks close */
        $('[id^=popup-box-]').hide();
        $('#blackout').hide();
        $("html,body").css("overflow", "auto");
        $('html').scrollTop(scrollPos);
    });

});

function addItemViaAjax(productId) {
    var productItem = {};
    productItem["productId"] = productId;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "cart/api/addItem",
        data: JSON.stringify(productItem),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            display(data);
        },
        error: function (e) {
            display(e);
        },
        done: function (e) {
        }
    });
}

function getPageContext(category_id) {
    var productItem = {};
    productItem["productId"] = category_id;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "page/api/loadPage",
        data: JSON.stringify(productItem),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log(data);
            pageLoad(data);
        },
        error: function (e) {
            console.log(e);
            display(e);
        },
        done: function (e) {
            console.log(e);
        }
    });
}

function display(data) {
    var itemsCount = data['results'].itemsCount;
    var fullPrice = data['results'].fullPrice;
    $('#articles').html(itemsCount);
    $('#fullPrice').html(fullPrice + " ₽");
}

function pageLoad(data) {
    var itemsCount = data['results'].itemsCount;
    var fullPrice = data['results'].fullPrice;
    $('#articles').html(itemsCount);
    $('#fullPrice').html(fullPrice + " ₽");
    var categories = data['results'].categories;
    var cList = $('ul.box-content-categories');
    $('ul.box-content-categories').empty();
    if (categories != null && categories.length > 0) {
        categories.forEach(function (item, i, arr) {
            var className = item.id;
            var categoryName = item.name;
            var li = $('<li/>')
                .appendTo(cList);
            var aaa = $('<a/>')
                .addClass(className)
                .text(categoryName)
                .appendTo(li);

        });
    }
    var pList = $('.products ul');
    $('.products ul').empty();
    var products = data['results'].products;
    if (products != null && products.length > 0) {
        products.forEach(function (item, i, arr) {
            var formId = "add-item" + item.id;
            var li = $('<li/>')
                .appendTo(pList);
            var form = $('<form/>')
                .attr('id', formId)
                .appendTo(li);
            form.append(
                $("<input>",
                    {
                        type: 'hidden',
                        name: 'productid',
                        id: 'productid',
                        value: item.id
                    }
                )
            );
            form.append(
                $("<input>",
                    {
                        type: 'submit',
                        name: 'submit',
                        class: 'buy-submit',
                        value: 'Buy'
                    }
                )
            );
            var productInfo = $('<div/>')
                .addClass('product-info')
                .appendTo(form);
            var productName = $('<h3/>')
                .text(item.productName)
                .appendTo(productInfo);
            var productDesc = $('<div/>')
                .addClass('product-desc')
                .appendTo(productInfo);
            var productDescH4 = $('<h4/>')
                .appendTo(productDesc);
            var productPrice = $('<strong/>')
                .addClass('price')
                .text(item.cost + ' ₽')
                .appendTo(productDesc);
        });
    }
}

function displayPopUp(data) {
    $('.products-popup').empty();
    var products = data['results'].products;
    var popupContent = "";
    if (products != null && products.length > 0) {
        products.forEach(function (item, i, arr) {
            $('.products-popup').append("<p><a href=''>" + item.productName + "</a></p>");
        });
    }
    console.log(products);
}
