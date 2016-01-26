package cn.org.metter.hitogether_android.exception;

/**
 * Created by Administrator on 2015/8/11.
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomException() {
        super();
    }

    public CustomException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CustomException(String detailMessage) {
        super(detailMessage);
    }

    public CustomException(Throwable throwable) {
        super(throwable);
    }

}

