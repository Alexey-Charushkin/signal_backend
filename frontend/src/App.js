import React, { useState } from 'react';
import axios from 'axios';

const App = () => {
    const [response, setResponse] = useState('');

    const sendRequestToBackend = async () => {
        try {
            const response = await axios.get('http://localhost:8080/ping');
            setResponse(response.data); // Сохраняем ответ от бэкенда в состоянии
        } catch (error) {
            console.error(error); // Обработка ошибки
        }
    };

    return (
        <div>
            <h1>Пример приложения на React + Spring</h1>
            <button onClick={sendRequestToBackend}>Отправить запрос на бэкенд</button>
            <p>Ответ от бэкенда: {response}</p>
        </div>
    );
};

export default App;