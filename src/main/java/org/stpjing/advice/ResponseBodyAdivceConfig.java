package org.stpjing.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.stpjing.annotation.MessageController;
import org.stpjing.utils.Message;

/**
 * @author stpJing
 * @version 1.0.0
 * date 2022/6/10 23:21
 */
@RestControllerAdvice(annotations = MessageController.class)//我们用自己的注释
public class ResponseBodyAdivceConfig implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 过滤器
     * @param methodParameter
     * @param aClass
     * @return 避免重复处理Message
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
//        return !methodParameter.getParameterType().getName().equals("org.example.utils.Message");
//        现在不需要这么做，除非你想要error被双重包裹
    }




    /**
     *进行预处理
     */
    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String returnClassType = returnType.getParameterType().getName();
        if ("java.lang.String".equals(returnClassType)){
            try {
                return objectMapper.writeValueAsString(Message.successMessage(returnValue));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return Message.successMessage(returnValue);
    }
}