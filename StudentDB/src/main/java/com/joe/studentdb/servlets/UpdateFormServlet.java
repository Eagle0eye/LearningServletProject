package com.joe.studentdb.servlets;

import com.joe.studentdb.core.Student;
import com.joe.studentdb.core.StudentSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateFormServlet")
public class UpdateFormServlet extends HttpServlet {
    public void init() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1> Update Student Information</h2>");

        int id = Integer.parseInt(request.getParameter("id"));

        Student student = StudentSQL.getById(id);
        String htmlForm = "<!DOCTYPE html>"
                + "<html lang='en'>"
                + "<head>"
                + "    <meta charset='UTF-8'>"
                + "    <title>Update Student</title>"
                + "    <style>"
                + "        body { font-family: Arial, sans-serif; margin: 20px; }"
                + "        form { width: 300px; }"
                + "        label { display: block; margin-top: 10px; }"
                + "        input[type='text'], input[type='email'], input[type='password'] {"
                + "            width: 100%; padding: 8px; margin-top: 5px; }"
                + "        input[type='submit'] {"
                + "            margin-top: 15px; padding: 8px 16px; }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <h2>Update Student Details</h2>"
                + "    <form method='post' action='updatedStudent'>"
                + "        <label for='id'>Student ID</label>"
                + "        <input type='text' id='id' name='id' disable=true value='" + student.getId() + "' readonly>"
                + "        <label for='name'>Name</label>"
                + "        <input type='text' id='name' name='name' value='" + student.getName() + "' required>"
                + "        <label for='email'>Email</label>"
                + "        <input type='email' id='email' name='email' value='" + student.getEmail() + "' required>"
                + "        <label for='password'>Password</label>"
                + "        <input type='password' id='password' name='password' value='" + student.getPassword() + "' required>"
                + "        <input type='submit' value='Update'>"
                + "    </form>"
                + "</body>"
                + "</html>";
        printWriter.write(htmlForm);
    }
        public void destroy() {}
}