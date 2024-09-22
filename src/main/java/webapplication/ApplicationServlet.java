package webapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try {
            String actions = req.getParameter("actions");
            
            //these will need to be altered 
            String url = "jdbc:mysql://localhost:3306/applicationDB";
            String uname = "root";
            String pass = "RooT00000";
            Connection con = DriverManager.getConnection(url, uname, pass);
            
            if("Display Users".equals(actions)){
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select FirstName, LastName from userInfo order by FirstName, LastName");
                
                while(rs.next()){
                    String fname = rs.getString(1);
                    String lname = rs.getString(2);
                    
                    
                }
                
                req.getRequestDispatcher("/WEB-INF/DisplayUsers.jsp").forward(req, res);                
            }
            else if("Register New User".equals(actions))                
                req.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(req, res);
            else if("Homepage".equals(actions))
                req.getRequestDispatcher("index.html").forward(req, res);
            else if("Register".equals(actions)){
                    UUID uuid = UUID.randomUUID();
                    String uuidS = uuid.toString();
                    
                    String fname = req.getParameter("fname");
                    String lname = req.getParameter("lname");
                    String gender = req.getParameter("gender");
                    String birthdate = req.getParameter("birthdate");
                    String waddress = req.getParameter("waddress");
                    String haddress = req.getParameter("haddress");
                    
                    PreparedStatement st1 = con.prepareStatement("insert into userInfo values(?,?,?,?,?)");
                    st1.setString(1, uuidS);
                    st1.setString(2, fname);
                    st1.setString(3, lname);
                    st1.setString(4, gender);
                    st1.setString(5, birthdate);
                    
                    st1.executeUpdate();
                    
                    PreparedStatement st2 = con.prepareStatement("insert into address values(?,?,?)");
                    st2.setString(1, uuidS);
                    st2.setString(2, waddress);
                    st2.setString(3, haddress);
                    
                    st2.executeUpdate();
                    
                    st1.close();
                    st2.close();
                    con.close();
                    
                    //some type of confirmation should be added here
                    req.getRequestDispatcher("/WEB-INF/DisplayUsers.jsp").forward(req, res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
