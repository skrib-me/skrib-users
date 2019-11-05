package me.skrib.users.exception;

import io.damru.exception.model.ApiException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {

    public static HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.NOT_FOUND;
    public static String DEFAULT_ERROR_CODE = "UserNotFound";

    public UserNotFoundException() {
        super(DEFAULT_HTTP_STATUS, DEFAULT_ERROR_CODE);
    }

    public UserNotFoundException(String key, Object value) {
        this();
        this.addError(key, value);
    }

}
