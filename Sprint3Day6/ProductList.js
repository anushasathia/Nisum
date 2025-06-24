import React from 'react';
import { useCart } from './CartContext';
import productsData from './products.json'; // Import your product data
import { Link } from 'react-router-dom';

const ProductList = () => {
  const { addToCart } = useCart();

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>Available Products</h2>
      <div style={styles.productList}>
        {productsData.map(product => (
          <div key={product.id} style={styles.productCard}>
            <h3 style={styles.productName}>{product.name}</h3>
            <p style={styles.productPrice}>${product.price.toFixed(2)}</p>
            <button
              onClick={() => addToCart(product)}
              style={styles.addToCartButton}
            >
              Add to Cart
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

// Basic inline styles
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
  productList: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))',
    gap: '20px',
    justifyContent: 'center',
  },
  productCard: {
    border: '1px solid #e0e0e0',
    borderRadius: '8px',
    padding: '20px',
    textAlign: 'center',
    boxShadow: '0 2px 8px rgba(0,0,0,0.05)',
    backgroundColor: '#fff',
  },
  productName: {
    fontSize: '1.4em',
    color: '#333',
    marginBottom: '10px',
  },
  productPrice: {
    fontSize: '1.2em',
    color: '#666',
    marginBottom: '20px',
    fontWeight: 'bold',
  },
  addToCartButton: {
    backgroundColor: '#28a745', // Green
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    padding: '10px 20px',
    cursor: 'pointer',
    fontSize: '1em',
    fontWeight: 'bold',
    transition: 'background-color 0.2s',
  },
  addToCartButtonHover: {
    backgroundColor: '#218838',
  },
};

export default ProductList;