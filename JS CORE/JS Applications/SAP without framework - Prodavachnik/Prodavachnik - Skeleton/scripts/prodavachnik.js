function startApp() {

    showHideMenuLinks();
    showView("viewHome");
    bind();
    const kinveyBaseUrl = "https://baas.kinvey.com/";
    const kinveyAppKey = "kid_BkptsgOEl";
    const kinveyAppSecret =
        "1ff33e48e5cc4f38b5707f43eadd8438";
    const kinveyAppAuthHeaders = {
        'Authorization': "Basic " +
        btoa(kinveyAppKey + ":" + kinveyAppSecret),
    };

    const kinveyUserUrl = `${kinveyBaseUrl}user/${kinveyAppKey}/${sessionStorage.getItem('userId')}`;

    function showHideMenuLinks() {
        $("#menu a").hide();
        if (sessionStorage.getItem("authToken")) {
            //Logged in user
            $("#linkHome").show();
            $("#linkListAds").show();
            $("#linkCreateAd").show();
            $("#linkLogout").show();

            $('#spanMenuLoggedInUser').text(
                "Welcome, " + sessionStorage.getItem("userName") + "!");
            $('#viewUserHomeHeading').text("Welcome, " + sessionStorage.getItem("userName") + '!');
        } else {
            // No user logged in
            $("#linkHome").show();
            $("#linkLogin").show();
            $("#linkRegister").show();
        }

    }

    function showView(viewName) {
        // Hide all views and show the selected view only
        $('main > section').hide();
        $('main > div').hide();
        $('#' + viewName).show();
        // if (!sessionStorage.getItem("authToken")) {
        //     $('#spanMenuLoggedInUser').text("");
        //     $('#viewUserHomeHeading').text("");
        // }

    }

    function registerView() {
        showView("viewRegister");
    }

    function loginView() {
        showView("viewLogin");
    }

    function homeView() {
        showView("viewHome");
    }

    function adsView() {
        showView("viewAds");
    }

    function createAdsView() {
        showView("viewCreateAd");

    }

    function logout() {
        sessionStorage.clear();
        showHideMenuLinks();
        homeView();
        showInfo('Logout successful.');
    }

    function bind() {

        // Bind the menu links
        $("#linkRegister").click(registerView); // no users logged
        $("#linkLogin").click(loginView); // no users logged
        $("#linkHome").click(homeView); // no users logged
        $("#linkListAds").click(adsView); // no users logged
        $("#linkCreateAd").click(createAdsView); // no users logged
        $("#linkLogout").click(logout); // no users logged


        // Bind the form submit buttons
        $("#buttonLoginUser").click(loginUser);
        $("#buttonRegisterUser").click(registerUser);
        $("#buttonCreateAd").click(createAdv);
        // $("#formSendMessage").submit(sendMessage);
        // $("#formEditBook").submit(editBook);
    }

    function registerUser(event) {
        event.preventDefault();
        let userData = {
            username: $('#formRegister input[name=username]').val(),
            password: $('#formRegister input[name=passwd]').val(),
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
        sessionStorage.setItem("userId", userInfo._id);
        sessionStorage.setItem("username", username);
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
            password: $('#formLogin input[name=passwd]').val()
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
            homeView();
            showInfo('Login successful.');

        }

    }

    function getKinveyUserAuthHeaders() {
        return {
            'Authorization': "Kinvey " + sessionStorage.getItem('authToken'),
        };
    }

    function createAdv() {
        event.preventDefault(); // not sure about it

        let AdvData = {
            title: $('#formCreateAd input[name=title]').val(),
            description: $('#formCreateAd textarea[name=description]').val(),
            datePublished: $('#formCreateAd input[name=datePublished]').val(),
            price: $('#formCreateAd input[name=price]').val(),
            publisher: sessionStorage.getItem("username")
        };

        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/offers",
            headers: getKinveyUserAuthHeaders(),
            data: AdvData,
            success: Success,
            error: handleAjaxError
        });
        function Success() {
            showInfo("Complete !");
            adsView();
        }
    }
}