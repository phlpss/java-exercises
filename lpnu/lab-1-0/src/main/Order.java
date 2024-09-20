package main;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    public String orderNumber;
    public String customerName;
    public List<Product> products;
    public String paymentMethod;

    public double getTotalOrderValue() {
        return products.stream()
                .mapToDouble(Product::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "main.Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", products=" + products +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
