

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/UserDAO")
public class UserDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public UserDAO() {

    }
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    
    public void deleteTables() throws SQLException, IOException, ServletException {
    	
    	connect_func();
    	try {
    		String sql1 = "DROP TABLE IF EXISTS User";
    		String sql2 = "DROP TABLE IF EXISTS Transfer";
    		String sql3 = "DROP TABLE IF EXISTS Tip";
    		
    		String sql4 = "DROP TABLE IF EXISTS Follows";
    		String sql5 = "DROP TABLE IF EXISTS Post";
    		
    		String sql6 = "DROP TABLE IF EXISTS Liked";
    		String sql7 = "DROP TABLE IF EXISTS Comment";

    		// Statements allow to issue SQL queries to the database
    		statement = connect.createStatement();

    		
    		statement.executeUpdate(sql2);
    		statement.executeUpdate(sql3);
    		statement.executeUpdate(sql4);
    		
    		statement.executeUpdate(sql6);
    		statement.executeUpdate(sql7);
    		
    		statement.executeUpdate(sql5);
    		
    		
    		
    		statement.executeUpdate(sql1);
    		
    		
    	}
    	catch (Exception e) {
            System.out.println(e);
       }
    	
    }
    
public void insertTables() throws SQLException, IOException, ServletException {
    	
    	connect_func();
    	try {
String sql1 = "CREATE TABLE User " +
                    
    			   " (Email VARCHAR(30), " +
    			   " Password VARCHAR(40),"+
                   " firstName VARCHAR(20), " + 
                   " lastName VARCHAR(30), " +
                   " Age INTEGER,"+
                   " PRIMARY KEY ( Email ))";
String sql2 = "CREATE TABLE Transfer " +
                    
    			   " (Email VARCHAR(30), " +
    			   " timeOfTrans DATETIME,"+
                   " buyORSell CHAR(1), " + 
                   " PPSPrice DOUBLE, " +
                   " amount DOUBLE,"+
                   " transferID VARCHAR(20),"+
                   " PRIMARY KEY ( transferID ),"+
                   " FOREIGN KEY ( email ) REFERENCES User(Email))";

String sql3 = "CREATE TABLE Tip " +
        
    			   " (Email VARCHAR(30), " +
    			   " timeOfTrans DATETIME,"+
                   " amount DOUBLE,"+
                   " tipID VARCHAR(20),"+
                   " PRIMARY KEY ( tipID ),"+
                   " FOREIGN KEY ( email ) REFERENCES User(Email))";

String sql4 = "CREATE TABLE Follows " +
        
    			   " (Email VARCHAR(30), " +
                   " PRIMARY KEY ( Email ),"+
                   " FOREIGN KEY ( email ) REFERENCES User(Email))";
String sql5 = "CREATE TABLE Post " +
        
    			   " (Email VARCHAR(30), " +
    			   " type CHAR(1),"+
                   " numOfLikes INT, " + 
                   " content VARCHAR(350), " +
                   " postID VARCHAR(20),"+
                   " PRIMARY KEY ( postID ),"+
                   " FOREIGN KEY ( email ) REFERENCES User(Email))";

String sql6 = "CREATE TABLE Liked " +
        
    			   " (Email VARCHAR(30), " +
    			   " postID VARCHAR(20),"+
                   " FOREIGN KEY ( email ) REFERENCES User(Email),"+
                   " FOREIGN KEY ( postID ) REFERENCES Post(postID))";
String sql7 = "CREATE TABLE Comment " +
        
    			   " (Email VARCHAR(30), " +
    			   " postID VARCHAR(20),"+
                   " content VARCHAR(350), " + 
                   " FOREIGN KEY ( email ) REFERENCES User(Email),"+
                   " FOREIGN KEY ( postID ) REFERENCES Post(postID))";
  			

    		// Statements allow to issue SQL queries to the database
    		statement = connect.createStatement();

    		statement.executeUpdate(sql1);
    		statement.executeUpdate(sql2);
    		statement.executeUpdate(sql3);
    		statement.executeUpdate(sql4);
    		statement.executeUpdate(sql5);
    		statement.executeUpdate(sql6);
    		statement.executeUpdate(sql7);
    		
    		
    	}
    	catch (Exception e) {
            System.out.println(e);
       }
    	
    }
    
    
    public List<User> listAllUser() throws SQLException {
        List<User> listUser = new ArrayList<User>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String fN = resultSet.getString("firstName");
            String lN = resultSet.getString("lastName");
  
             
            User User = new User(email, password, fN, lN, age);
            listUser.add(User);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    public boolean checkDuplicate(User User) throws SQLException {
    	
    	//List<User> listUser = new ArrayList<User>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        System.out.println(User.email);
        while (resultSet.next()) {
        	String email = resultSet.getString("email");
        	if((User.email).equals(email)) {
        		return true;
        		
        	}
        }
        resultSet.close();
        statement.close();         
        return false;
        
    	
    }
         
    public int insert(User User) throws SQLException {
    	connect_func(); 
    	
    	System.out.println("************testZ****************");
    	if(checkDuplicate(User))
    		return -1;
    	
    	
		String sql = "insert into  User(email, password, firstName, lastName, age) values (?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, User.email);
		preparedStatement.setString(2, User.password);
		preparedStatement.setString(3, User.fName);
		preparedStatement.setString(4, User.lName);
		preparedStatement.setInt(5, User.age);
//		preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return 1;
    }     
     
   
	
    public User getUser(int id) throws SQLException {
    	User User = null;
        String sql = "SELECT * FROM student WHERE id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String fN = resultSet.getString("firstName");
            String lN = resultSet.getString("lastName");
             
            User = new User(email, password, fN, lN, age);
            //test
        }
         
        resultSet.close();
        statement.close();
         
        return User;
    }
}
