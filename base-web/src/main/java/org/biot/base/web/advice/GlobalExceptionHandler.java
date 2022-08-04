package org.biot.base.web.advice;

import org.biot.BiotResult;
import org.biot.BizError;
import org.biot.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * 全局controller统一异常处理
 */
// todo 前者并没有生效
@RestControllerAdvice(basePackages = {"org.biot.**.controller", "org.biot"})
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 统一处理业务异常
     *
     * @param bizException
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public BiotResult handBizException(BizException bizException) {
        log.warn("Handle un-catch biz exception: {}", bizException.getErrorMsg());
        return BiotResult.failResult(bizException);
    }

    /**
     * 统一处理校验异常
     *
     * @param validationException
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BiotResult handValidationException(MethodArgumentNotValidException validationException) {
        log.info("Handle validation exception: {}", validationException.getMessage());
        String errorTip = validationException.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.joining(";"));
        return BiotResult.failResult(BizError.ILLEGAL_ARGS, errorTip);
    }

    /**
     * 统一处理系统异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BiotResult handleSystemException(Exception exception) {
        log.warn("Handle un-catch system exception: ", exception);
        return BiotResult.failResult(BizError.SYS_ERROR, exception.getMessage());
    }

    @PostConstruct
    private void recordStart() {
        log.warn("GlobalExceptionHandler is inited!");
    }
}
