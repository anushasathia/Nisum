class College {
    String collegeName;
    String studentName;

    private int mathMarks;
    private int scienceMarks;
    private int englishMarks;

    College(String collegeName, String studentName, int math, int science, int english) {
        this.collegeName = collegeName;
        this.studentName = studentName;
        this.mathMarks = math;
        this.scienceMarks = science;
        this.englishMarks = english;
    }

    void showInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Student: " + studentName);
        System.out.println("Total Marks: " + (mathMarks + scienceMarks + englishMarks));
    }
}

public class CollegeData {
    public static void main(String[] args) {
        College c = new College("NIT", "Rahul", 78, 85, 90);
        c.showInfo();
    }
}
