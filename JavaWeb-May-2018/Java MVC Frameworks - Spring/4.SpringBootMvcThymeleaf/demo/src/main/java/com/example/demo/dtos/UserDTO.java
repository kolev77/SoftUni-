package com.example.demo.dtos;

import com.example.demo.custom.IsGuest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
    private static final int MIN_PASSWORD_LENGTH = 3;
    private static final int MAX_PASSWORD_LENGTH = 20;
    private static final String PASSWORD_FORMAT_MESSAGE  = "Password must contain only digits and letters";
    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MAX_USERNAME_LENGTH = 15;
    private static final String PASSWORD_VALIDATION_MESSAGE = "Password must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " symbols long.";
    private static final String USERNAME_VALIDATION_MESSAGE = "Username must be between " + MIN_USERNAME_LENGTH + " and " + MAX_USERNAME_LENGTH + " symbols long.";

    @NotEmpty
    @Size(min = 3, max = 15, message = USERNAME_VALIDATION_MESSAGE)
    @IsGuest
    private String username;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9]+",message = PASSWORD_FORMAT_MESSAGE)
    @Size(min = 3, max = 20,
            message = PASSWORD_VALIDATION_MESSAGE)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
