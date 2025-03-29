const options = { weekday: "long", year: "numeric", month: "long", day: "numeric"};

document.addEventListener("DOMContentLoaded", function(event) {
    document.getElementById( "timestamp").innerHTML = new Date().toLocaleTimeString("pl", options);
});

setTimeout(function() {
    uuidFragmentReload();
}, 10);

function uuidFragmentReload() {
    $('#uuid').load('/fragments/uuid', function() {});
}

