document.addEventListener('DOMContentLoaded', () => {
  const cartItemsContainer = document.getElementById('cart-items');
  const totalDisplay = document.getElementById('total');

  let cart = JSON.parse(localStorage.getItem('cart')) || [];

  function renderCart() {
    cartItemsContainer.innerHTML = '';
    let total = 0;

    cart.forEach((item, index) => {
      const li = document.createElement('li');
      li.innerHTML = `
        ${item.name} - $${item.price.toFixed(2)} x ${item.quantity}
        <button onclick="removeItem(${index})">Remove</button>
      `;
      cartItemsContainer.appendChild(li);
      total += item.price * item.quantity;
    });

    totalDisplay.textContent = `Total: $${total.toFixed(2)}`;
  }

  window.removeItem = function(index) {
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
  };

  renderCart();
});

function toggleSidebar() {
  const sidebar = document.getElementById("sidebar");
  const openBtn = document.getElementById("openBtn");

  if (sidebar.style.width === "250px") {
    sidebar.style.width = "0";
    openBtn.style.display = "block";
  } else {
    sidebar.style.width = "250px";
    openBtn.style.display = "none"; 
  }
}