import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.*;

public class Menu implements ActionListener {

	public Menu() {
		JFrame Menuf = new JFrame("Main Page!");
		Menuf.setLayout(new GridLayout(2, 2, 20, 20));
		// JLabel TopScore=new JLabel("Top Scores:");
		// JLabel TopScore2=new JLabel("Top Scores:");
		// JLabel TopScore3=new JLabel("Top Scores:");
		// JLabel TopScore4=new JLabel("Top Scores:");
		JPanel Board1 = new JPanel();
		JPanel Board2 = new JPanel();
		JPanel Board3 = new JPanel();
		JPanel Board4 = new JPanel();

		// Layout the first boad
		JLabel TopScore = new JLabel("Top Score:");
		Font myFont = new Font("Serif", Font.BOLD, 18);
		TopScore.setFont(myFont);

		JLabel Rank1 = new JLabel("1.");
		JLabel Rank2 = new JLabel("2.");
		JLabel Rank3 = new JLabel("3.");
		JLabel Rank4 = new JLabel("4.");
		JLabel Rank5 = new JLabel("5.");
		Board1.setLayout(new GridLayout(6, 1, 5, 5));
		Board1.add(TopScore);
		Board1.add(Rank1);
		Board1.add(Rank2);
		Board1.add(Rank3);
		Board1.add(Rank4);
		Board1.add(Rank5);

		// Layout the Personal Score Board

		JLabel PTopScore = new JLabel("Personal Top Score:");

		PTopScore.setFont(myFont);
		JLabel Blank = new JLabel("    ");

		Blank.setFont(myFont);

		JLabel PRank1 = new JLabel("1.");
		JLabel PRank2 = new JLabel("2.");
		JLabel PRank3 = new JLabel("3.");
		JLabel PRank4 = new JLabel("4.");
		JLabel PRank5 = new JLabel("5.");

		Board3.setLayout(new GridLayout(7, 1, 5, 5));
		Board3.add(PTopScore);
		Board3.add(PRank1);
		Board3.add(PRank2);
		Board3.add(PRank3);
		Board3.add(PRank4);
		Board3.add(PRank5);
		Board3.add(Blank);

		// Layout the right side Board

		JLabel Gamename = new JLabel("Game Name");
		Font myFont1 = new Font("Serif", Font.BOLD, 24);
		Gamename.setFont(myFont1);
		JLabel SelectLabel = new JLabel("Select Difficuty Levels:");
		JPanel PRadio = new JPanel();
		PRadio.setLayout(new GridLayout(1, 3, 5, 5));

		JRadioButton easyButton = new JRadioButton("Easy");
		easyButton.setMnemonic(KeyEvent.VK_B);
		easyButton.setActionCommand("Easy");
		easyButton.setSelected(true);

		JRadioButton mediumButton = new JRadioButton("Medium");
		mediumButton.setMnemonic(KeyEvent.VK_B);
		mediumButton.setActionCommand("Medium");

		JRadioButton hardButton = new JRadioButton("Hard");
		hardButton.setMnemonic(KeyEvent.VK_B);
		hardButton.setActionCommand("Hard");
		PRadio.add(easyButton);
		PRadio.add(mediumButton);
		PRadio.add(hardButton);
		Board2.setLayout(new GridLayout(3, 1, 5, 5));
		Board2.add(Gamename);
		Board2.add(SelectLabel);
		Board2.add(PRadio);
		// Layout the fourth board

		JButton Bplay = new JButton("Play");
		JButton Bswitch = new JButton("Switch User");
		JButton Bhelp = new JButton("Help");
		JButton Bexit = new JButton("EXIT");
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

		Menu f = new Menu();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
