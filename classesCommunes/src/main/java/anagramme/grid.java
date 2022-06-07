package anagramme;


public class grid {

 box[][] grid;

 public grid(box[][] grid) {
  this.grid = new box[15][15];
 }

 public box[][] getGrid() {
  return grid;
 }

 public void setGrid(box[][] grid) {
  this.grid = grid;
 }

 public void init(){

  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid.length; j++) {
    this.grid[i][j] = new box(i,j);
   }
  }
 }
}

