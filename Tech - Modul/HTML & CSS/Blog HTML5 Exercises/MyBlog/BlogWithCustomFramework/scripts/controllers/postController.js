class PostController {
    constructor(postView, requester, baseUrl, appKey) {
        this._postView = postView;
        this._requester = requester;
        this._appKey = appKey;
        this._baseServiceUrl = baseUrl + "/appdata/" + appKey + "/posts/";
    }

    showCreatePostPage(fullName, isLoggedIn) {
        this._postView.showCreatePostPage(fullName, isLoggedIn);
    }

    createNewPost(data) {
        this._requester.post(this._baseServiceUrl, data, function (responseData) {
            showPopup('success', 'You`ve created a new post.');
            redirectUrl('#/')
        }, function (responseData) {
            showPopup('error', 'Something went wrong.');
        })
        if (requestData.title.length < 10) {
            showPopup('error', "Post title must consist atleast 10 symbols.");
            return;
        }
        if (requestData.content.length < 50) {
            showPopup('error', "Post content must consist of atleast 50 symbols");
            return;
        }
        function succes(data) {
            showPopup('success', "You have successfully created a new post.");
            redirectUrl("#/");
        }
        function error(data) {
            showPopup('error', "An error has occurred while attempting " + "to create a new post");

        }
    }
}