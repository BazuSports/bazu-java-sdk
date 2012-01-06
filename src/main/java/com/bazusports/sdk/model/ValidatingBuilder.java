package com.bazusports.sdk.model;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ilya
 * Date: 1/5/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ValidatingBuilder<T> {

  private final ValidatorFactory valFact;

  protected ValidatingBuilder() {
    Configuration config = Validation.byDefaultProvider().configure();
    config.ignoreXmlConfiguration();
    valFact = config.buildValidatorFactory();
  }

  @SuppressWarnings("unchecked")
  public final T build() {
    T obj = construct();
    Set<ConstraintViolation<T>> violations = valFact.getValidator().validate(obj);
    if (!violations.isEmpty()) {
      // The cast to object is needed.  Seems to be a java generics casting bug.  Probably this...
      // http://bugs.sun.com/view_bug.do?bug_id=6932571
      throw new ValidationException((Set<ConstraintViolation>) (Object) violations);
    }
    return obj;
  }

  protected abstract T construct();

}
