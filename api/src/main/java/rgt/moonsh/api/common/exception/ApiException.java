package rgt.moonsh.api.common.exception;

import lombok.Getter;
import rgt.moonsh.api.common.error.ErrorCodeInterface;

/**
 * 응답시 에러가 있을때 사용
 */
@Getter
public class ApiException extends RuntimeException implements ErrorCodeInterface {

    private final ErrorCodeInterface errorCodeInterface;

    private final String message;


    public ApiException(ErrorCodeInterface errorCodeInterface) {
        super(errorCodeInterface.getErrorMessage());
        this.errorCodeInterface = errorCodeInterface;
        this.message = errorCodeInterface.getErrorMessage();
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, String message) {
        super(message);
        this.errorCodeInterface = errorCodeInterface;
        this.message = message;
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, Throwable cause) {
        super(cause);
        this.errorCodeInterface = errorCodeInterface;
        this.message = errorCodeInterface.getErrorMessage();
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, String message, Throwable cause) {
        super(cause);
        this.errorCodeInterface = errorCodeInterface;
        this.message = message;
    }


    public Integer httpStatusCode;
    public Integer errorCode;
    public String errorMessage;
}
