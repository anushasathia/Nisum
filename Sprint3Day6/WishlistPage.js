import React from 'react';
import { useWishlist } from './WishlistContext';
import { Link } from 'react-router-dom';

const WishlistPage = () => {
  const { wishlist, toggleWishlist } = useWishlist();

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>❤️ Your Wishlist</h2>
      {wishlist.length === 0 ? (
        <div style={styles.emptyWishlist}>
          <p>Your wishlist is empty.</p>
          <Link to="/products-page" style={styles.continueShoppingButton}>Continue Shopping</Link>
        </div>
      ) : (
        <div style={styles.wishlistGrid}>
          {wishlist.map(item => (
            <div key={item.id} style={styles.wishlistItem}>
              <h3 style={styles.itemName}>{item.name}</h3>
              <p style={styles.itemPrice}>${item.price.toFixed(2)}</p>
              <button
                onClick={() => toggleWishlist(item)}
                style={styles.removeButton}
              >
                Remove ❤️
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

const styles = {
  container: {
    padding: '20px',
    maxWidth: '900px',
    margin: '40px auto',
    fontFamily: 'Arial, sans-serif',
  },
  title: {
    textAlign: 'center',
    marginBottom: '30px',
    color: '#333',
  },
  emptyWishlist: {
    textAlign: 'center',
    padding: '50px 0',
    color: '#666',
  },
  wishlistGrid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))',
    gap: '20px',
    justifyContent: 'center',
  },
  wishlistItem: {
    border: '1px solid #e0e0e0',
    borderRadius: '8px',
    padding: '20px',
    textAlign: 'center',
    boxShadow: '0 2px 8px rgba(0,0,0,0.05)',
    backgroundColor: '#fff',
  },
  itemName: {
    fontSize: '1.4em',
    color: '#333',
    marginBottom: '10px',
  },
  itemPrice: {
    fontSize: '1.2em',
    color: '#666',
    marginBottom: '20px',
    fontWeight: 'bold',
  },
  removeButton: {
    backgroundColor: '#dc3545', // Red
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    padding: '10px 20px',
    cursor: 'pointer',
    fontSize: '1em',
    fontWeight: 'bold',
    transition: 'background-color 0.2s',
  },
  removeButtonHover: {
    backgroundColor: '#c82333',
  },
  continueShoppingButton: {
    backgroundColor: '#007bff', // Blue
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
};

export default WishlistPage;