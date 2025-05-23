class Person {
    public String name = "Anusha";
    protected int age = 20;
    String city = "Bbsr"; 
    private String secret = "private";

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
        System.out.println("Secret (accessed within class): " + secret);
    }
}

class Student extends Person {
    static {
        System.out.println("Static Block Executed");
    }

    public void show() {
        displayInfo();  
        System.out.println("Inherited Public Name: " + name);
        System.out.println("Inherited Protected Age: " + age);
        System.out.println("Inherited Default City: " + city);
    }
}

public class java7 {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();
    }
}