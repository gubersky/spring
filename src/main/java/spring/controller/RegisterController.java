package spring.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.entity.User;
import spring.repository.UserRepository;
import spring.service.RegistrationUser;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public RegisterController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registerForm(){
        return "register";
    }

    @PostMapping
    public User save(RegistrationUser registrationUser){
        userRepository.save(registrationUser.toUser(passwordEncoder));
        return registrationUser.toUser(passwordEncoder);
    }
}
