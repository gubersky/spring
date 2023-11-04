package spring.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import spring.entity.User;
import spring.repository.RegisterRepository;

@Data
@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public User save(User user){
        registerRepository.save(user);
        return user;
    }
}
