package spring.controller;


import org.springframework.web.bind.annotation.*;
import spring.model.Order;
import spring.model.Product;
import spring.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/{id}")
    public Order addProductToOrder(@RequestBody Order order, @PathVariable Integer id) {
        return order;
    }
}
