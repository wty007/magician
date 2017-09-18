package org.terry.magician.api.support;

import com.google.common.collect.Maps;
import org.terry.magician.common.util.JsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Configuration
@ControllerAdvice(annotations = {RestController.class})
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Autowired
    private JsonService jsonService;

    @ExceptionHandler(value = {ServiceException.class})
    public final ResponseEntity<APIResult> handleServiceException(ServiceException ex, HttpServletRequest request) {
        // 注入servletRequest，用于出错时打印请求URL与来源地址
        logError(ex, request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        APIResult result = new APIResult(ex.errorCode.code, ex.getMessage());
        return new ResponseEntity<APIResult>(result, headers, HttpStatus.valueOf(ex.errorCode.httpStatus));
    }

    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<APIResult> handleGeneralException(Exception ex, HttpServletRequest request) {
        logError(ex, request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        APIResult result = new APIResult(-1,
                ex.getMessage());
        return new ResponseEntity<APIResult>(result, headers, HttpStatus.OK);
    }

    /**
     * 重载ResponseEntityExceptionHandler的方法，加入日志
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        logError(ex);

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, WebRequest.SCOPE_REQUEST);
        }

        APIResult result = APIResult.createInstance();

        if (ex instanceof ServiceException) {
            final ServiceException serviceException = (ServiceException) ex;
            result.setCode(serviceException.errorCode.code);
            result.setMessage(serviceException.getMessage());
        } else {
            result.setCode(ErrorCode.COMMON.code);
            result.setMessage(ex.getMessage());
        }

        return new ResponseEntity<Object>(result, headers, status);
    }

    public void logError(Exception ex) {
        Map<String, String> map = Maps.newHashMap();
        map.put("message", ex.getMessage());
        logger.error(jsonService.toJson(map), ex);
    }

    public void logError(Exception ex, HttpServletRequest request) {
        Map<String, String> map = Maps.newHashMap();
        map.put("message", ex.getMessage());
        map.put("from", request.getRemoteAddr());
        String queryString = request.getQueryString();
        map.put("path", queryString != null ? (request.getRequestURI() + "?" + queryString) : request.getRequestURI());

        logger.error(jsonService.toJson(map), ex);
    }
}
