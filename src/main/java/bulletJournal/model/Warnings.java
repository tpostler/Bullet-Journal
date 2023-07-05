package bulletJournal.model;

/**
 * represents the warnings
 */

public class Warnings {

  int currentTaskTotal;
  int currentEventTotal;

  int maxEvents = 100;
  int maxTasks = 100;

  /**
   * constructor for the warnings
   */
  public Warnings() {
    this.currentTaskTotal = 0;
    this.currentEventTotal = 0;
  }

  /**
   * updates the task total
   *
   * @param updatedTask the number of current tasks
   */
  public void updateTaskTotal(int updatedTask) {
    this.currentTaskTotal = updatedTask;
  }

  /**
   * updates the event total
   *
   * @param updatedEvent the number of current events
   */
  public void updateEventTotal(int updatedEvent) {
    this.currentEventTotal = updatedEvent;
  }

  /**
   * sets the max number of events
   *
   * @param updatedEventMax the number of max events
   */
  public void updateEventMax(int updatedEventMax) {
    this.maxEvents = updatedEventMax;
  }

  /**
   * sets the max number of tasks
   *
   * @param updatedTaskMax the number of max tasks
   */
  public void updatedTaskMax(int updatedTaskMax) {
    this.maxTasks = updatedTaskMax;
  }

  /**
   * checks if the number of events is over the max
   *
   * @return if the events are over the limit
   */
  public boolean isOverEventMax() {
    return currentEventTotal >= maxEvents;
  }

  /**
   * checks if the number of tasks is over the max
   *
   * @return if the number of tasks is over the max
   */
  public boolean isOverTaskMax() {
    return currentTaskTotal >= maxTasks;
  }
}
