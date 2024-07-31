$('.multiple-card-slider .carousel').each(function(){
  var currentCarouselId = '#' + $(this).attr('id');
  const multipleItemCarousel = document.querySelector(currentCarouselId);

  if(window.matchMedia("(min-width:576px)").matches){
    const carousel = new bootstrap.Carousel(multipleItemCarousel, {
        interval: false,
        wrap: false
    })
    var carouselWidth = $(currentCarouselId + ' .carousel-inner')[0].scrollWidth;
    var cardWidth = $(currentCarouselId + ' .carousel-item').width();
    var scrollPosition = 0;
    var maxScrollPosition = carouselWidth - (cardWidth * 3);
    
    $(currentCarouselId + ' .carousel-control-next').on('click', function(){
      if(scrollPosition < carouselWidth - cardWidth * 3){
          console.log('next');
          scrollPosition = scrollPosition + cardWidth;
      } else {
        scrollPosition = 0;
      }
      $(currentCarouselId + ' .carousel-inner').animate(
        {scrollLeft: scrollPosition},
      600);
    });

    $(currentCarouselId + ' .carousel-control-prev').on('click', function(){
      if(scrollPosition > 0){
          console.log('prev');
          scrollPosition = scrollPosition - cardWidth;
      } else {
        scrollPosition = maxScrollPosition;
      }
      $(currentCarouselId + ' .carousel-inner').animate(
        {scrollLeft: scrollPosition},
      600);
    });
  }else{
      $(multipleItemCarousel).addClass('slide');
  }
});

function clickMenu() {
    const menu = document.querySelector('#menu_bg');
    if(menu.style.display == 'block'){
        menu.style.display = 'none';
    } else {
        menu.style.display = 'block';
    }
}

// clickMenu();