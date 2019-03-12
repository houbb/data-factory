package com.github.houbb.data.factory.core.exception;

/**
 * 运行时异常
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class DataFactoryRuntimeException extends RuntimeException {

    public DataFactoryRuntimeException() {
    }

    public DataFactoryRuntimeException(String message) {
        super(message);
    }

    public DataFactoryRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFactoryRuntimeException(Throwable cause) {
        super(cause);
    }

    public DataFactoryRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
