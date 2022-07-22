package org.stpjing.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author stpJing
 * @version 1.0.0
 * 用于标记返回体
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component

public @interface MessageBody {
    String value();
}
