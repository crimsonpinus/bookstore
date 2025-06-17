package rgt.moonsh.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum BookErrorCode implements ErrorCodeInterface{

    BOOK_ID_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR.value(), 513, "Book id not found"),
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String errorMessage;
}
