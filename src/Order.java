import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<Product> products = new ArrayList<>();
    private Scanner scanner;

    public Order(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("\n[ Total ]\nW " + products.stream().mapToDouble(p -> p.price).sum());
    }

    public void clearOrder() {
        products.clear();
    }

    public void processOrder() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        displayOrder();
        System.out.println("\n1. 주문\t2. 메뉴판");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("주문이 완료되었습니다!\n\n대기번호는 [ 1 ] 번 입니다.");
            clearOrder();
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
