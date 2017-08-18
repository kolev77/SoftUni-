package softuni.users.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.users.dto.UserDto;
import softuni.users.entities.User;
import softuni.users.repositories.UserRepository;
import softuni.users.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(User user) {
        this.userRepository.save(user);
    }

    @Override
    public UserDto getById(Long id) {
        User user = this.userRepository.findOne(id);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @Override
    public List<Object[]> findUsersByEmailProvider(String provider) {
        return this.userRepository.findUsersByEmailProvider(provider);
    }
}
