package spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    Optional<Order> findById(int id);
    List<Order> findAll();
    Order save(Order order);

}
