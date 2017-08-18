const appId = 'kid_BJXTsSi-e';
const appSecret = "447b8e7046f048039d95610c1b039390";
let username = 'guest';
let password = 'guest';
let token = "Basic " + btoa(username + ':' + password);

let baseUrl = `https://baas.kinvey.com/appdata/${appId}/knock`;
let requestUrl = baseUrl + "?query=Knock Knock.";
console.log("Knock Knock.");

$.ajax({
    method: 'GET',
    url: requestUrl,
    headers: {
        "Authorization" : token,
        "Content-Type" : "application/json"
    },
    success: function (success) {
        console.log(success.answer);
        console.log(success.message);
        requestUrl = baseUrl + "?query=" + success.message;
        $.ajax({
            method: 'GET',
            url: requestUrl,
            headers: {
                "Authorization": token,
                "Content-Type": "application/json"
            },
            success: function (success2) {
                console.log(success2.answer);
                console.log(success2.message);
                requestUrl = baseUrl + "?query=" + success2.message;

                $.ajax({
                    method: 'GET',
                    url: requestUrl,
                    headers: {
                        "Authorization": token,
                        "Content-Type": "application/json"
                    },
                    success: function (success3) {
                        console.log(success3.answer);
                        console.log(success3.message);
                    }
                });


            },
            error: function (error2) {
                console.log(error2);
            }
        });
    },
    error: function (error) {
        console.log(error);
    }
});