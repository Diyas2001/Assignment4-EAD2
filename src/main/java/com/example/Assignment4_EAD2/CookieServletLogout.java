package com.example.Assignment4_EAD2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServletLogout", value = "/cookieServletLogout")
public class CookieServletLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("Cookie.jsp").include(request, response);

        Cookie[] ck = request.getCookies();
        for (Cookie c:
                ck) {
            c.setMaxAge(0);
            response.addCookie(c);
        }

        out.print("<h1>you are successfully logged out!</h1>");

    }
}
