package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServletURLRewriting", value = "/secondURLRewriting")
public class SecondServletURLRewriting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            //getting value from the query string
            String n = request.getParameter("uname");
            request.getRequestDispatcher("Header.jsp").include(request, response);
            out.print("<h1>Hello: " + n + "</h1>");
            request.getRequestDispatcher("Footer.jsp").include(request, response);
            out.close();

        }catch(Exception e){System.out.println(e);}
    }
}
