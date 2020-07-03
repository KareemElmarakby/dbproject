import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VideoDao {
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
    	System.out.println("InitializeDB For YoutubeVideos");
    	String sql1 = "DROP TABLE IF EXISTS YoutubeVideos";
        String sql2 = "CREATE TABLE IF NOT EXISTS YoutubeVideos" +
                       " url VARCHAR(50), " +
                       " title VARCHAR(50), " + 
                       " desc VARCHAR(200), " + 
                       " comid INTEGER NOT NULL, " +
                       " postuser VARCHAR(50) NOT NULL, " +
                       " postdate DATE, " +
                       " PRIMARY KEY (url), " +
                       " FOREIGN KEY (comid) REFERENCES Comedians(comid), " +
                       " FOREIGN KEY (postuser) REFERENCES Users(email), " ; 
        
        String sql3 = "insert into YoutubeVideos(url, title, desc) values (?, ?, ?)";
        String sql4 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/1\", \"Sketch1\", \"Description1\")";
        String sql5 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/2\", \"Sketch2\", \"Description2\")";
        String sql6 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/3\", \"Sketch3\", \"Description3\")";
        String sql7 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/4\", \"Sketch4\", \"Description4\")";
        String sql8 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/5\", \"Sketch5\", \"Description5\")";
        String sql9 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/6\", \"Sketch6\", \"Description6\")";
        String sql10 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/7\", \"Sketch7\", \"Description7\")";
        String sql11 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/8\", \"Sketch8\", \"Description8\")";
        String sql12 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/9\", \"Sketch9\", \"Description9\")";
        String sql13 = "insert into YoutubeVideos(url, title, desc) values (\"youtube.com/10\", \"Sketch10\", \"Description10\")";
        
        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Select a table and then print out its content.");
          connect = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/testdb?"
                  + "user=root&password=pass123");
          
          statement = connect.createStatement();

          statement.executeUpdate(sql1);
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
          statement.executeUpdate(sql13);
          
        } 
        catch (Exception e) {
             System.out.println(e);
        } 
          
        finally {
          close();
        }
    }
    
}