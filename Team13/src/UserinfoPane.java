import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class UserinfoPane implements ActionListener{
	// The preferred size of the editor
    final int PREFERRED_WIDTH = 500;
    final int PREFERRED_HEIGHT = 200;
    
    int mode;//sign up: 1; log in: 2.
    
    JFrame frame=new JFrame();
    JPanel inputform=new JPanel();
    JPanel usernamepanel=new JPanel();
    JPanel passwordpanel=new JPanel();
 
    JLabel username=new JLabel("Username:");
    JLabel password=new JLabel("Password:");
    JTextField usernameTextField=new JTextField(30);
    JTextField passwordTextField=new JTextField(30);
    JLabel errorinfo=new JLabel("");
    JButton submitButton;
    
	public UserinfoPane(int mode) throws HeadlessException {
		this.mode=mode;
		if(mode==1){
			submitButton=new JButton("Sign up");
		}else{
			submitButton=new JButton("Log in");
		}
		submitButton.addActionListener(this);
		
		//set frame properties
        frame.setTitle(submitButton.getText());
        frame.setSize(PREFERRED_WIDTH, PREFERRED_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SpringLayout layout=new SpringLayout();
        inputform.setLayout(layout);
        inputform.add(username);
        inputform.add(usernameTextField);
        inputform.add(password);
        inputform.add(passwordTextField);
        
        layout.putConstraint(SpringLayout.EAST, username, -10, SpringLayout.WEST, usernameTextField);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 85, SpringLayout.WEST, frame.getContentPane());    
        layout.putConstraint(SpringLayout.EAST, usernameTextField, -5, SpringLayout.EAST, frame.getContentPane()); 
        layout.putConstraint(SpringLayout.EAST, password, -10, SpringLayout.WEST, passwordTextField);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 85, SpringLayout.WEST, frame.getContentPane());
        layout.putConstraint(SpringLayout.EAST, passwordTextField, -5, SpringLayout.EAST, frame.getContentPane());
        
        layout.putConstraint(SpringLayout.SOUTH, username, -5, SpringLayout.SOUTH, usernameTextField);
        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 5, SpringLayout.NORTH, frame.getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, password, -5, SpringLayout.SOUTH, passwordTextField);
        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 50, SpringLayout.NORTH, frame.getContentPane());

       
        // set form properties
        usernameTextField.setSize(new Dimension(200, 30));
        passwordTextField.setSize(new Dimension(200, 30));
        
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(inputform);
        frame.getContentPane().add(errorinfo);
        frame.getContentPane().add(submitButton);
	}
	
	public String getUsername(){
		frame.setVisible(true);
		return "";
	}

	public static void main(String[] args) {
		UserinfoPane pane = new UserinfoPane(1);
		pane.getUsername();
		//System.out.println(pane.passwordTextField.size().height);
		//System.out.println(pane.passwordTextField.size().width);
	}
	
	public void actionPerformed(ActionEvent e){
        // Source can only be submit button. No need to check for source.
		String username=usernameTextField.getText();
		if(!checkUsername(username)){
			errorinfo.setText("Username should have length 6 - 19.");
			return;
		}
		String password=passwordTextField.getText();
		if(!checkPassword(password)){
			errorinfo.setText("Password should have length 6 - 19.");
			return;
		}
		String error=checkUser(username,password);
		if(error!=null){
			errorinfo.setText(error);
			return;
		}else{
			frame.setVisible(false);
		}
		
	}
	
	private boolean checkUsername(String username){
		if(username.length()>5 && username.length()<20){
			return true;
		}
		return false;
	}
	
	private boolean checkPassword(String password){
		if(password.length()>5 && password.length()<20){
			return true;
		}
		return false;
	}
	
	private String checkUser(String username,String password){
		if(mode==1){
			// TODO:(Matt) Check if username already exists in database.
			// If yes, return error message. If no, save it to database.
			String error="Username already existed.";
		}else if(mode==2){
			// TODO:(Matt) Check if password is correct for the username.
			// If no, return error message. If yes, log user in.
			String error="Password is incorrect.";
		}
		return null;
	}
	
}
