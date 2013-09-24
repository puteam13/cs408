import java.awt.Image;

import javax.swing.ImageIcon;


public class Enemy {
	Image poop_image;
	ImageIcon poop_ImageIcon;
	int x;
	int y;
	int movepath;
	public Enemy(int x, int y){
		this.x=x;
		this.y=y;
		
		poop_ImageIcon = new ImageIcon("images/poop.png");
		poop_image = poop_ImageIcon.getImage();
		
	}
	
	
}
