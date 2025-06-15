    // App.jsx
    import React from 'react';
    // Import our new Greeting component
    import Greeting from './Greeting'; // No need for .jsx extension if using Webpack/Babel

    export default function App() {
        // Define a dynamic value for the name
        const userName = "Student"; // You can change this name!

        return (
            <div>
                <h1>My React App</h1>
                {/*
                    Use the Greeting component and pass the 'userName' variable
                    as the 'name' prop.
                    The 'name' prop in Greeting.jsx will receive the value of 'userName' here.
                */}
                <Greeting name={userName} />
                <p>Welcome to your first custom component!</p>
            </div>
        );
    }
    