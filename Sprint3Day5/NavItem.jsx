import React from 'react';

export default function NavItem({ text, link, isActive, onClick }) {
    return (
        <a
            href={link}
            className={`nav-item ${isActive ? 'active' : ''}`}
            onClick={onClick}
            style={{
                textDecoration: 'none',
                color: 'inherit',
            }}
        >
            {text}
        </a>
    );
}
