package cs3500.pa05.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created a new bujo file.
 */
public class FileCreate {

  private ArrayList<Path> bujoFiles;

  private String name;

  /**
   * File create constructor.
   *
   * @param bujoFiles the current list of bujo files.
   */
  public FileCreate(ArrayList<Path> bujoFiles, String fileName) {
    this.bujoFiles = bujoFiles;
    this.name = fileName;
  }

  /**
   * constructor
   *
   * @param bujoFiles list of bujoFile paths
   */
  public FileCreate(ArrayList<Path> bujoFiles) {
    this.bujoFiles = bujoFiles;
  }


  /**
   * Creates a new bujo file and names the given week name.
   *
   * @return the created file path.
   */
  public Path create() throws IOException {
    File bujoFile;
    try {
      bujoFile = new File("src/main/resources/" + name + ".bujo");
      if (!bujoFile.createNewFile()) {
        return Paths.get("src/main/resources/" + name + ".bujo");
      } else {
        return bujoFile.toPath();
      }
    } catch (IOException e) {
      throw new IOException();
      // System.out.println("An error occurred.");
      //e.printStackTrace();
    }
  }
}
