public class User {
  String username;
  int currScore;
  
  public User() {
    username = null;
    currScore=0;
  }
  
  public User(String username) {
    this.username = username;
  }
  
  /********* Class Methods *********/
  // Sign up: check if (username, password) could be used for sign up.
  public static String checkForSignUp(String username, String password){
    String err=checkFormatForUsername(username);
    if(err!=null)return err;
    err=checkFormatForPassword(password);
    if(err!=null)return err;
    return DungeonDatabase.signup(username,password);
  }
  
  // Sign up: check if (username, password) could be used for sign in.
  public static String checkForSignIn(String username, String password){
    String err=checkFormatForUsername(username);
    if(err!=null)return err;
    err=checkFormatForPassword(password);
    if(err!=null)return err;
    return DungeonDatabase.signin(username,password);
  }
  
  
  // Sign up: check if a username has correct formats. If correct, return null; else return error information.
  private static String checkFormatForUsername(String username){
    if(username.length()<5 || username.length()>25){
      return "Username must have length between 5 and 25.";
    }else if(!Character.isLetter(username.charAt(0))){
      return "Username must start with a letter.";
    }
    return null;
  }
  
  // Sign up: check if a password has correct formats. If correct, return null; else return error information.
  private static String checkFormatForPassword(String password){
    if(password.length()<5 || password.length()>25){
      return "Password must have length between 5 and 25.";
    }
    return null;
  }
  
  /********* Database Assesses *********/
  public int[] getTopScores(){
    return DungeonDatabase.getTopScoresForUser(username);
  }
  
  public void saveScoreToDatabase(){
    DungeonDatabase.saveScoreForUser(username,currScore);
  }
  
  public String getUsername() {
    return username;
  }
  
  public int getCurrScore() {
    return currScore; 
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public void setCurrScore(int scores) {
    currScore=scores;
  }
  
  public static void main(String args[]){
    
    
  }
  
}
