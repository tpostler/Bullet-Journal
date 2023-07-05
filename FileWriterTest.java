package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the fileWriter class
 */
public class FileWriterTest {
  private FileWriter writer;

  /**
   * sets up nessary objects for File Writer to work
   */
  @BeforeEach
  public void setUp() {
    writer = new FileWriter();
  }

  /**
   * Tests writer writing a notesjson
   */
  @Test
  public void testWriteNotes() {
    NotesJson notes = new NotesJson("name");
    File file = new File("src/test/resources/failFile.txt");
    Path path = Path.of(file.toPath().toUri());
    writer.write(JsonUtils.serializeRecord(notes), path);
  }

  /**
   * tests writing a weeknamejson
   */
  @Test
  public void testWriteWeekName() {
    WeekNameJson weekNameJson = new WeekNameJson("weekname");
    File file = new File("src/test/resources/failFile.txt");
    Path path = Path.of(file.toPath().toUri());
    writer.write(JsonUtils.serializeRecord(weekNameJson), path);
  }

  /**
   * tests a fail if the file that is being written to doesn't exist
   */
  @Test
  public void testFail() {
    WeekNameJson weekNameJson = new WeekNameJson("weekname");
    File file = new File("src/test/resources/fail.txt");
    Path path = Path.of(file.toPath().toUri());
    assertThrows(RuntimeException.class, () ->
        writer.write(JsonUtils.serializeRecord(weekNameJson), path));
  }
}
