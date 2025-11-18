package ex;

import java.util.*;

public class OrderManagementSystem {

    private List<Product> products = new ArrayList<>();
    private Set<Product> uniqueProducts = new HashSet<>();
    private Map<Customer, List<Order>> ordersByCustomer = new HashMap<>();

    // Thêm sản phẩm (không trùng tên)
    public void addProduct(Product p) {
        if (uniqueProducts.add(p)) {
            products.add(p);
        } else {
            System.out.println("The product is already in the list, no need to add: " + p.getName());
        }
    }

    public void showAllProducts() {
        System.out.println("List Product:");
        products.forEach(System.out::println);
    }

    // Tạo đơn hàng
    public void createOrder(Customer c, List<Product> selectedProducts) {
        String orderId = "ORD" + (getTotalOrderCount() + 1);
        Order newOrder = new Order(orderId, c, selectedProducts);

        ordersByCustomer.computeIfAbsent(c, k -> new ArrayList<>()).add(newOrder);
        System.out.println("Order created successfully: " + orderId);
    }

    // Lấy tất cả đơn hàng của 1 khách
    public void showOrdersByCustomer(Customer c) {
        List<Order> list = ordersByCustomer.get(c);

        if (list == null || list.isEmpty()) {
            System.out.println("Customer has no orders.");
            return;
        }

        System.out.println("Orders of customer: " + c.getName());
        list.forEach(System.out::println);
    }

    // Tổng số đơn hàng của toàn hệ thống
    public int getTotalOrderCount() {
        return ordersByCustomer.values()
                .stream()
                .mapToInt(List::size)
                .sum();
    }
}
