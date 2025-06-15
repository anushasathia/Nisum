import React from 'react';
import MyCounterComponent from './MyCounterComponent'; 

export default function App() {
    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
            <h1>My Custom Counter Application</h1>
        
            <MyCounterComponent />
        </div>
    );
}
