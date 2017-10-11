package kolev.exam.dto.comments;

import kolev.exam.dto.posts.PostIdImportXmlDto;
import kolev.exam.entities.Post;
import kolev.exam.entities.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CommentImportXmlDto {
    @XmlElement
    private String content;

    @XmlElement
    private String user;

    @XmlElement
    private PostIdImportXmlDto post;

    public CommentImportXmlDto() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public PostIdImportXmlDto getPost() {
        return post;
    }

    public void setPost(PostIdImportXmlDto post) {
        this.post = post;
    }
}
