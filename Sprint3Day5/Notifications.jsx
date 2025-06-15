import React from 'react';
import './Notifications.css'; 

export default Notifications;

const notificationsData = [
    { id: 1, message: 'One new message', date: '2025-06-14', timestamp: '10:30 AM', read: false },
    { id: 2, message: 'Your order #12345 has been shipped', date: '2025-06-13', timestamp: '03:45 PM', read: true },
    { id: 3, message: 'Upcoming event reminder: Photography Workshop.', date: '2025-06-14', timestamp: '09:00 AM', read: false },
    { id: 4, message: 'Password change required soon.', date: '2025-06-12', timestamp: '11:00 AM', read: true },
];

function Notifications() {
    return (
        <div className="notifications-container">
            <h2>Notifications</h2>
            {notificationsData.length > 0 ? (
                <div className="notifications-grid">
                    {notificationsData.map(notification => (
                        <div key={notification.id} className={`notification-item ${notification.read ? 'read' : 'unread'}`}>
                            <p className="notification-message">{notification.message}</p>
                            <div className="notification-meta">
                                <span>{notification.date}</span>
                                <span>{notification.timestamp}</span>
                                <span className={`notification-status ${notification.read ? 'status-read' : 'status-unread'}`}>
                                    {notification.read ? 'Read' : 'Unread'}
                                </span>
                            </div>
                        </div>
                    ))}
                </div>
            ) : (
                <p>No new notifications.</p>
            )}
        </div>
    );
}

