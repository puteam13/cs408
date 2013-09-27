
public class Buildwallroom8 {
public Buildwallroom8(){
 Global.grid = new int[Global.GridWid][Global.GridHig];
 Global.level_size = 18;
 for (int i = 0; i < Global.level_size; i++) {
  setwall(i, 0);
  setwall(i, Global.level_size - 1);
 }
 for (int j = 0; j < Global.level_size; j++) {
  if (j != 2)
   setwall(0, j);
  if (j != Global.level_size - 2)
   setwall(Global.level_size - 1, j);
 }
 setwall(4, 1);
 setwall(10, 1);
 setwall(1, 2);
 setwall(2, 2);
 setwall(6, 2);
 setwall(10, 2);
 setwall(12, 2);
 setwall(13, 2);
 setwall(14, 2);
 setwall(15, 2);
 setwall(2, 3);
 setwall(4, 3);
 setwall(5, 3);
 setwall(6, 3);
 setwall(7, 3);
 setwall(9, 3);
 setwall(10, 3);
 setwall(12, 3);
 setwall(14, 3);
 setwall(2, 4);
 setwall(7, 4);
 setwall(14, 4);
 setwall(16, 4);//here is bug, should be comment
 setwall(2, 5);
 setwall(3, 5);    //here is bug, should be comment
 setwall(4, 5);
 setwall(5, 5);
 setwall(7, 5);
 setwall(8, 5);
 setwall(9, 5);
 setwall(10, 5);
 setwall(11, 5);
 setwall(12, 5);
 setwall(13, 5);
 setwall(14, 5);
 setwall(2, 6);
 setwall(7, 6);
 setwall(2, 7);
 setwall(5, 7);
 setwall(7, 7);
 setwall(9, 7);
 setwall(10, 7);
 setwall(11, 7);
 setwall(12, 7);
 setwall(13, 7);
 setwall(14, 7);
 setwall(15, 7);
 setwall(2, 8);
 setwall(4, 8);
 setwall(5, 8);
 setwall(6, 8);
 setwall(7, 8);
 setwall(9, 8);
 setwall(2, 9);
 setwall(7, 9);
 setwall(9, 9);
 setwall(10, 9);
 setwall(11, 9);
 setwall(12, 9);
 setwall(13, 9);
 setwall(14, 9);
 setwall(15, 9);
 setwall(16, 9);
 setwall(2, 10);
 setwall(4, 10);
 //setwall(7, 10);
 setwall(10, 10);
 setwall(11, 10);
 setwall(12, 10);
 setwall(13, 10);
 setwall(2, 11);
 setwall(4, 11);
 setwall(5, 11);
 setwall(7, 11);
 setwall(13, 11);
 setwall(15, 11);
 setwall(2, 12);
 setwall(5, 12);
 setwall(7, 12);
 setwall(9, 12);
 setwall(10, 12);
 setwall(11, 12);
 setwall(13, 12);
 setwall(15, 12);
 setwall(2, 13);
 setwall(3, 13);
 setwall(4, 13);
 setwall(5, 13);
 setwall(7, 13);
 setwall(10, 13);
 setwall(13, 13);
 setwall(15, 13);
 setwall(5, 14);
 setwall(7, 14);
 setwall(8, 14);
 setwall(10, 14);
 setwall(13, 14);
 setwall(14, 14);
 setwall(15, 14);
 setwall(1, 15);
 setwall(2, 15);
 setwall(4, 15);
 setwall(5, 15);
 setwall(7, 15);
 setwall(10, 15);
 setwall(11, 15);
 setwall(7, 16);
 setwall(9, 16);
 setwall(10, 16);
 setwall(11, 16);
 setwall(12, 16);
 setwall(14, 16);
 setwall(15, 16);
  
 }public void setwall(int x, int y) {
  Global.grid[x][y] = Global.WALL;
 
 }
}
