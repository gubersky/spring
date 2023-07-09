package spring.controller;

import org.springframework.web.bind.annotation.*;
import spring.dto.OrderDto;
import spring.dto.ProductDto;
import spring.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
        return productService.addProduct(id, productDto);
    }
}
