package jp.tuyano;

import java.io.IOException;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class Shoppeple extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String pas = "abc";
        String pas2 = req.getParameter("pass");
        if(pas2.equals(pas)) resp.sendRedirect("/shopselect.html");
        else resp.sendRedirect("/shoperror.html");
    }
}