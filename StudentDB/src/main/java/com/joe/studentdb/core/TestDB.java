package com.joe.studentdb.core;

public class TestDB {
    public static void main(String[] args) {





        // Prints "Hello, World" in the terminal window.
        System.out.println("Test Database Utilities\n" +
                "----------------------------------\n\n");

        // Created Information
        String email= "yousef_mohamed@yahoo.com";
        String name = "joe";
        String password = "12345678";

        // updated Information
        String updated_email= "yousef_mohamed@yahoo.com";
        String updated_name = "yousef";
        String updated_password = "122122122";

        // create students
            // create instance for fill users information
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);

            // create instance for fill users information
        Student updated_student = new Student();
        updated_student.setName(updated_name);
        updated_student.setEmail(updated_email);
        updated_student.setPassword(updated_password);


        // connecting to database
        StudentSQL studentSQL = new StudentSQL();
        System.out.println(studentSQL.deleteAllStudents());

        // Test Cases:
        // 1- Save a new student
        System.out.println("Saved Student");
        System.out.println(studentSQL.save(student));


        // 2- updated student
        System.out.println("updated Student");
        System.out.println(studentSQL.update(1,updated_student));





        // 3- getByID
        System.out.println("getNyID");
        System.out.println(studentSQL.getById(1));


        // get list
        System.out.println("get all students");
        System.out.println(studentSQL.save(student));
        System.out.println(studentSQL.getStudents());


        // 5- delete student
        System.out.println("Deleted Student");
        System.out.println(studentSQL.delete(16));
        System.out.println(studentSQL.getStudents());



    }

}
