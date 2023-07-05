package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the file create class
 */
public class FileCreateTest {

  private FileCreate fileCreate;
  private ArrayList<Path> bujoFiles;
  private String fileName;
  private FileCreate fileCreate2;

  /**
   * setup
   */
  @BeforeEach
  public void setUp() {
    bujoFiles = new ArrayList<>();
    fileName = "src/test/resources/TestWeek.bujo";
    fileCreate = new FileCreate(bujoFiles);
    fileCreate2 = new FileCreate(bujoFiles, fileName);
  }

  /**
   * tests the create method
   *
   * @throws IOException if already created
   */
  @Test
  public void testCreate() throws IOException {
    String actual = fileCreate.create().toString();
    String expected = "src/main/resources/null.bujo";
    assertEquals(expected, actual);
  }

  /**
   * tests the error
   */
  @Test
  public void testError()  {
    assertThrows(IOException.class, () -> fileCreate2.create());
  }
}




