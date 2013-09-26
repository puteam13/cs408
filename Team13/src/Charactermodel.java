import java.awt.Image;

import javax.swing.ImageIcon;


public class Charactermodel {
	ImageIcon octopus_ImageIcon;
	Image octopus_image;	
	int x;
	int y;
	public Charactermodel(){
		
		octopus_ImageIcon = new ImageIcon("images/snake3.png");
		octopus_image = octopus_ImageIcon.getImage();
		x=0;
		y=20;
	}
	public void setPosition(){
		x=0;
		y=20;
	}
	public void goup() {

		Global.movex = 0;
		Global.movey = -Global. difficulty / 5;// 1
		x = x + Global.movex;
		y = y + Global.movey;
	}

	public void godown() {

		Global.movex = 0;
		Global.movey = Global.difficulty / 5;
		x = x + Global.movex;
		y = y + Global.movey;
	}

	public void goright() {
		Global.movex = Global. difficulty / 5;
		Global.movey = 0;
		x = x + Global.movex;
		y = y + Global.movey;
	}

	public void goleft() {
		Global.movex = - Global.difficulty / 5;
		Global.movey = 0;
		x = x + Global.movex;
		y = y + Global.movey;
	}
	
}
