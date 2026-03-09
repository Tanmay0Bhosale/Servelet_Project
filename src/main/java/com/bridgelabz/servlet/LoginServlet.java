package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        // UC3 Username validation
        if(!user.matches("[A-Z][a-zA-Z]{2,}")){

            out.println("<h3>Invalid Username</h3>");
            out.println("<p>Name must start with capital letter and have minimum 3 characters</p>");

            request.getRequestDispatcher("login.html")
                    .include(request,response);

            return;
        }

        // UC2 Login Check
        if(user.equals("Tanmay") && pwd.equals("Password1@")){

            request.setAttribute("user", user);

            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request,response);
        }
        else{

            out.println("<h3>Invalid username or password</h3>");

            request.getRequestDispatcher("login.html")
                    .include(request,response);
        }
    }
}