package com.joe.studentdb.servlets;


import com.joe.studentdb.core.StudentSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
 public void init(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));

        if(StudentSQL.delete(id)>0)
            response.sendRedirect("view");
        else
            printWriter.println("<h2> Sorry not Found</h2>");
    }

    public void destroy(){}
}
