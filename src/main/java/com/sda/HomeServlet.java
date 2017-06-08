package com.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RENT on 2017-06-08.
 */
//1.Tworzymy klase
//2. Ma rozszerzac HttpServlet
//3. Override doGet -> piszemy cialo metody
//4. Skonfigurowac servlet -> main/webapp/WEB-INF/web.xml
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*******Hello World*******");
        PrintWriter writer = resp.getWriter();// System.out
        resp.setContentType("text/html");
        writer.println("<h1>Hello World</h1>");
    }
}
