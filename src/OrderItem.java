class OrderItem {
    private String name;
    private double price;
    private int quantity;
    private String option;
    private String description;

    public OrderItem(String name, double price, String option, String description) {
        this.name = name;
        this.price = price;
        this.option = option;
        this.description = description;
        this.quantity = 1;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getOption() {
        return option;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        String optionDisplay = option.isEmpty() ? "" : "(" + option + ")";
        return name + " | W " + price + " | " + quantity + "개" + (option.isEmpty() ? "" : " | " + option) + " | " + description;
    }
}