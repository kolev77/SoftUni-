package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.dto.comments.CommentImportXmlDto;
import kolev.exam.entities.Comment;
import kolev.exam.entities.Post;
import kolev.exam.entities.User;
import kolev.exam.repositories.CommentRepository;
import kolev.exam.repositories.PostRepository;
import kolev.exam.repositories.UserRepository;
import kolev.exam.services.api.CommentService;
import kolev.exam.utils.DTOConverter;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String add(CommentImportXmlDto commentDto) {
        String result = "";
        Comment comment = DTOConverter.convert(commentDto, Comment.class);
        try {
            Post post = postRepository.findOne(commentDto.getPost().getId());
            User user = userRepository.findByUsername(commentDto.getUser());

            if (post != null || user != null) {
                comment.setPost(post);
                comment.setUser(user);
                comment.setContent(commentDto.getContent());
                if (DataValidator.isValid(comment)) {
                    commentRepository.save(comment);
                    result = String.format(ResultMessages.SUCCESSFUL,
                            comment.getClass().getSimpleName(),
                            comment);
                } else {
                    result = ResultMessages.ERROR;
                }
            }else {
                result = ResultMessages.ERROR;
            }
        } catch (NullPointerException e) {
            result = ResultMessages.ERROR;
        };

        return result;
    }
}
