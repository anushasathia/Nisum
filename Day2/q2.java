import java.util.ArrayList;
import java.util.Scanner;

class StudentGrades {
    protected char maths;
    protected char science;
    protected char sst;
    protected char cs;

    StudentGrades(char maths, char science, char sst, char cs) {
        this.maths = maths;
        this.science = science;
        this.sst = sst;
        this.cs = cs;
    }
}

class Student {
    private static int idtag = 1; // moved here

    protected String name;
    protected int id;
    protected StudentGrades Grades;

    Student(String name) {
        this.name = name;
        this.id = idtag++;
    }

    public void addGrades(char maths, char science, char sst, char cs) {
        StudentGrades temp = new StudentGrades(maths, science, sst, cs);
        Grades = temp;
    }
}

class StudentList {
    ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student s1) {
        list.add(s1);
    }

    public void DisplayAllStudents() {
        for (Student x : list) {
            System.out.println("ID: " + x.id + ", Name: " + x.name);
        }
    }

    public void SearchStudent(int id) {
        for (Student x : list) {
            if (x.id == id) {
                System.out.println("Found Student - ID: " + x.id + ", Name: " + x.name);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void DeleteStudent(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                System.out.println("Student with ID " + id + " removed.");
                break;
            }
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Anusha");
        s1.addGrades('A', 'B', 'C', 'D');
        Student s2 = new Student("Rohan");
        s2.addGrades('A', 'A', 'A', 'A');
        Student s3 = new Student("Roshmi");
        s3.addGrades('B', 'B', 'C', 'A');
        Student s4 = new Student("Neha");
        s4.addGrades('C', 'B', 'B', 'D');

        StudentList students = new StudentList();
        students.addStudent(s1);
        students.addStudent(s2);
        students.addStudent(s3);
        students.addStudent(s4);

        students.DisplayAllStudents();

        System.out.println("Search by id :- ");
        int tempid = sc.nextInt();
        students.SearchStudent(tempid);

        System.out.println("Remove by id :- ");
        tempid = sc.nextInt();
        students.DeleteStudent(tempid);

        students.DisplayAllStudents();

        sc.close();
    }
}