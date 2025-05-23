public class ObjectMethodsDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectMethodsDemo obj1 = new ObjectMethodsDemo();
        ObjectMethodsDemo obj2 = obj1;
        ObjectMethodsDemo obj3 = new ObjectMethodsDemo();

        // equals()
        System.out.println("obj1 equals obj2: " + obj1.equals(obj2));
        System.out.println("obj1 equals obj3: " + obj1.equals(obj3));

        // hashCode()
        System.out.println("obj1 hashCode: " + obj1.hashCode());
        System.out.println("obj3 hashCode: " + obj3.hashCode());

        // toString()
        System.out.println("obj1 toString: " + obj1.toString());

        // getClass()
        System.out.println("obj1 class: " + obj1.getClass());

        // clone() - requires implementing Cloneable interface
        ObjectMethodsDemo obj4 = (ObjectMethodsDemo) obj1.clone();
        System.out.println("obj4 cloned from obj1: " + obj4.toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
