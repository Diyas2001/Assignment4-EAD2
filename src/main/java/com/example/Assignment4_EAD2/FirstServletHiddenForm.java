package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServletHiddenForm", value = "/firstHiddenForm")
public class FirstServletHiddenForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            request.getRequestDispatcher("Header.jsp").include(request, response);
            out.print("<h1>Welcome " + n + "</h1>");

            //creating form that have invisible text field
            out.print("<form action='servlet-hidden-form2' method='get'>");
            out.print("<input type='hidden' name='uname' value='" + n + "'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");
            request.getRequestDispatcher("Footer.jsp").include(request, response);
            out.close();

        }catch(Exception e){System.out.println(e);}
    }
}
