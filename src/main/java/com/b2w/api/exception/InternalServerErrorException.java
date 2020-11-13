package com.b2w.api.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author rketner
 */
public class InternalServerErrorException extends HttpStatusException{

    private static final long serialVersionUID = -1599105325558786938L;

    public InternalServerErrorException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
}
