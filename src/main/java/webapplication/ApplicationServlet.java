package webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApplicationServlet extends HttpServlet {
    
    private UserDAO userDAO;
    
    //part of servlet's lifecycle - called only once - initializing dao along with the servlet
    @Override
    public void init(){
        //these will need to be altered
        String url = "jdbc:mysql://localhost:3306/applicationDB";
        String uname = "root";
        String pass = "RooT00000";
        
        userDAO = new UserDAO(url,uname,pass);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try {
            String actions = req.getParameter("actions");
            
            switch(actions) {
                case "Register New User":
                    req.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(req, res);
                    break;
                case "Homepage":
                    req.getRequestDispatcher("index.html").forward(req, res);
                    break;
                case "Register":
                    String fname = req.getParameter("fname");
                    String lname = req.getParameter("lname");
                    String gender = req.getParameter("gender");
                    String birthdate = req.getParameter("birthdate");
                    String waddress = req.getParameter("waddress");
                    String haddress = req.getParameter("haddress");
                    
                    User newUser = new User(fname,lname,gender,birthdate,waddress,haddress);
                    userDAO.registerUser(newUser);
                    
                    //no forward or break on purpose so next case will be executed immediately after
                    
                case "Display Users":
                    List<User> userList = userDAO.displayUsers();
                    
                    req.setAttribute("userList", userList);
                    
                    req.getRequestDispatcher("/WEB-INF/DisplayUsers.jsp").forward(req, res);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
