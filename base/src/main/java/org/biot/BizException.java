package org.biot;

import lombok.Data;
import lombok.NonNull;

@Data
public class BizException extends RuntimeException {
    private int errorCode;
    private String errorMsg;

    public BizException(int errorCode, @NonNull String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(@NonNull BizError bizError) {
        this.errorCode = bizError.getErrorCode();
        this.errorMsg = bizError.getErrorMsg();
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}
