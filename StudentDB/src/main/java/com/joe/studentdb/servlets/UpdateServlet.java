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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    public void init() {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email  = request.getParameter("email");
        String password = request.getParameter("password");

        Student updatedStudent = new Student();

        updatedStudent.setId(id);
        updatedStudent.setName(name);
        updatedStudent.setEmail(email);
        updatedStudent.setPassword(password);

        if(StudentSQL.update(id,updatedStudent)>0)
            response.sendRedirect("view");
        else
            printWriter.println("<h2> Sorry not Saved</h2>");
    }
        public void destroy() {
    }
}