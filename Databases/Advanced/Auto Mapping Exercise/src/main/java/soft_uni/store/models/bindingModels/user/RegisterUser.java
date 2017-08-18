package soft_uni.store.models.bindingModels.user;

import soft_uni.store.validations.Password;
import soft_uni.store.validations.PasswordMatching;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Pattern;

@PasswordMatching
public class RegisterUser {
    @Pattern(regexp = ".+@.+\\..+",message = "Invalid email")
    private String email;
    @Password
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
