package com.adon92.message.handler;

import com.adon92.message.Message;
import com.adon92.message.MessageCode;
import com.adon92.message.MessageException;
import com.adon92.message.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: ExceptionHandlerAdvice <br>
 * date: 2022/3/30 下午4:32 <br>
 * author: adon <br>
 */
@Configurable
@ControllerAdvice(annotations = MessageResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    @ExceptionHandler(Exception.class)
    public Message handlerException(Exception e) {
        log.error(e.getMessage());
        return Message.fail(MessageCode.SERVICE_ERROR.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Message handlerRuntimeException(RuntimeException e) {
        log.error(e.getMessage());
        return Message.fail(MessageCode.SERVICE_ERROR.getMessage());
    }

    @ExceptionHandler(MessageException.class)
    public Message messageException(MessageException e) {
        return Message.fail(e.getMessage());
    }

}
