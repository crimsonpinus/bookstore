package rgt.moonsh.api.common.error;

public interface ErrorCodeInterface {
    Integer getHttpStatusCode();
    Integer getErrorCode();
    String getErrorMessage();
}
