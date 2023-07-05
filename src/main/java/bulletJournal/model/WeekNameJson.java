package bulletJournal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The weeks label
 *
 * @param name the label
 */
public record WeekNameJson(@JsonProperty("WeekName") String name) {
}
