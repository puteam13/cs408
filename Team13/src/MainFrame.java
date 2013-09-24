import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame extends JPanel implements ActionListener, KeyListener {

	JFrame f;
	JMenu menuRestart;

	JMenu menuBack;
	JMenu menuScore;
	JMenu menuExit;
	JMenu menuLife;
	JMenu menuScore1;
	JMenuBar Menub;
	Timer t;
	ImageIcon BackImg;
	Image wall_image;
	Image road_image;
	Image start_image;
	Image exit_image;
	Image octopus_image;
	Treasure Cash;
	// int Global.difficulty;
	Enemy E1;
	Charactermodel Hero;
	int velx = 1, vely = 2;

	// int Hero.x = 20, Hero.y = 100;

	public MainFrame() {
		frameLayout();

		E1 = new Enemy(60, 120);
		
		
		
		Cash = new Treasure(60, 120); 
	//	setEnemy(E1,60, 120);
		
		
		
		// System.out.println("mmmm");
		Hero = new Charactermodel();
	
		// Global.difficulty = 10;
		Global.LEVEL = 1;
		t = new Timer(Global.difficulty, this);
		t.start();
	}

	public void frameLayout() {
		f = new JFrame("Title");
		menuRestart = new JMenu("Restart");

		menuBack = new JMenu("Back");
		menuScore = new JMenu("Score");
		menuExit = new JMenu("Exit");
		menuLife = new JMenu("Life: 3");
		menuScore1 = new JMenu("Score: 0");
		Menub = new JMenuBar();
		menuRestart.add(makeMenuItem("Open"));
		Menub.add(menuRestart);
		Menub.add(menuBack);
		Menub.add(menuScore1);
		Menub.add(menuExit);
		Menub.add(menuLife);
		Menub.add(menuScore1);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setJMenuBar(Menub);
		// f.add(Menub);

		f.add(this);

		f.setVisible(true);
		f.addKeyListener(this);

		f.setSize(400, 400);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		// g.setColor(Color.green);
		g.drawOval(0, 0, 20, 20);
		drawmap(g);
		drawstart(g);
		drawexit(g);

		if (Global.LEVEL == 1) {

			drawenemy(g, E1);
			drawTreasure(g, Cash, 60, 120);// this is to set treasure place. 
			
			
			enemymovelogic(E1.x, E1.y);
			collison(E1, Hero);
		//	System.out.println("mmm");
		} else if(Global.LEVEL==2){
			
			
			
		}else if(Global.LEVEL==3){
			
			
			
		}else if(Global.LEVEL==4){
			
			
			
		}else if(Global.LEVEL==5){
			
			
			
		}else if(Global.LEVEL==6){
			
			
			
		}else if(Global.LEVEL==7){
			
			//E1=null;
			
		}else if(Global.LEVEL==8){
			
			
			
		}else if(Global.LEVEL==9){
			
			
			
		}else if(Global.LEVEL==10){
			
			
			
		}

		drawenemy(g, E1);
		
		drawcharacter(g);
	
	}

	public void drawstart(Graphics g) {
		ImageIcon start_ImageIcon = new ImageIcon("images/Exit.png");
		start_image = start_ImageIcon.getImage();
		g.drawImage(start_image, 0, 20, null);

	}

	public void drawexit(Graphics g) {
		ImageIcon exit_ImageIcon = new ImageIcon("images/Exit.png");
		exit_image = exit_ImageIcon.getImage();
		g.drawImage(exit_image, (Global.level_size - 1) * 20,
				(Global.level_size - 2) * 20, null);
		Global.grid[Global.level_size - 1][Global.level_size - 2] = Global.EXIT;

	}

	public void ChooseLevel() {
		if (Global.LEVEL == 1) {
			new Buildwallroom1();
		} else if (Global.LEVEL == 2) {
			new Buildwallroom2();
		} else if (Global.LEVEL == 3) {
			new Buildwallroom3();
		} else if (Global.LEVEL == 4) {
			new Buildwallroom4();
		} else if (Global.LEVEL == 5) {
			new Buildwallroom5();
		} else if (Global.LEVEL == 6) {
			new Buildwallroom6();
		} else if (Global.LEVEL == 7) {
			new Buildwallroom7();
		} else if (Global.LEVEL == 8) {
			new Buildwallroom8();
		} else if (Global.LEVEL == 9) {
			new Buildwallroom9();
		} else if (Global.LEVEL == 10) {
			new Buildwallroom10();
		}

	}

	public void drawmap(Graphics g) {

		ImageIcon wall_ImageIcon = new ImageIcon("images/wall24.png");
		ImageIcon road_ImageIcon = new ImageIcon("images/road24.png");
		wall_image = wall_ImageIcon.getImage();
		road_image = road_ImageIcon.getImage();

		ChooseLevel();

		for (int i = 0; i < Global.level_size; i++) {
			for (int j = 0; j < Global.level_size; j++) {
				if (Global.grid[i][j] == Global.WALL) {
					// g.drawRect(20, 20, 20, 20);
					g.drawImage(wall_image, i * 20, j * 20, null);

				} else if (Global.grid[i][j] == Global.ROAD) {

					g.drawImage(road_image, i * 20, j * 20, null);

				}

			}

		}

	}
public void setEnemy(Enemy e,int x, int y){
	e.x=x;
	e.y=y;
}
	public void drawenemy(Graphics g, Enemy E) {

		g.drawImage(E.poop_image, E.x, E.y, null);
	}
	public void drawTreasure(Graphics g, Treasure t, int x, int y) {
		t.x=x;
		t.y=y;
		
		g.drawImage(t.Treasure_image, x, y, null);
	}

	public void drawcharacter(Graphics g) {
		g.drawImage(Hero.octopus_image, Hero.x, Hero.y, null);

	}

	public void draw_wall(Graphics g, int x, int y) {
		g.drawImage(wall_image, x, y, null);

	}

	private JMenuItem makeMenuItem(String name) {

		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}

	public void collison(Enemy E, Charactermodel H) {
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {
		if(Global.Life>0){
			Global.Life--;
			menuLife.setText("Life: " + Global.Life);
		
		
			if (Global.Life <= 0) {
				System.out.println("Game Over");
			}
			else {				
				Hero.setPosition();// Go back to initialized position.
			}
		}
			
			System.out.println("Collision");

		}
	}

	public void enemymovelogic(int poopx, int poopy) {
		if (poopx < 0 || poopx > 380) {
			velx = -velx;

		}
		if (poopy < 0 || poopy > 380) {
			vely = -vely;
		}
		if (velx > 0
				&& Global.grid[(poopx + 20) / 20][poopy / 20] == Global.WALL) {
			/* It will turn back if collide with right wall. */
			velx = -velx;
			return;

		}
		if (velx < 0
				&& Global.grid[(poopx - 1) / 20][poopy / 20] == Global.WALL) {
			/* It will turn back if collide with left wall. */
			velx = -velx;
			return;
		}
		if (vely > 0
				&& Global.grid[poopx / 20][(poopy + 20) / 20] == Global.WALL) {
			/* It will turn back if collide with right wall. */
			vely = -vely;
			return;
		}
		//
		if (vely > 0
				&& Global.grid[poopx / 20][(poopy + -1) / 20] == Global.WALL) {
			/* It will turn back if collide with up wall. */
			vely = -vely;
			return;
		}

	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (Global.LEVEL == 1) {
			E1.x = E1.x + velx;
			
		//	System.out.println("mmm");
		} else if(Global.LEVEL==2){
			
			
			
		}else if(Global.LEVEL==3){
			
			
			
		}else if(Global.LEVEL==4){
			
			
			
		}else if(Global.LEVEL==5){
			
			
			
		}else if(Global.LEVEL==6){
			
			
			
		}else if(Global.LEVEL==7){
			
			//E1=null;
			
		}else if(Global.LEVEL==8){
			
			
			
		}else if(Global.LEVEL==9){
			
			
			
		}else if(Global.LEVEL==10){
			
			
			
		}

		//
		repaint();
	}

	public void start() {

	}

	public void stop() {

	}

	public void run() {
		// do stuff here
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		// e.getk
		if (Hero.x < 0) {
			Hero.x = 0;
		}
		if (Hero.y < 0) {
			Hero.y = 0;
		}
		// if (Hero.x > 400 || Hero.x < 0 || Hero.y > 400 || Hero.y < 0) {
		// return;
		// }
		if (c == KeyEvent.VK_LEFT) {
			if (Global.grid[(Hero.x - 1) / 20][(Hero.y + 8) / 20] != Global.WALL
					&& Global.grid[(Hero.x - 1) / 20][(Hero.y + 12) / 20] != Global.WALL)

			{
				Hero.y = ((Hero.y + 8) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.goleft();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;

			}

		}
		if (c == KeyEvent.VK_UP) {
			if (Global.grid[(Hero.x + 6) / 20][(Hero.y - 1) / 20] != Global.WALL
					&& Global.grid[(Hero.x + 14) / 20][(Hero.y - 1) / 20] != Global.WALL) {
				// if(!(octopus % 20==0) )

				Hero.x = ((Hero.x + 6) / 20) * 20;

				Hero.goup();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					// Hero.x = Hero.x + Global.Global.movex;
					Hero.y = Hero.y - Global.movey;
			}

		}
		if (c == KeyEvent.VK_RIGHT) {

			// System.out.println(Hero.x+" ssssssss  "+Hero.y);
			if (Global.grid[(Hero.x) / 20 + 1][(Hero.y + 6) / 20] != Global.WALL
					&& Global.grid[Hero.x / 20 + 1][(Hero.y + 14) / 20] != Global.WALL) {
				Hero.y = ((Hero.y + 6) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.goright();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.EXIT) {
					Global.LEVEL++;
					Hero.setPosition();
					Global.Score=Global.Score+25-Global.difficulty;
					menuScore1.setText("Score: "+Global.Score);
					
					
					
					if (Global.LEVEL > 10) {
						System.out.println("Game Over");

					}
				}

			}
		}
		if (c == KeyEvent.VK_DOWN) {
			if (Global.grid[(Hero.x + 6) / 20][(Hero.y) / 20 + 1] != Global.WALL
					&& Global.grid[(Hero.x + 14) / 20][Hero.y / 20 + 1] != Global.WALL)

			{

				Hero.x = ((Hero.x + 6) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.godown();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// Global.Global.movex = 0;
		// Global.movey = 0;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] agrs) {

		MainFrame f = new MainFrame();

	}

}