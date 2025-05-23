public class Student {
    String name;
    String address;
    String section;
    String studentClass;
    static String college = "ABC University";
    static int rollCounter = 1000;
    int rollNo;

    public Student(String name, String address, String section, String studentClass) {
        this.name = name;
        this.address = address;
        this.section = section;
        this.studentClass = studentClass;
        this.rollNo = rollCounter++;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Section: " + section);
        System.out.println("Class: " + studentClass);
        System.out.println("College: " + college);
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", "Delhi", "A", "10th");
        Student s2 = new Student("Anita", "Mumbai", "B", "10th");
        s1.displayInfo();
        s2.displayInfo();
    }
}
