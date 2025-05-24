import java.util.ArrayList;
import java.util.Scanner; 

class Items {
    protected String Name;
    protected int price;
    protected int quantity;

    Items(String name, int price, int quantity) {
        this.Name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item: " + Name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}


class shoppingCart {
    ArrayList<Items> list = new ArrayList<Items>();

    public int CalculateTotalPrice() {
        int totalprice = 0;
        for (Items x : list) {
            totalprice += (x.price * x.quantity);
        }
        return totalprice;
    }

    public void ViewAllItems() {
        if (list.isEmpty()) {
            System.out.println("\nCart is currently empty.");
            return;
        }
        System.out.println("\n--- Items in Cart ---");
        for (int i = 0; i < list.size(); i++) {
            Items item = list.get(i);
            System.out.println((i + 1) + ". " + item.Name + " (Qty: " + item.quantity + ", Price: $" + item.price + ")");
        }
        System.out.println("---------------------\n");
    }

    public void RemoveItem(String Name) {
        boolean itemRemoved = false;
      
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).Name.equalsIgnoreCase(Name.trim())) { 
                list.remove(i);
                itemRemoved = true;
                System.out.println("'" + Name + "' removed from cart.\n");
                break;
            }
        }
        if (!itemRemoved) {
            System.out.println("'" + Name + "' not found in cart. No item removed.\n");
        }
    }

    public void addItems(Items i1) {
        list.add(i1);
        System.out.println("'" + i1.Name + "' added to cart.\n");
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        shoppingCart newCart = new shoppingCart();
        boolean running = true;

        System.out.println("Welcome to your Shopping Cart Application!");

        while (running) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View All Items");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine()); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name (e.g., Mobile, Fridge, TV, Grinder): ");
                        String name = scanner.nextLine();
                        int price = 0;
                        int quantity = 0;

                        while (true) {
                            System.out.print("Enter item price: ");
                            try {
                                price = Integer.parseInt(scanner.nextLine());
                                if (price <= 0) {
                                    System.out.println("Price must be a positive number. Please try again.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for price.");
                            }
                        }

                        while (true) {
                            System.out.print("Enter item quantity: ");
                            try {
                                quantity = Integer.parseInt(scanner.nextLine());
                                if (quantity <= 0) {
                                    System.out.println("Quantity must be a positive number. Please try again.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for quantity.");
                            }
                        }

                        newCart.addItems(new Items(name, price, quantity));
                        break;

                    case 2:
                        if (newCart.list.isEmpty()) {
                            System.out.println("Cart is empty. Nothing to remove.\n");
                            break;
                        }
                        System.out.print("Enter the name of the item to remove: ");
                        String itemToRemove = scanner.nextLine();
                        newCart.RemoveItem(itemToRemove);
                        break;

                    case 3:
                        newCart.ViewAllItems();
                        break;

                    case 4:
                        System.out.println("Total price of items in cart: $" + newCart.CalculateTotalPrice() + "\n");
                        break;

                    case 5:
                        running = false;
                        System.out.println("Thank you for using the Shopping Cart Application. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage() + "\n");
            }
        }
        scanner.close(); 
    }
}
