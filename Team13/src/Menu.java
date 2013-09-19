import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.*;

import java.sql.*;

public class Menu implements ActionListener {

 public Menu() {
  String[] currentName = {"1.", "2.", "3.", "4.", "5."};
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
  }
  JFrame Menuf = new JFrame("Dungeon Explorer");
  Menuf.setLayout(new GridLayout(2, 2, 20, 20));
  JPanel Board1 = new JPanel();
  JPanel Board2 = new JPanel();
  JPanel Board3 = new JPanel();
  JPanel Board4 = new JPanel();

  // Layout the first board

  JLabel TopScore = new JLabel("OVERALL BESTS:");
  Font myFont = new Font("Serif", Font.BOLD, 18);
  TopScore.setFont(myFont);
  	
  JLabel Rank1 = new JLabel(globalName[0]);
  Rank1.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel Rank2 = new JLabel(globalName[1]);
  Rank2.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel Rank3 = new JLabel(globalName[2]);
  Rank3.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel Rank4 = new JLabel(globalName[3]);
  Rank4.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel Rank5 = new JLabel(globalName[4]);
  Rank5.setFont(new Font("Serif", Font.BOLD, 20));
  Board1.setLayout(new GridLayout(6, 1, 5, 5));
  Board1.add(TopScore);
  Board1.add(Rank1);
  Board1.add(Rank2);
  Board1.add(Rank3);
  Board1.add(Rank4);
  Board1.add(Rank5);

  // Layout the Personal Score Board

  JLabel PTopScore = new JLabel("PERSONAL BESTS:");

  PTopScore.setFont(myFont);
  JLabel Blank = new JLabel("    ");
  
  Blank.setFont(myFont);

  JLabel PRank1 = new JLabel(currentName[0]);
  PRank1.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel PRank2 = new JLabel(currentName[1]);
  PRank2.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel PRank3 = new JLabel(currentName[2]);
  PRank3.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel PRank4 = new JLabel(currentName[3]);
  PRank4.setFont(new Font("Serif", Font.BOLD, 20));
  JLabel PRank5 = new JLabel(currentName[4]);
  PRank5.setFont(new Font("Serif", Font.BOLD, 20));
  
  Board3.setLayout(new GridLayout(7, 1, 5, 5));
  Board3.add(PTopScore);
  Board3.add(PRank1);
  Board3.add(PRank2);
  Board3.add(PRank3);
  Board3.add(PRank4);
  Board3.add(PRank5);
  Board3.add(Blank);

  // Layout the right side Board

  JLabel Gamename = new JLabel("Dungeon Explorer");
  Font myFont1 = new Font("SansSerif", Font.BOLD, 26);
  Gamename.setFont(myFont1);
  
  JLabel SelectLabel = new JLabel("Select Difficulty:");
  Font myFont2 = new Font("Serif", Font.BOLD, 28);
  SelectLabel.setFont(myFont2);
  
  JPanel PRadio = new JPanel();
  PRadio.setLayout(new GridLayout(1, 3, 5, 5));  
  
  Font radioFont;
  
  JRadioButton easyButton = new JRadioButton("EASY");
  easyButton.setMnemonic(KeyEvent.VK_B);
  easyButton.setActionCommand("Easy");
  easyButton.setSelected(true);
  radioFont = new Font(easyButton.getFont().getName(), easyButton.getFont().getStyle(), 15);    
  easyButton.setFont(radioFont); 
  
  JRadioButton mediumButton = new JRadioButton("MEDIUM");
  mediumButton.setMnemonic(KeyEvent.VK_B);
  mediumButton.setActionCommand("Medium");
  radioFont = new Font(mediumButton.getFont().getName(), mediumButton.getFont().getStyle(), 15);    
  mediumButton.setFont(radioFont);
  
  JRadioButton hardButton = new JRadioButton("HARD");
  hardButton.setMnemonic(KeyEvent.VK_B);
  hardButton.setActionCommand("Hard");
  radioFont = new Font(hardButton.getFont().getName(), hardButton.getFont().getStyle(), 15);    
  hardButton.setFont(radioFont);
  
