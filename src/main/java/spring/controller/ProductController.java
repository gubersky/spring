package spring.controller;

import org.springframework.web.bind.annotation.*;
import spring.model.Product;
import spring.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/order/{orderId}")
    public Product addProductToOrder(@RequestBody Product product, @PathVariable Integer orderId) {
        return productService.addProductToOrder(product, orderId);
    }
}
