function startApp() {
    showHideMenuLinks();
    showView('viewHome');

    // Attach AJAX "loading" event listener
    $(document).on({
        ajaxStart: function () {
            $("#loadingBox").show()
        },
        ajaxStop: function () {
            $("#loadingBox").hide()
        }
    });

    $("form").submit(function (e) {
        e.preventDefault()
    });


    function showSendMessagesPage() {

        let query = `?query={"sender_username":"${sessionStorage.getItem("userName")}"}`
        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/messages" + query,
            headers: getKinveyUserAuthHeaders(),
            success: loadMyMessagesSuccess,
            error: handleAjaxError
        });

        function formatDate(dateISO8601) {
            let date = new Date(dateISO8601);
            if (Number.isNaN(date.getDate()))
                return '';
            return date.getDate() + '.' + padZeros(date.getMonth() + 1) +
                "." + date.getFullYear() + ' ' + date.getHours() + ':' +
                padZeros(date.getMinutes()) + ':' + padZeros(date.getSeconds());

            function padZeros(num) {
                return ('0' + num).slice(-2);
            }
        }


        function loadMyMessagesSuccess(messages) {

            for (let msg of messages) {
                let body = $('messages');
                let msgRow = $('<tr>');
                let recipient = $('<td>').text(msg.recipient_username);
                let text = $('<td>').text(msg.text);
                let date = $('<td>').text(formatDate(msg._kmd.lmt));


                msgRow.append(recipient);
                msgRow.append(text);
                msgRow.append(date);
                // msgRow.append(links);
                body.append(msgRow);
            }
        }

        $('#viewMyMessages').trigger('reset');
        showView('viewMyMessages')

    }

    function GetSentMessages() {

        let query = `?query={"sender_username":"${sessionStorage.getItem("userName")}"}`
        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/messages" + query,
            headers: getKinveyUserAuthHeaders(),
            success: loadArchiveSentSuccess,
            error: handleAjaxError
        });

        function formatDate(dateISO8601) {
            let date = new Date(dateISO8601);
            if (Number.isNaN(date.getDate()))
                return '';
            return date.getDate() + '.' + padZeros(date.getMonth() + 1) +
                "." + date.getFullYear() + ' ' + date.getHours() + ':' +
                padZeros(date.getMinutes()) + ':' + padZeros(date.getSeconds());

            function padZeros(num) {
                return ('0' + num).slice(-2);
            }
        }


        function deleteMessage(message) {
            $.ajax({
                method: 'DELETE',
                url: 'https://baas.kinvey.com/appdata/' + kinveyAppKey + '/messages' + '/' + message._id,
                headers: {
                    authorization: "Kinvey " + sessionStorage.getItem("authToken")
                },
                success: successDelete,
                error: handleAjaxError
            });

            function successDelete() {
                GetSentMessages();
                showInfo('Message deleted.');
            }
        }


        function loadArchiveSentSuccess(messages) {
            $('#viewArchiveSent tbody').empty();

            if (messages.length > 0) {
                for (let msg of messages) {
                    let body = $('#viewArchiveSent tbody');
                    let msgRow = $('<tr>');
                    let recipient = $('<td>').text(msg.recipient_username);
                    let text = $('<td>').text(msg.text);
                    let date = $('<td>').text(formatDate(msg._kmd.lmt));
                    let deleteLink = $('<td>');
                    let btnDelete = $('<button>').text('Delete').click(() => deleteMessage(msg));

                    deleteLink.append(btnDelete);

                    msgRow.append(recipient);
                    msgRow.append(text);
                    msgRow.append(date);
                    msgRow.append(deleteLink);
                    body.append(msgRow);
                }
            }
        }

        showView('viewArchiveSent')
    }

    function showMyMessages() {

        let query = `?query={"recipient_username":"${sessionStorage.getItem("userName")}"}`
        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/messages" + query,
            headers: getKinveyUserAuthHeaders(),
            success: loadMyMessagesSuccess,
            error: handleAjaxError
        });

        function formatDate(dateISO8601) {
            let date = new Date(dateISO8601);
            if (Number.isNaN(date.getDate()))
                return '';
            return date.getDate() + '.' + padZeros(date.getMonth() + 1) +
                "." + date.getFullYear() + ' ' + date.getHours() + ':' +
                padZeros(date.getMinutes()) + ':' + padZeros(date.getSeconds());

            function padZeros(num) {
                return ('0' + num).slice(-2);
            }
        }


        function loadMyMessagesSuccess(messages) {
            $('#myMessages tbody').empty();

            for (let msg of messages) {
                let body = $('#myMessages tbody');
                let msgRow = $('<tr>');
                let sender = $('<td>').text(msg.sender_name);
                let text = $('<td>').text(msg.text);
                let date = $('<td>').text(formatDate(msg._kmd.lmt));

                msgRow.append(sender);
                msgRow.append(text);
                msgRow.append(date);
                body.append(msgRow);
            }
        }

        $('#viewMyMessages').trigger('reset');

        showView('viewMyMessages');
    }


    function showSendMessagesPage() {
        showView('viewSendMessage');

        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/",
            headers: getKinveyUserAuthHeaders(),
            success: LoadUsersSuccess,
            error: handleAjaxError
        });

        function LoadUsersSuccess(users) {
            for (let user of users) {
                let userName_ = "";
                if (user.name !== "Unknown") {
                    userName_ = ` (${user.name}) `;
                }


                $('select[name="recipient"]').append($('<option>', {
                    value: user.username,
                    text: user.username + `${userName_}`
                }));
            }
        }
    }

    function showLogoutView() {
// TODO: write logout func
    }

    function showAppHome() {
        showView('viewAppHome');
    }

    function showLoginView() {
        showView('viewLogin');
        $('#formLogin').trigger('reset');
    }

    function showRegisterView() {
        $('#formRegister').trigger('reset');
        showView('viewRegister');
    }

