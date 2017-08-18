import * as requester from './requester';

function saveSession(userInfo) {
    let userAuth = userInfo._kmd.authtoken;
    sessionStorage.setItem('authToken',userAuth);
    let userId = userInfo._id;
    sessionStorage.setItem('userId',userId);
    let username = userInfo.username;
    sessionStorage.setItem('username',username);
}

//Log in user
function login(username, password, callback) {
    let userData = {
        username: username,
        password: password
    };
    requester.post('user','login','basic',userData)
        .then( (response) => {  // Anonymous function
            saveSession(response);
            callback(true);
        }).catch((err) => callback(false));
}

//Register user

function register(username, password, callback) {
    let userData = {
        username: username,
        password: password
    };
    requester.post('user','','basic',userData)
        .then( (response) => {  // Anonymous function
            saveSession(response);
            callback(true);
        });
}

//Logout user
function logout(callback) {
    requester.post('user','_logout','kinvey',null)
        .then( (response) => {  // Anonymous function
            sessionStorage.clear();
            callback(true);
        }).catch((err) => callback(false));
}

export {login, register, logout};