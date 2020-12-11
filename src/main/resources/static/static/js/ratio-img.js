function imgratio() {//图片 ratio方法调用
    $(".ratio-img").each(function (index, element) {
     
        if($(this).is(":visible"))
        {
            $(this).css({height:Math.floor($(this).width()*$(this).data("ratio"))});
        }
    });

    if ($(".menu_h").is(":visible")) {

        $("a").each(function (e) {
            $(this).attr({ "target": "_self" })
        });

    }

    if ($(".menu-bon").is(":visible")) {
        $(".other-header .nav-box .nav-ul").css("min-height", $(".other-header .nav").outerHeight() - $(".other-header .left-nav").outerHeight() - $(".other-header .header-tag").outerHeight() - 30)
    }


    //高度匹配
    var winw = $(window).width();
    
    if (winw > 980) {
        $(".fina-2 dl").height("auto")
        var ui1 = $(".fina-2 .left dl").height(),
            ui2 = $(".fina-2 .right dl").height();

        if (ui1 < ui2) {
            $(".fina-2 .left dl").height(ui2)
        } else {
            $(".fina-2 .right dl").height(ui1)
        }
    }

    if (winw > 980) {
        $(".advan-2").each(function () {
            $(this).find("dl").height("auto")
            var ui1 = $(this).find(".left dl").height(),
            ui2 = $(this).find(".right dl").height();

            if (ui1 < ui2) {
                $(this).find(".left dl").height(ui2)
            } else {
                $(this).find(".right dl").height(ui1)
            }
        })
        
    }


    if ($(".f-order-box").is(":visible")) {
        $(".f-order-box .item .w").height("auto")
        var h = 25;
        var t1 = $(".f-order-box .item1 .w").outerHeight(),
            t2 = $(".f-order-box .item2 .w").outerHeight(),
            t3 = $(".f-order-box .item3 .w").outerHeight(),
        j1 = $(".f-order-box .item1 .w"),
        j2 = $(".f-order-box .item2 .w"),
        j3 = $(".f-order-box .item3 .w");



        if (winw > 767) {
            if (t1 < t2 + t3) {
                j1.outerHeight(t2 + t3 + h+2 )
            } else {
                j3.outerHeight(t1 - t2-h+1)
            }
        }
    }


}

$(function () {

    imgratio()//初始化图片ratio

    setTimeout(function () {
        imgratio();
    }, 300)

    $(".ratio-img").each(function (index, element) {
        $(this).attr({ "src": $(this).data("src") });
    });


    //窗口改变大小回调ratio；
    var rtime = new Date();
    var timeout = false;
    var delta = 500;
    $(window).resize(function () {
        rtime = new Date();
        if (timeout === false) {
            timeout = true;
            if (!$("html").hasClass("ie7")) {
                setTimeout(resizeend, delta); //resize只回调最后一次
            }
        }
    });
    function resizeend() {  //window.resize回调
        if (new Date() - rtime < delta) {
            setTimeout(resizeend, delta);
        } else {
            timeout = false;
            imgratio()//ratio
        }
    }
    //

})

//无图图像
var nullimg = ROOT+'/images/error_bg.png';
function lod(t) {
    t.onerror = null;
    t.src = nullimg;
    t.className += " ratio-img-bg";
}
$(function () {
    $(".ratio-img").each(function () {
        if ($(this).attr("src") == "") {
            $(this).attr({ "src": nullimg });
        }
    })
})