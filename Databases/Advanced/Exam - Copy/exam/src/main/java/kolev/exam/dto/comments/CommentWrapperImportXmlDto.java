package kolev.exam.dto.comments;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "comments")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentWrapperImportXmlDto {

    @XmlElement(name = "comment")
    private List<CommentImportXmlDto> comments;

    public CommentWrapperImportXmlDto() {
    }

    public List<CommentImportXmlDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentImportXmlDto> comments) {
        this.comments = comments;
    }
}
