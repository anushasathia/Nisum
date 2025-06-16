import React, { useState } from 'react';
import NavItem from './NavItem';
import './Navbar.css';

export default function Navbar() {
    const [activeTab, setActiveTab] = useState('Home');

    const handleNavItemClick = (tabName) => {
        setActiveTab(tabName);
    };

    return (
        <nav className="navbar-container">
            <NavItem
                text="Home"
                link="#"
                isActive={activeTab === 'Home'}
                onClick={() => handleNavItemClick('Home')}
            />

            <NavItem
                text="About"
                link="#"
                isActive={activeTab === 'About'}
                onClick={() => handleNavItemClick('About')}
            />

            <NavItem
                text="Services"
                link="#"
                isActive={activeTab === 'Services'}
                onClick={() => handleNavItemClick('Services')}
            />

            <NavItem
                text="Contact"
                link="#"
                isActive={activeTab === 'Contact'}
                onClick={() => handleNavItemClick('Contact')}
            />
        </nav>
    );
}
