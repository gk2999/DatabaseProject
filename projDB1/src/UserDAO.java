

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
                   " USDAmount DOUBLE,"+
                   " PPSAmount DOUBLE,"+
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
        
    			   " (SenderEmail VARCHAR(30), " +
    			   " ReceiverEmail VARCHAR(30), " +
    			   " timeOfTrans DATETIME,"+
                   " amount DOUBLE,"+
                   " tipID VARCHAR(20),"+
                   " PRIMARY KEY ( tipID ),"+
                   " FOREIGN KEY ( SenderEmail ) REFERENCES User(Email),"+
				   " FOREIGN KEY ( ReceiverEmail ) REFERENCES User(Email))";

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
public void insertTuples() throws SQLException, IOException, ServletException {
	
	connect_func();
	try {
		String userInsert = "insert into User(Email, Password, firstName, lastName, Age, USDAmount, PPSAmount) values "; 
		
		String us1 = userInsert +"(\"pf@gmail.com\", \"pass1000684\", \"Parker\",\"Collymore\",\"21\",\"1000\",\"0\")";
		String us2 = userInsert +"(\"ab34@gmail.com\", \"pass88\", \"Abby\",\"Stoll\",\"31\",\"1000\",\"0\")";
		String us3 = userInsert +"(\"yu33@outlook.com\", \"pass2212\", \"Jen\",\"Adler\",\"19\",\"1000\",\"0\")";
		String us4 = userInsert +"(\"jen_t@gmail.com\", \"pass10001000\", \"Kathy\",\"Ford\",\"23\",\"1000\",\"0\")";
		String us5 = userInsert +"(\"hy88@yahoo.com\", \"pass100062\", \"Ted\",\"Pierce\",\"88\",\"1000\",\"0\")";
		String us6 = userInsert +"(\"emp555@wayne.edu\", \"pass55\", \"Andy\",\"Gray\",\"18\",\"1000\",\"0\")";
		String us7 = userInsert +"(\"gary88@gmail.com\", \"pass988\", \"Gary\",\"Hayes\",\"41\",\"1000\",\"0\")";
		String us8 = userInsert +"(\"johndata@outlook.com\", \"pass321\", \"John\",\"Wilson\",\"27\",\"1000\",\"0\")";
		String us9 = userInsert +"(\"sql123@gmail.com\", \"pass12\", \"Jesus\",\"Christ\",\"96\",\"1000\",\"0\")";
		String us10 = userInsert +"(\"klkg6543@wayne.edu\", \"pass46\", \"Megan\",\"Miller\",\"62\",\"1000\",\"0\")";
	      statement.executeUpdate(us1);
	      statement.executeUpdate(us2);
	      statement.executeUpdate(us3);
	      statement.executeUpdate(us4);
	      statement.executeUpdate(us5);
	      statement.executeUpdate(us6);
	      statement.executeUpdate(us7);
	      statement.executeUpdate(us8);
	      statement.executeUpdate(us9);
	      statement.executeUpdate(us10);
	      
	      
	    String transferInsert = "insert into Transfer(Email, timeOfTrans, buyOrSell, PPSPrice, amount, transferID) values ";
	    
	    String tr1 = transferInsert +"(\"pf@gmail.com\", \"2022-03-8 05:45:22\", \"b\",\"2.3\",\"120\",\"59150e43468fea17\")";
		String tr2 = transferInsert +"(\"ab34@gmail.com\", \"2022-03-8 04:45:22\", \"b\",\"2.1\",\"88\",\"d3ff8769940ec23f\")";
		String tr3 = transferInsert +"(\"yu33@outlook.com\", \"2022-03-8 05:48:22\", \"b\",\"2.2\",\"3\",\"21a31d3c7eb7905c\")";
		String tr4 = transferInsert +"(\"jen_t@gmail.com\", \"2022-03-8 02:45:22\", \"b\",\"2.6\",\"7\",\"9782f31962d483a4\")";
		String tr5 = transferInsert +"(\"hy88@yahoo.com\", \"2022-03-8 05:33:22\", \"b\",\"2.2\",\"88\",\"c967a86fcf1e1528\")";
		String tr6 = transferInsert +"(\"emp555@wayne.edu\", \"2022-03-8 05:59:22\", \"b\",\"2.3\",\"18\",\"b4a0b4cf6cbc1a40\")";
		String tr7 = transferInsert +"(\"gary88@gmail.com\", \"2022-03-8 05:11:22\", \"b\",\"2.6\",\"410\",\"7f3a73773836c2c2\")";
		String tr8 = transferInsert +"(\"johndata@outlook.com\", \"2022-03-8 02:45:22\", \"b\",\"2.6\",\"8\",\"ed34a8074b039c9d\")";
		String tr9 = transferInsert +"(\"sql123@gmail.com\", \"2022-03-8 08:45:22\", \"b\",\"2.7\",\"55\",\"d5cba5706d657e74\")";
		String tr10 = transferInsert +"(\"klkg6543@wayne.edu\", \"2022-03-8 05:16:22\", \"b\",\"2.1\",\"72\",\"9ad71db2e2ecd5f7\")";
		  statement.executeUpdate(tr1);
	      statement.executeUpdate(tr2);
	      statement.executeUpdate(tr3);
	      statement.executeUpdate(tr4);
	      statement.executeUpdate(tr5);
	      statement.executeUpdate(tr6);
	      statement.executeUpdate(tr7);
	      statement.executeUpdate(tr8);
	      statement.executeUpdate(tr9);
	      statement.executeUpdate(tr10);
	    
	      
	      String tipInsert = "insert into Tip(SenderEmail, ReceiverEmail, timeOfTrans, amount, tipID) values ";
		    
		    String tp1 = tipInsert +"(\"pf@gmail.com\",\"hy88@yahoo.com\", \"2022-03-8 05:42:22\", \"65\",\"59150e43468fea17\")";
			String tp2 = tipInsert +"(\"ab34@gmail.com\",\"yu33@outlook.com\", \"2022-03-8 02:45:22\",\"8\",\"d3ff8769940ec23f\")";
			String tp3 = tipInsert +"(\"yu33@outlook.com\",\"johndata@outlook.com\", \"2022-03-8 05:48:22\",\"38\",\"21a31d3c7eb7905c\")";
			String tp4 = tipInsert +"(\"jen_t@gmail.com\",\"hy88@yahoo.com\", \"2022-03-7 02:45:22\", \"44\",\"9782f31965d483a4\")";
			String tp5 = tipInsert +"(\"hy88@yahoo.com\",\"gary88@gmail.com\", \"2022-03-8 05:33:22\", \"7\",\"c967a86fcf151528\")";
			String tp6 = tipInsert +"(\"emp555@wayne.edu\",\"sql123@gmail.com\", \"2022-03-7 05:59:22\", \"9\",\"b4a0b4cf6cbc1a40\")";
			String tp7 = tipInsert +"(\"gary88@gmail.com\",\"hy88@yahoo.com\", \"2022-03-8 05:11:22\", \"1\",\"7f3a73773836c2c2\")";
			String tp8 = tipInsert +"(\"johndata@outlook.com\",\"hy88@yahoo.com\", \"2022-03-8 02:45:22\", \"35\",\"ed34a8084b039c9d\")";
			String tp9 = tipInsert +"(\"sql123@gmail.com\",\"jen_t@gmail.com\", \"2022-03-7 08:47:22\", \"100\",\"d5cba5706d657ew4\")";
			String tp10 = tipInsert +"(\"klkg6543@wayne.edu\",\"ab34@gmail.com\", \"2022-03-8 09:16:28\", \"55\",\"9ad71db2e2zcd5f7\")";
			  statement.executeUpdate(tp1);
		      statement.executeUpdate(tp2);
		      statement.executeUpdate(tp3);
		      statement.executeUpdate(tp4);
		      statement.executeUpdate(tp5);
		      statement.executeUpdate(tp6);
		      statement.executeUpdate(tp7);
		      statement.executeUpdate(tp8);
		      statement.executeUpdate(tp9);
		      statement.executeUpdate(tp10);
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
  
             
            User User = new User(email, password, fN, lN, age, 1000, 0);
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
    	
    	
		String sql = "insert into  User(email, password, firstName, lastName, age, USDAmount, PPSAmount) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, User.email);
		preparedStatement.setString(2, User.password);
		preparedStatement.setString(3, User.fName);
		preparedStatement.setString(4, User.lName);
		preparedStatement.setInt(5, User.age);
		preparedStatement.setDouble(6, User.usd);
		preparedStatement.setDouble(7, User.pps);
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
             
            User = new User(email, password, fN, lN, age,1000,0);
            //test
        }
         
        resultSet.close();
        statement.close();
         
        return User;
    }
}
