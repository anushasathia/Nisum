import React from 'react';
import UserProfile from './UserProfile';      
import Notifications from './Notifications'; 

export default function Dashboard() {
   
    const user = {
        name: "Neha Saripalli",
        email: "neha.s@gmail.com",
        avatarUrl: "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        bio: "Frontend enthusiast and aspiring full-stack developer."
    };

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            gap: '40px', 
            padding: '20px',
            width: '100%',
            maxWidth: '1000px', 
            margin: '0 auto' 
        }}>
        
            <UserProfile
                name={user.name}
                email={user.email}
                avatarUrl={user.avatarUrl}
                bio={user.bio}
            />

            <UserProfile
                name="New User"
            />
            <Notifications />
        </div>
    );
}
