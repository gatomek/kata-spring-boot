
const stompClient = new StompJs.Client({
    brokerURL: '/temp'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/messages', (frame) => {
        displayTemp(frame.body);
    });
};

stompClient.onWebSocketError = (error) => {
    setConnected(false);
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    console.log( "connected? " + connected)

    const tempElem = document.getElementById( "temp");
    tempElem.classList.remove( "alert-success", "alert-danger");
    tempElem.classList.add( connected ? "alert-success" : "alert-danger");

    tempElem.innerHTML = "---";
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function displayTemp(body) {
    document.getElementById( "temp").innerHTML = JSON.parse( body).temp;
}

connect();
