// JavaScript Document
function getUrlParam (name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {return decodeURI(r[2]);
    } else{
    return null;
    }
}

$(function () {

    // 手机导航
    $(document).on("click", ".menu-bon,.ph-mask", function () {
        $("body").toggleClass("menu-open");

        if ($("body").hasClass("menu-open")) {
            $(".body-box").height($(window).height())
        } else {
            $(".body-box").height("auto")
        }
    });


    //手机导航展开
    $(".other-header .nav li .h").click(function () {
        $(this).parent().toggleClass("open").siblings().removeClass("open");
    })
    //


    //


    //
    getSize();


    //视频播放按钮
    $(document).on("click", ".js-video-list", function (e) {
        e.preventDefault();
        e.stopPropagation();
        var h = $(this).attr("href"),
            t = $(this).attr("data-title"),
            w = $(window).width();
        winw = "750px",
        winh = "410px";
        w < 500 ? winw = "90%" : 0;
        w < 500 ? winh = "220px" : 0;
        layer.open({
            title: t,
            type: 2,
            fix: false,
            area: [winw, winh],
            content: [h, "no"], //这里content是一个DOM
            success: function (index, layero) {
                setTimeout(function () {
                    layer.iframeAuto(layero);//重新计算高度
                }, 100)
            }
        });
        //返回布尔值

    })
    //


})

//调整初始化字号
function getSize () {
    var deviceWidth = "",
        d = document.documentElement;
    window.onresize = setFont;
    setFont();
    function setFont() {
        if (window.innerWidth <= 750) {
            deviceWidth = Math.min(750, window.innerWidth, d.clientWidth);
            d.style.fontSize = (deviceWidth / 750 * 100) + "px";
        } else if (window.innerWidth > 750 && window.innerWidth <= 1010) {
            d.style.fontSize = "100px";
        }else {
            d.style.fontSize = "62.5%";
    }

    };
}
//分享代码
$(function () {

    $(".t-weixin-bon").click(function () {//微信
        var url = $(this).data("img")
        var title = ""
        title += "<div class='t-weixin'>"
        title += "<i class='c'>x</i>"
        title += "<h2>Qr code</h2>"
        title += "<div class='img'><img src='" + url + "' width='120px;' height='120px;'></div>"
        title += "<p>scan</p>"
        title += "</div>"
        $("body").remove(".weixin");
        $("body").append(title)
    })
    $(document).on("click", ".t-weixin .c", function () {
        $(".t-weixin").remove();
    })

    $("a.h-weibo").click(function () {//微博
        var url = window.location.href;
        var title = document.title;
        var op = "http://service.weibo.com/share/share.php?title=" + title + "&url=" + encodeURIComponent(url) + "";
        window.open(op)
    })

    $("a.h-qq").click(function () {//QQ
        var url = window.location.href;
        var title = document.title;
        var op = "http://connect.qq.com/widget/shareqq/index.html?url=" + encodeURIComponent(url) + "&title=" + title + "&desc=&summary=&site=baidu";
        window.open(op);
    })


    $("a.h-renren").click(function () {//人人
        var url = window.location.href;
        var title = document.title;
        var op = "http://widget.renren.com/dialog/share?resourceUrl=" + encodeURIComponent(url) + "&srcUrl=" + encodeURIComponent(url) + "&title=" + title + "&description=";
        window.open(op);

    })

    $("a.h-douban").click(function () {//豆瓣
        var url = window.location.href;
        var title = document.title;
        var op = "https://www.douban.com/share/service?href=" + encodeURIComponent(url) + "&name=" + title + "&text=";
        window.open(op);
    })

    $("a.h-baidu").click(function () {//百度
        var url = window.location.href;
        var title = document.title;
        var op = "http://i.baidu.com/store/?url=" + encodeURIComponent(url) + "&t=" + title + "";
        window.open(op);
    })

})


$(function(){
    // 跳转乐语
    var leyu = "http://looyuoms2431.looyu.com/chat/chat/p.do?n=dental_863&md=2&c=20002298&v=f3abdb0af79c15ac4638f3155a1453d312&u=f3abdb0af79c15ac4638f3155a1453d312&f=10072488&site=17712&p0=http%3A%2F%2F101.200.127.204%3A9113%2Fcontent%2Fdetails_4_26.html&ct=1&refer=&loc=http%3A%2F%2F101.200.127.204%3A9113%2Fcontent%2Fdetails_4_26.html&_d=1492583655477",
        leyu_el = ".zaixianyuyue",
        weibo = "http://weibo.com/p/1006061821548501/home?from=page_100606&mod=TAB&is_all=1",
        weibo_el = ".footer .oh a.a-wb,.details-box .top-box .btn-box a.btn-02,.index-wrap .item .w .w-wb";
    $(document).on('click',leyu_el,function(){
        window.open(leyu);
        return false;
    });

//    $(document).on("click",weibo_el,function(){
//        window.open(weibo);
//        return false;
//    });
//
// input placeholder 提示
    $("input,textarea").placeholder();
});








































