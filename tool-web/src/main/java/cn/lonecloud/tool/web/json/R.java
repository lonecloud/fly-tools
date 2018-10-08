package cn.lonecloud.tool.web.json;

/**
* @Title: json页面对象
* @Description: json页面对象
* @author lonecloud
* @date 2018/2/21 下午5:34
* @version V1.0
*/
public class R<T> {

    private int status;

    private String msg;

    private T data;

    public R(int status) {
        this.status = status;
    }

    public R(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public R(int status, String msg, T data) {
        this.status=status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 判断是否是成功返回
     *
     * @return
     */
    public boolean isSuccess() {
        return status == RCode.SUCCESS.getCode();
    }

    public static <T> R<T> success() {
        return new R<T>(RCode.SUCCESS.getCode());
    }

    public static <T> R<T> success(String msg) {
        return new R<T>(RCode.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<T>(RCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> R<T> success(T data) {
        return new R<T>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getDesc(), data);
    }

    public static <T> R<T> error() {
        return new R<T>(RCode.ERROR.getCode(), RCode.ERROR.getDesc());
    }

    public static <T> R<T> error(String errorMsg) {
        return new R<T>(RCode.ERROR.getCode(), errorMsg);
    }

    public static <T> R<T> error(int status, String errorMsg) {
        return new R<T>(status, errorMsg);
    }

    public static <T> R<T> error(RCode RCode) {
        return new R<T>(RCode.getCode(), RCode.getDesc());
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
