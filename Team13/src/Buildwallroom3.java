
public class Buildwallroom3 {
	
	public Buildwallroom3(){
		Global.grid = new int[Global.GridWid][Global.GridHig];
		Global.level_size = 14;
		for (int i = 0; i <Global.level_size; i++) {
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
		setwall(2, 10);
		setwall(2, 11);
		setwall(3, 2);
		setwall(3, 11);
		setwall(4, 2);
		setwall(4, 4);
		setwall(4, 5);
		setwall(4, 7);
		setwall(4, 8);
		setwall(4, 9);
		setwall(4, 11);
		setwall(5, 2);
		setwall(5, 4);
		setwall(5, 9);
		setwall(6, 4);
		setwall(6, 6);
		setwall(6, 7);
		setwall(6, 9);
		setwall(6, 11);
		setwall(7, 2);
		setwall(7, 6);
		setwall(7, 9);
		setwall(7, 10);
		setwall(7, 11);
		setwall(8, 2);
		setwall(8, 4);
		setwall(8, 11);
		setwall(9, 2);
		setwall(9, 4);
		setwall(9, 6);
		setwall(9, 7);
		setwall(9, 8);
		setwall(9, 9);
		setwall(9, 11);
		setwall(10, 2);
		setwall(10, 9);
		setwall(10, 11);
		setwall(11, 2);
		setwall(11, 3);
		setwall(11, 4);
		setwall(11, 5);
		setwall(11, 7);
		setwall(11, 8);
		setwall(11, 9);
		setwall(11, 11);
		setwall(11, 12);
		setwall(12, 9);
		
	}public void setwall(int x, int y) {
		Global.grid[x][y] = Global.WALL;
	}

}
