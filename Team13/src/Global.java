import javax.swing.JMenu;

public class Global {
	public static int UP = 1;
	public static int DOWN = 2;
	public static int LEFT = 3;
	public static int RIGHT = 4;
	public static int GridWid = 20;
	public static int GridHig = 20;
	public static int WALL = 1;
	public static int ROAD = 0;
	public static int Width = 20;
	public static int Hight = 20;
	public static int Hard = 10;
	public static int Medium = 15;
	public static int Easy = 20;
	public static int level_size = 0;
	public static int grid[][];
	public static int movex = 0;
	public static int movey = 0;
	public static int difficulty = Easy;
	public static int LEVEL = 1;
	public static int EXIT = 2;
	public static int Life = 3;
	public static int maxHealth = 300;
	public static int currHealth = 300;
	public static int Score = 0;
	public static int cash = 20;
	public static int door = 15;
	public static int picked = 0;
	public static int picked_door = 0;
	public static int fightResult = 0;
	public static boolean inFight = false;
	public static boolean test = false;
	public static Charactermodel Hero = new Charactermodel();

	public static JMenu maxhealth = new JMenu("Max Health: 200");
	public static JMenu currentHealth = new JMenu("Current Health: 200");
}
