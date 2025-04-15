import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String studentId;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    public Student(String studentId, String name, int age, String gender, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Display details
    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
    }
}

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        System.out.println("------------------------------------");

        login();

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    updateStudentDetails();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    retrieveStudentDetails();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        System.out.println("Exiting Student Management System");
    }

    private static void login() {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter username(admin): ");
            String username = scanner.nextLine();

            System.out.print("Enter password(admin123): ");
            String password = scanner.nextLine();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a new student");
        System.out.println("2. Update student details");
        System.out.println("3. Remove a student");
        System.out.println("4. Retrieve student details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addNewStudent() {
        System.out.println("\nEnter student details:");
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            if (age >= 18 && age <= 50) break;
            System.out.println("Invalid age. Age must be between 18 and 50.");
        }

        String gender;
        while (true) {
            System.out.print("Gender (Male/Female): ");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) break;
            System.out.println("Invalid gender. Please enter 'Male' or 'Female'.");
        }

        String phoneNumber;
        while (true) {
            System.out.print("Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) break;
            System.out.println("Invalid phone number. It must be exactly 10 digits.");
        }

        students.add(new Student(studentId, name, age, gender, phoneNumber));
        System.out.println("Student added successfully.");
    }

    private static void updateStudentDetails() {
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.print("New Name: ");
                student.setName(scanner.nextLine());

                int age;
                while (true) {
                    System.out.print("New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    if (age >= 18 && age <= 50) break;
                    System.out.println("Invalid age. Age must be between 18 and 50.");
                }
                student.setAge(age);

                System.out.print("New Phone Number: ");
                student.setPhoneNumber(scanner.nextLine());

                System.out.println("Student details updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String studentId = scanner.nextLine();
        students.removeIf(student -> student.getStudentId().equals(studentId));
        System.out.println("Student removed successfully.");
    }

    private static void retrieveStudentDetails() {
        System.out.print("Enter Student ID to retrieve: ");
        String studentId = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.displayDetails();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
