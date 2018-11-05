package cn.lonecloud.tools.obj.exception;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2018-09-17 20:19
 */
public class ObjectException extends RuntimeException {

    public ObjectException() {
    }

    public ObjectException(String message) {
        super(message);
    }

    public ObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectException(Throwable cause) {
        super(cause);
    }

    public ObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
