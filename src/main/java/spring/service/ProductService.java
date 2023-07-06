package spring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import spring.converter.OrderConverter;
import spring.dto.OrderDto;
import spring.dto.ProductDto;
import spring.entity.Product;
import spring.repository.OrderRepository;
import spring.repository.ProductRepository;
import java.util.List;

@Data
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<ProductDto> get(int id){
        return null;
    }

    public List<Product> getAll() {
        return null ;
    }

    public OrderDto add(int orderId, ProductDto product) {
        productRepository.add(Product.builder()
                .name(product.getName())
                .cost(product.getCost())
                .orderId(orderId)
                .build());
        return orderRepository.findById(orderId)
                .map(o -> OrderConverter.toOrderDto(o, productRepository.findAllByOrderId(orderId)))
                .orElseThrow();
    }
}
