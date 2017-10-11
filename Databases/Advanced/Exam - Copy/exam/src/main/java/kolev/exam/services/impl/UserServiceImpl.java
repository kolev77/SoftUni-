package kolev.exam.services.impl;


import kolev.exam.constants.ResultMessages;
import kolev.exam.dto.users.UserFollowersImportJsonDto;
import kolev.exam.dto.users.UserImportJsonDto;
import kolev.exam.entities.Comment;
import kolev.exam.entities.Post;
import kolev.exam.entities.User;
import kolev.exam.repositories.PictureRepository;
import kolev.exam.repositories.UserRepository;
import kolev.exam.services.api.UserService;
import kolev.exam.utils.DTOConverter;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PictureRepository pictureRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String add(UserImportJsonDto userDto) {
        User user = DTOConverter.convert(userDto, User.class);
        user.setProfilePicture(pictureRepository.findByPath(userDto.getProfilePicture()));
        user.setFollowers(new HashSet<>());
        user.setFollowing(new HashSet<>());

        String result;
        if (DataValidator.isValid(user)) {
            this.userRepository.save(user);
            result = String.format(ResultMessages.SUCCESSFUL, user.getClass().getSimpleName(), user);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public String addFollowers(UserFollowersImportJsonDto userFollowersDto) {
        String result = "";
        User user = userRepository.findByUsername(userFollowersDto.getUsername());
        if (user != null) {
            Set<User> followers = user.getFollowers();
            User follower = userRepository.findByUsername(userFollowersDto.getFollower());
            if (follower != null) {
                if (DataValidator.isValid(user)) {
                    followers.add(follower);
                    Set<User> following = follower.getFollowing();
                    following.add(user);
                    follower.setFollowing(following);
                    this.userRepository.save(user);
                    result = String.format(ResultMessages.SUCCESSFUL, "Follower ", user);
                } else {
                    result = ResultMessages.ERROR;
                }
            } else {
                result = ResultMessages.ERROR;
            }
        } else {
            result = ResultMessages.ERROR;
        }
        return result;

    }

    @Override
    public List<User> findUsersWithPostsAndComments() {
        return userRepository.findUsersWithPostsAndComments();
    }

    @Override
    public List<User> findWithCommentsByFollowers() {
        List<User> allUsers = userRepository.findUsersWithPostsAndComments();
        List<User> usersForExport = new ArrayList<>();
        for (User user : allUsers) {
            Set<User> followers = user.getFollowers();
            Set<Post> posts = user.getPosts();
            if (checkFollowers(followers, posts)) {
                usersForExport.add(user);
            }
        }
        return usersForExport;
    }


    public boolean checkFollowers(Set<User> followers, Set<Post> posts) {
        for (Post post : posts) {
            Set<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                if (followers.contains(comment.getUser())) {
                    return true;
                }
            }
        }
        return false;
    }
}
