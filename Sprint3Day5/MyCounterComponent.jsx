import React, { useState, useEffect } from 'react';
import './MyCounterComponent.css';

export default function MyCounterComponent() {
    const [count, setCount] = useState(0);

    const handleIncrement = () => {
        setCount(prevCount => prevCount + 1);
    };

    const handleDecrement = () => {
        if (count > 0) {
            setCount(prevCount => prevCount - 1);
        }
    };

    const handleReset = () => {
        setCount(0);
    };

    useEffect(() => {
        console.log('Count has changed:', count);
    }, [count]);

    return (
        <div className="counter-container">
            <h1>Count: {count}</h1>

            <div className="button-group">
                <button className="counter-button increment" onClick={handleIncrement}>
                    Increment
                </button>

                <button
                    className="counter-button decrement"
                    onClick={handleDecrement}
                    disabled={count === 0}
                >
                    Decrement
                </button>

                <button className="counter-button reset" onClick={handleReset}>
                    Reset
                </button>
            </div>
        </div>
    );
}
