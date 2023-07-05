package bulletJournal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents the password json record
 *
 * @param password password
 */
public record PasswordJson(@JsonProperty("Password") String password) {

  /**
   * gets the password
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }


}
