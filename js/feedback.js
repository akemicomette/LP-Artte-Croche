document.addEventListener('DOMContentLoaded', () => {
  const feedbackForm = document.getElementById('feedback-form');
  const feedbackInput = document.getElementById('feedback-input');
  const feedbackList = document.getElementById('feedback-list');

  function getCurrentDate() {
    const now = new Date();
    return `${now.getDate()}/${now.getMonth() + 1}/${now.getFullYear()}`;
  }

  function loadFeedbacks() {
    const feedbacks = JSON.parse(localStorage.getItem('feedbacks')) || [];
    feedbackList.innerHTML = '';

    feedbacks.forEach((feedback, index) => {
      const li = document.createElement('li');

      const dateSpan = document.createElement('span');
      dateSpan.className = 'feedback-date';
      dateSpan.textContent = feedback.date;

      const feedbackTextSpan = document.createElement('span');
      feedbackTextSpan.className = 'feedback-text';
      feedbackTextSpan.textContent = feedback.text;

      const deleteButton = document.createElement('button');
      deleteButton.textContent = 'Deletar';
      deleteButton.classList.add('delete-btn');
      deleteButton.addEventListener('click', () => deleteFeedback(index));

      li.appendChild(dateSpan);
      li.appendChild(feedbackTextSpan);
      li.appendChild(deleteButton);
      feedbackList.appendChild(li);
    });
  }

  function addFeedback(feedbackText) {
    const feedbacks = JSON.parse(localStorage.getItem('feedbacks')) || [];
    const feedback = {
      text: feedbackText,
      date: getCurrentDate()
    };
    feedbacks.push(feedback);
    localStorage.setItem('feedbacks', JSON.stringify(feedbacks));
    loadFeedbacks();
  }

  function deleteFeedback(index) {
    const feedbacks = JSON.parse(localStorage.getItem('feedbacks')) || [];
    feedbacks.splice(index, 1);
    localStorage.setItem('feedbacks', JSON.stringify(feedbacks));
    loadFeedbacks();
  }

  function fetchData(index, fetchDataSpan) {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {

        const feedbackData = JSON.stringify(data.slice(0, 1), null, 2);
        fetchDataSpan.textContent = feedbackData;
        feedbackData.classList.add('feedbackData');
      })
      .catch(error => {
        console.error('Error fetching data:', error);
        fetchDataSpan.textContent = 'Erro ao carregar dados';
      });
  }
  console.log(fetchData());

  feedbackForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const feedback = feedbackInput.value.trim();
    if (feedback) {
      addFeedback(feedback);
      feedbackInput.value = '';
    }
  });

  loadFeedbacks();
});
