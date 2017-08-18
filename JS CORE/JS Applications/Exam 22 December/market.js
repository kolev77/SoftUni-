function startApp() {
    if (!sessionStorage.getItem("authToken"))
        showHomeForAnonymous();
    else
        showUserHomeView();
    showHideMenuLinks();

    const kinveyBaseUrl = "https://baas.kinvey.com/";
    const kinveyAppKey = "kid_H1AH5bKEg";
    const kinveyAppSecret =
        "4fa11266acb7487fbe4bb42c8ab11c44";
    const kinveyAppAuthHeaders = {
        'Authorization': "Basic " +
        btoa(kinveyAppKey + ":" + kinveyAppSecret),
    };

    //Bind homepage buttons ANONYMOUS
    $("#linkMenuAppHome").click(showHomeForAnonymous);
    $("#linkMenuLogin").click(showLogin);
    $("#linkMenuRegister").click(showRegister);

    $("#linkMenuUserHome").click(showUserHomeView);
    $("#linkMenuShop").click(showShop);
    $("#linkUserHomeShop").click(showShop);
    $("#linkMenuCart").click(showCart);
    $("#linkUserHomeCart").click(showCart);
    $("#linkMenuLogout").click(logoutUser);


    // Bind the form submit buttons
    $("#formLogin").submit(loginUser);
    $("#formRegister").submit(registerUser);

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

    function showHideMenuLinks() {
        $("#menu a").hide();
        if (sessionStorage.getItem("authToken")) {
            //Logged in user
            showUserHomeView();
            $("#linkMenuUserHome").show();
            $("#linkMenuShop").show();
            $("#linkMenuCart").show();
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

    function showHomeForAnonymous() {
        showView('viewAppHome');
    }

    function showLogin() {
        showView('viewLogin');
    }

    function showRegister() {
        showView('viewRegister');
    }

    function showUserHomeView() {
        showView('viewUserHome');
    }

    function showShop() {
        getProducts();
        showView('viewShop');
    }

    function showCart() {
        $.ajax({
            method: "GET",
            contentType: "application/json",
            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/" + sessionStorage.getItem("userId"),
            headers: getKinveyUserAuthHeaders(),
            success: LoadMyProductsSuccess,
            error: handleAjaxError
        });

        function LoadMyProductsSuccess(user) {
            $('#cartProducts tbody').empty();
            let body = $('#cartProducts tbody');

            let total_sum = 0;
            if(user.cart) {
                for (let product in user.cart) {

                    let product_quantity = Number(user.cart[product].quantity);
                    let product_name = user.cart[product].product.name;
                    let product_price = Number(user.cart[product].product.price);
                    let product_description = user.cart[product].product.description;
                    console.log("quantity" + product_quantity);
                    console.log("price" + product_price);

                    let product_row = $('<tr>');
                    let name = $('<td>').text(product_name);
                    let description = $('<td>').text(product_description);
                    let quantity = $('<td>').text(product_quantity);
                    let totalPrice = $('<td>').text((product_quantity * product_price).toFixed(2));
                    let deleteBtn = $('<button>').text('Purchase').click(() => deleteProduct(product));

                    function deleteProduct(product) {
                        $.ajax({
                            method: "GET",
                            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/" + sessionStorage.getItem("userId"),
                            headers: getKinveyUserAuthHeaders(),
                            success: loadProducts,
                            error: handleAjaxError
                        });
                    }

                    function loadProducts(products) {
                        if (products.cart[product]) {
                            delete products.cart[product];
                        }

                        $.ajax({
                            method: "PUT",
                            url: kinveyBaseUrl + "user/" + kinveyAppKey + "/" + sessionStorage.getItem("userId"),
                            headers: getKinveyUserAuthHeaders(),
                            contentType: "application/json",
                            data: JSON.stringify(products),
                            success: success,
                            error: handleAjaxError
                        });

                        function success() {
                            showInfo("Success")
                        }

                    }

                    total_sum += (product_quantity * product_price);

                    product_row.append(name);
                    product_row.append(description);
                    product_row.append(quantity);
                    product_row.append(totalPrice);
                    product_row.append($('<td>').append(deleteBtn));
                    body.append(product_row);

                }
            }
            let totalContainer = $('<div>').text(total_sum.toFixed(2));
            body.append(totalContainer);
            showView('viewCart')
        }
    }

    function registerUser(event) {
        event.preventDefault();
        let userData = {
            username: $('#formRegister input[name=username]').val(),
            password: $('#formRegister input[name=password]').val(),
            name: $('#formRegister input[name=name]').val(),
            cart: {}
        };

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

    function getKinveyUserAuthHeaders() {
        return {
            'Authorization': "Kinvey " + sessionStorage.getItem('authToken'),
        };
    }

    function loginUser(event) {
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
            showUserHomeView();
            showInfo('Login successful.');
        }
    }

    function logoutUser() {
        $('#viewUserHomeHeading').text("");
        sessionStorage.clear();
        $('#spanMenuLoggedInUser').text("");
        showHideMenuLinks();
        showView('viewAppHome');
        showInfo('Logout successful.');
    }

    function getProducts() {
        $.ajax({
            method: "GET",
            url: kinveyBaseUrl + "appdata/" + kinveyAppKey + "/products",
            headers: getKinveyUserAuthHeaders(),
            success: loadProductsSuccess,
            error: handleAjaxError
        });

        function loadProductsSuccess(products) {
            $('#shopProducts tbody').empty();
            for (let product of products) {
                let body = $('#shopProducts tbody');
                let productRow = $('<tr>');
                let name = $('<td>').text(product.name);
                let description = $('<td>').text(product.description);
                let price = $('<td>').text((Math.round(product.price * 100) / 100).toFixed(2));
                let purchaseBtn = $('<button>').text('Purchase').click(() => getUser(product));
                productRow.append(name);
                productRow.append(description);
                productRow.append(price);
                productRow.append($('<td>').append(purchaseBtn));
                body.append(productRow);


                function getUser() {
                    $.ajax({
                        method: "GET",
                        contentType: "application/json",
                        url: kinveyBaseUrl + "user/" + kinveyAppKey + "/" + sessionStorage.getItem("userId"),
                        headers: getKinveyUserAuthHeaders(),
                        success: addInCart,
                        error: handleAjaxError
                    });
                }

                function addInCart(user) {
                    let productId = product._id;
                    let productData = {};
                    productData[productId] = {};
                    productData[productId] =
                        {
                            "quantity": "1",
                            "product": {
                                "name": product.name,
                                "description": product.description,
                                "price": product.price
                            }
                        };

                    if (user.cart == null) {
                        user.cart = new Object(productData);
                    } else {
                        if (user.cart[productId] != null) {
                            user.cart[productId].quantity++;
                        } else {
                            user.cart = Object.assign(user.cart, user.cart, productData);
                        }
                    }

                    $.ajax({
                        method: "PUT",
                        url: kinveyBaseUrl + "user/" + kinveyAppKey + "/" + sessionStorage.getItem("userId"),
                        headers: getKinveyUserAuthHeaders(),
                        contentType: "application/json",
                        data: JSON.stringify(user),
                        success: addedSuccess,
                        error: handleAjaxError
                    });
                }

                function addedSuccess() {
                    showInfo("Product purchased.");
                }
            }
        }
    }
}