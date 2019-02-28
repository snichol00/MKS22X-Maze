import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
      //do I use try to throw FileNotFound?
      File text = new File(fileName);
      Scanner inf = new Scanner(text);
      //will store the lines of the file
      ArrayList<String> lines = new ArrayList<String>();
      //adds the lines
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        lines.add(line);
      }
      //stores dimensions of Maze
      int rows = lines.size();
      int cols = lines.get(0).length();
      //initializes maze Array
      maze = new int[rows][cols];
      //checks for 1 "E" and 1 "S"
      int e = 0;
      int s = 0;
      //adds chars to array
      for (int y = 0; y < rows; y++){
        for (int x = 0; x < cols; x++){
          maze[y][x] = lines.get(y).charAt(x);
          if (maze[y][x] == 'S'){
            s++;
          }
          if (maze[y][x] == 'E'){
            e++;
          }
        }
      }
      if (e != 1 || s != 1){
        throw new llegalStateException();
      }
    }


    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
      //find the location of the S.
      for (int y = 0; y < maze.length; y++){
        for (int x = 0; x < maze[0].length; x++){
          if (maze[y][x] == "S"){
            //erase the S
            maze[y][x] = " ";
            startRow = y;
            startCol = x;
            return solve(y, x);
          }
        }
      }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private
        maze[row][col] == "@";
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


}
