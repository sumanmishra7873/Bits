import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentManagmentSystem {
    private String name;
    private int rollNumber;
    private String grade;

    public StudentManagmentSystem(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}

public class StudentManagementSystem {
    private List<StudentManagmentSystem> students;

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(StudentManagmentSystem student) {
        students.add(student);
    }

    // Method to remove a student
    public void removeStudent(StudentManagmentSystem student) {
        students.remove(student);
    }

    // Method to search for a student by roll number
    public StudentManagmentSystem searchStudent(int rollNumber) {
        for (StudentManagmentSystem student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        for (StudentManagmentSystem student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: "
                    + student.getGrade());
        }
    }

}

class StudentManagementSystemUI {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        StudentManagmentSystem student = new StudentManagmentSystem(name, rollNumber, grade);
        system.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        StudentManagmentSystem student = system.searchStudent(rollNumber);
        if (student != null) {
            system.removeStudent(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        StudentManagmentSystem student = system.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: "
                    + student.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        system.displayAllStudents();
    }
}