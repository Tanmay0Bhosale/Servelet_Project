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

        // UC3 Username Validation
        if(!user.matches("[A-Z][a-zA-Z]{2,}")){

            out.println("<h3>Invalid Username</h3>");
            out.println("<p>Name must start with capital letter and contain minimum 3 characters</p>");

            request.getRequestDispatcher("login.html")
                    .include(request,response);

            return;
        }

        // UC4 Password Validation
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

        if(!pwd.matches(passwordPattern)){

            out.println("<h3>Invalid Password</h3>");
            out.println("<p>Password must contain:</p>");
            out.println("<ul>");
            out.println("<li>Minimum 8 characters</li>");
            out.println("<li>At least one uppercase letter</li>");
            out.println("<li>At least one number</li>");
            out.println("<li>One special character</li>");
            out.println("</ul>");

            request.getRequestDispatcher("login.html")
                    .include(request,response);

            return;
        }

        // Login Check
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