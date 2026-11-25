
import { useState } from 'react';
import Home from './Home';
import Login from './Login';
import './App.css';

function App() {

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <div>
            {isLoggedIn ? (
                <Home />
            ) : (
                <Login onLogin={() => setIsLoggedIn(true)} />
            )}
        </div>
    );
}

export default App;
