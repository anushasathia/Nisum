public class java1 {

    public static void main(String[] args) {
        SampleClass obj = new SampleClass();

        Class objClass = obj.getClass();

        System.out.println("Class Name: " + objClass.getName());
        System.out.println("Simple Name: " + objClass.getSimpleName());
        System.out.println("Package: " + objClass.getPackage().getName());
        System.out.println("Superclass: " + objClass.getSuperclass().getName());

        Class [] interfaces = objClass.getInterfaces();
        System.out.println("Implemented Interfaces:");
        for (Class i : interfaces) {
            System.out.println(" - " + i.getName());
        }
    }
}

class SampleClass implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}