// Register user

    function registerUser(event) {
        event.preventDefault();
        let userData = {
            username: $('#formRegister input[name=username]').val(),
            password: $('#formRegister input[name=password]').val(),
            name: $('#formRegister input[name=name]').val(),
        };
        if (userData.name === "") {
            userData.name = "Unknown"
        }
        ;

        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/",
            headers: kinveyAppAuthHeaders,
            data: userData,
            success: registerSuccess,
            error: handleAjaxError
        });
    }

    function registerSuccess(userInfo) {
        console.dir(userInfo)
        saveAuthInSession(userInfo);
        showHideMenuLinks();
        showInfo('User registration successful.');
    }

    function saveAuthInSession(userInfo) {
        let userAuth = userInfo._kmd.authtoken;
        sessionStorage.setItem('authToken', userAuth);
        let userId = userInfo._id;
        sessionStorage.setItem('userId', userId);
        let username = userInfo.username;
        let name = userInfo.name;
        sessionStorage.setItem("name", name);
        sessionStorage.setItem("userId", userInfo._id);
        sessionStorage.setItem("userName", username);


    }

    function handleAjaxError(response) {
        let errorMsg = JSON.stringify(response);
        if (response.readyState === 0)
            errorMsg = "Cannot connect due to network error.";
        if (response.responseJSON &&
            response.responseJSON.description)
            errorMsg = response.responseJSON.description;
        showError(errorMsg);
    }

    function showInfo(message) {
        $('#infoBox').text(message);
        $('#infoBox').show();
        setTimeout(function () {
            $('#infoBox').fadeOut();
        }, 3000);
    }

    function showError(errorMsg) {
        $('#errorBox').text("Error: " + errorMsg);
        $('#errorBox').show();
    }

    function loginUser(event) {
        event.preventDefault();
        let userData = {
            username: $('#formLogin input[name=username]').val(),
            password: $('#formLogin input[name=password]').val()
        };
        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/login",
            headers: kinveyAppAuthHeaders,
            data: userData,
            success: loginSuccess,
            error: handleAjaxError
        });
        function loginSuccess(userInfo) {
            saveAuthInSession(userInfo);
            showHideMenuLinks();
            showInfo('Login successful.');
            showUserHomeView();
        }

    }

    function logoutUser() {
        $('#viewUserHomeHeading').text("");
        sessionStorage.clear();
        $('#loggedInUser').text("");
        $('#spanMenuLoggedInUser').text("");
        showHideMenuLinks();
        showView('viewAppHome');
        showInfo('Logout successful.');
    }

    function sendMessage() {
        event.preventDefault();

        let MessageData = {
            recipient_username: $('option:selected').val(),
            sender_username: sessionStorage.getItem("userName"),
            sender_name: sessionStorage.getItem("name"),
            text: $('#formSendMessage input[name=text]').val()
        };

        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/messages",
            headers: getKinveyUserAuthHeaders(),
            data: MessageData,
            success: messageSentSuccess,
            error: handleAjaxError
        });
        function messageSentSuccess() {
            showInfo("Message sent")
        }
    }
}