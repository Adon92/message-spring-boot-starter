package com.adon92.message;

public enum MessageCode {
    /**
     * 成功
     */
    OK("OK"),
    /**
     * 失败
     */
    FAIL("FAIL"),
    SERVICE_ERROR("服务发生错误");


    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
