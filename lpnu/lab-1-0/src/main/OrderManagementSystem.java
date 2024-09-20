package main;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManagementSystem {

    public static Set<Product> getUniqueProducts(List<Order> orders) {
        return new HashSet<>(orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toMap(
                        Product::getName,
                        product -> product,
                        (existing, replacement) -> replacement)) // Merge function to keep the replacement
                .values());
    }

    public static Optional<Order> getMaxValueOrder(List<Order> orders) {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalOrderValue));
    }

    public static List<Order> ordersByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(order -> order.customerName.equals(customerName))
                .toList();
    }

    public static Map<String, List<Order>> ordersGroupedByCustomer(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName));
    }

    public static List<Order> ordersByPaymentMethod(List<Order> orders, String paymentMethod) {
        return orders.stream()
                .filter(order -> order.paymentMethod.equals(paymentMethod))
                .toList();
    }

    public static Map<String, Integer> totalAmountOfEachProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products.stream())
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getAmount,
                        Integer::sum
                ));
    }

    public static List<Order> sortOrdersByTotalProductsValue(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotalOrderValue))
                .toList();
    }
}