$(document).ready(function () {

    const kinveyAppId = "kid_ryuO054Ml";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "petar";
    const kinveyPassword = "123";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);   // "btoa" encode it in base64
    const authHeaders = {"Authorization": "Basic " + base64auth};

    $("#btnLoadPosts").click(loadPostsClicked);
    $("#btnViewPost").click(viewPostsClicked);

    function loadPostsClicked() {
        let getPostsRequest = {
            method: "GET",
            url: serviceUrl + "/posts",
            headers: authHeaders
        };
        $.ajax(getPostsRequest)
            .then(displayPostsInDropDown)
            .catch(displayError)
    }

    function displayPostsInDropDown(posts) {
        for (let post of posts) {
            let option = $("<option>");
            option.text(post.title);
            option.val(post._id);
            $('#posts').append(option);
        }
    }

    function displayError(error) {
        let errDiv = $("<div>").text("Error: " + error.status + ' (' + error.statusText + ')');
        $(document.body).prepend(errDiv);
        setTimeout(function () {
            errDiv.fadeOut(function () {
                errDiv.remove();
            })
        }, 2000)

    }

    function viewPostsClicked() {
        let selectedPostId = $('#posts').val();

        let postRequest = $.ajax({
            method: "GET",
            url: serviceUrl + "/posts/" + selectedPostId,
            headers: authHeaders
        });

        let commentsRequest = $.ajax({
            method: "GET",
            url: serviceUrl + `/comments/?query={"post_id":"${selectedPostId}"}`,
            headers: authHeaders
        });

        Promise.all([postRequest, commentsRequest])
            .then(DisplayPostWithComments)
            .catch(displayError);
    }
        function DisplayPostWithComments([post,comments]) {
            $("#post-title").text(post.title);
            $("#post-body").text(post.body);

            for (let comment of comments) {
                $("<li>").text(comment.text)
                    .appendTo($("#post-comments"));
            }

    }
});