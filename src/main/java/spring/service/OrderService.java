package spring.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Data
@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final Random random = new Random();

    @Autowired
    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;


    public Optional<Order> getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> getAllOrder() {
        return orders;
    }

    public Order addOrder(Order order) {
        order.setId(random.nextInt());
        orders.add(order);
        return order;
    }

    public Order addProductToOrder(int id) {
        return null;

    }

}
