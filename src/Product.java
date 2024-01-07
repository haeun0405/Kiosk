import java.util.Map;
import java.util.HashMap;
public class Product {
    private String name;
    private double price;
    private String description;
    private String category;
    private Map<String, Double> options; // 옵션 관리
    // 옵션 포함 생성자
    public Product(String name, String description, double price, String category, Map<String, Double> options) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.options = (options != null) ? options : new HashMap<>();
    }
    // 옵션 미포함 생성자
    public Product(String name, String description, double price, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.options = new HashMap<>(); // 옵션이 없는 경우 빈 맵으로 초기화
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public Map<String, Double> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}