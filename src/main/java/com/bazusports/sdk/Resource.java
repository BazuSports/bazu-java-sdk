package com.bazusports.sdk;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Resource {

  public EntityResponse<? extends Resource> create(Client c);

  public EntityResponse<? extends Resource> update(Client c);

}
