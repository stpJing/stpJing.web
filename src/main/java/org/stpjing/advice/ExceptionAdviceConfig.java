package org.stpjing.advice;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stpjing.utils.Message;

/**
 * @author stpJing
 * @version 1.0.0
 * date: 2022/06/10 23:33
 */
@ControllerAdvice
public class ExceptionAdviceConfig {
    @ResponseBody
    @ExceptionHandler(Throwable.class)//处理所有异常
    public Message exceptionHanlder(Exception e){
        return Message.failureMessage(e.getMessage());
    }
}
