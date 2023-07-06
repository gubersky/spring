package spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Product;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByOrderId(int id);
    List<Product> saveAll(List<Product> products);
    Product save(Product product);


}
