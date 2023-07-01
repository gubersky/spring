package spring.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import spring.entity.Product;
import spring.repository.ProductRepository;
import java.util.List;

@Data
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProductById(int productId){
        return productRepository.findById(productId);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product addProductToOrder(Product product, int orderID) {
        product.setOrderId(orderID);
        return productRepository.save(product);
    }
}
