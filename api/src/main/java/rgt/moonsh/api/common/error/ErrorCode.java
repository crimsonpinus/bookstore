package rgt.moonsh.api.common.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeInterface{

    OK(200,200, "Success"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(),400, "Bad Request"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "Internal Server Error"),
    NULL_POINTER(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null Pointer"),
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String errorMessage;
}
