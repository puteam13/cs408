
public class Buildwallroom5 {
public Buildwallroom5(){
	Global.grid = new int[Global.GridWid][Global.GridHig];
	Global.level_size = 17;
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
	setwall(2, 6);
	setwall(2, 7);
	setwall(2, 9);
	setwall(2, 10);
	setwall(2, 11);
	setwall(2, 12);
	setwall(2, 13);
	setwall(2, 14);
	setwall(3, 2);
	setwall(3, 14);
	setwall(4, 2);
	setwall(4, 4);
	setwall(4, 5);
	setwall(4, 6);
	setwall(4, 7);
	setwall(4, 9);
	setwall(4, 10);
	setwall(4, 12);
	setwall(5, 2);
	setwall(5, 4);
	setwall(5, 12);
	setwall(5, 14);
	setwall(5, 15);
	setwall(6, 2);
	setwall(6, 4);
	setwall(6, 6);
	setwall(6, 7);
	setwall(6, 9);
	setwall(6, 10);
	setwall(6, 12);
	setwall(6, 14);
	setwall(6, 15);
	setwall(7, 2);
	setwall(7, 4);
	setwall(7, 6);
	setwall(7, 10);
	setwall(7, 12);
	setwall(7, 14);
	setwall(7, 15);
	setwall(8, 10);
	setwall(8, 12);
	setwall(9, 2);
	setwall(9, 4);
	setwall(9, 6);
	setwall(9, 12);
	setwall(9, 13);
	setwall(9, 14);
	setwall(10, 2);
	setwall(10, 4);
	setwall(10, 6);
	setwall(10, 7);
	setwall(10, 8);
	setwall(10, 10);
	setwall(10, 12);
	setwall(10, 13);
	setwall(10, 14);
	setwall(11, 2);
	setwall(11, 12);
	setwall(11, 13);
	setwall(11, 14);
	setwall(12, 2);
	setwall(12, 4);
	setwall(12, 5);
	setwall(12, 6);
	setwall(12, 7);
	setwall(12, 8);
	setwall(12, 9);
	setwall(12, 10);
	setwall(12, 11);
	setwall(12, 12);
	setwall(13, 2);
	setwall(13, 9);
	setwall(13, 10);
	setwall(13, 11);
	setwall(13, 14);
	setwall(13, 15);
	setwall(14, 2);
	setwall(14, 3);
	setwall(14, 5);
	setwall(14, 6);
	setwall(14, 7);
	setwall(14, 9);
	setwall(14, 10);
	setwall(14, 11);
	setwall(15, 5);
	setwall(15, 6);
	setwall(15, 7);
	setwall(15, 13);
	setwall(15, 14);
		
		
	}public void setwall(int x, int y) {
		Global.grid[x][y] = Global.WALL;
	}
}
