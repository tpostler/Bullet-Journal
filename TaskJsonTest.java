package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * Testing the task Json
 */
public class TaskJsonTest {

  /**
   * testing getting the name
   */
  @Test
  public void getName_ValidName_ReturnsName() {
    String expected = "Task 1";
    TaskJson taskJson = new TaskJson(expected, "Task description", Weekday.MONDAY);

    String result = taskJson.getName();

    assertEquals(expected, result);
  }

  /**
   * Testing getting the description
   */
  @Test
  public void getDescription_ValidDescription_ReturnsDescription() {
    String expected = "Task description";
    TaskJson taskJson = new TaskJson("Task 1", expected, Weekday.MONDAY);

    String result = taskJson.getDescription();

    assertEquals(expected, result);
  }

  /**
   * testing getting the weekeday
   */
  @Test
  public void getWeekday_ValidWeekday_ReturnsWeekday() {
    Weekday expected = Weekday.MONDAY;
    TaskJson taskJson = new TaskJson("Task 1", "Task description", expected);

    Weekday result = taskJson.getDay();

    assertEquals(expected, result);
  }

  /**
   * testing getting the day
   */
  @Test
  public void testDay() {
    Weekday expected = Weekday.MONDAY;
    TaskJson taskJson = new TaskJson("Test", "description", expected);
    Weekday result = taskJson.day();

    assertEquals(expected, result);
  }

  /**
   * testing getting the description
   */
  @Test
  public void testDescription() {
    String expected = "Task description";
    TaskJson taskJson = new TaskJson("Task 1", expected, Weekday.MONDAY);

    String result = taskJson.description();

    assertEquals(expected, result);
  }

  /**
   * testing getting the name
   */
  @Test
  public void testName() {
    String expected = "Task 1";
    TaskJson taskJson = new TaskJson(expected, "Task description", Weekday.MONDAY);

    String result = taskJson.name();

    assertEquals(expected, result);
  }
}
