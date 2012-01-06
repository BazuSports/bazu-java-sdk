package com.bazusports.sdk;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class JsonResponse extends Response {

  protected JsonResponse(int responseCode, String responseBody) {
    super(responseCode, responseBody);
  }

}
