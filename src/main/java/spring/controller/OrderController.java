package spring.controller;

import org.springframework.web.bind.annotation.*;
import spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.Product;
import spring.service.OrderService;
import spring.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
       return productService.addProduct(product);
    }
}
