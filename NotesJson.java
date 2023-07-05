package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents a notes json record
 *
 * @param notes for the week
 */
public record NotesJson(@JsonProperty("notes") String notes) {
}
