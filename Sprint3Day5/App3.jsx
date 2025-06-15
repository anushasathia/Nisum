import React from 'react';
import ThemeToggle from './ThemeToggle';

export default function App() {
    return (
        <div style={{ textAlign: 'center', padding: '20px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
            <h1>Welcome to Theme Toggler</h1>
            <ThemeToggle />
        </div>
    );
}
