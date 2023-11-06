package spring.service;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.entity.User;

@Data
public class RegistrationUser {

    private String userName;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(userName, passwordEncoder.encode(password));
    }
}
