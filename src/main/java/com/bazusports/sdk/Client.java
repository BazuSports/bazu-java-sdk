package com.bazusports.sdk;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Client {

  public <T extends Resource> EntityResponse<T> createResource(T entity);

  public <T extends Resource> EntityResponse<T> updateResource(T entity);
}
