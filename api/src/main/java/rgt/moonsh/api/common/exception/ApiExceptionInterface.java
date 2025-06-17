package rgt.moonsh.api.common.exception;

import rgt.moonsh.api.common.error.ErrorCodeInterface;

public interface ApiExceptionInterface {

    ErrorCodeInterface getErrorCode();
    String getErrorMessage();
}
