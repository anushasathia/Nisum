class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Animal a = new Dog();  

        a.makeSound();      
        Dog d = (Dog) a;       
        d.bark();              
    }
}
