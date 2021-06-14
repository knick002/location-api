package com.nitin.locationapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateGeoLocationException extends RuntimeException {
    public DuplicateGeoLocationException() { super();}
    public DuplicateGeoLocationException(String message) { super(message);}
}
