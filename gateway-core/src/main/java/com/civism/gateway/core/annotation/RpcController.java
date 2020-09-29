package com.civism.gateway.core.annotation;

import java.lang.annotation.*;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/19 9:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
public @interface RpcController {
    String value() default "";
}
