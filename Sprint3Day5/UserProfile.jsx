import React from 'react';
import './UserCard.css'; 

export default UserProfile;

function UserProfile({ name, email, avatarUrl, bio }) {
   
    const placeholderAvatar = 'https://placehold.co/100x100/A0A0A0/FFFFFF?text=No+Avatar';

    return (
        <div className="user-profile-card">
            <img
                src={avatarUrl || placeholderAvatar} 
                alt={`${name}'s avatar`}
                className="user-avatar"
                onError={(e) => { e.target.src = placeholderAvatar; }} 
            />
            <h2>{name}</h2>
            <p className="user-email">{email}</p>
            <p className="user-bio">{bio}</p>
        </div>
    );
}

UserProfile.defaultProps = {
    name: 'Guest User',
    email: 'No email provided',
    avatarUrl: '', 
    bio: 'No biography available.'
};

