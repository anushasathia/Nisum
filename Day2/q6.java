import java.util.*;



class Employee implements Comparable<Employee> {
    private int id;
    private String Name;
    private String Department;
    private int Salary;

    public static int idtag = 1;

    public int getid(){
        return this.id;
    }
    public int getSalary(){
        return this.Salary;
    }
    public String getName(){
        return this.Name;
    }
    public String getDepartment(){
        return this.Department;
    }


    Employee(String Name,String Department,int Salary){
        this.id = idtag++;
        this.Name = Name;
        this.Department = Department;
        this.Salary = Salary;
    }


    @Override
    public int compareTo(Employee obj){
        return this.getName().compareTo(obj.getName());
    }


}


class Employeelist{
    TreeSet<Employee> list = new TreeSet<>();

    public void addEmployee(Employee e){
        list.add(e);
    }

    @Override
    public String  toString(){
        String details = "";
        for(Employee e : list){
            details  = details + "Name : " + e.getName() + " Id: " + e.getid() + " Department : " + e.getDepartment() + " Salary : " + e.getSalary() + '\n';
        }
        return details;
    }
}


public class q6 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Rohan","Accounts",1000);
        Employee e2 = new Employee("Anusha","IT",100000);
        Employee e3 = new Employee("Shreya","IT",100);


        Employeelist list = new Employeelist();
        list.addEmployee(e1);
        list.addEmployee(e2);
        list.addEmployee(e3);

        System.out.println(list);
    }
}