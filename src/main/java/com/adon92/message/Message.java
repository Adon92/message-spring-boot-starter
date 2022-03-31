
package com.adon92.message;

/**
 * description: Message <br>
 * date: 2022/3/29 下午1:43 <br>
 * author: adon <br>
 */
public class Message {
    /**
     * server is success
     */
    private boolean success;

    /**
     * 消息
     * http response message
     */
    private String msg;

    /**
     * 数据
     * http response data
     */
    private Object data;


    private Message(boolean success) {
        this.success = success;
    }

    private static Message defaultBuilder(boolean flag) {
        return new Message(flag);
    }

    public static Message ok() {
        Message message = defaultBuilder(true);
        message.msg = "OK";
        message.success = Boolean.TRUE;
        return message;
    }


    public static <T> Message ok(T data) {
        Message message = ok();
        message.data = data;
        message.success = Boolean.TRUE;
        return message;
    }

    public static Message ok(String data) {
        Message message = ok();
        message.data = data;
        message.msg = "OK";
        message.success = Boolean.TRUE;
        return message;
    }

    public static <T> Message ok(T data, String msg) {
        Message message = ok();
        message.data = data;
        message.msg = msg;
        message.success = Boolean.TRUE;
        return message;
    }


    public static Message fail() {
        Message message = defaultBuilder(false);
        message.msg = "FAIL";
        message.success = Boolean.FALSE;
        return message;
    }

    public static <T> Message fail(T data) {
        Message message = fail();
        message.data = data;
        message.success = Boolean.FALSE;
        return message;
    }

    public static Message fail(String msg) {
        Message message = fail();
        message.msg = msg;
        message.success = Boolean.FALSE;
        return message;
    }

    public static <T> Message fail(T data, String msg) {
        Message message = fail();
        message.data = data;
        message.msg = msg;
        message.success = Boolean.FALSE;
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
