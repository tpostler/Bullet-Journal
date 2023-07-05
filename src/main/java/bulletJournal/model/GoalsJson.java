package bulletJournal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents the goals json record
 *
 * @param goals the weeks goals
 */
public record GoalsJson(@JsonProperty("goals") String goals) {
}
