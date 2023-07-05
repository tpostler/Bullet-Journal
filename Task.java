package cs3500.pa05.model;

/**
 * abstraction from Task
 */
public class Task implements Description {
  private String name;
  private String description;
  private Weekday day;

  /**
   * sets the name of the event
   *
   * @param name name of the task
   * @throws IllegalArgumentException if the name is empty
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (!name.isEmpty()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be empty");
    }
  }

  /**
   * sets the description of the task
   *
   * @param description description of task
   * @throws IllegalArgumentException if the description is empty
   */
  @Override
  public void setDescription(String description) throws IllegalArgumentException {
    this.description = description;
  }

  /**
   * not quite sure what we are doing for this
   *
   * @param day day of the week being set to
   */
  @Override
  public void setWeekDay(Weekday day) {
    if (day != null) {
      this.day = day;
    } else {
      throw new IllegalArgumentException("Invalid day");
    }
  }

  /**
   * creates a task queue, sorting by something
   *
   * @return the array of taskQues
   */
  public String[] createTaskQueue() {
    return null;
  }

  /**
   * gets the name of the Task
   *
   * @return name the name
   */
  public String getName() {
    return name;
  }

  /**
   * gets the description of the task
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * gets the day of the task
   *
   * @return the day of the task
   */
  public Weekday getDay() {
    return day;
  }
  //get task queue puts a in dropdown condensed
}
