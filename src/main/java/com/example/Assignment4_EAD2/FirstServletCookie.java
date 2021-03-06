package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServletCookie",value = "/firstCookie")
public class FirstServletCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            request.getRequestDispatcher("Header.jsp").include(request, response);
            out.print("<h1>Welcome " + n + "</h1>");

            Cookie ck = new Cookie("userName", n);//creating cookie object
            response.addCookie(ck);//adding cookie in the response

            //creating submit button
            out.print("<form action='servlet-cookie2' method='get'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");
            request.getRequestDispatcher("Footer.jsp").include(request, response);

            out.close();

        }catch(Exception e){System.out.println(e);}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
