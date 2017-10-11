package kolev.exam.dto.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserFollowersImportJsonDto {
    @Expose
    @SerializedName("user")
    private String username;

    @Expose
    private String follower;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }
}
