package soft_uni.store.services.api;

import soft_uni.store.models.bindingModels.user.LoggedInUser;
import soft_uni.store.models.bindingModels.user.RegisterUser;

public interface UserService {
    void save(RegisterUser registerUser);
    LoggedInUser findByEmailAndAndPassword(String username,String password);
}
