package com.aventude.patientCareService;

import com.aventude.patientCareService.exception.enums.InvalidUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the base controller class for other controller classes.
 *
 * @author Nuwan Danushka
 */
public class BaseController {

  private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

  /**
   * Handle invalid user exception.
   *
   * @param ex the InvalidUserIdentityException exception object
   * @return the map which contains error message and error status
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ InvalidUserException.class })
  public @ResponseBody Map<String, Object>
  handleInvalidUserIdentityException(InvalidUserException ex) {
    logger.error(ex.getMessage(), ex);
    HashMap<String, Object> result = new HashMap<>();
    result.put("error", true);
    result.put("error_message", ex.getMessage());
    return result;
  }

  /**
   * Maps Illegal Argument Exception to Bad Request.
   *
   * @param ex the thrown IllegalArgumentException
   * @return the map
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ IllegalArgumentException.class })
  public @ResponseBody Map<String, Object>
      handleIllegalArgumentException(IllegalArgumentException ex) {
    logger.error(ex.getMessage(), ex);
    HashMap<String, Object> result = new HashMap<>();
    result.put("error", true);
    result.put("error_message", ex.getMessage());
    return result;
  }

  /**
   * Maps Authentication Exception to Bad Request.
   *
   * @param ex the thrown AuthenticationException
   * @return the map
   */
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({ AuthenticationException.class })
  public @ResponseBody Map<String, Object>
      handleAuthenticationException(AuthenticationException ex) {
    logger.error(ex.getMessage(), ex);
    HashMap<String, Object> result = new HashMap<>();
    result.put("error", true);
    result.put("error_message", "user name or password is incorrect");
    return result;
  }
}
