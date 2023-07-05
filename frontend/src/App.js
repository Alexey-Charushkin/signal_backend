import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';

const URL = "ws://websocket-echo.com"

const App = () => {
    const [isConnected, setIsConnected] = useState(false);
    const [name,setName] = useState("");
    const socket = useRef(null);
    const [response, setResponse] = useState("")
    function connect() {
        socket.current = new WebSocket(URL);
        socket.current.onopen = () => {
        console.log('WebSocket connection established.');
        };
        socket.current.onerror = (error) => {
            console.error('WebSocket connection error:', error);
        };
        socket.current.onclose = () => {
            console.log('WebSocket connection closed.');
        }
        socket.current.onmessage = (event) => {
            setResponse(event.data)
        }
        setIsConnected(true)
    }
    function disconnect(){
        socket.current.close()
        setIsConnected(false)
    }
    function send(){
        if (socket.current === null){return}
        socket.current.send(name)
    }

  return (
    <>
      <noscript>
        <h2 style={{ color: '#ff0000' }}>
          Seems your browser doesn't support Javascript! Websocket relies on
          Javascript being enabled. Please enable Javascript and reload this
          page!
        </h2>
      </noscript>
      <div id="main-content" className="container">
        <div className="row">
          <div className="col-md-6">
            <form className="form-inline">
              <div className="form-group">
                <label htmlFor="connect">WebSocket connection:</label>
                <button
                  id="connect"
                  className="btn btn-default"
                  type="button"
                  onClick={connect}
                  disabled={isConnected}
                >
                  Connect
                </button>
                <button
                  id="disconnect"
                  className="btn btn-default"
                  type="button"
                  disabled={!isConnected}
                  onClick={disconnect}
                >
                  Disconnect
                </button>
              </div>
            </form>
          </div>
          <div className="col-md-6">
            <form className="form-inline">
              <div className="form-group">
                <label htmlFor="name">What is your name?</label>
                <input
                  type="text"
                  id="name"
                  className="form-control"
                  placeholder="Your name here..."
                  value={name}
                  onChange={(e)=>{setName(e.target.value)}}
                />
              </div>
              <button id="send" className="btn btn-default" type="button"
                onClick={send}
                
              >
                Send
              </button>
            </form>
          </div>
        </div>
        <div className="row">
          <div className="col-md-12">
            <table id="conversation" className="table table-striped">
              <thead>
                <tr>
                  <th>Greetings {response}</th>
                </tr>
              </thead>
              <tbody id="greetings"></tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
};

export default App;
