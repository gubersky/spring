package spring.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.Order;
import org.springframework.stereotype.Service;
import spring.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Data
@Service
public class OrderService {

    private final ProductService productService;
    private final List<Order> orders = new ArrayList<>();
    private final Random random = new Random();

    @Autowired
    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Optional<Order> getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> getAllOrder() {
        return orders;
    }

    public Order addOrder(Order order) {
        order.setId(random.nextInt());
        orders.add(order);
        return order;
    }

    public Order addProductToOrder(Order order, int productID) {
        Product addProduct = null;
        Order newOrder = null;
        for (Product product : productService.getProducts()) {
            if (product.getId() == productID) addProduct = product;
        }
        for (Order findOrder : orders) {
            if (findOrder.getId() == order.getId()) {
                if (findOrder.getProducts() == null) {
                    List<Product> list = new ArrayList<>();
                    list.add(addProduct);
                    findOrder.setProducts(list);
                }else findOrder.getProducts().add(addProduct);
                newOrder = findOrder;
            }
        }
        return newOrder;
    }

}
