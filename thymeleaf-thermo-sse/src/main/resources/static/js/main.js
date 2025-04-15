
function reloadTemp() {
    try {
        $('#temp').load('/fragments/temp', function() {});
    } catch (error) {
        console.error('Display temp failed:', error);
    }
}


reloadTemp();