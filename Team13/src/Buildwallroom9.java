
public class Buildwallroom9 {
public Buildwallroom9(){
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

 setwall(2, 2);
 setwall(4, 2);
 setwall(5, 2);
 setwall(6, 2);
 setwall(7, 2);
 setwall(8, 2);
 setwall(9, 2);
 setwall(11, 2);
 setwall(12, 2);
 setwall(13, 2);
 setwall(14, 2);
 setwall(15, 2);
 setwall(16, 2);
 setwall(17, 2);
 setwall(2, 3);
 setwall(7, 3);
 setwall(11, 3);
 setwall(2, 4);
 setwall(3, 4);
 setwall(4, 4);
 setwall(7, 4);
 setwall(8, 4);
 setwall(10, 4);
 setwall(11, 4);
 setwall(12, 4);
 setwall(13, 4);
 setwall(14, 4);
 setwall(15, 4);
 setwall(16, 4);
 setwall(17, 4);
 setwall(18, 4);
 setwall(2, 5);
 setwall(4, 5);
 setwall(6, 5);
 setwall(7, 5);
 setwall(11, 5);
 setwall(4, 6);
 setwall(7, 6);
 setwall(8, 6);
 setwall(9, 6);
 setwall(10, 6);
 setwall(11, 6);
 setwall(13, 6);
 setwall(14, 6);
 setwall(15, 6);
 setwall(16, 6);
 setwall(17, 6);
 //setwall(18, 6);//HERE IS BUG
 setwall(1, 7);
 setwall(2, 7);
 setwall(3, 7);
 setwall(4, 7);
 setwall(6, 7);
 setwall(7, 7);
 setwall(11, 7);
 setwall(13, 7);
 setwall(17, 7);
 setwall(2, 9);
 setwall(4, 9);
 setwall(5, 9);
 setwall(6, 9);
 setwall(7, 9);
 setwall(8, 9);
 setwall(9, 9);
 setwall(10, 9);
 setwall(11, 9);
 setwall(13, 9);
 setwall(15, 9);
 setwall(16, 9);
 setwall(17, 9);
 setwall(4, 10);
 setwall(11, 10);
 setwall(13, 10);
 setwall(17, 10);
 setwall(1, 11);
 setwall(2, 11);
 setwall(4, 11);
 setwall(6, 11);
 setwall(7, 11);
 setwall(8, 11);
 setwall(9, 11);
 setwall(11, 11);
 setwall(13, 11);
 setwall(14, 11);
 setwall(15, 11);
 setwall(16, 11);
 setwall(17, 11);
 setwall(4, 12);
 setwall(7, 12);
 setwall(9, 12);
 setwall(11, 12);
 setwall(2, 13);
 setwall(3, 13);
 setwall(4, 13);
 setwall(5, 13);
 setwall(7, 13);
 setwall(9, 13);
 setwall(11, 13);
 setwall(12, 13);
 setwall(13, 13);
 setwall(14, 13);
 setwall(15, 13);
 setwall(16, 13);
 setwall(17, 13);
 setwall(7, 14);
 setwall(9, 14);
 setwall(15, 14);
 setwall(17, 14);
 setwall(1, 15);
 setwall(2, 15);
 setwall(4, 15);
 setwall(5, 15);
 setwall(6, 15);
 setwall(7, 15);
 setwall(9, 15);
 setwall(11, 15);
 setwall(12, 15);
 setwall(13, 15);
 setwall(17, 15);
 setwall(9, 16);
 setwall(11, 16);
 setwall(13, 16);
 setwall(15, 16);
 setwall(17, 16);
 setwall(2, 17);
 setwall(3, 17);
 setwall(4, 17);
 setwall(5, 17);
 setwall(6, 17);
 setwall(7, 17);
 setwall(9, 17);
 setwall(13, 17);
 setwall(15, 17);
 setwall(16, 17);
 setwall(17, 17);
 setwall(7, 18);
 setwall(8, 18);
 setwall(9, 18);
 setwall(11, 18);
 setwall(13, 18);
  
  
 }public void setwall(int x, int y) {
  Global.grid[x][y] = Global.WALL;
 }
}
