import java.util.HashMap;
import java.util.Map;

class Product{
    private String Name;
    private Integer Quantity;

    public int getQuantity(){
        return this.Quantity;
    }

    public String getName(){
        return this.Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    Product(String Name, int Quantity){
        this.Quantity = Math.max(Quantity, 0);
        this.Name = Name;
    }

}

class Inventory{
    HashMap<String,Integer> inventory = new HashMap<String, Integer>();

    public void addProduct(Product p){
        inventory.put(p.getName(),p.getQuantity());
    }
    public void updateQuantity(Product p, int Quantity){
        inventory.put(p.getName(),Math.max(Quantity,0));
        p.setQuantity(Math.max(Quantity,0));
    }
    public void removeProduct(Product p){
        inventory.remove(p.getName());
    }
    public boolean checkProduct(Product p){
        Integer qt = inventory.get(p.getName());
        if(qt == null){
            System.out.println("Product Does not Exist in Inventory");
            return false;
        }
        return qt > 0;
    }

    public void printInventory(){
        for(Map.Entry<String,Integer> e : inventory.entrySet()){
            System.out.println("Name : " + e.getKey() + " Quantity: " + e.getValue());
        }
    }
}



class q4 {
    public static void main(String[] args){
        Product p1 = new Product("Soap",25);
        Product p2 = new Product("Facewash",0);
        Product p3 = new Product("Sunscreen",2);
        Product p4 = new Product("Shirts",40);

        Inventory shop1 = new Inventory();
        shop1.addProduct(p1);
        shop1.addProduct(p2);
        shop1.addProduct(p3);
        shop1.addProduct(p4);

        shop1.printInventory();
        System.out.println("\n");
        shop1.updateQuantity(p1,30);
        System.out.println("\n");
        shop1.printInventory();

        shop1.removeProduct(p1);
        System.out.println("\n");
        shop1.printInventory();

        System.out.println("Is product p2 in stock : " + shop1.checkProduct(p2));


    }
}