
public class Buildwallroom10 {
public Buildwallroom10(){
	Global.grid = new int[Global.GridWid][Global.GridHig];
	Global.level_size = 20;
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
	setwall(2, 1);
	setwall(12, 1);
	setwall(2, 2);
	setwall(4, 2);
	setwall(5, 2);
	setwall(6, 2);
	setwall(7, 2);
	setwall(8, 2);
	setwall(10, 2);
	setwall(11, 2);
	setwall(12, 2);
	setwall(14, 2);
	//setwall(15, 2);
	setwall(16, 2);
	setwall(17, 2);
	setwall(2, 3);
	setwall(3, 3);
	setwall(4, 3);
	setwall(6, 3);
	setwall(10, 3);
	setwall(12, 3);
	setwall(14, 3);
	setwall(16, 3);
	setwall(17, 3);
	setwall(2, 4);
	setwall(6, 4);
	setwall(7, 4);
	setwall(8, 4);
	setwall(10, 4);
	setwall(12, 4);
	setwall(14, 4);
	setwall(16, 4);
	setwall(17, 4);
	setwall(2, 5);
	setwall(4, 5);
	setwall(5, 5);
	setwall(6, 5);
	setwall(8, 5);
	setwall(10, 5);
	setwall(12, 5);
	setwall(14, 5);
	setwall(16, 5);
	setwall(2, 6);
	setwall(14, 6);
	setwall(4, 7);
	setwall(5, 7);
	setwall(6, 7);
	setwall(7, 7);
	setwall(9, 7);
	setwall(10, 7);
	setwall(11, 7);
	setwall(12, 7);
	setwall(13, 7);
	setwall(14, 7);
	setwall(16, 7);
	setwall(17, 7);
	setwall(2, 8);
	setwall(7, 8);
	setwall(9, 8);
	setwall(11, 8);
	setwall(14, 8);
	setwall(17, 8);
	setwall(18, 8);
	setwall(2, 9);
	setwall(5, 9);
	setwall(11, 9);
	setwall(14, 9);
	setwall(2, 10);
	setwall(4, 10);
	setwall(5, 10);
	setwall(6, 10);
	setwall(7, 10);
	setwall(8, 10);
	setwall(9, 10);
	setwall(10, 10);
	setwall(11, 10);
	setwall(14, 10);
	setwall(16, 10);
	setwall(17, 10);
	setwall(2, 11);
	//setwall(6, 11);
	setwall(16, 11);
	setwall(17, 11);
	setwall(2, 12);
	setwall(3, 12);
	setwall(5, 12);
	setwall(6, 12);
	setwall(7, 12);
	setwall(8, 12);
	setwall(9, 12);
	setwall(10, 12);
	setwall(11, 12);
	setwall(12, 12);
	setwall(14, 12);
	setwall(15, 12);
	setwall(16, 12);
	setwall(17, 12);
	setwall(5, 13);
	setwall(6, 13);
	setwall(11, 13);
	setwall(12, 13);
	setwall(14, 13);
	setwall(2, 14);
	setwall(3, 14);
	setwall(4, 14);
	setwall(5, 14);
	setwall(6, 14);
	setwall(8, 14);
	setwall(9, 14);
	setwall(11, 14);
	setwall(12, 14);
	setwall(14, 14);
	setwall(13, 14);
	setwall(16, 14);
	setwall(17, 14);
	setwall(18, 14);
	setwall(8, 15);
	setwall(13, 15);
	setwall(14, 15);
	setwall(2, 16);
	setwall(3, 16);
	setwall(4, 16);
	setwall(5, 16);
	setwall(6, 16);
	setwall(7, 16);
	setwall(8, 16);
	setwall(10, 16);
	setwall(11, 16);
	setwall(12, 16);
	setwall(13, 16);
	setwall(14, 16);
	setwall(15, 16);
	setwall(16, 16);
	setwall(18, 16);
	setwall(5, 17);
	setwall(16, 17);
	setwall(3, 18);
	setwall(7, 18);
	setwall(9, 18);
	setwall(10, 18);
	setwall(11, 18);
	setwall(12, 18);
	setwall(13, 18);
	setwall(14, 18);
	setwall(16, 18);
	setwall(17, 18);
		
		
	}public void setwall(int x, int y) {
		Global.grid[x][y] = Global.WALL;
	}
}
