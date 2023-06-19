package spring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Order {
    private int id;
    private String date;
    private int cost;
    private List<Product> products;
}
