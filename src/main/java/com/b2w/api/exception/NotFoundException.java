package com.b2w.api.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author rketner
 */
public class NotFoundException extends HttpStatusException {

    private static final long serialVersionUID = 5940909388255036806L;

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

}
