package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * tests the event class
 */
public class EventTest {

  private Event event;

  /**
   * set up
   */
  @BeforeEach
  public void setUp() {
    event = new Event();
  }

  /**
   * tests the set method
   */
  @Test
  public void testSetName() {
    String name = "Test Event";
    event.setName(name);
    String retrievedName = event.getName();
    assertEquals(name, retrievedName);
  }

  /**
   * tests the set name method
   */
  @Test
  public void testSetNameWithEmptyString() {
    String emptyName = "";
    assertThrows(IllegalArgumentException.class, () -> {
      event.setName(emptyName);
    });
  }

  /**
   * tests the set description method
   */
  @Test
  public void testSetDescription() {
    String description = "Test Description";
    event.setDescription(description);
    String retrievedDescription = event.getDescription();
    assertEquals(description, retrievedDescription);
  }

  /**
   * tests the set weekday method
   */
  @Test
  public void testSetWeekDay() {
    Weekday day = Weekday.MONDAY;
    event.setWeekDay(day);
    Weekday retrievedDay = event.getDay();
    assertEquals(day, retrievedDay);
  }

  /**
   * tests the set week day method that throws
   * an error when null
   */
  @Test
  public void testSetWeekDayWithNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      event.setWeekDay(null);
    });
  }

  /**
   * tests the set start time method
   */
  @Test
  public void testSetStartTime() {
    String startTime = "10:00 AM";
    event.setStartTime(startTime);
    String retrievedStartTime = event.getStartTime();
    assertEquals(startTime, retrievedStartTime);
  }

  /**
   * tests the set time of day method
   */
  @Test
  public void testSetTimeOfDayWithValidValue() {
    String timeOfDay = "AM";
    event.setTimeOfDay(timeOfDay);
    String retrievedTimeOfDay = event.getTimeOfDay();
    assertEquals(timeOfDay, retrievedTimeOfDay);
  }

  /**
   * tests the set time of day method
   */
  @Test
  public void testSetTimeOfDayWithInvalidValue() {
    String invalidTimeOfDay = "Morning";
    assertThrows(IllegalArgumentException.class, () -> {
      event.setTimeOfDay(invalidTimeOfDay);
    });
  }

  /**
   * tests the set time of day method
   */
  @Test
  public void setTimeOfDay_ValidPmTimeOfDay_SetsTimeOfDayToPm() {
    String selectedTimeOfDay = "PM";

    event.setTimeOfDay(selectedTimeOfDay);

    assertEquals("PM", event.getTimeOfDay());
  }

  /**
   * tests the get links methods
   */
  @Test
  public void testGetLinks() {
    int expected = 1;
    event.setDescription("tester https://google.com");
    int actual = event.getLinks().size();
    assertEquals(expected, actual);
  }
}