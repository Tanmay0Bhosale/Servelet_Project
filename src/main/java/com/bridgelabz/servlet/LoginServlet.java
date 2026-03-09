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

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(user.equals("Tanmay") && pwd.equals("Password123")){

            request.setAttribute("user", user);

            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request,response);
        }
        else{

            PrintWriter out = response.getWriter();

            out.println("<h3>Invalid username or password</h3>");

            request.getRequestDispatcher("login.html")
                    .include(request,response);
        }
    }
}