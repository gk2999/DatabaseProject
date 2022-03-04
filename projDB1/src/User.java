



public class User {
    protected String email;
    protected String password;
    protected String fName;
    protected String lName;
    protected int age;
 
    public User() {
    }
 
    public User(String email) {
        this.email = email;
    }
 
    public User(String email, String password, String fName, String lName, int age) {
        this.email = email; this.password = password; this.fName = fName; this.lName = lName; this.age = age;
    }
   
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getfName() {
        return fName;
    }
 
    public void setfName(String fName) {
        this.fName = fName;
    }
 
    public String getlName() {
        return lName;
    }
 
    public void setlName(String lName) {
        this.lName = lName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}