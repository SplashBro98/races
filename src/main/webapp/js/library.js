function checkValue(form, message) {
    var userInput = form;

    if(userInput.value == ''){
        alert(message)
        userInput.focus();
        return false
    }
    return true
}