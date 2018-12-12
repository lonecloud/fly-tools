package cn.lonelcoud.tool.exception;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2018/12/12 18:16
 */
public class ExceptionFactory {

    public static RuntimeException wrapException(String message, Exception e) {
        return new BusinessException(ErrorContext.instance().message(message).cause(e).toString(), e);
    }
}
