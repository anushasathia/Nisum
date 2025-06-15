import React from 'react';

export default function ProductCard({ title, price, description }) {
    return (
        <div style={{
            border: '1px solid #ddd',
            borderRadius: '8px',
            padding: '20px',
            margin: '20px',
            maxWidth: '300px',
            boxShadow: '0 4px 8px rgba(202, 10, 109, 0.34)',
            fontFamily: 'Inter, sans-serif'
        }}>
            <h2>{title}</h2>
            <p>Price: ${price}</p>
            <p>{description}</p>
        </div>
    );
}

ProductCard.defaultProps = {
    title: 'Default Product',
    price: 0,
    description: 'No description provided.'
};
