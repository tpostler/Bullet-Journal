package cs3500.pa05.model;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * The file reader class that implements a FileVisitor interface.
 */
public class FileReader implements FileVisitor<Path> {

  private ArrayList<Path> bujoFiles = new ArrayList<>();


  /**
   * Invoked for a directory before entries in the directory are visited.
   *
   * @param dir   a reference to the directory
   * @param attrs the directory's basic attributes
   * @return the visit result
   * @throws IOException if an I/O error occurs
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    //System.out.println("Path visiting: " + dir);
    return CONTINUE;
  }

  /**
   * Invoked for a file in a directory.
   *
   * @param file  a reference to the file
   * @param attrs the file's basic attributes
   * @return the visit result
   * @throws IOException if an I/O error occurs
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (file.getFileName().toString().endsWith("bujo")) {
      bujoFiles.add(file);
    }
    return CONTINUE;
  }

  /**
   * Invoked for a file that could not be visited. This method is invoked
   * if the file's attributes could not be read, the file is a directory
   * that could not be opened, and other reasons.
   *
   * @param file a reference to the file
   * @param exc  the I/O exception that prevented the file from being visited
   * @return the visit result
   * @throws IOException if an I/O error occurs
   */

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    throw new IOException("file unable to be read.");
  }


  /**
   * Invoked for a directory after entries in the directory, and all of their
   * descendants, have been visited. .
   *
   * @param dir a reference to the directory
   * @param exc {@code null} if the iteration of the directory completes without
   *            an error; otherwise the I/O exception that caused the iteration
   *            of the directory to complete prematurely
   * @return the visit result
   * @throws IOException if an I/O error occurs
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    return CONTINUE;
  }

  /**
   * gets the bujo files
   *
   * @return the bujo files
   */
  public ArrayList<Path> getBujoFiles() {
    return bujoFiles;
  }
}
