package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents the taskJson record
 *
 * @param name        name of the task
 * @param description description of the task
 * @param day         day of the task
 */
public record TaskJson(@JsonProperty("Name") String name,
                       @JsonProperty("Description") String description,

                       @JsonProperty("Weekday") Weekday day) {

  /**
   * gets the name of the task
   *
   * @return the name of the task
   */
  public String getName() {
    return name;
  }

  /**
   * gets the description of the task
   *
   * @return the description of the task
   */
  public String getDescription() {
    return description;
  }

  /**
   * gets the weekday of the task
   *
   * @return the weekday of the task
   */
  public Weekday getDay() {
    return day;
  }
}
