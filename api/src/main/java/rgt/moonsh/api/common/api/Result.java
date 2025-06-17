package rgt.moonsh.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rgt.moonsh.api.common.error.ErrorCode;
import rgt.moonsh.api.common.error.ErrorCodeInterface;

/**
 * 응답시 사용되는 구조체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer code;
    private String message;
    private String description;

    public static Result SUCCESS() {
        return Result.builder()
                .code(ErrorCode.OK.getErrorCode())
                .message(ErrorCode.OK.getErrorMessage())
                .description("Success")
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface) {
        return Result.builder()
                .code(errorCodeInterface.getErrorCode())
                .message(errorCodeInterface.getErrorMessage())
                .description("Error")
                .build();
    }
    public static Result ERROR(ErrorCodeInterface errorCodeInterface, Throwable throwable) {
        return Result.builder()
                .code(errorCodeInterface.getErrorCode())
                .message(errorCodeInterface.getErrorMessage())
                .description(throwable.getLocalizedMessage())
                .build();
    }
    public static Result ERROR(ErrorCodeInterface errorCodeInterface, String message) {
        return Result.builder()
                .code(errorCodeInterface.getErrorCode())
                .message(errorCodeInterface.getErrorMessage())
                .description(message)
                .build();
    }
    public static Result ERROR(Integer code, String message, String description) {
        return Result.builder()
                .code(code)
                .message(message)
                .description(description)
                .build();
    }

}
