package cs3500.pa05.model;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests the file reader
 */
public class FileReaderTest {

  @Mock
  private Path mockPath;

  @Mock
  private BasicFileAttributes mockAttributes;

  private FileReader fileReader;

  @BeforeEach
  public void setUp() {
    fileReader = new FileReader();
    MockitoAnnotations.openMocks(this);
  }

  /**
   * Tests visiting a directory
   *
   * @throws IOException error
   */
  @Test
  public void testPreVisitDirectory() throws IOException {
    FileVisitResult result = fileReader.preVisitDirectory(mockPath, mockAttributes);
    assertEquals(CONTINUE, result);
  }

  /**
   * tests visiting a file
   *
   * @throws IOException error
   */
  @Test
  public void testVisitFile() throws IOException {
    ArrayList<Path> expectedFiles = new ArrayList<>();
    expectedFiles.add(mockPath);
    when(mockPath.getFileName()).thenReturn(mockPath);
    when(mockPath.toString()).thenReturn("sample.bujo");

    FileVisitResult result = fileReader.visitFile(mockPath, mockAttributes);
    assertEquals(CONTINUE, result);
    assertEquals(expectedFiles, fileReader.getBujoFiles());
  }

  /**
   * testing if there is an error when the file cannot be visited
   */
  @Test
  public void testVisitFileFailed() {
    IOException exception = new IOException("file unable to be read.");
    try {
      FileVisitResult result = fileReader.visitFileFailed(mockPath, exception);
    } catch (IOException e) {
      assertEquals(exception.getMessage(), e.getMessage());
    }
  }

  /**
   * Tests what happens after visiting a directory
   *
   * @throws IOException error
   */
  @Test
  public void testPostVisitDirectory() throws IOException {
    FileVisitResult result = fileReader.postVisitDirectory(mockPath, null);
    assertEquals(CONTINUE, result);
  }
}
