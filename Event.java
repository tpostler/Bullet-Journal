package cs3500.pa05.model;

import java.util.ArrayList;

/**
 * abstraction for event
 */
public class Event implements Description {

  private String name;
  private String description;
  private Weekday day;

  private String startTime;

  private String timeOfDay;

  private ArrayList<String> linkList = new ArrayList<>();

  public Event() {
  }

  /**
   * sets the name of the event
   *
   * @param name name of event
   * @throws IllegalArgumentException if name is empty
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (!name.isEmpty()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be empty!");
    }
  }

  /**
   * Sets the description of the event
   *
   * @param description the description of event
   * @throws IllegalArgumentException if description is empty
   */
  @Override
  public void setDescription(String description) throws IllegalArgumentException {
    this.description = description;
    findHyperLinks();
  }

  /**
   * sets the week day, with the date, need to clarify what this means though
   *
   * @param day the date
   * @throws IllegalArgumentException if date is invalid
   */
  @Override
  public void setWeekDay(Weekday day) throws IllegalArgumentException {
    if (day != null) {
      this.day = day;
    } else {
      throw new IllegalArgumentException("Invalid day");
    }
  }

  /**
   * sets the time equal to the given
   *
   * @param time time being set
   */
  public void setStartTime(String time) {
    this.startTime = time;
  }

  /**
   * gets the giving name
   *
   * @return the name
   */
  public String getName() {
    return name;
  }


  /**
   * gets the description
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * gets the weekday
   *
   * @return the weekday
   */
  public Weekday getDay() {
    return day;
  }

  /**
   * gets the start time
   *
   * @return the time
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * gets the time of day
   *
   * @return the time of day
   */
  public String getTimeOfDay() {
    return timeOfDay;
  }

  /**
   * sets the time of day
   *
   * @param selectedTimeOfDay time of day being set to
   */
  public void setTimeOfDay(String selectedTimeOfDay) {
    if (selectedTimeOfDay.equals("AM") && selectedTimeOfDay != null) {
      timeOfDay = "AM";
    } else if (selectedTimeOfDay.equals("PM") && selectedTimeOfDay != null) {
      timeOfDay = "PM";
    } else {
      throw new IllegalArgumentException("Time of day must be am or pm");
    }
  }

  /**
   * finds the hyperlinks
   */
  private void findHyperLinks() {

    String[] words;
    words = description.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].startsWith("http") || words[i].startsWith("https")) {
        linkList.add(words[i]);
      }
    }
  }

  /**
   * gets the array list of links
   *
   * @return lis of links
   */
  public ArrayList<String> getLinks() {
    return linkList;
  }
}
