package soft_uni.store.utils;

import soft_uni.store.models.bindingModels.user.LoggedInUser;

public class Session {
    private static LoggedInUser loggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        Session.loggedInUser = loggedInUser;
    }
}
