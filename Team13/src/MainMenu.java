import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainMenu implements ActionListener{
 
 JFrame frame=new JFrame();
 JButton startButton;
 JButton helpButton;
 JButton exitButton;
 JButton switchButton;
 JButton signupButton;
 
 ImageIcon image;
 JLabel logolbl;
 JLabel topscorelbl;
 JLabel firstlbl;
 JLabel secondlbl;
 JLabel thirdlbl;
 JLabel fourthlbl;
 JLabel fifthlbl;
 
 
 JLabel personalscorelbl;
 JLabel pfirstlbl;
 JLabel psecondlbl;
 JLabel pthirdlbl;
 JLabel pfourthlbl;
 JLabel pfifthlbl;
 
 JPanel content;
 JPanel middleContent;
 JPanel leftContent;
 
 public MainMenu()
 {
  
  content = new JPanel(new BorderLayout());
  middleContent = new JPanel(new GridLayout(5,1));
  leftContent = new JPanel(new GridLayout(12,1));
  
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  startButton = new JButton("START");
  helpButton = new JButton("HELP");
  exitButton = new JButton("EXIT");
  switchButton = new JButton("SWITCH USER");
  signupButton = new JButton("SIGN UP");
  
  startButton.setPreferredSize(new Dimension(40,40));
  
  startButton.addActionListener(this);
  helpButton.addActionListener(this);
  exitButton.addActionListener(this);
  switchButton.addActionListener(this);
  signupButton.addActionListener(this);
  
  topscorelbl = new JLabel("Top Scores: ");
  firstlbl = new JLabel("1. ");
  secondlbl = new JLabel("2. ");
  thirdlbl = new JLabel("3. ");
  fourthlbl = new JLabel("4. ");
  fifthlbl = new JLabel("5. ");
  
  personalscorelbl = new JLabel("Person Best Score: ");
  pfirstlbl = new JLabel("1. ");
  psecondlbl = new JLabel("2. ");
  pthirdlbl = new JLabel("3. ");
  pfourthlbl = new JLabel("4. ");
  pfifthlbl = new JLabel("5. ");
  try{
   image = new ImageIcon("images/Logo.jpg");
   
  }catch(Exception E){}
  
  middleContent.add(startButton);
  middleContent.add(helpButton);
  middleContent.add(switchButton);
  middleContent.add(signupButton);
  middleContent.add(exitButton);
  
  leftContent.add(topscorelbl);
  leftContent.add(firstlbl);
  leftContent.add(secondlbl);
  leftContent.add(thirdlbl);
  leftContent.add(fourthlbl);
  leftContent.add(fifthlbl);
  
  leftContent.add(personalscorelbl);
  leftContent.add(pfirstlbl);
  leftContent.add(psecondlbl);
  leftContent.add(pthirdlbl);
  leftContent.add(pfourthlbl);
  leftContent.add(pfifthlbl);
  
  logolbl = new JLabel (image);
  content.add(logolbl, BorderLayout.NORTH);
  content.add(middleContent, BorderLayout.EAST);
  content.add(leftContent, BorderLayout.WEST);
  
  
  frame.add(content);
  frame.setSize(700,800);
  frame.setVisible(true);
  
  
 }
 public void actionPerformed(ActionEvent e){
  if(e.getSource() == startButton)
  {
   frame.setVisible(false);
   frame.dispose();
   MainFrame f = new MainFrame();
   
  }
  else if(e.getSource() == helpButton)
  {
   
  }
  else if(e.getSource() == switchButton)
  {
   
  }
  else if(e.getSource() == signupButton)
  {
   //UserinfoPane pane = new UserinfoPane(1);
   //pane.getUsername();
  }
  else if(e.getSource() == exitButton)
  {
   System.exit(0);
  }
  
  
 }
}
