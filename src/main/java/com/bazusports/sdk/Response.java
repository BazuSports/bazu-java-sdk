package com.bazusports.sdk;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Response {

  protected final int responseCode;
  protected final String responseBody;

  protected Response(int responseCode, String responseBody) {
    this.responseCode = responseCode;
    this.responseBody = responseBody;
  }

  public boolean isSuccess() {
    return responseCode >= 200 && responseCode <= 300;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public String getResponseBody() {
    return responseBody;
  }
}
