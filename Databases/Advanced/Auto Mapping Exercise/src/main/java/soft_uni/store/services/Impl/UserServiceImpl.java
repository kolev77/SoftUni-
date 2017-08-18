package soft_uni.store.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.store.entities.Role;
import soft_uni.store.entities.User;
import soft_uni.store.models.bindingModels.user.LoggedInUser;
import soft_uni.store.utils.ModelParser;
import soft_uni.store.models.bindingModels.user.RegisterUser;
import soft_uni.store.repositories.UserRepository;
import soft_uni.store.services.api.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(RegisterUser registerUser) {
        User user = ModelParser.getInstance()
                .map(registerUser, User.class);

        if (this.userRepository.findAll().size() > 0) {
            user.setRole(Role.USER);
        } else{
            user.setRole(Role.ADMIN);
        }
            this.userRepository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser findByEmailAndAndPassword(String username, String password) {
        User user = this.userRepository.findByEmailAndAndPassword(username,password);
        LoggedInUser loggedInUser = null;
        if (user!=null){
            loggedInUser = ModelParser.getInstance().map(user,LoggedInUser.class);
        }
        return loggedInUser;
    }
}
