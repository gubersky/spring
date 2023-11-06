package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);
    User findByUserName(String userName);
}
