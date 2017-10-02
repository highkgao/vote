function parseResult(data) {
    if (data["status"] == "success") {
        return true;
    } else {
        return false;
    }
}