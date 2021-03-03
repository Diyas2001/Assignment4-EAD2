package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServletProfile", value = "/cookieServletProfile")
public class CookieServletProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("Cookie.jsp").include(request, response);

        Cookie ck[] = request.getCookies();
        if(ck!=null){
            String name = ck[ck.length - 1].getValue();
            if(!name.equals("") || name!=null){
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + name);
            }
        }else{
            out.print("<h1>Please login first</h1>");
            request.getRequestDispatcher("LoginCookie.jsp").include(request, response);
        }
        out.close();

    }
}
