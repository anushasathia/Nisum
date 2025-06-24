import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => (
  <div style={{ textAlign: 'center', padding: '50px', fontFamily: 'Arial, sans-serif' }}>
    <h1>Welcome to the Quantity Cart Demo!</h1>
    <p>Explore products and manage quantities in your cart.</p>
    <Link to="/products-page" style={{ textDecoration: 'none', backgroundColor: '#007bff', color: 'white', padding: '10px 20px', borderRadius: '5px', marginTop: '30px', display: 'inline-block', fontSize: '1.1em' }}>
      Start Shopping
    </Link>
  </div>
);

export default HomePage;