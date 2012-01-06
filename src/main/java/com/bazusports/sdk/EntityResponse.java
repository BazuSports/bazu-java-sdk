package com.bazusports.sdk;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityResponse<T extends Resource> extends Response {

  private T entity;

  protected EntityResponse(int responseCode, String responseBody, T entity) {
    super(responseCode, responseBody);
    this.entity = entity;
  }

  public T getEntity() {
    return entity;
  }
}
