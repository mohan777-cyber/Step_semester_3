package week6_assignment;

class Employee {
    private String empName;
    private double salary;

    // Static fields shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // increment count every time a new employee is created
    }

    // Static method to print company info
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInfoManagement {
    public static void main(String[] args) {
        // Create three Employee objects
        Employee e1 = new Employee("Divya", 65000);
        Employee e2 = new Employee("Arjun", 50000);
        Employee e3 = new Employee("Kiran", 45000);

        // Call static method through class name
        Employee.printCompanyInfo();
    }
}

