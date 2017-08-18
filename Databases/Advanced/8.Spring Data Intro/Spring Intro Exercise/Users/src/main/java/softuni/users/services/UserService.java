package softuni.users.services;

import softuni.users.dto.UserDto;
import softuni.users.entities.User;

import java.util.List;

public interface UserService {
    void persist(User user);

    UserDto getById(Long id);

    List<Object[]> findUsersByEmailProvider(String emailProvider);
}
