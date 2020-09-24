package com.civism.gateway.core.annotation;

import java.lang.annotation.*;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 16:12
 * @E-mail:695234456@qq.com
 * @return
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface UrlPatch {

    String[] url();
}
