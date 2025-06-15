import React from 'react';
import ProductCard from './ProductCard';

export default function App() {
    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
            <h1>My Product Catalog</h1>

            <ProductCard
                title="iPhone 15"
                price={1099}
                description="Latest model with improved battery life and camera."
            />

            <ProductCard
                title="Wireless Earbuds"
                description="High-quality sound with active noise cancellation."
            />

            <ProductCard />
        </div>
    );
}
