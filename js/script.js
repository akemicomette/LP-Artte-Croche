const carouselImages = document.querySelector('.carousel-images');
const slideCount = document.querySelectorAll('.img-intro').length;
let currentIndex = 0;

document.querySelector('.next-btn').addEventListener('click', () => {
    if (currentIndex < slideCount - 1) {
        currentIndex++;
    } else {
        currentIndex = 0;
    }
    updateCarousel();
});

document.querySelector('.prev-btn').addEventListener('click', () => {
    if (currentIndex > 0) {
        currentIndex--;
    } else {
        currentIndex = slideCount - 1;
    }
    updateCarousel();
});

function updateCarousel() {
    carouselImages.style.left = `${-currentIndex * 30}%`;
}