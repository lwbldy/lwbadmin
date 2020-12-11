$(function(){
	// 切换
	setTimeout(setSwiperPic, 400);
	
});

// 头部地区导航
function getMuen(){
	$(".top-nav").each(function(i){
		if ($(".menu-bon").css("display") == "none") {
			$(this).find("li").not(".on").on("mouseover mouseout",function(){
				$(this).toggleClass('hover');
			});
		}
		$(this).addClass("swiper3"+i);
		var num = 8,
			item_length = $(this).find(".swiper-slide").length,
			n_index = 0;
		if($(window).width() < 1260) num = 6;
		if($(window).width() < 1010) num = 3;
		if(item_length > num) {
			var mySwiper = new Swiper(".swiper3"+ i +" .swiper-container",{
				calculateHeight: true,
	            slidesPerView: num,
	            slidesPerGroup : num,
	            onSlideChangeStart : function(swiper,index){
	            	$(".swiper3"+ i +" .back").removeClass("over");
	            	$(".swiper3"+ i +" .next").removeClass('over');
	            	if(mySwiper.activeIndex == 0) $(".swiper3"+ i +" .back").addClass("over");
	            	if(mySwiper.activeIndex == item_length - num) $(".swiper3"+ i +" .next").addClass('over');
	            }
			});
		}else{
			var mySwiper = new Swiper(".swiper3"+ i +" .swiper-container",{
				calculateHeight: true,
	            slidesPerView: num,
	            simulateTouch : false
			});
			$(".swiper3"+ i +" .back,"+".swiper3"+ i +" .next").on("click",function(e){
				e.preventDefault();
			});
			$(".swiper3"+ i +" .next").addClass('over');
			return false;
		}
		$(".swiper3"+ i +" .back").on("click",function(e){
			e.preventDefault();
			n_index -= num;
			n_index = n_index < num ? 0 : n_index;
			$(".swiper3"+ i +" .next").removeClass('over');
			if(n_index == 0) $(this).addClass('over');
			mySwiper.swipePrev();
		});
		$(".swiper3"+ i +" .next").on("click",function(e){
			e.preventDefault();
			n_index += num;
			n_index = n_index > item_length-num ? item_length : n_index;
			if(n_index == item_length) $(this).addClass("over");
			$(".swiper3"+ i +" .back").removeClass("over");
			mySwiper.swipeNext();
		});

		var $th = $(this).find("li");
		$th.each(function(ii,ee){
			if ($(ee).hasClass("on")) {
				mySwiper.swipeTo(ii,0,false);
				$(".swiper3"+ i +" .back").removeClass("over");
            	$(".swiper3"+ i +" .next").removeClass('over');
            	if(ii == 0) $(".swiper3"+ i +" .back").addClass("over");
            	if(item_length - ii <= num ) $(".swiper3"+ i +" .next").addClass('over');
			}
		});
	});
}



function setSwiperPic(){
	$(".swiper-pic").each(function(i){
		$(this).addClass('swiper2'+i);
		var item = $(this).find(".swiper-slide");
		if(item.length > 1) var mySwiper = new Swiper(".swiper2" + i + " .swiper-container",{
	    autoplay : 2000,
	    loop : true,
	    slidesPerView : 1,
	    calculateHeight : true,
	    paginationClickable: true,
	    pagination : '.pagination'
	    });
	});
}