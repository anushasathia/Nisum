import React, { useState, useEffect } from 'react';

export default function ThemeToggle() {
    const [theme, setTheme] = useState('light');

    const toggleTheme = () => {
        setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
    };

    useEffect(() => {
        const body = document.body;
        if (theme === 'dark') {
            body.style.backgroundColor = '#333';
            body.style.color = '#f0f0f0';
        } else {
            body.style.backgroundColor = '#f0f0f0';
            body.style.color = '#333';
        }
    }, [theme]);

    return (
        <div style={{ textAlign: 'center', marginTop: '20px' }}>
            <p>Current Theme: {theme.toUpperCase()}</p>
            <button
                onClick={toggleTheme}
                style={{
                    padding: '10px 20px',
                    fontSize: '1em',
                    cursor: 'pointer',
                    borderRadius: '5px',
                    border: '1px solid #ccc',
                    backgroundColor: theme === 'light' ? '#eee' : '#555',
                    color: theme === 'light' ? '#333' : '#fff',
                    transition: 'background-color 0.3s ease, color 0.3s ease'
                }}
            >
                Toggle Theme
            </button>
        </div>
    );
}
