public class User {
  String username;
  int[] topScores;
  int currScore;
  
  public User() {
    username = null;
    currScore=0;
    topScores=new int[5];
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
    if(username.length()<5 || username.length()>14){
      return "Username must have length between 5 and 14.";
    }else if(!Character.isLetter(username.charAt(0))){
      return "Username must start with a letter.";
    }
    return null;
  }
  
  // Sign up: check if a password has correct formats. If correct, return null; else return error information.
  private static String checkFormatForPassword(String password){
    if(password.length()<5 || password.length()>14){
      return "Password must have length between 5 and 14.";
    }
    return null;
  }
  
  /********* Database Assesses *********/
  public int[] getTopScores(){
    if(topScores==null){
      topScores=new int[5];
      // TODO: get top topScores from database.
      for(int i=0;i<5;i++){
       topScores[i]=(5-i)*100; 
      }
    }
    return topScores;
  }
  
  public void saveTopScores(){
    // TODO: Save topScores to database.
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
