// Navigation functionality for the SPA
document.addEventListener('DOMContentLoaded', function () {
    const navLinks = document.querySelectorAll('nav a');
    const pages = document.querySelectorAll('.page');

    navLinks.forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();

            // Remove active class from all nav links and sections
            navLinks.forEach(nav => nav.classList.remove('active'));
            pages.forEach(page => page.classList.remove('active'));

            // Add active class to the clicked link
            this.classList.add('active');

            // Show the corresponding section
            const targetId = this.getAttribute('href');
            document.querySelector(targetId).classList.add('active');
        });
    });
});
