package org.biot;

import lombok.Data;
import lombok.NonNull;

/**
 * 业务异常统一定义
 */
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

    /**
     * 不追踪异常栈信息，提升性能
     *
     * @return
     */
    public Throwable fillInStackTrace() {
        return this;
    }
}
