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
        
        String sql = "select UserID,FirstName,LastName from userInfo";
        
        connect();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            int id = rs.getInt("UserID");
            String fname = rs.getString("FirstName");
            String lname = rs.getString("LastName");
            
            User user = new User(id,fname,lname);
            users.add(user);
        }
        
        rs.close();
        st.close();
        disconnect();
        
        return users;
    }
    
    //displaying all user info (for button More Info)
    public User displayUserInfo(User user) throws SQLException{
        User tmp = null;
        int id = user.getId();
        
        String sql = "select * from userInfo left join address on userInfo.UserID=address.ID where userInfo.UserID=?";
        
        connect();
        
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            String fname = rs.getString("FirstName");
            String lname = rs.getString("LastName");
            String gender = rs.getString("Gender");
            String birthdate = rs.getString("Birthdate");
            String waddress = rs.getString("WorkAddress");
            String haddress = rs.getString("HomeAddress");
            
            tmp = new User(fname,lname,gender,birthdate,waddress,haddress);
        }
        
        rs.close();
        st.close();
        disconnect();
        return tmp;
    }
    
    //deleting a user (for button Delete)
    public void deleteUser(User user) throws SQLException{
        int id = user.getId();
        
        String sql1 = "delete from userInfo where UserID=?";
        String sql2 = "delete from address where ID=?";
        
        connect();
        
        PreparedStatement st1 = con.prepareStatement(sql1);
        st1.setInt(1, id);
        st1.executeUpdate();
        
        PreparedStatement st2 = con.prepareStatement(sql2);
        st2.setInt(1, id);
        st2.executeUpdate();
        
        st1.close();
        st2.close();
        disconnect();
    }
}
