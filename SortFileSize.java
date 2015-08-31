/*
 *    Returns file list in a directory greater than particular limit
 */

package getpathsize;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 *
 * @author Vasu Jindal
 */
public class Walktree {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {
       // Program input the directory name
 
       Path startingDir = Paths.get("C://Users//REDACTED//Desktop");
       Files.walkFileTree(startingDir, new FindJavaVisitor());
  }

  private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

      if (Files.size(file)>500000)
      {
           System.out.println(file.getFileName());
	   int tempsize = (int) Files.size(file) / 1000;           
           System.out.print(" " + tempsize + "," + Files.size(file) % 1000);
           System.out.println();
      }
      return FileVisitResult.CONTINUE;
    }
  }  // prints all files anme and size in the directory tree of the given path
        // greater than 500,000

    
}
