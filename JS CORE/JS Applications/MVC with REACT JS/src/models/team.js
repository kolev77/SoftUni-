import * as requester from './requester';

function create(name, description, callback) {
    let teamData = {
        name: name,
        description: description
    };
    requester.post('appdata', 'messages', 'kinvey', teamData)
        .then(() => callback(true))
        .catch(() => callback(false));
}

function loadTeams(callback) {
    requester.get('appdata', 'messages', 'kinvey')
        .then(callback);
}

function loadDetails(teamId, callback) {
    requester.get('appdata', 'messages/' + teamId, 'kinvey')
        .then(callback);
}

function edit(teamId,name,description, callback) {
    let teamData = {
        name: name,
        description: description
    };
    requester.update('appdata', 'messages/'+ teamId, 'kinvey', teamData)
        .then(() => callback(true))
        .catch(() => callback(false));
}
export {create, loadTeams, loadDetails,edit};