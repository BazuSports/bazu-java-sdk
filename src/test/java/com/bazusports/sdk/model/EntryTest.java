package com.bazusports.sdk.model;

import com.bazusports.sdk.Client;
import com.bazusports.sdk.EntityResponse;
import com.bazusports.sdk.RestClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntryTest {

  private Client client;

  @BeforeTest
  public void beforeTest() {
    client = new RestClient("asd8f8isjdf");
  }

  @Test(expectedExceptions = ValidationException.class)
  public void randomInvalidTest() {
    Entry.builder().
        withEventId(1234L).
        build();
  }

  @Test
  public void createEntryTest() {
    Entry e = Entry.builder().
        withEventId(1234L).
        withRaceId(12345678L).
        withExternalId("adf8uksdfkj").
        withFirstName("Ilya").
        withLastName("Stering").
        build();
    EntityResponse<Entry> response = e.create(client);
    System.err.println("Response code: " + response.getResponseCode());
    System.err.println("Response body: " + response.getResponseBody());
    System.err.println("Response body: " + response.getEntity());
  }
}
