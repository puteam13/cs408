import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BattleWindow implements ActionListener {
	
	JFrame frame;
	Enemy enemy;
	JButton rock;
	JButton paper;
	JButton scissors;
	JButton run;
	JButton fight;
	JButton buttonnull;
	int randNum;
	
	JPanel panel;
	
	public BattleWindow(Enemy E)
	{
		enemy = E;
		frame = new JFrame();
		panel = new JPanel(new GridLayout(2,3));
		
		Global.inFight = true;
		buttonnull = new JButton("");
		buttonnull.setVisible(false);
		rock = new JButton("Rock");
		paper = new JButton("Paper");
		scissors = new JButton("Scissors");
		
		run = new JButton("Run");
		fight = new JButton("Fight");
		
		panel.add(buttonnull);
		panel.add(run);
		panel.add(fight);
		panel.add(rock);
		panel.add(paper);
		panel.add(scissors);
		
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		run.addActionListener(this);
		fight.addActionListener(this);
		
		rock.setEnabled(false);
		paper.setEnabled(false);
		scissors.setEnabled(false);
		
		frame.add(panel);
		frame.setSize(300,100);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
	}
	public void userWin(){
		
		frame.dispose();
		JOptionPane.showMessageDialog(null, "you won");
		this.enemy.kill();
		Global.inFight = false;
		Global.fightResult = 1;
	}
	public void userLose(){
		run.setEnabled(true);
		fight.setEnabled(true);
		Global.maxHealth = Global.maxHealth - 100;
		Global.currentHealth.setText("Current Health: " + Global.currHealth);
		JOptionPane.showMessageDialog(null, "you lost");
		randNum = (int) Math.random() * 3;
		if(Global.currHealth <= 0){
			frame.dispose();
		}
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == run)
		{
			Global.currHealth = Global.currHealth - 200;
			Global.currentHealth.setText("Current Health: " + Global.currHealth);
			Global.inFight = false;
			Global.Hero.setPosition();
			frame.dispose();
			
		}
		else if(e.getSource() == fight)
		{
			// 0 = rock, 1 = paper, 2 = scissors
			randNum = (int) Math.random() * 3;
			run.setEnabled(false);
			fight.setEnabled(false);
			rock.setEnabled(true);
			paper.setEnabled(true);
			scissors.setEnabled(true);
		}
		else if(e.getSource() == rock)
		{
			if (randNum == 0 || randNum == 2 ){
				userWin();
			}
			else{
				userLose();
			}
			
			rock.setEnabled(false);
			paper.setEnabled(false);
			scissors.setEnabled(false);
		}
		else if(e.getSource() == paper)
		{
			if (randNum == 0 || randNum == 1 ){
				userWin();
			}
			else{
				userLose();
			}			
			rock.setEnabled(false);
			paper.setEnabled(false);
			scissors.setEnabled(false);
		}
		else if(e.getSource() == scissors)
		{
			if (randNum == 1 || randNum == 0 ){
				userWin();
			}
			else{
				userLose();
			}			
			rock.setEnabled(false);
			paper.setEnabled(false);
			scissors.setEnabled(false);
		}
	}
	

}
