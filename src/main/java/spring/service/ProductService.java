package spring.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import spring.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Data
@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final Random random = new Random();
    OrderService orderService;


    public ProductService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Product addProduct(Product product) {
        product.setId(random.nextInt());
        products.add(product);
        return product;
    }
}
