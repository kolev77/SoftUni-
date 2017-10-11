package kolev.exam.services.api;

import kolev.exam.dto.posts.PostImportXmlDto;
import kolev.exam.entities.Post;

import java.util.List;

public interface PostService {
    String add(PostImportXmlDto postDto);
    List<Post> findAllByCommentsIsNullOrderByIdAsc();
}
