// JavaScript to toggle the notification dropdown

const notificationButton = document.getElementById('notification-button');
const notificationDropdown = document.getElementById('notification-dropdown');
let isDropdownOpen = false;

notificationButton.addEventListener('click', () => {
    // Toggle the visibility of the notification dropdown
    isDropdownOpen = !isDropdownOpen;
    if (isDropdownOpen) {
        notificationDropdown.style.display = 'block';
    } else {
        notificationDropdown.style.display = 'none';
    }
});

// Close the dropdown when clicking outside of it
window.addEventListener('click', (event) => {
    if (!notificationButton.contains(event.target) && !notificationDropdown.contains(event.target)) {
        notificationDropdown.style.display = 'none';
        isDropdownOpen = false;
    }
});
