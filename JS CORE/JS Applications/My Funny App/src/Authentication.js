const kinveyBaseUrl = "https://baas.kinvey.com/";
const kinveyAppKey = "kid_rk57R_c7e";
const kinveyAppSecret =
    "30b265c485f54ef4bb123749bec0775b";
const kinveyAppAuthHeaders = {
    'Authorization': "Basic " +
    btoa(kinveyAppKey + ":" + kinveyAppSecret),
};

function getKinveyUserAuthHeaders() {
    return {
        'Authorization': "Kinvey " + sessionStorage.getItem('authToken'),
    };
}