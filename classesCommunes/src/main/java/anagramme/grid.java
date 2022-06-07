package anagramme;


import java.util.Arrays;

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
  init();
 }

 public void init(){

  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid.length; j++) {
    this.grid[i][j] = new box(i,j);
   }
  }
 }
 //affichage de la grille
 @Override
 public String toString() {
  return "grid{" +
          "grid=" + Arrays.toString(grid) +
          '}';
 }

 public void show() {
  for (int i = 0; i < this.grid.length; i++) {
   System.out.print("\n");
  }
  System.out.print("\n");
  System.out.print("\n");

 }
}

