class DadClass {
    // Just a basic static method, doesn't rely on object instance
    static void showGreeting() {
        System.out.println("Hello from DadClass!");
    }
}

class KidClass extends DadClass {
    void callParentMethod() {
        // Static method accessed using parent class name
        DadClass.showGreeting();

        // Note: could also use showGreeting() directly here,
        // but this makes it super clear where it's coming from
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        KidClass kid = new KidClass();
        kid.callParentMethod();  // trigger the method that calls the static one
    }
}
