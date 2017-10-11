package kolev.springintro.serviceImpl;

import kolev.springintro.dto.UserDto;
import kolev.springintro.entities.User;
import kolev.springintro.repositories.UserRepository;
import kolev.springintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
