package bulletJournal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * represents the event json record
 *
 * @param name        name of the event
 * @param description description of the event
 * @param day         day of the event
 * @param timeOfDay   time of day of the event
 * @param startTime   start time of the evnet
 */
public record EventJson(
    @JsonProperty("Name") String name,
    @JsonProperty("Description") String description,
    @JsonProperty("bulletJournal.model.Weekday") Weekday day,
    @JsonProperty("TimeofDay") String timeOfDay,
    @JsonProperty("StartTime") String startTime,

    @JsonProperty("Links") ArrayList<String> links) {

  public ArrayList<String> getLinks() {
    return links;
  }

  /**
   * gets the name of the event
   *
   * @return the event name
   */
  public String getName() {
    return name;
  }

  /**
   * gets the description of the event
   *
   * @return the event's description
   */
  public String getDescription() {
    return description;
  }

  /**
   * gets the weekday
   *
   * @return the weekday of the event
   */
  public Weekday getDay() {
    return day;
  }

  /**
   * returns the time of day
   *
   * @return the time of day
   */
  public String getTimeOfDay() {
    return timeOfDay;
  }

  /**
   * returns the starttime of the event
   *
   * @return the start time
   */
  public String getStartTime() {
    return startTime;
  }

}
