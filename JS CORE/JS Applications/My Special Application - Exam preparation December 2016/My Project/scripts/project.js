function startApp() {
    // Clear user auth data
     //  sessionStorage.clear();

    showHideMenuLinks();

    showView('viewHome');

    // Bind the navigation menu links
    $("#linkHome").click(showHomeView);
    $("#linkLogin").click(showLoginView);
    $("#linkRegister").click(showRegisterView);
    $("#linkListBooks").click(listPosts);
    $("#linkCreateBook").click(showCreateBookView);
    $("#linkLogout").click(logoutUser);


    // Bind the form submit buttons
    $("#formLogin").submit(loginUser);
    $("#formRegister").submit(registerUser);
    $("#formCreatePost").submit(createBook);
    $("#formEditBook").submit(editBook);


    // Bind the info / error boxes: hide on click
    $("#infoBox, #errorBox").click(function () {
        $(this).fadeOut();
    });


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


    const kinveyBaseUrl = "https://baas.kinvey.com/";
    const kinveyAppKey = "kid_S19OESYH";
    const kinveyAppSecret =
        "ac882f6363264dc4ba6739b329b156be";
    const kinveyAppAuthHeaders = {
        'Authorization': "Basic " +
        btoa(kinveyAppKey + ":" + kinveyAppSecret),
    };


    function showHideMenuLinks() {
        $("#menu a").hide();
        if (sessionStorage.getItem("authToken")) {
            //Logged in user
            $("#linkHome").show();
            $("#linkListBooks").show();
            $("#linkCreateBook").show();
            $("#linkLogout").show();
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
        $('#' + viewName).show();
    }


    function showHomeView() {
        showView("viewHome");
    }


    function showLoginView() {
        showView('viewLogin');
        $('#formLogin').trigger('reset');
    }

    function showRegisterView() {
            $('#formRegister').trigger('reset');
        showView('viewRegister');
    }

    function listPosts() {
        $('#posts').empty();
        showView('viewPosts');

        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/posts",
            headers: getKinveyUserAuthHeaders(),
            success: loadPostsSuccess,
            error: handleAjaxError
        });
    }

    function loadPostsSuccess(posts) {
        showInfo('Loading...');
        if (posts.length == 0) {
            $('#posts').text('Base is empty.');
        } else {
            let Posts = $('<div>');
            for (let post of posts) {
                appendPost(post, Posts);
                console.log(post);
            }
            $('#posts').append(Posts);
        }
    }

    function getKinveyUserAuthHeaders() {
        return {
            'Authorization': "Kinvey " +
            sessionStorage.getItem('authToken'),
        };
    }


    function showCreateBookView() {
        $('#formCreatePost').trigger('reset');
        showView('viewCreatePost');
    }

    function appendPost(post, Posts) {
        let links = [];
        if (post._acl.creator == sessionStorage.getItem("userId")) {
            let deleteLink = $("<a href='#' style='text-decoration: none; color: #FF5500'>[Delete]</a>").click(deleteBook.bind(this, post));
            let editLink = $('<a href="#" style="text-decoration: none; color: #FF5500">[Edit]</a>')
                .click(loadBookForEdit.bind(this, post));
            links.push(deleteLink);
            links.push(" ");
            links.push(editLink);
        }
        Posts.append($('<div class="post">').append(
            $('<div class="post-title">').text(post.title),
            $('<div class="post-author">').text(post.author),
            $('<textarea readonly="true" role="100" cols="65" style="margin-left: 80px; margin-top: 20px">').text(post.contentText),
            $('<div class="post-buttons">').append(links),
            $('<div class="comments">')
        ));

    }

    function loadBookForEdit(post) {
        $.ajax({
            method: "GET",
            url: kinveyBookUrl = kinveyBaseUrl + "appdata/" +
                kinveyAppKey + "/posts/" + book._id,
            headers: getKinveyUserAuthHeaders(),
            success: loadBookForEditSuccess,
            error: handleAjaxError
        });

        function loadBookForEditSuccess(post) {
            $('#formEditBook input[name=id]').val(book._id);
            $('#formEditBook input[name=title]').val(book.title);
            $('#formEditBook input[name=author]')
                .val(book.author);
            $('#formEditBook textarea[name=descr]')
                .val(book.description);
            showView('viewEditBook');
        }
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
            listPosts();
            showInfo('Login successful.');
        }

    }


    function logoutUser() {
        sessionStorage.clear();
        $('#loggedInUser').text("");
        showHideMenuLinks();
        showView('viewHome');
        showInfo('Logout successful.');
    }


    function registerUser(event) {
        event.preventDefault();
        let userData = {
            username: $('#formRegister input[name=username]').val(),
            password: $('#formRegister input[name=passwd]').val(),
            city: $('#formRegister select[name=City]').val(),
            email: $('#formRegister input[name=email]').val()
        };

        if ($('#formRegister input[name=passwd]').val() == $('#formRegister input[name=passwdRepeat]').val()) {
            $.ajax({
                method: "POST",
                url: kinveyBaseUrl + "user/" + kinveyAppKey + "/",
                headers: kinveyAppAuthHeaders,
                data: userData,
                success: registerSuccess,
                error: handleAjaxError
            });
        } else {
            showError("verification password is incorrect")
        }
    }

    function registerSuccess(userInfo) {
        console.dir(userInfo)
        saveAuthInSession(userInfo);
        showHideMenuLinks();
        listPosts();
        showInfo('User registration successful.');
    }

    function saveAuthInSession(userInfo) {
        let userAuth = userInfo._kmd.authtoken;
        sessionStorage.setItem('authToken', userAuth);
        let userId = userInfo._id;
        sessionStorage.setItem('userId', userId);
        let username = userInfo.username;
        sessionStorage.setItem("userId", userInfo._id);
        $('#loggedInUser').text(
            "Welcome, " + username + "!");
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


    function createBook() {
        alert('!!!!!')

        let postData = {
            title: $('#formCreatePost input[name=title]').val(),
            author: $('#formCreatePost input[name=author]').val(),
            contentText: $('#formCreatePost textarea[name=contentText]').val()
        };
        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/posts",
            headers: getKinveyUserAuthHeaders(),
            data: postData,
            success: createPostSuccess,
            error: handleAjaxError
        });
        function createPostSuccess(response) {
            listPosts();
            showInfo('Post created.');
        }
    }


    function editBook(event) {
        event.preventDefault();
        let bookData = {
            title: $('#formEditBook input[name=title]').val(),
            author: $('#formEditBook input[name=author]').val(),
            description: $('#formEditBook textarea[name=descr]').val()
        };
        $.ajax({
            method: "PUT",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey +
            "/books/" + $('#formEditBook input[name=id]').val(),
            headers: getKinveyUserAuthHeaders(),
            data: bookData,
            success: editBookSuccess,
            error: handleAjaxError
        });

        function editBookSuccess(response) {
            listPosts();
            showInfo('Book edited.');
        }
    }


    function deleteBook(book) {
        $.ajax({
            method: "DELETE",
            url: kinveyBookUrl = kinveyBaseUrl + "appdata/" +
                kinveyAppKey + "/books/" + book._id,
            headers: getKinveyUserAuthHeaders(),
            success: deleteBookSuccess,
            error: handleAjaxError
        });
        function deleteBookSuccess(response) {
            listPosts();
            showInfo('Book deleted.');
        }
    }

}