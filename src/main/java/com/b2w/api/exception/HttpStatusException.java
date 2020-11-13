package com.b2w.api.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author rketner
 */
public abstract class HttpStatusException extends RuntimeException {

    private static final long serialVersionUID = 8717596536757710378L;

    public HttpStatusException(String message) {
        super(message);
    }

    public abstract HttpStatus getHttpStatus();

}
