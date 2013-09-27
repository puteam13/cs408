import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MainFrame extends JPanel implements ActionListener, KeyListener,
		MouseListener {

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

	// int Global.difficulty;
	Enemy E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15,
			E16, E17, E18, E19, E20, E21, E22, E23, E24, E25, E26, E27, E28,
			E29, E30, E31, E32, E33, E34, E35, E36, E37, E38;
	//Charactermodel Global.Hero;
	// int velx = 1, vely = 1;
	User user;
	Treasure Cash, Cash2, Cash3, Cash4, Cash5, Cash6, Cash7, Cash8, Cash9,
			Cash10;
	Door door1, door2, door3, door4, door5, door6, door7, door8, door9, door10;
	JFrame frame;

	// int Global.Hero.x = 20, Global.Hero.y = 100;

	public MainFrame(User User, JFrame frame) {
		this.user = User;
		this.frame = frame;

		frameLayout();

		E1 = new Enemy(60, 120); // level 1, up-down
		E2 = new Enemy(180, 120); // level 1, up-down
		E3 = new Enemy(140, 60); // level 2, left-right
		E4 = new Enemy(180, 100); // level 2, left-right
		E5 = new Enemy(0, 180); // level 2, left-right
		E6 = new Enemy(60, 180); // level 3, up-down
		E7 = new Enemy(200, 120); // level 3, up-down
		E8 = new Enemy(120, 60); // level 3, left-right
		E9 = new Enemy(100, 100); // level 4, left-right
		E10 = new Enemy(140, 140); // level 4, left-right
		E11 = new Enemy(240, 220); // level 4, up-down
		E12 = new Enemy(60, 160); // level 5, up-down
		E13 = new Enemy(100, 160); // level 5, up-down
		E14 = new Enemy(160, 60); // level 5, left-right
		E15 = new Enemy(160, 100); // level 5, left-right
		E16 = new Enemy(160, 220); // level 5, left-right
		E17 = new Enemy(100, 100); // level 6, left-right
		E18 = new Enemy(60, 240); // level 6, left-right
		E19 = new Enemy(280, 240); // level 6, up-down
		E20 = new Enemy(160, 280); // level 6, left-right
		E21 = new Enemy(60, 140); // level 7, up-down
		E22 = new Enemy(260, 120); // level 7, left-right
		E23 = new Enemy(80, 240); // level 7, left-right
		E24 = new Enemy(240, 220); // level 7, up-down
		E25 = new Enemy(60, 160); // level 8, up-down
		E26 = new Enemy(120, 240); // level 8, up-down
		E27 = new Enemy(160, 200); // level 8, up-down
		E28 = new Enemy(320, 240); // level 8, up-down
		E29 = new Enemy(320, 80); // level 8, up-down
		E30 = new Enemy(200, 20); // level 9, left-right
		E31 = new Enemy(180, 160); // level 9, left-right
		E32 = new Enemy(60, 320); // level 9, left-right
		E33 = new Enemy(200, 280); // level 9, up-down
		E34 = new Enemy(360, 240); // level 9, up-down
		E35 = new Enemy(20, 160); // level 10, up-down
		E36 = new Enemy(160, 120); // level 10, left-right
		E37 = new Enemy(200, 340); // level 10, left-right
		E38 = new Enemy(300, 140); // level 10, up-down

		Cash = new Treasure(140, 180);
		Cash2 = new Treasure(0, 180);
		Cash3 = new Treasure(140, 140);
		Cash4 = new Treasure(100, 120);
		Cash5 = new Treasure(160, 160);
		Cash6 = new Treasure(60, 280);
		Cash7 = new Treasure(140, 320);
		Cash8 = new Treasure(160, 300);
		Cash9 = new Treasure(120, 360);
		Cash10 = new Treasure(240, 160);

		door1 = new Door(100, 120);
		door2 = new Door(100, 120);
		door3 = new Door(100, 120);
		door4 = new Door(100, 120);
		door5 = new Door(100, 120);
		door6 = new Door(100, 120);
		door7 = new Door(100, 120);
		door8 = new Door(100, 120);
		door9 = new Door(100, 120);
		door10 = new Door(100, 120);

		// setEnemy(E1,60, 120);

		// System.out.println("mmmm");
	//	Global.Hero = new Charactermodel();

		// Global.difficulty = 10;
		Global.LEVEL = 1;
		t = new Timer( 20, this);
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
		
		Menub.add(menuRestart);
		Menub.add(menuBack);
		Menub.add(menuScore1);
		Menub.add(menuExit);
		Menub.add(menuLife);
		Menub.add(menuScore1);
		Menub.add(Global.currentHealth);
		Menub.add(Global.maxhealth);
		menuRestart.addMouseListener(this);
		menuBack.addMouseListener(this);
		menuScore.addMouseListener(this);
		menuExit.addMouseListener(this);
		menuLife.setEnabled(false);
		menuScore1.setEnabled(false);

		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setJMenuBar(Menub);

		f.add(this);

		f.setVisible(true);
		f.addKeyListener(this);
		f.setLocationRelativeTo(null);

		// f.setSize(400, 400);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		// g.setColor(Color.green);
		g.drawOval(0, 0, 20, 20);
		// g.drawRoundRect(100, 10, 80, 30, 15, 15);
	//	g.drawImage(E1.poop_image, 0, 20, null);
	//	drawDoor(g, door1, 20, 0);
		drawmap(g);
		drawstart(g);
		drawexit(g);

		if (Global.LEVEL == 1) {
			
			drawenemy(g, E1);
			drawenemy(g, E2);
			enemymovelogic(E1);
			enemymovelogic(E2);
			// System.out.println(E2.y);

			if (Global.picked == 0) {
				PickCash(Cash, Global.Hero);
				drawTreasure(g, Cash, 160, 200);// this is to set treasure
				// place.
			}// enemymovelogic(E1.x, E1.y);
			if (Global.picked_door == 0) {
				//PickDoor(door1, Global.Hero);
				drawDoor(g, door1, 80, 160);
			}
			collision(E2, Global.Hero);
			collision(E1, Global.Hero);
			// System.out.println("mmm");
		} else if (Global.LEVEL == 2) {
			drawenemy(g, E3);
			drawenemy(g, E4);
			drawenemy(g, E5);
		//	enemymovelogic(E3);
			//enemymovelogic(E5);

			collision(E3, Global.Hero);
			collision(E4, Global.Hero);
			collision(E5, Global.Hero);
			// collision(E3, Global.Hero);
			if (Global.picked == 0) {
				PickCash(Cash2, Global.Hero);
				drawTreasure(g, Cash2, 0, 200);
			}
			if (Global.picked_door == 0) {
				PickDoor(door2, Global.Hero);
				drawDoor(g, door2, 160, 120);
			}

		} else if (Global.LEVEL == 3) {
			drawenemy(g, E6);
			drawenemy(g, E7);
			drawenemy(g, E8);
			enemymovelogic(E6);
			enemymovelogic(E7);
			enemymovelogic(E8);

			collision(E6, Global.Hero);
			collision(E7, Global.Hero);
			//collision(E8, Global.Hero);
			if (Global.picked == 0) {
				PickCash(Cash3, Global.Hero);
				drawTreasure(g, Cash3, 140, 140);
			}
			if (Global.picked_door == 0) {
				PickDoor(door3, Global.Hero);
				drawDoor(g, door3, 40, 120);
			}
		} else if (Global.LEVEL == 4) {
			drawenemy(g, E9);
			drawenemy(g, E10);
			drawenemy(g, E11);
			//enemymovelogic(E9);
			enemymovelogic(E10);
			enemymovelogic(E11);

			collision(E9, Global.Hero);
			collision(E10, Global.Hero);
			collision(E11, Global.Hero);
			if (Global.picked_door == 0) {
				PickDoor(door4, Global.Hero);
				drawDoor(g, door4, 40, 180);
			}
			if (Global.picked == 0) {
				PickCash(Cash4, Global.Hero);
				drawTreasure(g, Cash4, 100, 120);
			}
		} else if (Global.LEVEL == 5) {
			drawenemy(g, E12);
			drawenemy(g, E13);
			drawenemy(g, E14);
			drawenemy(g, E15);
			drawenemy(g, E16);
			enemymovelogic(E12);
			enemymovelogic(E13);
			enemymovelogic(E14);
			enemymovelogic(E15);
			enemymovelogic(E16);

			collision(E12, Global.Hero);
			collision(E13, Global.Hero);
			collision(E14, Global.Hero);
			collision(E15, Global.Hero);
			collision(E16, Global.Hero);
			if (Global.picked_door == 0) {
				PickDoor(door5, Global.Hero);
				drawDoor(g, door5, 280, 80);
			}
			if (Global.picked == 0) {
				PickCash(Cash5, Global.Hero);
				drawTreasure(g, Cash5, 160, 160);
			}
		} else if (Global.LEVEL == 6) {
			drawenemy(g, E17);
			drawenemy(g, E18);
			drawenemy(g, E19);
			drawenemy(g, E20);
			enemymovelogic(E17);
			enemymovelogic(E18);
			enemymovelogic(E19);
			enemymovelogic(E20);

			collision(E17, Global.Hero);
			collision(E18, Global.Hero);
			collision(E19, Global.Hero);
			collision(E20, Global.Hero);
			if (Global.picked_door == 0) {
				PickDoor(door6, Global.Hero);
				drawDoor(g, door6, 100, 260);
			}
			if (Global.picked == 0) {
				PickCash(Cash6, Global.Hero);
				drawTreasure(g, Cash6, 60, 280);
			}
		} else if (Global.LEVEL == 7) {
			drawenemy(g, E21);
			drawenemy(g, E22);
			drawenemy(g, E23);
			drawenemy(g, E24);
			enemymovelogic(E21);
			enemymovelogic(E22);
			enemymovelogic(E23);
			enemymovelogic(E24);

			collision(E21, Global.Hero);
			collision(E22, Global.Hero);
			collision(E23, Global.Hero);
			collision(E24, Global.Hero);
			if (Global.picked_door == 0) {
				PickDoor(door7, Global.Hero);
				drawDoor(g, door7, 100, 280);
			}
			if (Global.picked == 0) {
				PickCash(Cash7, Global.Hero);
				drawTreasure(g, Cash7, 140, 320);
			}
		} else if (Global.LEVEL == 8) {
			drawenemy(g, E25);
			drawenemy(g, E26);
			drawenemy(g, E27);
			drawenemy(g, E28);
			drawenemy(g, E29);
			enemymovelogic(E25);
			enemymovelogic(E26);
			enemymovelogic(E27);
			enemymovelogic(E28);
			enemymovelogic(E29);

			collision(E25, Global.Hero);
			collision(E26, Global.Hero);
			collision(E27, Global.Hero);
			collision(E28, Global.Hero);
			collision(E29, Global.Hero);

			if (Global.picked_door == 0) {
				PickDoor(door8, Global.Hero);
				drawDoor(g, door8, 160, 60);
			}

		//	if (Global.picked == 0) {
				PickCash(Cash8, Global.Hero);
				drawTreasure(g, Cash8, 160, 320);
		//	}
		} else if (Global.LEVEL == 9) {
			drawenemy(g, E30);
			drawenemy(g, E31);
			drawenemy(g, E32);
			// drawenemy(g, E33);
			drawenemy(g, E34);
			enemymovelogic(E30);
			enemymovelogic(E31);
			enemymovelogic(E32);
			enemymovelogic(E33);
			enemymovelogic(E34);

			collision(E30, Global.Hero);
			collision(E31, Global.Hero);
			collision(E32, Global.Hero);
			collision(E33, Global.Hero);
			collision(E34, Global.Hero);
			//if (Global.picked_door == 0) {
				PickDoor(door9, Global.Hero);
				drawDoor(g, door9, 220, 280);
			//}
			if (Global.picked == 0) {
				PickCash(Cash9, Global.Hero);
				drawTreasure(g, Cash9, 120, 360);
			}
		} else if (Global.LEVEL == 10) {
			drawenemy(g, E35);
			drawenemy(g, E36);
			drawenemy(g, E37);
			drawenemy(g, E38);
			enemymovelogic(E35);
			enemymovelogic(E36);
			enemymovelogic(E37);
			enemymovelogic(E38);

			collision(E35, Global.Hero);
			collision(E36, Global.Hero);
			collision(E37, Global.Hero);
			collision(E38, Global.Hero);
			if (Global.picked_door == 0) {
				PickDoor(door10, Global.Hero);
			//	drawDoor(g, door10, 100, 220);
			}
			if (Global.picked == 0) {
				PickCash(Cash10, Global.Hero);
			//	drawTreasure(g, Cash10, 240, 160);
			}
		}

		// drawenemy(g, E1);
		//repaint();

		drawcharacter(g);

	}

	public void drawstart(Graphics g) {
		ImageIcon start_ImageIcon = new ImageIcon(getClass().getResource("exit.png"));
		start_image = start_ImageIcon.getImage();
		g.drawImage(start_image, 0, 20, null);

	}

	public void drawexit(Graphics g) {
		ImageIcon exit_ImageIcon = new ImageIcon(getClass().getResource("exit.png"));
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

		ImageIcon wall_ImageIcon = new ImageIcon(getClass().getResource("wall24.png"));
		ImageIcon road_ImageIcon = new ImageIcon(getClass().getResource("road24.png"));
		wall_image = wall_ImageIcon.getImage();
		road_image = road_ImageIcon.getImage();

		ChooseLevel();

		for (int i = 0; i < Global.level_size; i++) {
			for (int j = 0; j < Global.level_size; j++) {
				if (Global.grid[i][j] == Global.WALL) {
					// g.drawRect(20, 20, 20, 20);
					if((i!=9||j!=9)){
					g.drawImage(wall_image, i * 20, j * 20, null);
					}
				} else if (Global.grid[i][j] == Global.ROAD) {

					g.drawImage(road_image, i * 20, j * 20, null);

				}

			}

		}

	}

	public void setEnemy(Enemy e, int x, int y) {
		e.x = x;
		e.y = y;
	}

	public void drawenemy(Graphics g, Enemy E) {
		if(E.isAlive() == true){
			g.drawImage(E.poop_image, E.x, E.y, null);
		}
	}

	public void drawTreasure(Graphics g, Treasure t, int x, int y) {
		t.x = x;
		t.y = y;

		g.drawImage(t.Treasure_image, x, y, null);
	}

	public void drawDoor(Graphics g, Door d, int x, int y) {
		d.x = x;
		d.y = y;

		g.drawImage(d.Door_image, x, y, null);
	}

	public void drawcharacter(Graphics g) {
		g.drawImage(Global.Hero.octopus_image, Global.Hero.x, Global.Hero.y, null);

	}

	public void draw_wall(Graphics g, int x, int y) {
		g.drawImage(wall_image, x, y, null);

	}

	private JMenuItem makeMenuItem(String name) {

		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}

	public void PickCash(Treasure E, Charactermodel H) {
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {

			// System.out.println("~~~");
			Global.Score = Global.Score + 30;//Global.Score = Global.Score + Global.cash;
			Global.maxHealth = Global.maxHealth + 100;
			Global.maxhealth.setText("Max Health: " + Global.maxHealth);
			Global.currentHealth.setText("Current Health: " + Global.currHealth);
			// E=null;
			menuScore1.setText("Score: " + Global.Score);
			Global.picked = 1;

			// System.out.println("Collision");

		}
	}

	public void PickDoor(Door E, Charactermodel H) {
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {

			// System.out.println("~~~");
		if(Global.LEVEL!=4)	Global.Score = Global.Score - Global.door;   //here is a bug
		//	if (Global.Score < 0) {
		//		Global.Score = 0;            //here should be noncomment.
		//	}
			// E=null;
			menuScore1.setText("Score: " + Global.Score);
			Global.picked_door = 1;
			// System.out.println("Collision");

		}
	}

	public void collision(Enemy E, Charactermodel H) {
	
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {
			if (Global.Life > 0) {
				
				if(Global.inFight == false){
					
					BattleWindow fight = new BattleWindow(E);
					if(Global.LEVEL!=8){
					Global.inFight = true;
					}
				}
				/*while(Global.inFight == true){
					//pause game
				}*/
				}
				if (Global.currHealth <= 0){
					Global.Life--;
					reviveEnemies();
					Global.Hero.setPosition();
					Global.currHealth = Global.maxHealth;
				}
				menuLife.setText("Life: " + Global.Life);

				if (Global.Life <= 0) {
					System.out.println("Game Over");

					user.currScore = Global.Score;
					user.saveScoreToDatabase();
				} else {
					//Global.Hero.setPosition();// Go back to initialized position.
				}
			}

		//	System.out.println("Collision");

		}
	
	
	void returnHero()
	{
		Global.Hero.setPosition();
	}

	public void enemymovelogic(Enemy E) {
		if(E.isAlive() == true){
			if (E.x < 0 || E.x > (Global.level_size - 2) * 20) {
				E.velx = -E.velx;

			}
			if ( E.y > (Global.level_size - 1) * 20) {
				E.vely = -E.vely;
			}
			if (E.velx > 0 && Global.grid[(E.x + 20) / 20][E.y / 20] == Global.WALL) {
				/* It will turn back if collide with right wall. */
				E.velx = -E.velx;
				return;

			}
			if (E.velx < 0 && Global.grid[(E.x - 1) / 20][E.y / 20] == Global.WALL) {
				/* It will turn back if collide with left wall. */
				E.velx = -E.velx;
				// System.out.println("@@@@"+E.x);
				return;
			}
			if (E.vely > 0 && Global.grid[E.x / 20][(E.y + 20) / 20] == Global.WALL) {
				// System.out.println("mmm");
				/* It will turn back if collide with right wall. */
				E.vely = -E.vely;
				return;
			}
			//
			if (E.vely < 0
					&& (Global.grid[E.x / 20][(E.y - 1) / 20] == Global.WALL)) {
				/* It will turn back if collide with up wall. */
				// System.out.println("sss"+E.y);
				// System.out.println("mmmnnn"+E.x / 20+"ffff"+(E.y - 2) / 20);
				E.vely = -E.vely;
				return;
			}
		}

	}

	public void actionPerformed(ActionEvent e) {

		if (Global.LEVEL == 1) {
			E1.y = E1.y + E1.vely;
			E2.y = E2.y + E2.vely;
			// System.out.println("mmm");
		} else if (Global.LEVEL == 2) {
			E3.x = E3.x + E3.velx;
			//E4.x = E4.x + E4.velx;
			E5.x = E5.x + E5.velx;

		} else if (Global.LEVEL == 3) {
			E6.y = E6.y + E6.vely;
			E7.y = E7.y + E7.vely;
			E8.x = E8.x + E8.velx;

		} else if (Global.LEVEL == 4) {
			E9.x = E9.x + E9.velx;
			E10.x = E10.x + E10.velx;
			E11.y = E11.y + E11.vely;

		} else if (Global.LEVEL == 5) {
			E12.y = E12.y + E12.vely;
			E13.y = E13.y + E13.vely;
			E14.x = E14.x + E14.velx;
			E15.x = E15.x + E15.velx;
			E16.x = E16.x + E16.velx;

		} else if (Global.LEVEL == 6) {
			E17.x = E17.x + E17.velx;
			E18.y = E18.y + E18.vely;
			E19.y = E19.y + E19.vely;
			E20.x = E20.x + E20.velx;

		} else if (Global.LEVEL == 7) {
			E21.y = E21.y + E21.vely;
			E22.x = E22.x + E22.velx;
			E23.x = E23.x + E23.velx;
			E24.y = E24.y + E24.vely;

		} else if (Global.LEVEL == 8) {
			E25.y = E25.y + E25.vely;
			E26.y = E26.y + E26.vely;
			E27.y = E27.y + E27.vely;
			E28.y = E28.y + E28.vely;
			E29.y = E29.y + E29.vely;

		} else if (Global.LEVEL == 9) {
			E30.x = E30.x + E30.velx;
			E31.x = E31.x + E31.velx;
			E32.x = E32.x + E32.velx;
			E33.y = E33.y + E33.vely;
			E34.y = E34.y + E34.vely;

		} else if (Global.LEVEL == 10) {
			E35.y = E35.y + E35.vely;
			E36.x = E36.x + E36.velx;
			E37.x = E37.x + E37.velx;
			E38.y = E38.y + E38.vely;

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
	public void reviveEnemies(){
		E1.revive();
		E2.revive();
		E3.revive();
		E4.revive();
		E5.revive();
		E6.revive();
		E7.revive();
		E8.revive();
		E9.revive();
		E10.revive();
		E11.revive();
		E12.revive();
		E13.revive();
		E14.revive();
		E15.revive();
		E16.revive();
		E17.revive();
		E18.revive();
		E19.revive();

		E21.revive();
		E22.revive();
		E23.revive();
		E24.revive();
		E25.revive();
		E26.revive();

		//E28.revive();
		E29.revive();
		E31.revive();
		E32.revive();
		E33.revive();
		E34.revive();
		E35.revive();
		E36.revive();
		E37.revive();
		E38.revive();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		// e.getk
		if (Global.Hero.x < 0) {
			//Global.Hero.x = 0;
		}
		if (Global.Hero.y < 0) {
			Global.Hero.y = 0;
		}
		// if (Global.Hero.x > 400 || Global.Hero.x < 0 || Global.Hero.y > 400 || Global.Hero.y < 0) {
		// return;
		// }
		if (c == KeyEvent.VK_LEFT) {
			if (Global.grid[(Global.Hero.x - 1) / 20][(Global.Hero.y + 8) / 20] != Global.WALL
					&& Global.grid[(Global.Hero.x - 1) / 20][(Global.Hero.y + 12) / 20] != Global.WALL)

			{
				Global.Hero.y = ((Global.Hero.y + 8) / 20) * 20;
				// System.out.println(Global.Hero.y);

				Global.Hero.goleft();
				if (Global.grid[Global.Hero.x / 20][Global.Hero.y / 20] == Global.WALL)
					Global.Hero.x = Global.Hero.x - Global.movex;

			}

		}
		if (c == KeyEvent.VK_UP) {
			if (Global.grid[(Global.Hero.x + 6) / 20][(Global.Hero.y - 1) / 20] != Global.WALL
					&& Global.grid[(Global.Hero.x + 14) / 20][(Global.Hero.y - 1) / 20] != Global.WALL) {
				// if(!(octopus % 20==0) )

				Global.Hero.x = ((Global.Hero.x + 6) / 20) * 20;

				Global.Hero.goup();
				if (Global.grid[Global.Hero.x / 20][Global.Hero.y / 20] == Global.WALL)
					// Global.Hero.x = Global.Hero.x + Global.Global.movex;
					Global.Hero.y = Global.Hero.y - Global.movey;
			}

		}
		if (c == KeyEvent.VK_RIGHT) {

			// System.out.println(Global.Hero.x+" ssssssss  "+Global.Hero.y);
			if (Global.grid[(Global.Hero.x) / 20 + 1][(Global.Hero.y + 6) / 20] != Global.WALL
					&& Global.grid[Global.Hero.x / 20 + 1][(Global.Hero.y + 14) / 20] != Global.WALL) {
				Global.Hero.y = ((Global.Hero.y + 6) / 20) * 20;
				// System.out.println(Global.Hero.y);

				Global.Hero.goright();
				if (Global.grid[Global.Hero.x / 20][Global.Hero.y / 20] == Global.WALL)
					Global.Hero.x = Global.Hero.x - Global.movex;
				if (Global.grid[Global.Hero.x / 20][Global.Hero.y / 20] == Global.EXIT) {
					Global.currHealth = Global.maxHealth;
					Global.LEVEL++;
					Global.picked = 0;
					Global.picked_door = 0;
					if(Global.LEVEL!=9){       					  //bug is here
					Global.Hero.setPosition();
					}
					Global.Score = Global.Score + 25;//  Global.Score = Global.Score + 25 - Global.difficulty;
					menuScore1.setText("Score: " + Global.Score);

					if (Global.LEVEL > 10) {
						System.out.println("Game Over");
						/*JOptionPane.showMessageDialog(null,
								"Congratulations!Your final score is "
										+ Global.Score, "You Win!",
								JOptionPane.INFORMATION_MESSAGE);*/
						Global.LEVEL = 0;

					//	user.currScore = Global.Score;
					//	user.saveScoreToDatabase();

					//	f.dispose();
						frame.setVisible(true);
					//	Global.Score = 0;
					}
				}

			}
		}
		if (c == KeyEvent.VK_DOWN) {
			if (Global.grid[(Global.Hero.x + 6) / 20][(Global.Hero.y) / 20 + 1] != Global.WALL
					&& Global.grid[(Global.Hero.x + 14) / 20][Global.Hero.y / 20 + 1] != Global.WALL)

			{

				Global.Hero.x = ((Global.Hero.x + 6) / 20) * 20;
				// System.out.println(Global.Hero.y);

				Global.Hero.godown();
				if (Global.grid[Global.Hero.x / 20][Global.Hero.y / 20] == Global.WALL)
					Global.Hero.x = Global.Hero.x - Global.movex;

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

	//public static void main(String[] agrs) {
	//	User User = null;
	//JFrame F = null;
	//	MainFrame f = new MainFrame(User, F);
//
	//}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == menuBack) {
			// System.out.println("menuBack");
			frame.setVisible(true);
			user.currScore = Global.Score;
			user.saveScoreToDatabase();
			f.dispose();
			//f.setVisible(false);
			Global.Score = 0;

		} else if (arg0.getSource() == menuScore) {

			System.out.println("menuScore");

		} else if (arg0.getSource() == menuExit) {

			System.out.println("menuExit");
			String message = " Really Quit ? ";
			String title = "Quit";

			int reply = JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {

				user.currScore = Global.Score;
				user.saveScoreToDatabase();
				System.exit(0);
			}

		} else if (arg0.getSource() == menuRestart) {
			if(Global.LEVEL!=9){
			Global.Hero.setPosition();
			//System.out.println("menuRestart");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}