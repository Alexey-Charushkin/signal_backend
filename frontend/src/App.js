import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';
import  "./stomp"
const URL = "ws://localhost:8080/new-orders"

const App = () => {
    const [isConnected, setIsConnected] = useState(false);
    const socket = useRef(null);
    const stompClient = useRef(null)
    const [response, setResponse] = useState([])
    function connect() {
        socket.current = new WebSocket(URL);
        stompClient.current = Stomp.over(socket.current);
        stompClient.current.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.current.subscribe('/topic/order-notifications', function(messageOutput) {
                console.log(messageOutput.body)
                setResponse([...response, messageOutput.body])
            });
        });
        setIsConnected(true)
    }
    function disconnect(){
        if(stompClient.current != null) {
          stompClient.current.disconnect();
        }
        console.log("Disconnected");
        setIsConnected(false)
    }

  return (
    <>
      <div>
          <div>
              <button id="connect" onClick={connect} disabled={isConnected}>Connect</button>
              <button id="disconnect" onClick={disconnect} disabled={!isConnected}>Disconnect</button>
          </div>
          <br />
          <div id="conversationDiv">
            {response.map((item, index) => (
              <p key={index}>{item}</p>
            ))}
          </div>
      </div>
    </>
  );
};

export default App;
