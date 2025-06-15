import React from 'react';
import UserProfile from './UserProfile';
import Notifications from './Notifications';
import './index.css';

export default function App() {
    return (
        <div style={{
            minHeight: '100vh',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'flex-start',
            padding: '20px',
            boxSizing: 'border-box'
        }}>
            <h1>My Custom Application Dashboard</h1>

            <UserProfile
                name="Anusha Sathia"
                email="xyz@gmail.com"
                avatarUrl="https://plus.unsplash.com/premium_photo-1676070096487-32dd955e09e0?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YnJpZ2h0JTIwZmxvd2Vyc3xlbnwwfHwwfHx8MA%3D%3D"
                bio="Shutterbug by day, code wizard by night"
            />

            <UserProfile
                name="Roshmi Talukdar"
            />

            <Notifications />
        </div>
    );
}
