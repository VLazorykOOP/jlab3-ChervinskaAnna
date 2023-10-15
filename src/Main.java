import java.util.Scanner;

class Employee {
    String name;
    int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Метод для виведення даних про об'єкт класу
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

// Підклас для кадрів
class Staff extends Employee {
    String department;

    public Staff(String name, int employeeId, String department) {
        super(name, employeeId);
        this.department = department;
    }

    // Перевизначений метод show для виведення додаткових даних
    @Override
    public void show() {
        super.show();
        System.out.println("Department: " + department);
    }
}

// Підклас для інженерів
class Engineer extends Employee {
    String project;

    public Engineer(String name, int employeeId, String project) {
        super(name, employeeId);
        this.project = project;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Project: " + project);
    }
}

// Підклас для адміністрації
class Administration extends Employee {
    String role;

    public Administration(String name, int employeeId, String role) {
        super(name, employeeId);
        this.role = role;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Role: " + role);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lab 3");
        // Введення інформації про об'єкти
        Staff staff = new Staff("Anna", 101, "Tester");
        Engineer engineer = new Engineer("Mary", 201, "Development");
        Administration admin = new Administration("Alex", 301, "Manager");

        // Створення масиву типу суперкласу
        Employee[] employees = { staff, engineer, admin };

        // Друк введеного масиву
        for (Employee employee : employees) {
            employee.show();
            System.out.println(); // Додатковий рядок для розділення виводу
        }
    }
}