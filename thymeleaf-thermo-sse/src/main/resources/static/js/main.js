
function reloadTemp() {
    try {
        $('#temp').load('/fragments/temp');
    } catch (error) {
        console.error('Display temp failed:', error);
    }
}

const sse = new EventSource('/sse');
sse.addEventListener("temp", () => reloadTemp());

reloadTemp();
