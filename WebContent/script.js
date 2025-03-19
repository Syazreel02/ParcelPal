
  document.addEventListener('DOMContentLoaded', () => {
    const box = document.querySelector('.box');
    const loginLink = document.querySelector('.login-link');
    const registerLink = document.querySelector('.register-link');

    registerLink.addEventListener('click', () => {
      box.classList.add('active');
    });

    loginLink.addEventListener('click', () => {
      box.classList.remove('active');
    });

    // Check if the hash fragment is 'register' and activate the registration box
    if (window.location.hash === '#register') {
      box.classList.add('active');
    }
  });
