import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import ProductDetail from './ProductDetail';
import productsData from './products.json'; // Import products for listing

// A simple Home component
const Home = () => (
  <div style={{ textAlign: 'center', padding: '50px', fontFamily: 'Arial, sans-serif' }}>
    <h1>Welcome to Our Product Showcase!</h1>
    <p>Explore our amazing products.</p>
    <Link to="/products" style={{ textDecoration: 'none', backgroundColor: '#007bff', color: 'white', padding: '10px 20px', borderRadius: '5px', marginTop: '20px', display: 'inline-block' }}>View All Products</Link>
  </div>
);

// A simple ProductList component to display all products with links
const ProductList = () => (
  <div style={{ textAlign: 'center', padding: '20px', fontFamily: 'Arial, sans-serif' }}>
    <h1>Our Products</h1>
    <ul style={{ listStyle: 'none', padding: 0 }}>
      {productsData.map(product => (
        <li key={product.id} style={{ marginBottom: '15px', border: '1px solid #eee', padding: '10px', borderRadius: '5px', display: 'flex', alignItems: 'center', maxWidth: '500px', margin: '15px auto', boxShadow: '0 1px 3px rgba(0,0,0,0.05)' }}>
          <img src={product.image} alt={product.name} style={{ width: '80px', height: '80px', objectFit: 'cover', borderRadius: '4px', marginRight: '15px' }} />
          <div style={{ flexGrow: 1, textAlign: 'left' }}>
            <h3 style={{ margin: '0 0 5px 0', color: '#333' }}>
              <Link to={`/products/${product.id}`} style={{ textDecoration: 'none', color: '#007bff' }}>
                {product.name}
              </Link>
            </h3>
            <p style={{ margin: 0, color: '#666' }}>${product.price}</p>
          </div>
        </li>
      ))}
    </ul>
    <Link to="/" style={{ textDecoration: 'none', backgroundColor: '#6c757d', color: 'white', padding: '8px 16px', borderRadius: '5px', marginTop: '20px', display: 'inline-block' }}>Back to Home</Link>
  </div>
);


function App() {
  return (
    <Router>
      <div className="App">
        <header style={{ backgroundColor: '#f8f9fa', padding: '15px 0', borderBottom: '1px solid #e9ecef', marginBottom: '30px' }}>
          <nav style={{ maxWidth: '960px', margin: '0 auto', display: 'flex', justifyContent: 'center', gap: '20px' }}>
            <Link to="/" style={{ textDecoration: 'none', color: '#333', fontWeight: 'bold', fontSize: '18px' }}>Home</Link>
            <Link to="/products" style={{ textDecoration: 'none', color: '#333', fontWeight: 'bold', fontSize: '18px' }}>Products</Link>
          </nav>
        </header>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<ProductList />} />
          <Route path="/products/:id" element={<ProductDetail />} />
          <Route path="*" element={<h2 style={{ textAlign: 'center', marginTop: '50px' }}>404 - Page Not Found</h2>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;