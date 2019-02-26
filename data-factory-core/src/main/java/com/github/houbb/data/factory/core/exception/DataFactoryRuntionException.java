package com.github.houbb.data.factory.core.exception;

/**
 * 运行时异常
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class DataFactoryRuntionException extends RuntimeException {

    public DataFactoryRuntionException() {
    }

    public DataFactoryRuntionException(String message) {
        super(message);
    }

    public DataFactoryRuntionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFactoryRuntionException(Throwable cause) {
        super(cause);
    }

    public DataFactoryRuntionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
