public class java2 {

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        System.out.println("Demonstrating getClass()");
        Class<?> cls = obj1.getClass();
        System.out.println("Class of obj1: " + cls.getName());

        System.out.println(" Demonstrating toString()");
        System.out.println("obj1.toString(): " + obj1.toString());
        System.out.println("obj2.toString(): " + obj2.toString());

        System.out.println("Demonstrating hashCode()");
        System.out.println("obj1.hashCode(): " + obj1.hashCode());
        System.out.println("obj2.hashCode(): " + obj2.hashCode());

        System.out.println("Demonstrating equals()");
        System.out.println("obj1.equals(obj1): " + obj1.equals(obj1));
        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));

        MyClass obj3 = obj1;
        System.out.println("obj1.equals(obj3): " + obj1.equals(obj3));
    }
}

class MyClass {

}