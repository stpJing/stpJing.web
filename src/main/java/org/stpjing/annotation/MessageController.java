package org.stpjing.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author stpJing
 * @version 1.0.0
 * 继承RestController，用于标记Controller
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface MessageController {
    @AliasFor(
            annotation = RestController.class
    )
    String value() default "";
}
