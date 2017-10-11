package kolev.exam.services.impl;


import kolev.exam.constants.ResultMessages;
import kolev.exam.dto.posts.PostImportXmlDto;
import kolev.exam.entities.Picture;
import kolev.exam.entities.Post;
import kolev.exam.entities.User;
import kolev.exam.repositories.PictureRepository;
import kolev.exam.repositories.PostRepository;
import kolev.exam.repositories.UserRepository;
import kolev.exam.services.api.PostService;
import kolev.exam.utils.DTOConverter;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PictureRepository pictureRepository;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String add(PostImportXmlDto postDto) {
        Post post = DTOConverter.convert(postDto, Post.class);
        String result = "";
        if (post != null) {
            User user = userRepository.findByUsername(postDto.getUser());
            Picture picture = pictureRepository.findByPath(postDto.getPicture());
            if (user != null && picture != null) {
                post.setUser(user);
                post.setPicture(picture);
                if (DataValidator.isValid(post)){
                    postRepository.save(post);
                    result = String.format(ResultMessages.SUCCESSFUL,
                            post.getClass().getSimpleName(),
                            post);
                }
            }else {
                result = ResultMessages.ERROR;
            }
        }else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public List<Post> findAllByCommentsIsNullOrderByIdAsc() {
        return postRepository.findAllByCommentsIsNullOrderByIdAsc();
    }


}
