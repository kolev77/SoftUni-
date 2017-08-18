import $ from 'jquery';
const kinveyBaseUrl = "https://baas.kinvey.com/";
const kinveyAppKey = "kid_Sk71TTzml";
const kinveyAppSecret = "bb976e95e2034437a35bc315db3d07ab";
function makeHeader(auth) {
    let header = {"Authorization": ""};
    switch (auth) {
        case "basic":
            header["Authorization"] = "Basic " + btoa(kinveyAppKey + ":" + kinveyAppSecret);
            break;
        case "kinvey":
            header["Authorization"] = "Kinvey " + sessionStorage.getItem("authToken");
            break;
    }
    return header;
}

function get(module, url, auth) {
    let hostUrl = kinveyBaseUrl + module + "/" + kinveyAppKey + "/" + url;
    let header = makeHeader(auth);
    return $.ajax({
        method: "GET",
        url: hostUrl,
        headers: header
    });   // it returns "promise"

};

function post(module, url, auth, data) {
    let hostUrl = kinveyBaseUrl + module + "/" + kinveyAppKey + "/" + url;
    let header = makeHeader(auth);

    let request = {
        method: "POST",
        url: hostUrl,
        headers: header,
    };

    if (data) {
        request.data = data;
    }

    return $.ajax(request);
}

function update(module, url, auth, data) {
    let hostUrl = kinveyBaseUrl + module + "/" + kinveyAppKey + "/" + url;
    let header = makeHeader(auth);

    let request = {
        method: "PUT",
        url: hostUrl,
        headers: header,
        data:data
    };

    return $.ajax(request);
}

export { get, post, update};