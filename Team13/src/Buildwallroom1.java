
public class Buildwallroom1 {
	
public Buildwallroom1( ){
	Global.grid = new int[Global.GridWid][Global.GridHig];

	Global.level_size = 12;

	for (int i = 0; i < Global.level_size; i++) {
		setwall(i, 0);
		setwall(i, Global.level_size - 1);
	}
	for (int j = 0; j < Global.level_size; j++) {
		if (j != 1)
			setwall(0, j);
		if (j != Global.level_size - 2)
			setwall(Global.level_size - 1, j);
	}

	setwall(2, 2);
	setwall(2, 3);
	setwall(2, 4);
	setwall(2, 5);
	setwall(2, 7);
	setwall(2, 8);
	setwall(2, 9);
	setwall(3, 2);
	setwall(4, 2);
	setwall(4, 4);
	setwall(4, 6);
	setwall(4, 7);
	setwall(4, 9);
	setwall(4, 10);
	setwall(5, 2);
	setwall(5, 4);
	setwall(5, 6);
	setwall(6, 2);
	setwall(6, 4);
	setwall(6, 6);
	setwall(6, 8);
	setwall(6, 9);
	setwall(6, 10);
	setwall(7, 4);
	setwall(7, 6);
	setwall(8, 2);
	setwall(8, 4);
	setwall(8, 6);
	setwall(8, 8);
	setwall(9, 8);
	setwall(9, 9);
	setwall(9, 10);
	setwall(10, 2);
	setwall(10, 3);
	setwall(10, 4);
	setwall(10, 6);
	
}
public void setwall(int x, int y) {
	Global.grid[x][y] = Global.WALL;
}
	
	
}
