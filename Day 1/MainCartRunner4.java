import java.util.ArrayList;

// This was meant to hold shopping cart items... maybe I should've named it CartItem?
class ShoppingThing {
    String nameOfItem;
    double costOfItem;
    int id;  // might be better named itemId, but this works for now

    public ShoppingThing(String nameOfItem, double costOfItem, int id) {
        // Some basic sanity checks here
        if (nameOfItem == null || nameOfItem.isEmpty()) {
            throw new IllegalArgumentException("Hey! Item name can't be blank.");
        }

        if (costOfItem <= 0) {
            throw new IllegalArgumentException("Cost should be more than zero.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("ID has to be a positive number.");
        }

        this.nameOfItem = nameOfItem;
        this.costOfItem = costOfItem;
        this.id = id;
    }
}

public class MainCartRunner4 {
    public static void main(String[] args) {
        ArrayList<ShoppingThing> stuffInCart = new ArrayList<>();
        // might consider switching to LinkedList later?

        try {
            stuffInCart.add(new ShoppingThing("Laptop", 50000.0, 101));
            stuffInCart.add(new ShoppingThing("Mouse", 500.0, 102));
            stuffInCart.add(new ShoppingThing("Keyboard", 1500.0, 103));
            // stuffInCart.add(new ShoppingThing("", 0, -1)); // used to test validation
        } catch (IllegalArgumentException problem) {
            // not very graceful error handling, but enough for now
            System.out.println("Oops! Couldn't add item: " + problem.getMessage());
        }

        // Count and total - basic summary
        int numberOfItems = stuffInCart.size();  // probably unnecessary variable but clearer this way
        double totalAmount = 0.0;

        for (ShoppingThing s : stuffInCart) {
            totalAmount += s.costOfItem;
        }

        // Final printout - summary block
        System.out.println("\n--- Order Summary ---");
        System.out.println("Total Items: " + numberOfItems);
        System.out.println("Order Total: ₹" + totalAmount);
    }
}
