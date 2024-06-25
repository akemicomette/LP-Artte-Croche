
function moveCarousel(containerClass, nextButtonClass, prevButtonClass, imagesClass) {

    const orderImages = document.querySelector(containerClass);
    const ordersCount = document.querySelectorAll(imagesClass).length;
    let ordersCurrentIndex = 0;
    
    document.querySelector(nextButtonClass).addEventListener('click', () => {
        if (ordersCurrentIndex < ordersCount - 1) {
            ordersCurrentIndex++;
        } else {
            ordersCurrentIndex = 0;
        }
        updateCarousel();
    });
    
    document.querySelector(prevButtonClass).addEventListener('click', () => {
        if (ordersCurrentIndex > 0) {
            ordersCurrentIndex--;
        } else {
            ordersCurrentIndex = ordersCount - 1;
        }
        updateCarousel();
    });
    
    function updateCarousel() {
        orderImages.style.left = `${-ordersCurrentIndex * 20}%`;
    }
}

moveCarousel('.order-carousel-images','.order-next-btn','.order-prev-btn','.order-img-intro');
moveCarousel('.inspiration-carousel-images','.inspiration-next-btn','.inspiration-prev-btn','.inspiration-img-intro');
