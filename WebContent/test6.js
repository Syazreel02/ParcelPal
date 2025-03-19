document.addEventListener('DOMContentLoaded', function() {
      const form = document.getElementById('parcel-form');

      const sr = ScrollReveal({
        origin: 'top',
        distance: '50px',
        duration: 1000,
        delay: 300,
        reset: true
      });

      sr.reveal(form);
    });

function resetForm() {
      document.getElementById('parcel-form').reset();
}

// Wait for the DOM content to load
document.addEventListener('DOMContentLoaded', function() {
  const logoutButton = document.getElementById('logout-button');
  const cancelButton = document.getElementById('cancel-button');
  const overlay = document.getElementById('overlay');

  logoutButton.addEventListener('click', function() {
    // Perform logout actions here, such as clearing session data
    alert('Logged out successfully.'); // Replace with your desired logout action
    
    // Redirect to the home page after 5 seconds
    setTimeout(function() {
      window.location.href = 'staff.html';
    }, 5000);
  });

  cancelButton.addEventListener('click', function() {
    // Hide the confirmation pop-up
    overlay.style.display = 'none';
  });

  // Show the confirmation pop-up when the logout link is clicked
  const logoutLink = document.querySelector('.nav-icons a');
  logoutLink.addEventListener('click', function(e) {
    e.preventDefault();
    overlay.style.display = 'block';
  });
});

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
