package main;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManagementSystem {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("001", "John Doe", Arrays.asList(
                        new Product("Laptop", 1, 1000.0),
                        new Product("Mouse", 2, 25.0)), "card"),

                new Order("002", "John Doe", List.of(
                        new Product("Laptop", 2, 950.0)), "cash"),

                new Order("003", "Alice Boehm", Arrays.asList(
                        new Product("Keyboard", 1, 45.0),
                        new Product("Mouse", 2, 20.0),
                        new Product("Keyboard", 2, 45.0)), "cash"),

                new Order("004", "Victor Boehm", List.of(
                        new Product("SSD", 3, 70.0),
                        new Product("Keyboard", 1, 45.0)), "cash"),

                new Order("005", "Alice Boehm", List.of(
                        new Product("SSD", 3, 70.0),
                        new Product("Monitor", 2, 200.0),
                        new Product("Keyboard", 1, 45.0)), "cash"),

                new Order("006", "John Doe", Arrays.asList(
                        new Product("Laptop", 1, 1000.0),
                        new Product("Headphones", 1, 150.0)), "card")
        );

        List<Order> cardOrders = ordersByPaymentMethod(orders, "card");
        List<Order> cashOrders = ordersByPaymentMethod(orders, "cash");
        System.out.println("Orders paid by card: " + cardOrders);
        System.out.println("Orders paid by cash: " + cashOrders);

        Map<String, List<Order>> ordersByCustomer = ordersGroupedByCustomer(orders);
        System.out.println("Orders grouped by customer: " + ordersByCustomer);

        List<Order> aliceOrders = ordersByCustomerName(orders, "Alice Boehm");
        System.out.println("Orders by customer name: " + aliceOrders);

        Map<String, Integer> totalProductAmount = totalAmountOfEachProduct(orders);
        System.out.println("Total amount of each product: " + totalProductAmount);

        List<Order> sortedOrders = sortOrdersByTotalProductsValue(orders);
        System.out.println("Orders sorted by total value: " + sortedOrders);

        List<Product> uniqueProducts = getUniqueProducts(orders).stream().toList();
        System.out.println("Unique products: " + uniqueProducts);

        Optional<Order> maxValueOrder = getMaxValueOrder(orders);

        maxValueOrder.ifPresentOrElse(
                order -> System.out.println("main.Order with highest total value: " + order),
                () -> System.out.println("No orders available")
        );
    }

    public static Optional<Order> getMaxValueOrder(List<Order> orders) {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalOrderValue));
    }

    public static Set<Product> getUniqueProducts(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());
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