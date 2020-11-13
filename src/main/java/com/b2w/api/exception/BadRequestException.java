package com.b2w.api.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author rketner
 */
public class BadRequestException extends HttpStatusException {

    private static final long serialVersionUID = -7321482594091459563L;

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

}
