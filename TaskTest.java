package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


/**
 * Testing the task obj
 */
public class TaskTest {

  /**
   * testing setting the name
   */
  @Test
  public void setName_ValidName_SetsName() {
    Task task = new Task();
    String name = "Task 1";

    task.setName(name);

    assertEquals(name, task.getName());
  }

  /**
   * testing it will throw an error when the name is empty
   */
  @Test
  public void setName_EmptyName_ThrowsIllegalArgumentException() {
    Task task = new Task();
    String name = "";

    assertThrows(IllegalArgumentException.class, () -> {
      task.setName(name);
    });
  }

  /**
   * testing getting the description
   */
  @Test
  public void setDescription_ValidDescription_SetsDescription() {
    Task task = new Task();
    String description = "Task 1 description";

    task.setDescription(description);

    assertEquals(description, task.getDescription());
  }


  /**
   * sets the week day equal to a valid week day
   */
  @Test
  public void setWeekDay_ValidWeekDay_SetsWeekDay() {
    Task task = new Task();
    Weekday day = Weekday.MONDAY;

    task.setWeekDay(day);

    assertEquals(day, task.getDay());
  }

  /**
   * tests that the week day is null then throws an error
   */

  @Test
  public void setWeekDay_NullWeekDay_ThrowsIllegalArgumentException() {
    Task task = new Task();
    Weekday day = null;

    assertThrows(IllegalArgumentException.class, () -> {
      task.setWeekDay(day);
    });
  }

  /**
   * creates a task queue and makes sure it is null
   */
  @Test
  public void createTaskQueue_ReturnsTaskQueue() {
    Task task = new Task();

    String[] taskQueue = task.createTaskQueue();

    assertNull(taskQueue);
  }
}