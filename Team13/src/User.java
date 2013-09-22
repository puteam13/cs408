public class User {
  String username;
  String password;
  int[] topScores;
  int currScore;
  
  public User() {
    username = null;
    password = null;
    currScore=0;
    topScores=new int[5];
  }
  
  public User(String n, String s) {
    this.username = n;
    this.password = s;
  }
  
  /********* Class Methods *********/
  // Sign up: check if a username has correct formats. If correct, return null; else return error information.
  public static String checkFormatForUsername(String username){
    if(username.length()<5 || username.length()>14){
      return "Username must have length between 5 and 14.";
    }else if(!Character.isLetter(username.charAt(0))){
      return "Username must start with a letter.";
    }
    return null;
  }
  
  // Sign up: check if a password has correct formats. If correct, return null; else return error information.
  public static String checkFormatForPassword(String password){
    if(password.length()<5 || password.length()>14){
      return "Password must have length between 5 and 14.";
    }
    return null;
  }
  
  // Sign up: check if a username exists in database.
  public static String checkUserExistance(String username){
    // TODO: check if username exists in database.
    return null;
  }
  
  // Sign in: check if a password is correct for the username.
  public static String checkPassword(String username, String password){
    // TODO: check if password is correct.
    return null;
  }
  
  /********* Database Assesses *********/
  public void retriveTopScores(){
    // set top topScoress
  }
  
  public void saveTopScores(){
    
  }
  
  
  public String getUsername() {
    return username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public int getCurrScore() {
    return currScore; 
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public void setCurrScore(int topScores) {
    currScore=topScores;
    updateTopScores();
  }
  
  // Update top scores with currScore.
  public void updateTopScores() {
    // topScores[0]>=topScores[1]>=topScores[2]>=topScores[3]>=topScores[4]
    if (currScore <= topScores[4])
      return;
    if (currScore > topScores[0]) {
      topScores[4] = topScores[3];
      topScores[3] = topScores[2];
      topScores[2] = topScores[1];
      topScores[1] = topScores[0];
      topScores[0] = currScore;
    } else if (currScore > topScores[1]) {
      topScores[4] = topScores[3];
      topScores[3] = topScores[2];
      topScores[2] = topScores[1];
      topScores[1] = currScore;
    } else if (currScore > topScores[2]) {
      topScores[4] = topScores[3];
      topScores[3] = topScores[2];
      topScores[2] = currScore;
    } else if (currScore > topScores[3]) {
      topScores[4] = topScores[3];
      topScores[3] = currScore;
    } else if (currScore > topScores[4]) {
      topScores[4] = currScore;
    }
  }
  
  public static void main(String args[]){
    
    
  }
  
}
