package com.ooobgy.mapinfo.exception;

/**
 * 表示源数据的异常
 * <b>created:</b> 2012-3-5
 * @author 周晓龙  frogcherry@gmail.com
 */
public class IllDataException extends RuntimeException {

    /**
     * random serial version UID
     */
    private static final long serialVersionUID = -791644032116542320L;

    public IllDataException() {
        super();
    }

    public IllDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllDataException(String message) {
        super(message);
    }

    public IllDataException(Throwable cause) {
        super(cause);

    }

}
