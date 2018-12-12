package cn.lonelcoud.tool.exception;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2018/12/12 18:18
 */

public class ErrorContext {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");
    private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal();
    private ErrorContext stored;
    private String message;
    private Throwable cause;

    private ErrorContext() {
    }

    public static ErrorContext instance() {
        ErrorContext context = (ErrorContext)LOCAL.get();
        if (context == null) {
            context = new ErrorContext();
            LOCAL.set(context);
        }

        return context;
    }

    public ErrorContext store() {
        this.stored = this;
        LOCAL.set(new ErrorContext());
        return (ErrorContext)LOCAL.get();
    }

    public ErrorContext recall() {
        if (this.stored != null) {
            LOCAL.set(this.stored);
            this.stored = null;
        }

        return (ErrorContext)LOCAL.get();
    }

    public ErrorContext message(String message) {
        this.message = message;
        return this;
    }

    public ErrorContext cause(Throwable cause) {
        this.cause = cause;
        return this;
    }

    public ErrorContext reset() {

        this.message = null;
        this.cause = null;
        LOCAL.remove();
        return this;
    }

    public String toString() {
        StringBuilder description = new StringBuilder();
        if (this.message != null) {
            description.append(LINE_SEPARATOR);
            description.append("### ");
            description.append(this.message);
        }
        if (this.cause != null) {
            description.append(LINE_SEPARATOR);
            description.append("### Cause: ");
            description.append(this.cause.toString());
        }

        return description.toString();
    }
}

