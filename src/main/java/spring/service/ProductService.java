package spring.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import spring.model.Order;
import spring.model.Product;
import spring.repository.ProductRepository;



@Data
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Order addProductToOrder(Order order, int productID) {
        return null;
    }
}
