package org.biot;

import lombok.Data;
import lombok.NonNull;

@Data
public class BizError {
    public static final int ILLEGAL_ARGS = 400;
    public static final int SYS_ERROR = 500;

    public static final BizError BIZ_400 = build(ILLEGAL_ARGS, "Illegal arguments!");
    public static final BizError BIZ_500 = build(SYS_ERROR, "System error!");

    private final int errorCode;
    private final String errorMsg;

    private BizError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static BizError build(int errorCode, @NonNull String errorMsg) {
        return new BizError(errorCode, errorMsg);
    }
}