  PRadio.add(easyButton);
  PRadio.add(mediumButton);
  PRadio.add(hardButton);
  Board2.setLayout(new GridLayout(3, 1, 5, 5));
  Board2.add(Gamename);
  //Board2.add(Gamename_2);
  Board2.add(SelectLabel);
  Board2.add(PRadio);
  // Layout the fourth board

  Font buttonFont;
  
  JButton Bplay = new JButton("PLAY");
  buttonFont = new Font(Bplay.getFont().getName(), Bplay.getFont().getStyle(), 20);
  Bplay.setFont(buttonFont);
  
  JButton Bswitch = new JButton("HELP");
  buttonFont = new Font(Bswitch.getFont().getName(), Bswitch.getFont().getStyle(), 20);
  Bswitch.setFont(buttonFont);
  
  JButton Bhelp = new JButton("SIGN OUT");
  buttonFont = new Font(Bhelp.getFont().getName(), Bhelp.getFont().getStyle(), 20);
  Bhelp.setFont(buttonFont);
  
  JButton Bexit = new JButton("EXIT");
  buttonFont = new Font(Bexit.getFont().getName(), Bexit.getFont().getStyle(), 20);
  Bexit.setFont(buttonFont);
  
  Bplay.addActionListener(this);
  Bswitch.addActionListener(this);
  Bhelp.addActionListener(this);
  Bexit.addActionListener(this);
  Board4.setLayout(new GridLayout(5, 1, 10, 10));

  Board4.add(Bplay);
  Board4.add(Bswitch);
  Board4.add(Bhelp);
  Board4.add(Bexit);
  Board4.add(Blank);

  Menuf.add(Board1);
  Menuf.add(Board2);
  Menuf.add(Board3);
  Menuf.add(Board4);

  Menuf.setVisible(true);
  Menuf.setSize(600, 600);

 }

 public static void main(String[] args) {
	 Connection c = null;
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
			String userPass = 	"CREATE TABLE IF NOT EXISTS USER" +
						"(NAME		CHAR(30) PRIMARY KEY	NOT NULL UNIQUE, " +
						"PASS		CHAR(30)	NOT NULL);";

			
			String userScore = 	"CREATE TABLE IF NOT EXISTS SCORE" +
						"(NAME 		CHAR(30)	NOT NULL," +
						"HS 		 INT		NOT NULL," +
						"FOREIGN KEY (NAME) REFERENCES USER(NAME) 		)";
			/*
			String test = "INSERT INTO USER (ID, NAME) VALUES (NULL, 'MATT');";
			stmt.executeUpdate(test);
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			while(rs.next()) { 
				System.out.println(rs.getString("NAME"));
			}
			*/
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
			String addUser1 = 	"INSERT INTO USER (NAME, PASS) VALUES ('Matt', 'mattpass');";
			String addUser2 = 	"INSERT INTO USER (NAME, PASS) " +
								"VALUES ('Art', 'artpass');";
			stmt.executeUpdate(addUser1);
			
			stmt.executeUpdate(addUser2);
			
			String addScore1 = 	"INSERT INTO SCORE (NAME, HS) " +
						"VALUES ('Matt', 100);";
			String addScore2 = 	"INSERT INTO SCORE (NAME, HS) " +
						"VALUES ('Matt', 200);";
			String addScore3 = 	"INSERT INTO SCORE (NAME, HS) " +
						"VALUES ('Art', 300);";
			String addScore4 = 	"INSERT INTO SCORE (NAME, HS) " +
						"VALUES ('Matt', 700);";
			String addScore5 = 	"INSERT INTO SCORE (NAME, HS) " +
						"VALUES ('Art', 50);";
			String addScore6 = 	"INSERT INTO SCORE (NAME, HS) " +
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
		
  Menu f = new Menu();

 }

 @Override
 public void actionPerformed(ActionEvent arg0) {
  // TODO Auto-generated method stub

 }

}
