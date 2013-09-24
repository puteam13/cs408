
public class Buildwallroom2 {
public Buildwallroom2(){
	Global.grid=new int [Global.GridWid][Global.GridHig];
	Global.level_size = 12;
	for (int i = 0; i < Global.level_size; i++) {
		setwall(i,Global.level_size - 1);
	}
	for (int j = 0; j < Global.level_size; j++) {
		if (j != 1)
			setwall(0, j);
		if (j != Global.level_size - 2)
			setwall(Global.level_size - 1, j);
	}

	setwall(1, 2);
	setwall(1, 4);
	setwall(1, 6);
	setwall(1, 8);
	setwall(1, 9);
	setwall(1, 10);
	setwall(2, 2);
	setwall(2, 6);
	setwall(3, 2);
	setwall(3, 4);
	setwall(3, 8);
	setwall(3, 10);
	setwall(4, 2);
	setwall(4, 6);
	setwall(5, 4);
	setwall(5, 6);
	setwall(5, 8);
	setwall(5, 9);
	setwall(5, 10);
	setwall(6, 2);
	setwall(6, 4);
	setwall(7, 2);
	setwall(7, 4);
	setwall(7, 6);
	setwall(7, 8);
	setwall(7, 10);
	setwall(8, 4);
	setwall(9, 2);
	setwall(9, 6);
	setwall(9, 8);
	setwall(9, 9);
	setwall(9, 10);
	setwall(10, 2);
	setwall(10, 4);
	setwall(10, 6);
	
	
}

public void setwall(int x, int y) {
	Global.grid[x][y] = Global.WALL;
}
	
}
