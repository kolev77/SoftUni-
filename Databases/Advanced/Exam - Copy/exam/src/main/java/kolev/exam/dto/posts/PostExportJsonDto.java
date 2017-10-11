package kolev.exam.dto.posts;

import com.google.gson.annotations.Expose;
import kolev.exam.entities.Picture;
import kolev.exam.entities.User;

public class PostExportJsonDto {
    @Expose
    private Integer id;

    @Expose
    private String user;

    @Expose
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
