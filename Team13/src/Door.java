import java.awt.Image;

import javax.swing.ImageIcon;

public class Door {
	Image Door_image;
	ImageIcon Door_ImageIcon;
	int x;
	int y;

	public Door(int x, int y) {
		this.x = x;
		this.y = y;

		Door_ImageIcon = new ImageIcon("images/Door.png");
		Door_image = Door_ImageIcon.getImage();

	}

}
