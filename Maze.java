import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public String Maze1;
  public static void main(String[] args) throws FileNotFoundException {
    File text = new File("input.txt");
    Scanner inf = new Scanner(text);
    while(inf.hasNextLine()){
      String line = inf.nextLine();
      Maze1 += line;
    }
  }
}
