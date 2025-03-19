const header = document.querySelector("header");

// Smooth scrolling for internal page links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener("click", function (e) {
    e.preventDefault();

    const target = document.querySelector(this.getAttribute("href"));
    if (target) {
      target.scrollIntoView({
        behavior: "smooth"
      });
    }
  });
});

window.addEventListener("scroll", function() {
  header.classList.toggle("sticky", window.scrollY > 80);
});

const sr = ScrollReveal({
	origin : 'top',
	distance : '85px',
	duration : 2500,
	reset : true
})

sr.reveal ('.home-text', {delay:300});
sr.reveal ('.home-png', {delay:400});
sr.reveal ('.container', {delay:400});

sr.reveal ('.about-png', {});
sr.reveal ('.about-text', {delay:300});

sr.reveal ('.middle-text', {});
sr.reveal ('.row-btn', {delay:300});

sr.reveal ('.org-content, .faq-content', {delay:300});
sr.reveal ('.contact-content', {delay:300});

sr.reveal('.home1-text', { delay: 300 });

document.addEventListener('DOMContentLoaded', function() {
  const logoutBtn = document.querySelector('.nav-icons');
  const overlay = document.querySelector('.overlay');
  const cancelBtn = document.querySelector('.cancel-btn');
  const logoutConfirmBtn = document.querySelector('.logout-confirm-btn');

  logoutBtn.addEventListener('click', () => {
    overlay.style.display = 'flex';
  });

  cancelBtn.addEventListener('click', () => {
    overlay.style.display = 'none';
  });

  logoutConfirmBtn.addEventListener('click', () => {
    // Perform logout action here
    overlay.style.display = 'none';
    showLogoutSuccess();
    redirectHomePage();
  });

  function showLogoutSuccess() {
    const logoutSuccessOverlay = document.querySelector('.logout-success-overlay');
    logoutSuccessOverlay.style.display = 'flex';
  }

  function redirectHomePage() {
    let countdown = 3;
    const countdownElement = document.getElementById('countdown');

    const countdownInterval = setInterval(() => {
      countdown--;
      countdownElement.textContent = `Redirecting to homepage in ${countdown} seconds...`;

      if (countdown === 0) {
        clearInterval(countdownInterval);
        window.location.href = 'welcome.html'; // Replace with the actual homepage URL
      }
    }, 1000);
  }
});
