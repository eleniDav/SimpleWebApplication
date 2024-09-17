package webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String action = req.getParameter("action");
        
        if("Display Users".equals(action))
            req.getRequestDispatcher("/WEB-INF/DisplayUsers.jsp").forward(req, res);
        else if("Register User".equals(action))
            req.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(req, res);
        else if("Homepage".equals(action))
            req.getRequestDispatcher("index.html").forward(req, res);
    }
}
