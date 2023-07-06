package spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.dto.OrderDto;
import spring.dto.ProductDto;
import spring.service.ProductService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable int id) {
        return null;
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return null;
    }

    @PostMapping("/{id}")
    public OrderDto add(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.add(id, productDto);
    }
}
