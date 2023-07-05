package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * tests the week name record json
 */

public class WeekNameJsonTest {

  /**
   * tests the name method
   */
  @Test
  public void testWeekNameWorks() {
    WeekNameJson testName = new WeekNameJson("Test");
    assertEquals(testName.name(), "Test");
  }
}
