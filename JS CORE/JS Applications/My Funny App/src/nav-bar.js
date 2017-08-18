// Bind the navigation menu links
$("#linkMenuUserHome").click(showUserHomeView); // user home
$("#linkMenuArchiveSent").click(GetSentMessages);
$("#linkMenuMyMessages").click(showMyMessages);
$("#linkMenuSendMessage").click(showSendMessagesPage);
$("#linkMenuLogout").click(showLogoutView);
$("#linkMenuAppHome").click(showAppHome);
$("#linkMenuLogin").click(showLoginView);
$("#linkMenuRegister").click(showRegisterView);
$("#linkMenuLogout").click(logoutUser);

//Bind homepage buttons
$("#linkUserHomeMyMessages").click(showMyMessages);
$("#linkUserHomeSendMessage").click(showSendMessagesPage);
$("#linkUserHomeArchiveSent").click(GetSentMessages);


// Bind the form submit buttons
$("#formLogin").submit(loginUser);
$("#formRegister").submit(registerUser);
$("#formSendMessage").submit(sendMessage);
// $("#formEditBook").submit(editBook);


// Bind the info / error boxes: hide on click
$("#infoBox, #errorBox").click(function () {
    $(this).fadeOut();
});


function showHideMenuLinks() {
    $("#menu a").hide();
    if (sessionStorage.getItem("authToken")) {
        //Logged in user
        $("#linkMenuUserHome").show();
        $("#linkMenuArchiveSent").show();
        $("#linkMenuMyMessages").show();
        $("#linkMenuSendMessage").show();
        $("#linkMenuLogout").show();
        $('#spanMenuLoggedInUser').text(
            "Welcome, " + sessionStorage.getItem("userName") + "!");
        $('#viewUserHomeHeading').text("Welcome, " + sessionStorage.getItem("userName") + '!');
    } else {
        // No user logged in
        $("#linkMenuAppHome").show();
        $("#linkMenuLogin").show();
        $("#linkMenuRegister").show();
    }

}

// views

function showView(viewName) {
    // Hide all views and show the selected view only
    $('main > section').hide();
    $('main > div').hide();
    $('#' + viewName).show();
    if (!sessionStorage.getItem("authToken")) {
        $('#spanMenuLoggedInUser').text("");
        $('#viewUserHomeHeading').text("");
    }

}

function showUserHomeView() {
    showView('viewUserHome');
}