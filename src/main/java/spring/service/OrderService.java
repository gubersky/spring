package spring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring.converter.OrderConverter;
import spring.dto.OrderDto;
import spring.entity.Order;
import org.springframework.stereotype.Service;
import spring.entity.Product;
import spring.repository.OrderRepository;
import spring.repository.ProductRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@Service
public class OrderService {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderDto get(int id) {
        return orderRepository.findById(id)
                .map(order -> OrderConverter.toOrderDto(order, productRepository.findAllByOrderId(id)))
                .orElseThrow();
    }

    public List<OrderDto> getAll() {
        return orderRepository.getAll()
                .stream()
                .map(order -> OrderConverter.toOrderDto(order,productRepository.findAllByOrderId(order.getId())))
                .toList();
    }

    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderRepository.add(Order.builder().date(Date.valueOf(LocalDate.now())).build());
        if (orderDto.getProducts() != null) {
           List<Product> products = orderDto.getProducts().stream()
                   .map(product -> Product.builder()
                           .name(product.getName())
                           .cost(product.getCost())
                           .orderId(order.getId())
                           .build())
                   .toList();
           productRepository.add(products);
        }
        return orderRepository.findById(order.getId())
                .map(o -> OrderConverter.toOrderDto(o, productRepository.findAllByOrderId(order.getId())))
                .orElseThrow();
    }
}
