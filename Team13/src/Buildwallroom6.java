
public class Buildwallroom6 {
public Buildwallroom6(){
	Global.grid = new int[Global.GridWid][Global.GridHig];
	Global.level_size = 16;
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

	setwall(6, 1);
	setwall(12, 1);
	setwall(2, 2);
	setwall(3, 2);
	setwall(4, 2);
	setwall(6, 2);
	setwall(8, 2);
	setwall(9, 2);
	setwall(10, 2);
	setwall(11, 2);
	setwall(12, 2);
	setwall(14, 2);
	setwall(4, 3);
	setwall(6, 3);
	setwall(8, 3);
	setwall(1, 4);
	setwall(2, 4);
	setwall(3, 4);
	setwall(4, 4);
	setwall(6, 4);
	setwall(8, 4);
	setwall(9, 4);
	setwall(11, 4);
	setwall(12, 4);
	setwall(13, 4);
	setwall(14, 4);
	setwall(6, 5);
	setwall(11, 5);
	setwall(2, 6);
	setwall(3, 6);
	setwall(4, 6);
	setwall(5, 6);
	setwall(6, 6);
	setwall(8, 6);
	setwall(9, 6);
	setwall(10, 6);
	setwall(11, 6);
	setwall(13, 6);
	setwall(14, 6);
	setwall(2, 7);
	setwall(11, 7);
	setwall(2, 8);
	setwall(4, 8);
	setwall(5, 8);
	setwall(6, 8);
	setwall(7, 8);
	setwall(8, 8);
	setwall(9, 8);
	setwall(11, 8);
	setwall(13, 8);
	setwall(14, 8);
	setwall(2, 9);
	setwall(4, 9);
	setwall(7, 9);
	setwall(9, 9);
	setwall(11, 9);
	setwall(13, 9);
	setwall(2, 10);
	setwall(4, 10);
	setwall(6, 10);
	setwall(7, 10);
	setwall(9, 10);
	setwall(11, 10);
	setwall(2, 11);
	setwall(4, 11);
	setwall(9, 11);
	setwall(11, 11);
	setwall(13, 11);
	setwall(4, 12);
	setwall(7, 12);
	setwall(11, 12);
	setwall(13, 12);
	setwall(2, 13);
	setwall(3, 13);
	setwall(4, 13);
	setwall(6, 13);
	setwall(7, 13);
	setwall(9, 13);
	setwall(10, 13);
	setwall(11, 13);
	setwall(12, 13);
	setwall(13, 13);
	setwall(2, 14);
	setwall(6, 14);
		
	}public void setwall(int x, int y) {
		Global.grid[x][y] = Global.WALL;
	}
}
