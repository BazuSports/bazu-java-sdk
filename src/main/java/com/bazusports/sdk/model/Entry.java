package com.bazusports.sdk.model;

import com.bazusports.sdk.Client;
import com.bazusports.sdk.EntityResponse;
import com.bazusports.sdk.Resource;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entry implements Resource {

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ValidatingBuilder<Entry> {

    private Entry e = new Entry();

    private Builder() {
    }

    public Builder withEventId(Long eventId) {
      e.eventId = eventId;
      return this;
    }

    public Builder withRaceId(Long raceId) {
      e.raceId = raceId;
      return this;
    }

    public Builder withExternalId(String externalId) {
      e.externalId = externalId;
      return this;
    }

    public Builder withFirstName(String firstName) {
      e.firstName = firstName;
      return this;
    }

    public Builder withMiddleName(String middleName) {
      e.middleName= middleName;
      return this;
    }

    public Builder withLastName(String lastName) {
      e.lastName = lastName;
      return this;
    }

    @Override
    protected Entry construct() {
      return e;
    }
  }


  public EntityResponse<Entry> create(Client c) {
    return c.createResource(this, Entry.class);
  }

  public EntityResponse<Entry> update(Client c) {
    return c.updateResource(this, Entry.class);
  }

  public Entry() {
  }

  /* Event id */
  @NotNull
  private Long eventId;

  /* Race id */
  @NotNull
  private Long raceId;

  /* External id */
  @NotNull
  private String externalId;

  /* First Name */
  @NotNull
  private String firstName;

  /* Middle Name */
  private String middleName;

  /* Last Name */
  @NotNull
  private String lastName;

  public Long getEventId() {
    return eventId;
  }

  public Long getRaceId() {
    return raceId;
  }

  public String getExternalId() {
    return externalId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }
}
