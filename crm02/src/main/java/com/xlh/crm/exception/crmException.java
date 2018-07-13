package com.xlh.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wwz on 2017/3/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class crmException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected String message;

    protected int errorCode;

    public crmException(String message) {
        super(message);
    }

    public crmException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
