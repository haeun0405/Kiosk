import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Kiosk {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();
    private static final Order order = new Order(scanner);

    public static void main(String[] args) {
        initializeProducts();

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showProductsMenu("Burgers");
                    break;
                case 2:
                    showProductsMenu("Frozen Custard");
                    break;
                case 3:
                    showProductsMenu("Drinks");
                    break;
                case 4:
                    showProductsMenu("Beer");
                    break;
                case 5:
                    order.processOrder();
                    break;
                case 6:
                    order.cancelOrder();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void initializeProducts() {
        // 버거 메뉴
        products.add(new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, "Burgers"));
        products.add(new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, "Burgers"));
        products.add(new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4, "Burgers"));
        products.add(new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, "Burgers"));
        products.add(new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4, "Burgers"));
        // 아이스크림 메뉴
        products.add(new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터,커피", 5.9, "Frozen Custard"));
        products.add(new Product("Shakes of the Week", "특별한 커스터드 플레이버", 6.5, "Frozen Custard"));
        products.add(new Product("Red Bean Shakes", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5, "Frozen Custard"));
        products.add(new Product("Floats", "루트 비어, 퍼플 카우, 크림시클", 5.9, "Frozen Custard"));
        products.add(new Product("Cups & Cones", "바닐라, 초콜렛, Flovor of the Week", 5.9, "Frozen Custard"));
        products.add(new Product("concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9, "Frozen Custard"));
        // 음료 메뉴
        products.add(new Product("shack-made Lemonade", "매장에서 직접 만다는 상큼한 레몬에이드(오리지날/시즈널)", 3.9, "Drinks"));
        products.add(new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks"));
        products.add(new Product("Fifty/fifty", "레몬에이드와 아이스티의 만남", 3.5, "Drinks"));
        products.add(new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, "Drinks"));
        products.add(new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks"));
        products.add(new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks"));
        // 맥주
        products.add(new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8, "Beer"));
    }

    private static void showMainMenu() {
        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거" );
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println("\n[ ORDER MENU ]");
        System.out.println("5. Order           | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel          | 징행중인 주문을 취소합니다.");
    }

    private static void showProductsMenu(String category) {
        System.out.println("\n\"" + category + " MENU\"");
        List<Product> categoryProducts = products.stream()
                .filter(p -> p.category.trim().equalsIgnoreCase(category.trim()))
                .toList();

        for (int i = 0; i < categoryProducts.size(); i++) {
            System.out.println((i + 1) + ". " + categoryProducts.get(i));
        }

        System.out.println("상품을 선택해주세요. (메인 메뉴로 돌아가려면 0을 입력하세요)");
        int choice = scanner.nextInt();

        if (choice == 0 || choice > categoryProducts.size()) return;

        Product selectedProduct = categoryProducts.get(choice - 1);
        System.out.println(selectedProduct + "\n위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인\t2. 취소");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            order.addProduct(selectedProduct);
            System.out.println(selectedProduct.name + "가 장바구니에 추가되었습니다.");
        }
    }

}