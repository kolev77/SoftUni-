package kolev.exam.services.api;

import kolev.exam.dto.users.UserFollowersImportJsonDto;
import kolev.exam.dto.users.UserImportJsonDto;
import kolev.exam.entities.User;

import java.util.List;

public interface UserService {
    String add(UserImportJsonDto userDto);
    String addFollowers(UserFollowersImportJsonDto userFollowersDto);
    List<User> findUsersWithPostsAndComments();

    List<User> findWithCommentsByFollowers();
}
