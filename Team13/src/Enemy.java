import java.awt.Image;

import javax.swing.ImageIcon;


public class Enemy {
	Image poop_image;
	ImageIcon poop_ImageIcon;
	boolean Alive;
	int x;
	int y;
	int movepath;
	int velx;
	int vely;
	public Enemy(int x, int y){
		this.Alive = true;
		this.x=x;
		this.y=y;
		this.velx = 1;
		this.vely = 1;
		poop_ImageIcon = new ImageIcon(getClass().getResource("poop.png"));
		poop_image = poop_ImageIcon.getImage();
		
	}
	public boolean isAlive(){
		return this.Alive;
	}
	
	public void kill(){
		this.Alive = false;
	}
	public void revive(){
		this.Alive = true;
	}
	
}
