package org.backend.wizardry.springbootcrashcoursewithvega.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "content obj not found")
public class ContentNotFoundException extends Exception{
    public ContentNotFoundException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
