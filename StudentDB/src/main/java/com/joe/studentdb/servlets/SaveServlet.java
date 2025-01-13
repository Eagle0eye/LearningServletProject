package com.joe.studentdb.servlets;

import java.io.*;

import com.joe.studentdb.core.Student;
import com.joe.studentdb.core.StudentSQL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    public void init() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name =request.getParameter("name");
        String email =request.getParameter("email");
        String password =request.getParameter("password");

        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        int num = StudentSQL.save(student);

        if(num>0) {
            out.println("<h2>Saved Successfully</h2>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home.html");
            dispatcher.forward(request, response);
        }
        else
            out.println("<h2>Sorry, not saved</h2>");
    }


    public void destroy() {}
}