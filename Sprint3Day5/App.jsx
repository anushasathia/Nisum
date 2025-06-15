    import React from 'react';
    import Greeting from './Greeting'; 
    export default function App() {
        const userName = "Anusha"; 

        return (
            <div>
                <h1>My First React App</h1>
        
                <Greeting name={userName} />
                <p>Welcome everyone</p>
            </div>
        );
    }
    