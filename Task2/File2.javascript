let cart = [];
let totalPrice = 0;

function addToCart(itemName, itemPrice) {
    cart.push({ name: itemName, price: itemPrice });
    totalPrice += itemPrice;
    updateCartUI();
}

function updateCartUI() {
    const cartItems = document.getElementById('cartItems');
    const totalPriceElement = document.getElementById('totalPrice');
    
    cartItems.innerHTML = '';
    cart.forEach(item => {
        const listItem = document.createElement('li');
        listItem.textContent = `${item.name} - $${item.price.toFixed(2)}`;
        cartItems.appendChild(listItem);
    });

    totalPriceElement.textContent = totalPrice.toFixed(2);
}

function checkout() {
    if (cart.length === 0) {
        alert('Your cart is empty.');
        return;
    }

    alert(`Thank you for your purchase! Total amount: $${totalPrice.toFixed(2)}`);
    // Here you can integrate with a back-end system for processing the order
    cart = [];
    totalPrice = 0;
    updateCartUI();
}
