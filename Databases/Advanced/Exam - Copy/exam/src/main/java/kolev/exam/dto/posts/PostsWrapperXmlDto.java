package kolev.exam.dto.posts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsWrapperXmlDto {

    @XmlElement(name = "post")
    private List<PostImportXmlDto> posts;

    public PostsWrapperXmlDto() {
    }

    public List<PostImportXmlDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostImportXmlDto> posts) {
        this.posts = posts;
    }
}
