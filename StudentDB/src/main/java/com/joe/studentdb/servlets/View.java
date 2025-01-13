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
import java.util.List;

@WebServlet("/view")
public class View extends HttpServlet {
    public void init() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Student Information</h2>");

        List<Student> students = StudentSQL.getStudents();
        StringBuilder tableRows = new StringBuilder();
        for (Student student : students) {
            tableRows.append("<tr>")
                    .append("<td>").append(student.getId()).append("</td>")
                    .append("<td>").append(student.getName()).append("</td>")
                    .append("<td>").append(student.getEmail()).append("</td>")
                    .append("<td>").append(student.getPassword()).append("</td>")
                    .append("<td>")
                    .append("<form style='display:inline;' method='GET' action='UpdateFormServlet'>")
                    .append("<input type='hidden' name='id' value='").append(student.getId()).append("'>")
                    .append("<button type='submit'>Update</button>")
                    .append("</form>")
                    .append("<form style='display:inline;' method='GET' action='DeleteServlet'>")
                    .append("<input type='hidden' name='id' value='").append(student.getId()).append("'>")
                    .append("<button type='submit'>Delete</button>")
                    .append("</form>")
                    .append("</td>")
                    .append("</tr>");
        }
        String html = "<!DOCTYPE html>"
                + "<html lang='en'>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>Manage Students</title>"
                + "<style>"
                + "table { width: 80%; border-collapse: collapse; margin: 20px auto; }"
                + "table, th, td { border: 1px solid black; }"
                + "th, td { padding: 10px; text-align: left; }"
                + ".actions button { margin-right: 5px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h2 style='text-align:center;'>Student Management</h2>"
                + "<table>"
                + "<thead>"
                + "<tr>"
                + "<th>ID</th>"
                + "<th>Name</th>"
                + "<th>Email</th>"
                + "<th>Password</th>"
                + "<th>Actions</th>"
                + "</tr>"
                + "</thead>"
                + tableRows
                + "</table>"
                + "</body>"
                + "</html>";
        printWriter.println(html);
    }
    public void destroy() {}

}
