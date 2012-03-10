package com.ooobgy.comm.util.testutil;

/**
 * 用于测试的异常类
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class UtilException extends Throwable {

    /**
     * 
     */
    private static final long serialVersionUID = -780845398116782234L;

    public UtilException() {
        super();
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(Throwable cause) {
        super(cause);
    }

    
}
