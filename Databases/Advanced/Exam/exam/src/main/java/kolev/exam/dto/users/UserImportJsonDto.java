package kolev.exam.dto.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kolev.exam.entities.Picture;

public class UserImportJsonDto {
    @Expose
    private String username;  // unique

    @Expose
    private String password;

    @Expose
    @SerializedName("profile_picture")
    private String profilePicture;

    public UserImportJsonDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
