package spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Order;
import spring.entity.Product;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByOrderId(int id);

    List<Product> findAll();

    @Override
    <S extends Product> Iterable<S> saveAll(Iterable<S> entities);

    Product save(Product product);

}
