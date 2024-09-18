package webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String actions = req.getParameter("actions");
        
        if("Display Users".equals(actions))
            req.getRequestDispatcher("/WEB-INF/DisplayUsers.jsp").forward(req, res);
        else if("Register New User".equals(actions))
            req.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(req, res);
        else if("Homepage".equals(actions))
            req.getRequestDispatcher("index.html").forward(req, res);
        else if("Register".equals(actions))
            System.out.println("k");
    }
}
