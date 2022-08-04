package org.biot;

import lombok.Getter;
import lombok.Setter;

/**
 * BIoT 返回结果统一定义
 *
 * @param <T>
 */
@Getter
@Setter
public class BiotResult<T> {
    private boolean success;
    private T result;
    private int errorCode;
    private String errorMsg;

    private BiotResult() {
        // 反序列化用
    }

    private BiotResult(T result) {
        this.success = true;
        this.result = result;
    }

    private BiotResult(int errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private BiotResult(BizException exception) {
        this.success = false;
        this.errorCode = exception.getErrorCode();
        this.errorMsg = exception.getErrorMsg();
    }

    public static <T> BiotResult successResult(T value) {
        return new BiotResult(value);
    }

    public static BiotResult failResult(int errorCode, String errorMsg) {
        return new BiotResult(errorCode, errorMsg);
    }

    public static BiotResult failResult(BizError bizError) {
        return new BiotResult(bizError.getErrorCode(), bizError.getErrorMsg());
    }

    public static BiotResult failResult(BizException exception) {
        return new BiotResult(exception);
    }
}
