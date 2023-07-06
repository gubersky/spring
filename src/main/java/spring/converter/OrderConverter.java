package spring.converter;

import spring.dto.OrderDto;
import spring.dto.ProductDto;
import spring.entity.Order;
import spring.entity.Product;

import java.sql.Date;
import java.util.List;

public class OrderConverter {

    public static OrderDto toOrderDto(Order order, List<Product> products) {
        double orderCost = products.stream()
                .mapToDouble(Product::getCost)
                .sum();
        List<ProductDto> productsDto = products.stream()
                .map(p -> ProductDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .cost(p.getCost())
                        .build())
                .toList();
        return OrderDto.builder()
                .id(order.getId())
                .date((Date) order.getDate())
                .cost(orderCost)
                .products(productsDto)
                .build();
    }
}
