package com.adon92.message;


/**
 * description: MessageException <br>
 * date: 2022/3/30 下午4:37 <br>
 * author: adon <br>
 */
public class MessageException extends RuntimeException {


    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public MessageException(MessageCode messageCode) {
        this.message = messageCode.getMessage();
    }

    public MessageException(String message) {
        this.message = message;
    }

    public MessageException(Throwable cause, MessageCode messageCode) {
        super(cause);
        this.message = messageCode.getMessage();
    }

}
