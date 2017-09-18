package org.terry.magician.api.support;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -8634700792767837033L;

    public ErrorCode errorCode;

    public ServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message) {
        super(message);
        this.errorCode = ErrorCode.COMMON;
    }

    public ServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
