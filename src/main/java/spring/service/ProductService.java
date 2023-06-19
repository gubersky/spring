package spring.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Order;
import spring.model.Product;

import java.util.Optional;
import java.util.Random;


@Data
@Service
public class ProductService {

    private final Random random = new Random();
    OrderService orderService;

    @Autowired
    public ProductService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Optional<Order> addProduct(int id, Product product) {
        product.setId(random.nextInt());
        orderService.getOrders().stream()
                .filter(order -> order.getId() == id)
                .map(order -> order.getProducts().add(product));
        return orderService.getOrders().stream().filter(order -> order.getId() == id).findFirst();
    }
}
