package kolev.springintro.services;

import kolev.springintro.dto.UserDto;
import kolev.springintro.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {
    void persist(User user);
    UserDto getById(Long id);
}
