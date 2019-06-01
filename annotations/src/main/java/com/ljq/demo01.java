package com.ljq;

import java.lang.annotation.*;

/**
 * @author : LJQ
 * @date : 2019/6/1 9:31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface demo01 {
    long time() default -1;
}
