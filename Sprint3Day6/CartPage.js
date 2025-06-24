import React from 'react';
import { useCart } from './CartContext';
import { Link } from 'react-router-dom'; 

const CartPage = () => {
  const { cart, removeFromCart, clearCart } = useCart();

  const totalItems = cart.reduce((acc, item) => acc + item.quantity, 0);
  const totalPrice = cart.reduce((acc, item) => acc + (item.price * item.quantity), 0);

  return (
    <div style={styles.cartContainer}>
      <h2 style={styles.cartTitle}>Your Shopping Cart ({totalItems} items)</h2>

      {cart.length === 0 ? (
        <div style={styles.emptyCart}>
          <p>No items in cart.</p>
          <Link to="/products" style={styles.continueShoppingButton}>Continue Shopping</Link>
        </div>
      ) : (
        <>
          <ul style={styles.cartList}>
            {cart.map((item) => (
              <li key={item.id} style={styles.cartItem}>
                <div style={styles.itemInfo}>
                  <span>{item.name}</span>
                  <span>${item.price} x {item.quantity}</span>
                </div>
                <button
                  onClick={() => removeFromCart(item.id)}
                  style={styles.removeButton}
                >
                  Remove
                </button>
              </li>
            ))}
          </ul>
          <div style={styles.cartSummary}>
            <h3>Total: ${totalPrice.toFixed(2)}</h3>
            <button onClick={clearCart} style={styles.clearCartButton}>
              Clear Cart
            </button>
            <Link to="/products" style={styles.continueShoppingButton}>Continue Shopping</Link>
          </div>
        </>
      )}
    </div>
  );
};

const styles = {
  cartContainer: {
    padding: '20px',
    maxWidth: '800px',
    margin: '40px auto',
    fontFamily: 'Arial, sans-serif',
    border: '1px solid #e0e0e0',
    borderRadius: '8px',
    boxShadow: '0 4px 12px rgba(0,0,0,0.05)',
    backgroundColor: '#fff',
  },
  cartTitle: {
    textAlign: 'center',
    marginBottom: '30px',
    color: '#333',
  },
  emptyCart: {
    textAlign: 'center',
    padding: '50px 0',
    color: '#666',
  },
  cartList: {
    listStyle: 'none',
    padding: 0,
    margin: 0,
  },
  cartItem: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '15px 0',
    borderBottom: '1px dashed #eee',
  },
  itemInfo: {
    fontSize: '1.1em',
    color: '#444',
  },
  removeButton: {
    backgroundColor: '#dc3545', // Red
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    padding: '8px 15px',
    cursor: 'pointer',
    fontSize: '0.9em',
    transition: 'background-color 0.2s',
  },
  removeButtonHover: {
    backgroundColor: '#c82333',
  },
  cartSummary: {
    marginTop: '30px',
    paddingTop: '20px',
    borderTop: '1px solid #eee',
    textAlign: 'right',
  },
  clearCartButton: {
    backgroundColor: '#ffc107', // Yellow
    color: '#333',
    border: 'none',
    borderRadius: '5px',
    padding: '10px 20px',
    cursor: 'pointer',
    fontSize: '1em',
    fontWeight: 'bold',
    marginRight: '15px',
    transition: 'background-color 0.2s',
  },
  clearCartButtonHover: {
    backgroundColor: '#e0a800',
  },
  continueShoppingButton: {
    backgroundColor: '#007bff', 
    color: 'white',
    textDecoration: 'none',
    borderRadius: '5px',
    padding: '10px 20px',
    cursor: 'pointer',
    fontSize: '1em',
    fontWeight: 'bold',
    transition: 'background-color 0.2s',
    display: 'inline-block', 
  },
  continueShoppingButtonHover: {
    backgroundColor: '#0056b3',
  },
};

export default CartPage;