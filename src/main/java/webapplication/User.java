package webapplication;

public class User {
    protected int id;
    protected String fname;
    protected String lname;
    protected String gender;
    protected String birthdate;
    protected String waddress;
    protected String haddress;

    public User(String fname, String lname, String gender, String birthdate, String waddress, String haddress){
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.waddress = waddress;
        this.haddress = haddress;
    }
    
    public User(int id, String fname, String lname){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }
    
    public User(int id){
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }
}
