package bulletJournal.model;

/**
 * Abstraction for description
 */
public interface Description {

  /**
   * sets the name to the given parameter name
   *
   * @param name the given name
   * @throws IllegalArgumentException an exception
   */

  void setName(String name) throws IllegalArgumentException;

  /**
   * sets the descriprion equal to the given description
   *
   * @param description the given description
   * @throws IllegalArgumentException an exception
   */
  void setDescription(String description) throws IllegalArgumentException;

  /**
   * sets the week day equal to the given name
   *
   * @param day the given day
   */
  void setWeekDay(Weekday day);


}
