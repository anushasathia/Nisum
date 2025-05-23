class Nisum {
    String companyName = "Nisum Technologies";
    String location = "Hyderabad";
}

class Employee extends Nisum {
    void showDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Location: " + location);
    }
}

public class CompanyInfo {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showDetails();
    }
}
