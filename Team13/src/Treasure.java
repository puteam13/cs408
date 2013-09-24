import java.awt.Image;

import javax.swing.ImageIcon;


public class Treasure {
	Image Treasure_image;
	ImageIcon Treasure_ImageIcon;
	int x;
	int y;
	//int movepath;
	public Treasure(int x, int y){
		this.x=x;
		this.y=y;
		
		Treasure_ImageIcon = new ImageIcon("images/Treasure.png");
		Treasure_image = Treasure_ImageIcon.getImage();
		
	}
	
	
}
