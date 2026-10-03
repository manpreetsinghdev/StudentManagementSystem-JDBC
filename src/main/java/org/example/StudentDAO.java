package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // 1. ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO Student " +
                "(rollNo, name, course, semester, email, marks) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getSemester());
            ps.setString(5, student.getEmail());
            ps.setDouble(6, student.getMarks());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {

            System.out.println("Error adding student: " + e.getMessage());
        }
    }


    // 2. UPDATE STUDENT
    public void updateStudent(Student student) {

        String sql = "UPDATE Student SET " +
                "name = ?, course = ?, semester = ?, " +
                "email = ?, marks = ? " +
                "WHERE rollNo = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setInt(3, student.getSemester());
            ps.setString(4, student.getEmail());
            ps.setDouble(5, student.getMarks());
            ps.setInt(6, student.getRollNo());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {

            System.out.println("Error updating student: " + e.getMessage());
        }
    }


    // 3. DELETE STUDENT
    public void deleteStudent(int rollNo) {

        String sql = "DELETE FROM Student WHERE rollNo = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {

            System.out.println("Error deleting student: " + e.getMessage());
        }
    }


    // 4. SEARCH STUDENT
    public void searchStudent(int rollNo) {

        String sql = "SELECT * FROM Student WHERE rollNo = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n----- Student Details -----");

                System.out.println("Roll No  : " + rs.getInt("rollNo"));
                System.out.println("Name     : " + rs.getString("name"));
                System.out.println("Course   : " + rs.getString("course"));
                System.out.println("Semester : " + rs.getInt("semester"));
                System.out.println("Email    : " + rs.getString("email"));
                System.out.println("Marks    : " + rs.getDouble("marks"));

            } else {

                System.out.println("Student not found!");
            }

        } catch (SQLException e) {

            System.out.println("Error searching student: " + e.getMessage());
        }
    }


    // 5. DISPLAY ALL STUDENTS
    public void displayAllStudents() {

        String sql = "SELECT * FROM Student ORDER BY rollNo";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n================ STUDENTS ================");

            System.out.printf(
                    "%-8s %-15s %-15s %-10s %-25s %-10s%n",
                    "Roll", "Name", "Course",
                    "Semester", "Email", "Marks"
            );

            System.out.println(
                    "--------------------------------------------------------------------------"
            );

            while (rs.next()) {

                System.out.printf(
                        "%-8d %-15s %-15s %-10d %-25s %-10.2f%n",
                        rs.getInt("rollNo"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("semester"),
                        rs.getString("email"),
                        rs.getDouble("marks")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error displaying students: " + e.getMessage());
        }
    }
}