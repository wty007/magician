package org.terry.magician.admin.support;

public enum CRUDErrorCode {

    BAD_REQUEST(400, 400), UNAUTHORIZED(401, 401), FORBIDDEN(403, 403), INTERNAL_SERVER_ERROR(500, 500),

    COMMON(-1, 200);

    public int code;
    public int httpStatus;

    CRUDErrorCode(int code, int httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
