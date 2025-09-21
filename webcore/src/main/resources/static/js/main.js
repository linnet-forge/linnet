class Login {
    constructor(login) {
        this.login = login
    }

    validate() {
        return this.login != null && this.login.trim() !== ""
    }
}

function validate() {
    let login = document.getElementById("login").value
    let check = new Login(login)
    let result = check.validate()

    if (result) {
        alert("succes")
    } else {
        alert("failure")
    }
}
