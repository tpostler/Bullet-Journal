package cs3500.pa05.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * tests the event json record
 */
public class EventJsonTest {

  /**
   * tests the get name method
   */
  @Test
  public void testGetName() {
    String name = "Test Event";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson(name, "Test Description", Weekday.MONDAY,
        "AM", "10:00 AM", links);
    assertEquals(name, eventJson.getName());
  }

  /**
   * tests the get description method
   */
  @Test
  public void testGetDescription() {
    String description = "Test Description";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", description, Weekday.MONDAY,
        "AM", "10:00 AM", links);
    assertEquals(description, eventJson.getDescription());
  }

  /**
   * tests the get weekday  method
   */
  @Test
  public void testGetWeekday() {
    Weekday day = Weekday.MONDAY;
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", "Test Description", day,
        "AM", "10:00 AM", links);
    assertEquals(day, eventJson.getDay());
  }

  /**
   * tests the get time of day method
   */
  @Test
  public void testGetTimeOfDay() {
    String timeOfDay = "AM";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", "Test Description",
        Weekday.MONDAY, timeOfDay, "10:00 AM", links);
    assertEquals(timeOfDay, eventJson.getTimeOfDay());
  }

  /**
   * tests the get start time
   */
  @Test
  public void testGetStartTime() {
    String startTime = "10:00 AM";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", "Test Description",
        Weekday.MONDAY, "AM", startTime, links);
    assertEquals(startTime, eventJson.getStartTime());
  }

  /**
   * tests the get links
   */
  @Test
  public void testGetLinks() {
    String startTime = "10:00 AM";
    ArrayList<String> expected = new ArrayList<>();
    expected.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", "Test Description",
        Weekday.MONDAY, "AM", startTime, expected);

    int actual = eventJson.getLinks().size();
    assertEquals(expected.size(), actual);
  }

  /**
   * tests the links
   */
  @Test
  public void testLinks() {
    String startTime = "10:00 AM";
    ArrayList<String> expected = new ArrayList<>();
    expected.add("https://google.com");
    EventJson eventJson = new EventJson("Test Event", "Test Description",
        Weekday.MONDAY, "AM", startTime, expected);

    int actual = eventJson.links().size();
    assertEquals(expected.size(), actual);
  }

  /**
   * tests the name
   */
  @Test
  public void testName() {
    String expected = "Event Name";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson(expected, "Test Description",
        Weekday.MONDAY, "AM", "10:20", links);

    String actual = eventJson.name();
    assertEquals(expected, actual);
  }

  /**
   * tests the description
   */
  @Test
  public void testDescription() {
    String expected = "description";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("test", expected,
        Weekday.MONDAY, "AM", "10:20", links);

    String actual = eventJson.description();
    assertEquals(expected, actual);
  }

  /**
   * tests the week day method
   */
  @Test
  public void testWeekDay() {
    Weekday expected = Weekday.MONDAY;
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("test", "description",
        expected, "AM", "10:20", links);

    Weekday actual = eventJson.day();
    assertEquals(expected, actual);
  }

  /**
   * tests the time of day method
   */
  @Test
  public void testTimeOfDay() {
    String expected = "AM";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("test", "description",
        Weekday.MONDAY, expected, "10:20", links);

    String actual = eventJson.timeOfDay();
    assertEquals(expected, actual);
  }

  /**
   * tests the start time
   */
  @Test
  public void testStartTime() {
    String expected = "10:30";
    ArrayList<String> links = new ArrayList<>();
    links.add("https://google.com");
    EventJson eventJson = new EventJson("test", "description",
        Weekday.MONDAY, "AM", expected, links);

    String actual = eventJson.startTime();
    assertEquals(expected, actual);
  }
}
