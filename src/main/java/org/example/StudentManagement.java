package org.example;

import java.util.Scanner;

public class StudentManagement {

    static Scanner sc = new Scanner(System.in);

    static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    dao.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // ADD STUDENT
    static void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Roll No: ");
        int rollNo = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Course: ");
        String course = sc.nextLine();

        System.out.print("Semester: ");
        int semester = sc.nextInt();

        sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(
                rollNo,
                name,
                course,
                semester,
                email,
                marks
        );

        dao.addStudent(student);
    }


    // UPDATE STUDENT
    static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        System.out.print("Roll No: ");
        int rollNo = sc.nextInt();

        sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Course: ");
        String course = sc.nextLine();

        System.out.print("New Semester: ");
        int semester = sc.nextInt();

        sc.nextLine();

        System.out.print("New Email: ");
        String email = sc.nextLine();

        System.out.print("New Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(
                rollNo,
                name,
                course,
                semester,
                email,
                marks
        );

        dao.updateStudent(student);
    }


    // DELETE STUDENT
    static void deleteStudent() {

        System.out.print("\nEnter Roll No: ");

        int rollNo = sc.nextInt();

        dao.deleteStudent(rollNo);
    }


    // SEARCH STUDENT
    static void searchStudent() {

        System.out.print("\nEnter Roll No: ");

        int rollNo = sc.nextInt();

        dao.searchStudent(rollNo);
    }
}