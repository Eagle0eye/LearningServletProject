package com.joe.studentdb.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentSQL {


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct driver class
            String url = "jdbc:mysql://127.0.0.1:3306/servletdb";
            connection = DriverManager.getConnection(url, "yousef", "112233112233");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int save(Student student) {
        int st = 0;
        String sql = StatementSQL.INSERT.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPassword());
            st = preparedStatement.executeUpdate();
            System.out.println("Student has been saved! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return st;
    }

    public static int update(int id, Student student) {
        int st = 0;
        String sql = StatementSQL.UPDATE.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setInt(4, id);
            st = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static int delete(int id) {
        int st = 0;
        String sql = StatementSQL.DELETE.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            st = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static Student getById(int id) {
        Student student = null;
        String sql = StatementSQL.GETBYID.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public static int deleteAllStudents() {
        int st = 0;
        String sql = StatementSQL.DELETEALL.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            st = preparedStatement.executeUpdate();
            System.out.println("All students have been deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = StatementSQL.GETALL.toString();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setPassword(resultSet.getString("password"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
