// scripts.js

document.getElementById('orderForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const checkboxes = document.querySelectorAll('input[name="item"]:checked');
    let totalAmount = 0;
    let summaryItems = '';

    checkboxes.forEach(checkbox => {
        const itemName = checkbox.value;
        const itemPrice = parseFloat(checkbox.getAttribute('data-price'));
        totalAmount += itemPrice;
        summaryItems += `<div>${itemName}: $${itemPrice.toFixed(2)}</div>`;
    });

    document.getElementById('summaryItems').innerHTML = summaryItems;
    document.getElementById('totalAmount').textContent = `Total Amount: $${totalAmount.toFixed(2)}`;
});
