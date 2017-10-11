package kolev.exam.dto.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kolev.exam.entities.Picture;
import kolev.exam.entities.User;

import java.util.Set;

public class UserExportJsonDto {

    @Expose
    @SerializedName("user")
    private String username;  // unique

    @Expose
    @SerializedName("followers")
    private Integer followersNumber;

    public UserExportJsonDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowersNumber() {
        return followersNumber;
    }

    public void setFollowersNumber(Integer followersNumber) {
        this.followersNumber = followersNumber;
    }
}
