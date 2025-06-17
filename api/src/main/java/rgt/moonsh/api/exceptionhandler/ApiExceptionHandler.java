package rgt.moonsh.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rgt.moonsh.api.common.api.Api;
import rgt.moonsh.api.common.exception.ApiException;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Api<Object>> handleApiException(ApiException e) {
        log.error(e.getMessage());
        var errorCode = e.getErrorCodeInterface();
        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(
                        Api.ERROR(errorCode, e.getMessage())
                );
    }

}
