class Electronics {
    public String brand;
    protected String model;
    int warrantyYears;
    private double price;

    static String category;

    static {
        category = "Electronic Devices";
        System.out.println("Static Block: Category initialized.");
    }

    public Electronics(String brand, String model, int warrantyYears, double price) {
        this.brand = brand;
        this.model = model;
        this.warrantyYears = warrantyYears;
        this.price = price;
    }

    public void showBasicInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Warranty: " + warrantyYears + " years");
    }

    private void showPrice() {
        System.out.println("Price: ₹" + price);
    }

    public void displayAll() {
        showBasicInfo();
        showPrice();
    }
}

class Television extends Electronics {
    int screenSize;

    public Television(String brand, String model, int warrantyYears, double price, int screenSize) {
        super(brand, model, warrantyYears, price);
        this.screenSize = screenSize;
    }

    public void showTVDetails() {
        displayAll();
        System.out.println("Screen Size: " + screenSize + " inches");
    }
}

public class ElectronicsStore {
    public static void main(String[] args) {
        Television tv = new Television("Samsung", "QLED-X45", 2, 75000.0, 55);
        tv.showTVDetails();
        System.out.println("Category: " + Electronics.category);
    }
}
