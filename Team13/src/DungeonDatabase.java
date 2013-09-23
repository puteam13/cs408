import java.sql.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class DungeonDatabase{
  private static final String dbURL="jdbc:sqlite:dungeon.db";
  
  // Create table if there isn't one.
  public static void createTable(){
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection(dbURL);
      con.setAutoCommit(false);
 
      stmt = con.createStatement();
      String createUsersTable = "CREATE TABLE IF NOT EXISTS USERS " +
        "(UID INT PRIMARY KEY     NOT NULL," +
        " NAME           TEXT    NOT NULL, " + 
        " PASSWORD       TEXT    NOT NULL)";
      String createScoresTable = "CREATE TABLE IF NOT EXISTS SCORES " +
        "(SID INT PRIMARY KEY     NOT NULL," +
        " SCORE           INT, " +
        " UID             INT, " +
        " FOREIGN KEY (UID) REFERENCES USERS(UID))"; 
      stmt.executeUpdate(createUsersTable);
      stmt.executeUpdate(createScoresTable);
      stmt.close();
      con.commit();
      con.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
  }
  
  public static void dropTable(){
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection(dbURL);
      con.setAutoCommit(false);

      stmt = con.createStatement();
      String dropUsersTable = "DROP TABLE IF EXISTS USERS;";
      String dropScoresTable = "DROP TABLE IF EXISTS SCORES;";
      stmt.executeUpdate(dropUsersTable);
      stmt.executeUpdate(dropScoresTable);
      stmt.close();
      con.commit();
      con.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
  }
  
  // Sign up with username and password. Return error message if there is one.
  public static String signup(String username, String password){
    createTable();
    
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      
      stmt = c.createStatement();
      String query="SELECT * FROM USERS WHERE NAME='"+username+"';";
      ResultSet rs = stmt.executeQuery(query);
      if ( rs.next() ) {
        rs.close();
        stmt.close();
        c.close();
        return "ERROR: Username already exists!";
      }
      // Username does not exist. Insert such entry.
      String hashedPassword=getHashedPassword(password);
      if(hashedPassword==null){
        rs.close();
        stmt.close();
        c.close();
        return "ERROR: Invalid Password!";
      }
     
      query="SELECT UID FROM USERS ORDER BY UID DESC;";
      rs = stmt.executeQuery(query);
      int uid=0;
      if ( rs.next() ) {
        uid=rs.getInt("UID")+1;
      }

      String insert = String.format("INSERT INTO USERS (UID,NAME,PASSWORD) VALUES (%d, %s, %s);",
                                    uid, "'"+username+"'","'"+hashedPassword+"'"); 
      stmt.executeUpdate(insert);
      stmt.close();
      rs.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
    return null;
  }
  
  // Sign in with username and password. Return error message if there is one.
  public static String signin(String username, String password){
    createTable();
    
    Connection c = null;
    Statement stmt = null;
    String dbpassword=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();

      String query="SELECT * FROM USERS WHERE NAME='"+username+"';";
      ResultSet rs = stmt.executeQuery(query);

      if ( rs.next() ) {
        dbpassword=rs.getString("PASSWORD");
      }else{
        rs.close();
        stmt.close();
        c.close();
        return "ERROR: Username does not exist!";
      }

      String hashedPassword=getHashedPassword(password);
      if(!hashedPassword.equals(dbpassword)){
        rs.close();
        stmt.close();
        c.close();
        return "ERROR: Incorrect password!";
      }

      stmt.close();
      rs.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
    return null;
  }
  
  // Return uid if found; return -1 if no such user exists.
  private static String getName(int uid){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();

      String query="SELECT * FROM USERS WHERE UID="+uid+";";
      ResultSet rs = stmt.executeQuery(query);

      if ( rs.next() ) {
        String uname=rs.getString("NAME");
        rs.close();
        stmt.close();
        c.close();
        return uname;
      }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
    return null;
  }
  
  // Return uid if found; return -1 if no such user exists.
  private static int getUID(String username){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();

      String query="SELECT * FROM USERS WHERE NAME='"+username+"';";
      ResultSet rs = stmt.executeQuery(query);

      if ( rs.next() ) {
        int uid=rs.getInt("UID");
        rs.close();
        stmt.close();
        c.close();
        return uid;
      }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
    return -1;
  }
  
  // Save score for user.
  public static void saveScoreForUser(String username, int score){
    int uid=getUID(username);
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();
      String query="SELECT UID FROM USERS ORDER BY UID DESC;";
      ResultSet rs = stmt.executeQuery(query);
      int sid=0;
      if ( rs.next() ) {
        sid=rs.getInt("SID")+1;
      }

      String insert = String.format("INSERT INTO USERS (SID,SCORE,UID) VALUES (%d, %d, %d);",
                                    sid, score, uid); 
      stmt.executeUpdate(insert);
      stmt.close();
      rs.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
  }
  
  public static Object[] getGlobalTopScores(){
    Object[] res=new Object[2];
    int[] scores=new int[5];
    String[] names=new String[5];
    res[0]=scores;
    res[1]=names;
    
    Connection c=null;
    Statement stmt=null;
    String dbpassword=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();

      String query="SELECT * FROM SCORES ORDER BY SCORE DESC;";
      ResultSet rs = stmt.executeQuery(query);

      int i=0;
      while ( rs.next() && i<5 ) {
        int uid=rs.getInt("UID");
        int score=rs.getInt("SCORE");
        scores[i]=score;
        names[i++]=getName(uid);
      }

      stmt.close();
      rs.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(1);
    }
    return res;
  }
  
  public static int[] getTopScoresForUser(String username){
    int[] scores=new int[5];
    int uid=getUID(username);
    
    Connection c=null;
    Statement stmt=null;
    String dbpassword=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      stmt = c.createStatement();

      String query=String.format("SELECT SCORE FROM SCORES WHERE UID=%d ORDER BY SCORE DESC;",uid);
      ResultSet rs = stmt.executeQuery(query);

      int i=0;
      while ( rs.next() && i<5) {
        int score=rs.getInt("SCORE");
        scores[i++]=score;
      }

      stmt.close();
      rs.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(1);
    }
    return scores;
  }
  
  // Get hashed password from a password string.
  public static String getHashedPassword(String password){
    Mac mac;
    byte[] passwordarr,hashedPassword;
    String keystr="4AS8A9dnGXkZku26CRUMOYZOIwBCyTUNw2mZYLSKYa5mWxCPRbVY5j2W8AhMLZjS";
    byte[] keyarr=keystr.getBytes();
    SecretKeySpec speckey = new SecretKeySpec(keyarr,"HmacSHA256");
    try{
      mac = Mac.getInstance("HmacSHA256");
      mac.init(speckey);
      passwordarr=password.getBytes();
      hashedPassword=mac.doFinal(passwordarr);
      return new String(hashedPassword, "UTF-8");
    }catch(Exception e){
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
  
  
  
  
  public static void main(String[] args){
    String err =DungeonDatabase.signup("meguyan","abcde12");
    if(err!=null){
      System.out.println(err);
    }
    err=DungeonDatabase.signin("meguyan","abcde12");
    if(err==null){
     System.out.println("Successfully signed in!"); 
    }
  }
  
}