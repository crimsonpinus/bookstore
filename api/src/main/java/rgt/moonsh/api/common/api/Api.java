package rgt.moonsh.api.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rgt.moonsh.api.common.error.ErrorCodeInterface;

/**
 * 보내고자 하는 구조
 * {
 * result{
 * }
 * body{
 * }
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> SUCCESS(T data) {
        var api = new Api<T>();
        api.result = Result.SUCCESS();
        api.body = data;
        return api;
    }

    //error body 필요 없음
    public static Api<Object> ERROR(Result result) {
        var api = new Api<Object>();
        api.result = result;

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, Throwable throwable) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, throwable);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, description);

        return api;
    }

    //외부 모듈 오류 수신
    public static Api<Object> ERROR(Integer errCode, String errCodeDescrition, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errCode, errCodeDescrition, description);

        return api;
    }


}