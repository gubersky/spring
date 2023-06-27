package spring.service;

import lombok.Data;
import spring.model.Order;
import org.springframework.stereotype.Service;
import spring.repository.OrderRepository;
import java.util.List;

@Data
@Service
public class OrderService {

    private final ProductService productService;
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository,ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
}
