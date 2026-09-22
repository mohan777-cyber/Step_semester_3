package week6_assignment;

class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns (chains to the above)
    public Employee(String empId, String empName) {
        this(empId, empName, 0); // salary set to 0
        this.isIntern = true;    // mark as intern
    }

    // Print profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        // Permanent employee
        Employee permanent = new Employee("E-101", "Divya", 65000);

        // Intern
        Employee intern = new Employee("E-102", "Arjun");

        // Print profiles
        permanent.printProfile();
        intern.printProfile();
    }
}

