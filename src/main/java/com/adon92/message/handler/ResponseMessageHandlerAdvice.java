package com.adon92.message.handler;

import com.adon92.message.Message;
import com.adon92.message.MessageResponse;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * description: ResponeMessageHandlerAdvice <br>
 * date: 2022/3/30 下午4:44 <br>
 * author: adon <br>
 */
@Configurable
@ControllerAdvice(annotations = MessageResponse.class)
public class ResponseMessageHandlerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (MediaType.APPLICATION_JSON.equals(mediaType)) {
            if (o instanceof Message) {
                return o;
            } else {
                return Message.ok(o);
            }

        }
        return o;
    }
}
