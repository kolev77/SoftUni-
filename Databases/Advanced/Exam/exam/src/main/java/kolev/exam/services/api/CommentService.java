package kolev.exam.services.api;

import kolev.exam.dto.comments.CommentImportXmlDto;

public interface CommentService {
    String add(CommentImportXmlDto commentDto);
}
