package webapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String url;
    private String uname;
    private String pass;
    
    private Connection con;
    
    //contstructor that will bring the connection info from servlet to dao 
    public UserDAO(String url, String uname, String pass){
        this.url = url;
        this.uname = uname;
        this.pass = pass;
    }
    
    //to create the connection to our db
    protected void connect() throws SQLException{
        if(con == null || con.isClosed())
            con = DriverManager.getConnection(url, uname, pass);
    }
    
    //to close that connection when we're done
    protected void disconnect() throws SQLException{
        if(con != null || !con.isClosed())
            con.close();
    }
    
    //registering users to db (for RegisterUser.jsp)
    public void registerUser(User user) throws SQLException{
        String sql1 = "insert into userInfo (FirstName,LastName,Gender,Birthdate) values(?,?,?,?)";
        String sql2 = "insert into address (WorkAddress,HomeAddress) values (?,?)";
        
        connect();
        
        PreparedStatement st1 = con.prepareStatement(sql1);
        st1.setString(1, user.getFname());
        st1.setString(2, user.getLname());
        st1.setString(3, user.getGender());
        st1.setString(4, user.getBirthdate());
        
        st1.executeUpdate();
        
        PreparedStatement st2 = con.prepareStatement(sql2);
        st2.setString(1, user.getWaddress());
        st2.setString(2, user.getHaddress());
                    
        st2.executeUpdate();
        
        st1.close();
        st2.close();
        disconnect();
    }
    
    //displaying all names and last names (for DisplayUsers.jsp)
    public List<User> displayUsers() throws SQLException{
        List<User> users = new ArrayList<>();
        
        String sql = "select FirstName,LastName from userInfo";
        
        connect();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String fname = rs.getString("FirstName");
            String lname = rs.getString("LastName");
            
            User user = new User(fname,lname);
            users.add(user);
        }
        
        rs.close();
        st.close();
        disconnect();
        
        return users;
    }
}
