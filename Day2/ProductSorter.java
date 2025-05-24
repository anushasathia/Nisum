import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s $%.2f", name, category, price);
    }
}

public class ProductSorter {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Shoes", "Fashion", 60.00));
        products.add(new Product("TV", "Electronics", 800.00));
        products.add(new Product("Jacket", "Fashion", 100.00));
        products.add(new Product("Blender", "Home", 150.00));

        products.sort(
            Comparator.comparing((Product p) -> p.category.toLowerCase())
                      .thenComparingDouble(p -> p.price)
        );

        System.out.printf("%-15s %-15s %s\n", "Name", "Category", "Price");
        System.out.println("---------------------------------------------");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}