

/*
 *
 The purpose of exercise 3 is to learn how to execute a CREATE/INSERT/SELECT/UPDATE/DELETE statement in Java over a table located at a local MySQL database server. 
     1) Execute each SQL statement from ch2's slides in Java. You will need to understand how method writeResultSet() works and modify it to display your results correctly. 
     2) Understand the difference between dynamic SQLs and static SQLs. 
 *
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class test3  {
  private static Connection connect = null;
  private static Statement statement = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;



 public static void main(String[] args) {

	 //1 Create Table
	 
	 String sql1 = "DROP TABLE IF EXISTS User";
    String sql2 = "CREATE TABLE IF NOT EXISTS User " +
                   
    			   " (Email VARCHAR(30), " +
    			   " Password VARCHAR(40),"+
                   " firstName VARCHAR(20), " + 
                   " lastName VARCHAR(30), " +
                   " Age INTEGER,"+
                   " PRIMARY KEY ( Email ))"; 
    
    /*
	 String sql1 = "DROP TABLE IF EXISTS Student";
	    String sql2 = "CREATE TABLE IF NOT EXISTS Student " +
	                   "(id INTEGER not NULL AUTO_INCREMENT, " +
	                   " Name VARCHAR(20), " + 
	                   " Address VARCHAR(50), " + 
	                   " Status VARCHAR(10), " + 
	                   " PRIMARY KEY ( id ))"; 
	 
	 */

    try {
      System.out.println("Select a table and then print out its content.");
      // This will load the MySQL driver, each DB has its own driver
      // Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/testdb?"
              + "useSSL=false&user=john&password=pass1234");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      statement.executeUpdate(sql1);
      statement.executeUpdate(sql2);

   
      System.out.println("***Connected Database***");
      
      //Modified Database(Exercise 3)
      //4 inserts
      String insertQuery1 = "insert into User(Email, Password, firstName, lastName, Age) values (\"Jeff Smalls\", \"765 Runny Road, Detroit, MI 48208\", \"Sophmore\")";
      statement.executeUpdate(insertQuery1);
      String insertQuery2 = "insert into User(Email, Password, firstName, lastName, Age) values (\"Biggie Smalls\", \"4782 River Road, Detroit, MI 48208\", \"Senior\")";
      statement.executeUpdate(insertQuery2);
      String insertQuery3 = "insert into User(Email, Password, firstName, lastName, Age) values (\"Ed Thomson\", \"82 West Hill Drive, Ann Arbor, MI 48421\", \"Freshman\")";
      statement.executeUpdate(insertQuery3);
      String insertQuery4 = "insert into User(Email, Password, firstName, lastName, Age) values (\"Gary Smary\", \"8915 Rocky Hill Street, Grand Rapids, MI 48266\", \"Junior\")";
      statement.executeUpdate(insertQuery4);
      
      resultSet = statement.executeQuery("select * from User");
      System.out.println("**4 INSERTS**");
      writeResultSet(resultSet);

      /*
      //5 selects
      String selectQuery1 = "SELECT Address FROM User WHERE Status = 'Senior'";
      String selectQuery2 = "SELECT Name FROM User WHERE Status = 'Sophmore'";
      String selectQuery3 = "SELECT Address FROM User WHERE Status = 'Freshman'";
      String selectQuery4 = "SELECT Status FROM User WHERE Address = '765 Runny Road, Detroit, MI 48208'";
      String selectQuery5 = "SELECT Name FROM User WHERE Name = 'Jeff Smalls'";
      preparedStatement = connect.prepareStatement(selectQuery1);
       
      System.out.println("**5 SELECTS**");
      resultSet = preparedStatement.executeQuery(selectQuery1);
      System.out.println("Selection 1:");
      writeResultSet(resultSet);
      resultSet = preparedStatement.executeQuery(selectQuery2);
      System.out.println("Selection 2:");
      writeResultSet(resultSet);
      resultSet = preparedStatement.executeQuery(selectQuery3);
      System.out.println("Selection 3:");
      writeResultSet(resultSet);
      resultSet = preparedStatement.executeQuery(selectQuery4);
      System.out.println("Selection 4:");
      writeResultSet(resultSet);
      resultSet = preparedStatement.executeQuery(selectQuery5);
      System.out.println("Selection 5:");
      writeResultSet(resultSet);
      
      
      
      //1 Update
      String updateQuery = "update User set Address = \"99 East Hill Drive, Ann Arbor, MI 48421\" where Name = \"Ed Thomson\"";
      statement.executeUpdate(updateQuery);
      
      resultSet = statement.executeQuery("select * from User");
      System.out.println("**1 UPDATE**");
      writeResultSet(resultSet);
      
      
      
      //1 DELETE
      String deleteQuery = "DELETE FROM User WHERE Name=\"Biggie Smalls\"";
      statement.executeUpdate(deleteQuery);
      
      resultSet = statement.executeQuery("select * from User");
      System.out.println("**1 DELETE**");
      writeResultSet(resultSet);
      */

    } catch (Exception e) {
         System.out.println(e);
    } finally {
      close();
    }

  }



  private static void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    //System.out.println("print result from a table..");
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
    	
    	try{
            resultSet.findColumn("id");
            Integer id = resultSet.getInt("id");
            System.out.println("id " + id);
            
        } catch (SQLException sqlex){}
    	try{
            resultSet.findColumn("Name");
            String name = resultSet.getString("Name");
            System.out.println("name: " + name);
            
        } catch (SQLException sqlex){}
    	try{
            resultSet.findColumn("Address");
            String address = resultSet.getString("Address");
            System.out.println("address: " + address);
            
        } catch (SQLException sqlex){}
    	try{
            resultSet.findColumn("Status");
            String status = resultSet.getString("status");
            System.out.println("status: " + status);
            
        } catch (SQLException sqlex){}
    	
      
        System.out.println("");
    }
  }

  // You need to close the resultSet
  private static void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }
  public static void p() {
	  System.out.println("TEST");
  }
} 
