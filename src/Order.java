import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    private Map<String, OrderItem> orderItems = new HashMap<>();
    private Scanner scanner;

    public Order(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addProduct(Product product, String option) {
        String key = product.getName() + (option.isEmpty() ? "" : " (" + option + ")");
        if(orderItems.containsKey(key)) {
            orderItems.get(key).incrementQuantity();
        } else {
            double price = product.getPrice() + (option.isEmpty() ? 0 : product.getOptions().get(option));
            OrderItem newItem = new OrderItem(product.getName(), price, option, product.getDescription());
            orderItems.put(key, newItem);
        }
    }

    public void displayOrder() {
        double total = 0.0;
        for (OrderItem item : orderItems.values()) {
            System.out.println(item);
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("\n[ Total ]\nW " + String.format("%.1f", total));
    }
    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : orderItems.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearOrder() {
        orderItems.clear();
    }
    public void processOrder() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        displayOrder();
        System.out.println("\n1. 주문\t2. 메뉴판");

        int choice = scanner.nextInt();

        if (choice == 1) {
            double orderTotal = calculateTotal(); // 주문 총액 계산
            Kiosk.updateSales(orderTotal); // 총 판매액 업데이트
            updateSoldProducts(); // 총 판매상품 업데이트
            System.out.println("주문이 완료되었습니다!\n\n대기번호는 [ 1 ] 번 입니다.");
            clearOrder();
        }
    }

    private void updateSoldProducts() {
        for (OrderItem item : orderItems.values()) {
            Kiosk.updateSoldProducts(item.getName(), item.getQuantity());
        }
    }

    public void cancelOrder() {
        System.out.println("\n진행하던 주문을 취소하시겠습니까?\n1. 확인\t2. 취소");
        int choice = scanner.nextInt();

        if (choice == 1) {
            clearOrder();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }
}
