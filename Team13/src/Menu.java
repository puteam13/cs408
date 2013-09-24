import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class Menu implements ActionListener {
  User user; // Current user playing the game.
  int topScores[]; // Top global scores.
  String topUsers[]; // Users who obtained the top global scores.
  
  // Swing components.
  private final int PREFERRED_WIDTH = 600;
  private final int PREFERRED_HEIGHT = 600;
  
  JFrame frame;
  JPanel maincomp;
  JTabbedPane signcomp;
  
  Font titleFont,heading1Font,heading2Font,heading3Font;
  
  MainFrame game;
  
  // Components in Maincomp.
  JLabel header,footer,personalBests,globalBests, personalScores[], globalScores[],welcomeMsg,selectLevel;
  JPanel scoresPanel,mainPanel,levelPanel;
  TitledBorder scoresBorder;
  ButtonGroup levelGroup;
  JRadioButton easy,medium,hard;
  JButton playButton,switchUserButton,helpButton,exitButton;
  
  // Components in Signcomp.
  JPanel signupPanel,signinPanel;
  JLabel usernameLabels[],passwordLabels[];
  JTextField usernameFields[],passwordFields[];
  JButton signup,signin,cancelButtons[];
  
  public Menu() {
    initializeGUI();
    obtainTopScores();
    obtainUserInfo();
  }
  
  // Obtain user information by showing a sign in/up screen.
  public void obtainUserInfo(){
    frame.setContentPane(signcomp);
    frame.setVisible(true);
  }
  
  // Obtain top scores and its users.
  public void obtainTopScores(){
    Object[] res=DungeonDatabase.getGlobalTopScores();
    topScores=(int[])res[0];
    topUsers=(String[])res[1];
    
    // Resetting JLabel |globalScores[]| based on the topScores.
    for(int i=0;i<5;i++){
      globalScores[i].setText((i+1)+". "+topScores[i]+"        "+topUsers[i]);
    }
  }
  
  // Initialize all the GUI Components.
  public void initializeGUI(){
    titleFont = new Font("Serif", Font.BOLD, 30);
    heading1Font = new Font("Serif", Font.BOLD, 25);
    heading2Font = new Font("Serif", Font.BOLD, 20);
    heading3Font = new Font("Serif", Font.BOLD, 15);
    
    frame = new JFrame("Dungeon Explorer");
    
    // Setup Maincomp.
    maincomp=new JPanel();
    maincomp.setLayout(new BorderLayout(50,10));
    
    header=new JLabel("Dungeon Explorer");
    header.setHorizontalAlignment(SwingConstants.CENTER);
    header.setFont(titleFont);
    footer=new JLabel("2013 CS408 Team 13.");
    footer.setHorizontalAlignment(SwingConstants.CENTER);
    
    // Layout the scores panel
    scoresPanel=new JPanel();
    scoresPanel.setLayout(new SpringLayout());
    
    scoresBorder=BorderFactory.createTitledBorder("Top scores");
    scoresBorder.setTitleJustification(TitledBorder.CENTER);
    scoresPanel.setBorder(scoresBorder);
    
    personalBests=new JLabel("Personal Bests");
    personalBests.setFont(heading3Font);
    globalBests=new JLabel("Global Bests");
    globalBests.setFont(heading3Font);
    
    personalScores=new JLabel[5];
    globalScores=new JLabel[5];
    for(int i=1;i<=5;i++){
      globalScores[i-1]=new JLabel(i+". "+100+"\t\tGod");
      personalScores[i-1]=new JLabel(i+". "+50);
    }
    
    scoresPanel.add(globalBests);
    for(int i=0;i<5;i++){
      scoresPanel.add(globalScores[i]);
    }
    scoresPanel.add(personalBests);
    for(int i=0;i<5;i++){
      scoresPanel.add(personalScores[i]);
    }
    SpringUtilities.makeCompactGrid(scoresPanel, 12, 1, //rows, cols
                                    10, 10,        //initX, initY
                                    40, 20);       //xPad, yPad
    
    // Layout the main panel.
    mainPanel=new JPanel();
    mainPanel.setLayout(new SpringLayout());
    
    welcomeMsg=new JLabel("Welcome! Please sign up/in first.");
    if(user!=null){
      welcomeMsg=new JLabel("Welcome back "+user.getUsername()+"!"); 
    }
    welcomeMsg.setFont(heading2Font);
    selectLevel = new JLabel("Select Difficulty:");
    levelGroup=new ButtonGroup();
    easy=new JRadioButton("Easy");
    easy.setSelected(true);
    medium=new JRadioButton("Medium");
    hard=new JRadioButton("Hard");
    levelGroup.add(easy);
    levelGroup.add(medium);
    levelGroup.add(hard);
    
    levelPanel=new JPanel();
    levelPanel.setLayout(new SpringLayout());
    levelPanel.add(easy);
    levelPanel.add(medium);
    levelPanel.add(hard);
    SpringUtilities.makeCompactGrid(levelPanel, 1, 3, //rows, cols
                                    0, 0,        //initX, initY
                                    20, 0);       //xPad, yPad
    
    playButton = new JButton("Play");
    playButton.setEnabled(false);
    playButton.setPreferredSize(new Dimension(64, 264));
    switchUserButton = new JButton("Sign up/in");
    switchUserButton.setPreferredSize(new Dimension(64, 264));
    helpButton = new JButton("Help");
    helpButton.setPreferredSize(new Dimension(64, 264));
    exitButton = new JButton("Exit");
    exitButton.setPreferredSize(new Dimension(64, 264));
    
    playButton.addActionListener(this);
    switchUserButton.addActionListener(this);
    helpButton.addActionListener(this);
    exitButton.addActionListener(this);
    
    mainPanel.add(welcomeMsg);
    mainPanel.add(selectLevel);
    mainPanel.add(levelPanel);
    mainPanel.add(playButton);
    mainPanel.add(switchUserButton);
    mainPanel.add(helpButton);
    mainPanel.add(exitButton);
    
    SpringUtilities.makeCompactGrid(mainPanel, 7, 1, //rows, cols
                                    5, 20,        //initX, initY
                                    100, 20);       //xPad, yPad
    
    // Adding elements to Maincomp.
    maincomp.add(header, BorderLayout.PAGE_START);
    maincomp.add(footer, BorderLayout.PAGE_END);
    maincomp.add(mainPanel, BorderLayout.CENTER);
    maincomp.add(scoresPanel, BorderLayout.LINE_START);
    
    // Setup Signcomp.
    signcomp=new JTabbedPane();
    signupPanel=new JPanel();
    signinPanel=new JPanel();
    
    usernameLabels=new JLabel[2];
    passwordLabels=new JLabel[2];
    usernameFields=new JTextField[2];
    passwordFields=new JTextField[2];
    
    for(int i=0;i<2;i++){
      usernameLabels[i]=new JLabel("Username:");
      passwordLabels[i]=new JLabel("Password:");
      usernameFields[i]=new JTextField(30);
      passwordFields[i]=new JTextField(30);
    }
    
    signup=new JButton("Sign up");
    signin=new JButton("Sign in");
    cancelButtons=new JButton[2];
    cancelButtons[0]=new JButton("Cancel");
    cancelButtons[1]=new JButton("Cancel");
    
    signupPanel.setLayout(new SpringLayout());
    signupPanel.add(usernameLabels[0]);
    signupPanel.add(usernameFields[0]);
    signupPanel.add(passwordLabels[0]);
    signupPanel.add(passwordFields[0]);
    signupPanel.add(cancelButtons[0]);
    signupPanel.add(signup);
    
    SpringUtilities.makeCompactGrid(signupPanel, 3, 2, //rows, cols
                                    20, 50,        //initX, initY
                                    50, 150);       //xPad, yPad
    
    signinPanel.setLayout(new SpringLayout());
    signinPanel.add(usernameLabels[1]);
    signinPanel.add(usernameFields[1]);
    signinPanel.add(passwordLabels[1]);
    signinPanel.add(passwordFields[1]);
    signinPanel.add(cancelButtons[1]);
    signinPanel.add(signin);
    SpringUtilities.makeCompactGrid(signinPanel, 3, 2, //rows, cols
                                    20, 50,        //initX, initY
                                    50, 150);       //xPad, yPad
    
    signin.addActionListener(this);
    signup.addActionListener(this);
    cancelButtons[0].addActionListener(this);
    cancelButtons[1].addActionListener(this);
    
    frame.pack();
    signcomp.addTab("Sign up",signupPanel);
    signcomp.addTab("Sign in",signinPanel);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(PREFERRED_WIDTH, PREFERRED_HEIGHT);
  }
  
  
  // Get global top socres from database, save them to |topScores|.
  private void getTopScores() {
    /*String[] currentName = {"1.", "2.", "3.", "4.", "5."};
    String[] globalName = {"1.", "2.", "3.", "4.", "5."};
    int count = 0;
    Connection c = null;
    Statement stmt = null;
    //retrieve top 5 scores from current user and total
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:data5.db");
    } catch ( Exception e){
      //CORRECT ERROR
      System.out.println(e.getClass().getName() + e.getMessage());
      System.out.println("error in connecting for score");
      
      //System.exit(0);
      //JOptionPane.showMessageDialog(frame, "error connecting to db to get scores");
    }
    try {
      stmt = c.createStatement();   
      ResultSet rs = stmt.executeQuery("SELECT * FROM SCORE ORDER BY HS DESC;");
      
      while(rs.next() && count < 5){
        globalName[count] += rs.getString("NAME") + " --- " + Integer.toString(rs.getInt("HS"));
        
        count++;
      }
      ResultSet rs2 = stmt.executeQuery("SELECT * FROM SCORE WHERE NAME='" + Global.currentUser  +"' ORDER BY HS DESC;");
      count = 0;
      while(rs2.next() && count < 5){
        currentName[count] += rs2.getString("NAME") + " --- " + Integer.toString(rs2.getInt("HS"));
        count++;
      }
    } catch (Exception e) {
      //CORRECT ERROR
      //JOptionPane.showMessageDialog(frame, "error selecting scores from database");
      System.out.println(e.getClass().getName() + e.getMessage());
      System.out.println("error in retrieving score");
      
      //System.exit(0);
    }*/
  }
  
  
  public static void main(String[] args) {
    
    
    /*Connection c = null;
     Statement stmt = null;
     try {
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:data5.db");
     
     } catch ( Exception e){
     System.exit(0);//CORRECT ERROR
     System.out.println(e.getClass().getName() + e.getMessage());
     //JOptionPane.showMessageDialog(frame, "error connecting to db to creating tables");
     }
     System.out.println("Connection created.");
     try {
     stmt = c.createStatement();
     //create user table unique ID, Username, and password(pass doesnt have to be unique)
     String userPass =  "CREATE TABLE IF NOT EXISTS USER" +
     "(NAME  CHAR(30) PRIMARY KEY NOT NULL UNIQUE, " +
     "PASS  CHAR(30) NOT NULL);";
     
     
     String userScore =  "CREATE TABLE IF NOT EXISTS SCORE" +
     "(NAME   CHAR(30) NOT NULL," +
     "HS    INT  NOT NULL," +
     "FOREIGN KEY (NAME) REFERENCES USER(NAME)   )";
     
     //String test = "INSERT INTO USER (ID, NAME) VALUES (NULL, 'MATT');";
     //stmt.executeUpdate(test);
     //ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
     //while(rs.next()) { 
     //System.out.println(rs.getString("NAME"));
     //}
     
     stmt.executeUpdate(userPass);
     stmt.executeUpdate(userScore);
     stmt.close();
     c.close();
     
     }
     catch ( Exception e ){
     //CORRECT ERROR
     System.out.println("error in table creation");
     System.out.println(e.getClass().getName() + e.getMessage());
     //System.exit.(0);
     //JOptionPane.showMessageDialog(frame, "error creating tables");
     
     }
     
     
     // start add temp user and scores
     try {
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:data5.db");
     
     } catch ( Exception e){
     System.exit(0);//CORRECT ERROR
     }
     try {
     
     stmt = c.createStatement();
     String deleteUsers = "DELETE FROM USER;";
     stmt.execute(deleteUsers);
     String addUser1 =  "INSERT INTO USER (NAME, PASS) VALUES ('Matt', 'mattpass');";
     String addUser2 =  "INSERT INTO USER (NAME, PASS) " +
     "VALUES ('Art', 'artpass');";
     stmt.executeUpdate(addUser1);
     
     stmt.executeUpdate(addUser2);
     
     String addScore1 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Matt', 100);";
     String addScore2 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Matt', 200);";
     String addScore3 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Art', 300);";
     String addScore4 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Matt', 700);";
     String addScore5 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Art', 50);";
     String addScore6 =  "INSERT INTO SCORE (NAME, HS) " +
     "VALUES ('Matt', 10);";
     
     stmt.executeUpdate(addScore1);
     stmt.executeUpdate(addScore2);
     stmt.executeUpdate(addScore3);
     stmt.executeUpdate(addScore4);
     stmt.executeUpdate(addScore5);
     stmt.executeUpdate(addScore6);
     
     stmt.close();
     c.close();
     
     
     }
     catch (Exception e){
     //CORRECT ERROR
     System.out.println(e.getClass().getName() + e.getMessage());
     System.out.println("error");
     //JOptionPane.showMessageDialog(frame, "error creating temp uses and scores");
     }
     // end add temp user and scores
     */
    Menu menu = new Menu();
  }

  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    // Components in maincomp
    if(obj==playButton){
      if(easy.isSelected()){
    	  Global.difficulty=Global.Easy;
      }else if(medium.isSelected()){
    	  Global.difficulty=Global.Medium;
      }else{
    	  Global.difficulty=Global.Hard;
      }
      
      game = new MainFrame();
      game.f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      //frame.setVisible(false);
    }else if(obj==switchUserButton){
      if(game!=null){
    	  game.f.dispose();
    	  game=null;
      }
      frame.setContentPane(signcomp);
      frame.setVisible(true);
    }else if(obj==helpButton){
      String helpText="Connect With Us\nPlease email us at jtee@purdue.edu.\nWe're here for you.";
      JOptionPane.showMessageDialog(maincomp,helpText,"Help",JOptionPane.INFORMATION_MESSAGE);
    }else if(obj==exitButton){
      System.exit(0);
    }
    
    // Components in signcomp
    if(obj==cancelButtons[0] || obj==cancelButtons[1]){
      frame.setContentPane(maincomp);
      if(user==null){
        switchToUser(null);
      }
      frame.setVisible(true);
    }else if(obj==signup){
      String uname=usernameFields[0].getText(),pword=passwordFields[0].getText();
      String err=User.checkForSignUp(uname,pword);
      if(err==null){
        switchToUser(uname);
      }else{
        JOptionPane.showMessageDialog(signcomp,err,"Error occured!",JOptionPane.ERROR_MESSAGE);
      }
    }else if(obj==signin){
      String uname=usernameFields[1].getText(),pword=passwordFields[1].getText();
      String err=User.checkForSignIn(uname,pword);
      if(err==null){
        switchToUser(uname);
      }else{
        JOptionPane.showMessageDialog(signcomp,err,"Error occured!",JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  // Used in |actionPerformed| to switch to another user account.
  private void switchToUser(String uname){
    if(uname==null){
      // Reset personal bests to empty
      for(int i=0;i<5;i++){
        personalScores[i].setText((i+1)+". ");
      }
      // Reset playbutton to be disbaled
      playButton.setEnabled(false);
      return; 
    }
    user=new User(uname);
    // Reset personal bests
    int userTopScores[]=user.getTopScores();
    for(int i=0;i<5;i++){
      personalScores[i].setText((i+1)+". "+userTopScores[i]);
    }
    // Reset welcome message
    String msg="Welcome back "+uname+"!";
    if(msg.length()<33){
      for(int i=0;i<33-msg.length();i++){
        msg=msg+" "; 
      }
    }
    welcomeMsg.setText(msg);
    // Change the text of switch user button
    switchUserButton.setText("Switch User");
    // Reset playbutton to be enbaled
    playButton.setEnabled(true);
    // Clear textFields
    for(int i=0;i<2;i++){
     usernameFields[i].setText(""); 
     passwordFields[i].setText("");
    }
    frame.setContentPane(maincomp);
    frame.setVisible(true);
  }
  
}
