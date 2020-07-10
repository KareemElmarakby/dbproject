import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComedianDao {
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "user=root&password=pass123");
            System.out.println(connect);
        }
    }
    
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
    
    public static void InitializeDB() {
    	// TODO Auto-generated method stub
    	System.out.println("InitializeDB For Comedians");
        String sql2 = "CREATE TABLE IF NOT EXISTS Comedians" +
                       " (comid INT NOT NULL AUTO_INCREMENT, " +
                       " firstname VARCHAR(50), " + 
                       " lastname VARCHAR(50), " + 
                       " birthday DATE, " +
                       " birthplace VARCHAR(50), " + 
                       " PRIMARY KEY (comid)) "; 
        
        String sql3 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"1\", \"First1\", \"Last1\", \"DATE '2013-11-26'\", \"Dakota\")";
        String sql4 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"2\", \"First2\", \"Last2\", \"DATE '2013-11-26'\", \"Michigan\")";
        String sql5 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"3\", \"First3\", \"Last3\", \"DATE '2013-11-26'\", \"Texas\")";
        String sql6 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"4\", \"First4\", \"Last4\", \"DATE '2013-11-26'\", \"Maine\")";
        String sql7 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"5\", \"First5\", \"Last5\", \"DATE '2013-11-26'\", \"Washington\")";
        String sql8 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"6\", \"First6\", \"Last6\", \"DATE '2013-11-26'\", \"New York\")";
        String sql9 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"7\", \"First7\", \"Last7\", \"DATE '2013-11-26'\", \"Florida\")";
        String sql10 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"8\", \"First8\", \"Last8\", \"DATE '2013-11-26'\", \"California\")";
        String sql11 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"9\", \"First9\", \"Last9\", \"DATE '2013-11-26'\", \"Kansas\")";
        String sql12 = "insert into Comedians(comid, firstname, lastname, birthday, birthplace) values (\"10\", \"First10\", \"Last10\", \"DATE '2013-11-26'\", \"Tennessee\")";
        
        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Select a table and then print out its content.");
          connect = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/testdb?"
                  + "user=root&password=pass123");
          
          statement = connect.createStatement();

          statement.executeUpdate(sql2);
          statement.executeUpdate(sql3);
		  statement.executeUpdate(sql4);
		  statement.executeUpdate(sql5);
		  statement.executeUpdate(sql6);
		  statement.executeUpdate(sql7);
		  statement.executeUpdate(sql8);
		  statement.executeUpdate(sql9);
		  statement.executeUpdate(sql10);
		  statement.executeUpdate(sql11);
		  statement.executeUpdate(sql12);
          
        } 
        catch (Exception e) {
             System.out.println(e);
        } 
          
        finally {
          close();
        }
    }
}