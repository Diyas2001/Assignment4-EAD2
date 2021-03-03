package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServletProfile", value = "/sessionServletProfile")
public class SessionServletProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("Session.jsp").include(request, response);

        HttpSession session=request.getSession(false);
        if(session!=null){
            String name=(String)session.getAttribute("name");

            out.print("<h1>Hello, "+name+" Welcome to Profile</h1>");
        }
        else{
            out.print("<h1>Please login first</h1>");
            request.getRequestDispatcher("LoginSession.jsp").include(request, response);
        }
        out.close();
    }
}
