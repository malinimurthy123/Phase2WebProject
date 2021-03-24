package com.example.LoginTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		Get a reference to the Session
        HttpSession session = request.getSession();

//		Check whether user is already logged in
        if(session.getAttribute("userName") != null) {
//			Reditrect to the dashboard
            response.sendRedirect("index.jsp");
        }
        else {

//		Get the userName from the request
            String userName = request.getParameter("userName");

            session.setAttribute("userName", userName);

//		Redirect to the Dashboard
            response.sendRedirect("index.jsp");
        }
    }

}