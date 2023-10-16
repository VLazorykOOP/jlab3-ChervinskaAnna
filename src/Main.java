import java.util.Scanner;

class Employee {
    String name;
    int employee;

    public Employee(String name, int employee) {
        this.name = name;
        this.employee = employee;
    }

    // Метод для виведення даних про об'єкт класу
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Employee: " + employee);
    }
}

// Підклас для кадрів
class Staff extends Employee {
    String department;

    public Staff(String name, int employee, String department) {
        super(name, employee);
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

    public Engineer(String name, int employee, String project) {
        super(name, employee);
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

    public Administration(String name, int employee, String role) {
        super(name, employee);
        this.role = role;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Role: " + role);
    }
}

interface Currency {
    double convertToUah();

    void display();
}

// Похідний клас Dollar
class Dollar implements Currency {
    // Поле для хранения суммы
    private double amount;

    // Конструктор
    public Dollar(double amount) {
        this.amount = amount;
    }

    // Реалізація методу для переводу суми в гривні для долара
    @Override
    public double convertToUah() {
        // переведення долара в гривні
        return amount * exchangeRateToUah;
    }

    // Реалізація методу для виводу на екран для долара
    @Override
    public void display() {
        System.out.println("Dollar amount: " + amount);
    }

    // Константа для обмінного курсу
    private static final double exchangeRateToUah = 36.38;
}

// Похідний клас Euro
class Euro implements Currency {
    // Поле для хранения суммы
    private double amount;

    // Конструктор
    public Euro(double amount) {
        this.amount = amount;
    }

    // Реалізація методу для переводу суми в гривні для євро
    @Override
    public double convertToUah() {
        // переведення євро в гривні
        return amount * exchangeRateToUah;
    }

    // Реалізація методу для виводу на екран для євро
    @Override
    public void display() {
        System.out.println("Euro amount: " + amount);
    }

    // Константа для обмінного курсу
    private static final double exchangeRateToUah = 38.25;
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Java Lab 3 ");
        System.out.println("Select the task you would like to see (1-3)");
        int choice = s.nextInt();
        if (s != null) {
            // s.close();
            switch (choice) {
                case 1: {
                    First();
                    break;
                }

                case 2: {
                    Second();
                    break;
                }

                default: {
                    System.out.print("There is no number with this task number");
                    break;
                }
            }
        }
        s.close();
    }

    public static void First() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lab 3");
        // Введення інформації про об'єкти
        Staff staff = new Staff("Anna", 121, "Game testing");
        Engineer engineer = new Engineer("Mary", 243, "Software Development");
        Administration admin = new Administration("Alex", 327, "Manager");

        // Створення масиву типу суперкласу
        Employee[] employees = { staff, engineer, admin };

        // Друк введеного масиву
        for (Employee employee : employees) {
            employee.show();
            System.out.println(); // Додатковий рядок для розділення виводу
        }
    }

    public static void Second() {
        // Створення об'єктів
        Dollar dollar = new Dollar(100);
        Euro euro = new Euro(50);

        // Виведення на екран
        dollar.display();
        System.out.println("Converted to UAH: " + dollar.convertToUah());

        euro.display();
        System.out.println("Converted to UAH: " + euro.convertToUah());

        // Перевірка методів toString та equals
        System.out.println(dollar.toString());
        System.out.println(dollar.equals(new Dollar(100)));

        System.out.println(euro.toString());
        System.out.println(euro.equals(new Euro(50)));
    }

}