
public class Buildwallroom7 {
public Buildwallroom7(){
 Global.grid = new int[Global.GridWid][Global.GridHig];
 Global.level_size = 18;
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

 setwall(8, 1);
 setwall(12, 1);
 for (int i = 2; i <= 10; i++)
  setwall(i, 2);
 setwall(12, 2);
 setwall(14, 2);
 setwall(15, 2);
 setwall(16, 2);
 setwall(4, 3);
 setwall(10, 3);
 setwall(12, 3);
 setwall(14, 3);
 setwall(16, 3);
 setwall(1, 4);
 setwall(2, 4);
 setwall(4, 4);
 setwall(6, 4);
 setwall(7, 4);
 setwall(8, 4);
 setwall(14, 4);
 setwall(4, 5);
 setwall(6, 5);
 for (int i = 8; i <= 10; i++)
  setwall(i, 5);
 setwall(16, 5);
 setwall(4, 6);
 setwall(10, 6);
 setwall(2, 7);
 for (int i = 4; i <= 8; i++)
  setwall(i, 7);
 for (int i = 10; i <= 15; i++)
  setwall(i, 7);
 setwall(4, 8);
 setwall(10, 8);
 setwall(1, 9);
 setwall(2, 9);
 setwall(4, 9);
 for (int i = 6; i <= 11; i++)
  setwall(i, 9);
 setwall(11, 9);
 setwall(15, 9);
 setwall(4, 10);
 setwall(7, 10);
 setwall(11, 10);
 for (int i = 13; i <= 16; i++)
  setwall(i, 10);
 setwall(1, 11);
 setwall(3, 11);
 setwall(4, 11);
 setwall(5, 11);
 setwall(7, 11);
 setwall(8, 11);
 setwall(9, 11);
 //setwall(11, 11);
 setwall(15, 11);
 setwall(11, 12);
 setwall(13, 12);
 setwall(14, 12);
 setwall(15, 12);
 setwall(1, 13);
 setwall(2, 13);
 setwall(3, 13);
 setwall(5, 13);
 setwall(6, 13);
 setwall(7, 13);
 setwall(9, 13);
 setwall(10, 13);
 setwall(11, 13);
 setwall(13, 13);
 setwall(3, 14);
 //setwall(6, 14);
 setwall(11, 14);
 setwall(13, 14);
 setwall(15, 14);
 setwall(16, 14);
 setwall(2, 15);
 setwall(3, 15);
 for (int i = 5; i <= 9; i++)
  setwall(i, 15);
 //setwall(11, 15);
 setwall(13, 15);
 setwall(6, 16);
 setwall(11, 16);
 setwall(15, 16);
  
 }public void setwall(int x, int y) {
  Global.grid[x][y] = Global.WALL;
 }
}
