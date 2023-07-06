package spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.dto.OrderDto;
import spring.service.OrderService;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable int id) {
        return orderService.get(id);
    }

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public OrderDto add(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }
}
