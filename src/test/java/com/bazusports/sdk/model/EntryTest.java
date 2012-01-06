package com.bazusports.sdk.model;

import com.bazusports.sdk.Client;
import com.bazusports.sdk.EntityResponse;
import com.bazusports.sdk.RestClient;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

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
  public void randomInvalidTest2() {
    try {
      Entry.builder().
              withEventId(1234L).
              build();
    } catch (ValidationException e) {
      for (ConstraintViolation v : e.getViolations()) {
        assertNotNull(v.getMessage());
        assertFalse(v.getMessage().isEmpty());
      }
    }
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
    assertFalse(response.isSuccess());
    assertNull(response.getEntity());
  }

  @Test
  public void jsonTest() {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    Entry e = gson.fromJson("{\"event_id\": 12345}", new TypeToken<Entry>() {}.getType());
    System.err.println("ENTRY: " + e);
  }
}
