package org.terry.magician.admin.support;

import org.terry.magician.admin.support.CRUDErrorCode;

public class CRUDException extends RuntimeException {

    public CRUDErrorCode errorCode;

    public CRUDException(String message, CRUDErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CRUDException(String message) {
        super(message);
        this.errorCode = CRUDErrorCode.COMMON;
    }

    public CRUDException(CRUDErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
