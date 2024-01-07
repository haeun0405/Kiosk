class Product extends Menu {
    double price;
    String category;

    Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}
