package com.ooobgy.mapinfo.exception;

/**
 * 表示配置项错误的异常<br>
 * <b>created:</b> 2012-3-5
 * @author 周晓龙  frogcherry@gmail.com
 */
public class IllConfException extends RuntimeException {

    /**
     * random serial version UID
     */
    private static final long serialVersionUID = -791644032116542320L;

    public IllConfException() {
        super();
    }

    public IllConfException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllConfException(String message) {
        super(message);
    }

    public IllConfException(Throwable cause) {
        super(cause);

    }

}
