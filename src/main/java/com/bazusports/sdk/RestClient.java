package com.bazusports.sdk;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.wink.client.ClientResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestClient implements Client {

  private static final String BASE_URI = "http://api.bazumedia.com/api";

  private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
  private org.apache.wink.client.RestClient client = new org.apache.wink.client.RestClient();

  private final String applicationId;

  public RestClient(String applicationId) {
    this.applicationId = applicationId;
  }

  public <T extends Resource> EntityResponse<T> createResource(T entity, Class<T> cls) {
    return updateResource(entity, cls);
  }

  public <T extends Resource> EntityResponse<T> updateResource(T entity, Class<T> cls) {
    org.apache.wink.client.Resource resource = client.resource(BASE_URI + "/resource/" + getResourceNameFrom(entity));
    String json = gson.toJson(entity);
    System.err.println("Calling resource: " + resource);
    ClientResponse response = resource.contentType(MediaType.APPLICATION_JSON_TYPE).post(json);
    if (response.getStatusType().getFamily() == Response.Status.Family.SUCCESSFUL) {
      T retEntity = gson.fromJson(response.getEntity(String.class), cls);
      return new EntityResponse<T>(response.getStatusCode(), response.getMessage(), retEntity);
    }
    else {
      T retEntity = gson.fromJson(json, cls);
      return new EntityResponse<T>(response.getStatusCode(), response.getMessage(), retEntity);
    }
  }

  private String getResourceNameFrom(Object entity) {
    String name = entity.getClass().getSimpleName();
    return name.replaceAll(".+([A-Z]+)", "-$1").toLowerCase();
  }
}
