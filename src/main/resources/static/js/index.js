var marsApiButtons = document.querySelectorAll("button[id*='marsApi']");

marsApiButtons.forEach( button => button.addEventListener('click', function() {
    alert('A button was clicked');
}));