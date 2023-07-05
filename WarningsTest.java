package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


/**
 * tests the warnings class
 */
public class WarningsTest {

  /**
   * tests that the total task is correct
   */
  @Test
  public void updateTaskTotal_ValidTotal_UpdatesTaskTotal() {
    int updatedTaskTotal = 3;
    Warnings warnings = new Warnings();

    warnings.updateTaskTotal(updatedTaskTotal);

    assertEquals(updatedTaskTotal, warnings.currentTaskTotal);
  }

  /**
   * tests the event total is correct
   */
  @Test
  public void updateEventTotal_ValidTotal_UpdatesEventTotal() {
    int updatedEventTotal = 2;
    Warnings warnings = new Warnings();

    warnings.updateEventTotal(updatedEventTotal);

    assertEquals(updatedEventTotal, warnings.currentEventTotal);
  }

  /**
   * tests that the events are set to the max
   */
  @Test
  public void updateEventMax_ValidMax_UpdatesEventMax() {
    int updatedEventMax = 5;
    Warnings warnings = new Warnings();

    warnings.updateEventMax(updatedEventMax);

    assertEquals(updatedEventMax, warnings.maxEvents);
  }

  /**
   * tests that the tasks are set to the max
   */
  @Test
  public void updatedTaskMax_ValidMax_UpdatesTaskMax() {
    int updatedTaskMax = 3;
    Warnings warnings = new Warnings();

    warnings.updatedTaskMax(updatedTaskMax);

    assertEquals(updatedTaskMax, warnings.maxTasks);
  }

  /**
   * checks if the events are over the max
   */

  @Test
  public void isOverEventMax_CurrentEventsOverMax_ReturnsTrue() {
    Warnings warnings = new Warnings();
    warnings.updateEventTotal(3);
    warnings.updateEventMax(2);

    boolean result = warnings.isOverEventMax();

    assertTrue(result);
  }

  /**
   * tests if the events are over the max
   */
  @Test
  public void isOverEventMax_CurrentEventsUnderMax_ReturnsFalse() {
    Warnings warnings = new Warnings();
    warnings.updateEventTotal(2);
    warnings.updateEventMax(3);

    boolean result = warnings.isOverEventMax();

    assertFalse(result);
  }

  /**
   * tests if the tasks are over the max
   */
  @Test
  public void isOverTaskMax_CurrentTasksOverMax_ReturnsTrue() {
    Warnings warnings = new Warnings();
    warnings.updateTaskTotal(3);
    warnings.updatedTaskMax(2);

    boolean result = warnings.isOverTaskMax();

    assertTrue(result);
  }

  /**
   * tests if the tasks are over the max
   */
  @Test
  public void isOverTaskMax_CurrentTasksUnderMax_ReturnsFalse() {
    Warnings warnings = new Warnings();
    warnings.updateTaskTotal(2);
    warnings.updatedTaskMax(3);

    boolean result = warnings.isOverTaskMax();

    assertFalse(result);
  }

}
